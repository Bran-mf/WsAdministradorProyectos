/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.service;

import WebServiceTarea2.model.Administrador;
import WebServiceTarea2.model.AdministradorDto;
import WebServiceTarea2.util.CampoException;
import WebServiceTarea2.util.CodigoRespuesta;
import WebServiceTarea2.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author Jose Pablo Bermudez
 */
@Stateless
@LocalBean
public class AdministradorService {

    @PersistenceContext(unitName = "WebServiceTarea2PU")
    private EntityManager em;

    private static final Logger LOG = Logger.getLogger(AdministradorService.class.getName());
    
    public Respuesta validarAdministrador(String usuario, String contrasena) { 
        try {
            Query qry = em.createNamedQuery("Administrador.findByUsuClave", Administrador.class);
            qry.setParameter("adnUsuario", usuario);
            qry.setParameter("adnContrasena", contrasena);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Administrador", new AdministradorDto((Administrador) qry.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un usuario con las credenciales ingresadas.", "validarUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario " + ex.getMessage());
        }
    }
    
    public Respuesta getAdministradores() {
        try {
            Query qryAdministrador = em.createNamedQuery("Administrador.findAll", Administrador.class);
            List<Administrador> Administrador = qryAdministrador.getResultList();
            List<AdministradorDto> AdministradorsDto = new ArrayList<>();
            for (Administrador administradores : Administrador) {
                AdministradorsDto.add(new AdministradorDto(administradores));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Administradores", AdministradorsDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Administradors con los criterios ingresados.", "getAdministradors NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el Administrador.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Administrador.", "getAdministrador " + ex.getMessage());
        }
    }

     public Respuesta guardarAdministrador(AdministradorDto AdministradorDto) {
        try {
            Administrador Administrador;
            if (AdministradorDto.getAdnId() != null && AdministradorDto.getAdnId() > 0) {
                Administrador = em.find(Administrador.class, AdministradorDto.getAdnId());

                if (Administrador == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontró el Administrador a modificar.", "guardarAdministrador NoResultException");
                }
                Administrador.actualizar(AdministradorDto);
                Administrador = em.merge(Administrador);
            } else {
                Administrador = new Administrador(AdministradorDto);
                em.persist(Administrador);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "Administrador guardado exitosamente", "", "Administrador", (AdministradorDto) new AdministradorDto(Administrador));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Administrador.", ex);
            /*if(ex.getCause().getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class){
                SQLIntegrityConstraintViolationException sqle = new SQLIntegrityConstraintViolationException(ex.getCause().getCause());
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Administrador. Ya existe un Administrador con el mismo campo "
                        + CampoException.getCampo(sqle.getMessage(), "UNA", "ADN")
                        , "guardarAdministrador " + sqle.getMessage());
            }*/
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Administrador.", "guardarAdministrador " + ex.getMessage());
        }
    }
    
    public Respuesta eliminarAdministrador(Long id) {
        try {
            //Empleado empleado;
            Administrador Administrador;
            if (id != null && id > 0) {
                Administrador = em.find(Administrador.class, id);
                if (Administrador == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontró el Administrador a eliminar.", "EliminarAdministrador NoResultException");
                }
                em.remove(Administrador);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Administrador a eliminar.", "EliminarAdministrador NoResultException");
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS, "No se puede eliminar el Administrador porque tiene relaciones con otros registros.", "EliminarAdministrador " + ex.getMessage());
            }
            Logger.getLogger(AdministradorService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Administrador.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el Administrador.", "EliminarAdministrador " + ex.getMessage());
        }
    }
    
     public Respuesta getAdministrador(Long id) {
        try {
            Query qryAdmin = em.createNamedQuery("Administrador.findByAdnId", Administrador.class);
            qryAdmin.setParameter("adnId", id);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Administrador", new AdministradorDto((Administrador) qryAdmin.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un administrador con el código ingresado.", "getAdministrador NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el Administrador.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el administrador.", "getAdministrador NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmpleado " + ex.getMessage());
        }
    }


}
