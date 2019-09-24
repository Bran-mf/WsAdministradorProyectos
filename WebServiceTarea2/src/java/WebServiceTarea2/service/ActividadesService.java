  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.service;

import WebServiceTarea2.model.Actividades;
import WebServiceTarea2.model.ActividadesDto;
import WebServiceTarea2.util.CodigoRespuesta;
import WebServiceTarea2.util.Respuesta;
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
public class ActividadesService {
    @PersistenceContext(unitName = "WebServiceTarea2PU")
    private EntityManager em ;
    
    
    //revisar por que recive long y no se si puede dar fallo en algun momento
    public Respuesta getActividad(long id) {
        try {
            Query query = em.createNamedQuery("Actividades.findByActId", Actividades.class);
            query.setParameter("actId", id);
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Actividades", new ActividadesDto((Actividades) query.getSingleResult()));
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un actividad con las credenciales ingresadas", "validar actividad No result exception");
        } catch (Exception es) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error con la consulta", "Error desconocido Exception");
        }
    }

    public Respuesta cargarActividades() {
        try {
            Query query = em.createNamedQuery("Actividades.findAll");
            List<Actividades> actividadesList = query.getResultList();
            List<ActividadesDto> actividadesDtoList = new ArrayList<>();
            for (Actividades actividades : actividadesList) {
                actividadesDtoList.add(new ActividadesDto(actividades));
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Actividadeses", actividadesDtoList);
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "no existen actividadeses en este momento", "No ResultException");
        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "error desconocido", "excepton");
        }
    }

    public Respuesta GuardarActividades(ActividadesDto actividadesDto) {
        try {
            Actividades actividades;
            if (actividadesDto.getId()!= null && actividadesDto.getId() > 0) {
                actividades = em.find(Actividades.class, actividadesDto.getId());
                if (actividades == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el empleado a modificar", "guardar empleado NoResult");
                }
                actividades.actualizarActividades(actividadesDto);
                em.persist(actividades);
            } else {
                actividades = new Actividades(actividadesDto);
                em.persist(actividades);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "actividades", new ActividadesDto(actividades));
        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el empleado", "guardar empleado");
        }

    }

    public Respuesta eliminarActividad(int id) {
        try {
            Actividades actividades;
            if (id != 0 && id > 0) {
                actividades = em.find(Actividades.class, id);
                if (actividades == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "no se encontro el actividades que desea eliminar", "Objetivo a eliminar no encontrado");

                }
                em.remove(actividades);

            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Debe de seleccionar un empleado a eliminar ", "no se entro un id valido");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");

        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {// relaciones con otras entidades
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "El Actividades tiene relaciones con otros registros, no se pudo eliminar", "depedenciade entidades");
            }
            return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO,"error desconocido","excepcion");
        }
    }
}

