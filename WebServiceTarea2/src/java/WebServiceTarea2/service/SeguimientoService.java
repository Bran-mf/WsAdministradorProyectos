/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.service;

import WebServiceTarea2.model.Seguimiento;
import WebServiceTarea2.model.SeguimientoDto;
import WebServiceTarea2.util.CodigoRespuesta;
import WebServiceTarea2.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class SeguimientoService {
    @PersistenceContext(unitName = "WebServiceTarea2PU")
    private EntityManager em;
    
    
     public Respuesta getSeguimiento(long id) {
        try {
            Query query = em.createNamedQuery("Seguimientoes.findByActId", Seguimiento.class);
            query.setParameter("actId", id);
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Seguimientoes", new SeguimientoDto((Seguimiento) query.getSingleResult()));
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un seguimiento con las credenciales ingresadas", "validar seguimiento No result exception");
        } catch (Exception es) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error con la consulta", "Error desconocido Exception");
        }
    }

    public Respuesta cargarSeguimientoeses() {
        try {
            Query query = em.createNamedQuery("Seguimientoes.findAll");
            List<Seguimiento> seguimientoesList = query.getResultList();
            List<SeguimientoDto> seguimientoesDtoList = new ArrayList<>();
            for (Seguimiento seguimientoes : seguimientoesList) {
                seguimientoesDtoList.add(new SeguimientoDto(seguimientoes));
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Seguimientoeses", seguimientoesDtoList);
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "no existen seguimientoeses en este momento", "No ResultException");
        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "error desconocido", "excepton");
        }
    }

    public Respuesta GuardarSeguimientoes(SeguimientoDto seguimientoesDto) {
        try {
            Seguimiento seguimientoes;
            if (seguimientoesDto.getId()!= null && seguimientoesDto.getId() > 0) {
                seguimientoes = em.find(Seguimiento.class, seguimientoesDto.getId());
                if (seguimientoes == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el empleado a modificar", "guardar empleado NoResult");
                }
                seguimientoes.actualizarSeguimiento(seguimientoesDto);
                em.persist(seguimientoes);
            } else {
                seguimientoes = new Seguimiento(seguimientoesDto);
                em.persist(seguimientoes);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "seguimientoes", new SeguimientoDto(seguimientoes));
        } catch (Exception ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el empleado", "guardar empleado");
        }

    }

    public Respuesta eliminarAdmnistrador(Long id) {
        try {
            Seguimiento seguimientoes;
            if (id != 0 && id > 0) {
                seguimientoes = em.find(Seguimiento.class, id);
                if (seguimientoes == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "no se encontro el seguimientoes que desea eliminar", "Objetivo a eliminar no encontrado");

                }
                em.remove(seguimientoes);

            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Debe de seleccionar un empleado a eliminar ", "no se entro un id valido");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");

        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {// relaciones con otras entidades
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "El Seguimientoes tiene relaciones con otros registros, no se pudo eliminar", "depedenciade entidades");
            }
            return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO,"error desconocido","excepcion");
        }
    }
}
