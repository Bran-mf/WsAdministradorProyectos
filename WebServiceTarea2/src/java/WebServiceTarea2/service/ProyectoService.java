/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.service;

import WebServiceTarea2.model.Proyecto;
import WebServiceTarea2.model.ProyectoDto;
import WebServiceTarea2.model.Proyecto;
import WebServiceTarea2.model.ProyectoDto;
import WebServiceTarea2.util.CodigoRespuesta;
import WebServiceTarea2.util.Respuesta;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bran
 */
@Stateless
@LocalBean
public class ProyectoService  {
    @PersistenceContext(unitName = "WebServiceTarea2PU")
    private EntityManager em ;
    
    public Respuesta buscarProyecto(int id){
       
        BigDecimal temporal = BigDecimal.valueOf(id);
        try{
            Query query = em.createNamedQuery("Proyecto.findByPryId");
            query.setParameter("pryId", temporal);           
            return new Respuesta(true,CodigoRespuesta.CORRECTO,"","","proyecto", new ProyectoDto((Proyecto) query.getSingleResult()));
        } catch (NoResultException ex){
            printStackTrace();
            return new Respuesta(false,CodigoRespuesta.ERROR_NOENCONTRADO,"No existe Proyecto con las credenciales insertadas","validar id, no result exception");           
        } catch(Exception ex){    
            return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO,"error","algo paso");
        }
    }
    
    public Respuesta cargarProyectoes() {
        try {
            Query query = em.createNamedQuery("Proyecto.findAll");
            List<Proyecto> proyectoList = query.getResultList();
            List<ProyectoDto> proyectoDtoList = new ArrayList<>();
            for (Proyecto proyecto : proyectoList) {
                proyectoDtoList.add(new ProyectoDto(proyecto));
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Proyectoes", proyectoDtoList);
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "no existen proyectoes en este momento", "No ResultException");
        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "error desconocido", "excepton");
        }
    }

    public Respuesta GuardarProyecto(ProyectoDto proyectoDto) {
        try {
            Proyecto proyecto;
            if (proyectoDto.getId()!= null && proyectoDto.getId() > 0) {
                proyecto = em.find(Proyecto.class, proyectoDto.getId());
                if (proyecto == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el empleado a modificar", "guardar empleado NoResult");
                }
                proyecto.actualizarProyecto(proyectoDto);
                em.persist(proyecto);
            } else {
                proyecto = new Proyecto(proyectoDto);
                em.persist(proyecto);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "proyecto", new ProyectoDto(proyecto));
        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el empleado", "guardar empleado");
        }

    }

    public Respuesta eliminarAdmnistrador(Long id) {
        try {
            Proyecto proyecto;
            if (id != 0 && id > 0) {
                proyecto = em.find(Proyecto.class, id);
                if (proyecto == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "no se encontro el proyecto que desea eliminar", "Objetivo a eliminar no encontrado");

                }
                em.remove(proyecto);

            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Debe de seleccionar un empleado a eliminar ", "no se entro un id valido");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");

        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {// relaciones con otras entidades
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "El Proyecto tiene relaciones con otros registros, no se pudo eliminar", "depedenciade entidades");
            }
            return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO,"error desconocido","excepcion");
        }
    }
    
}
