/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import WebServiceTarea2.model.Administrador;
import WebServiceTarea2.model.AdministradorDto;
import WebServiceTarea2.model.ProyectoDto;
import WebServiceTarea2.service.AdministradorService;
import WebServiceTarea2.service.ProyectoService;
import WebServiceTarea2.util.CodigoRespuesta;
import WebServiceTarea2.util.Respuesta;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jose Pablo Bermudez
 */
@WebService(serviceName = "WS")
public class WS {
    @EJB
    AdministradorService administradorService;
    @EJB
    ProyectoService proyectoService;

    @WebMethod(operationName = "getUsuario")
    public Respuesta getUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        try {
            Respuesta respuesta = administradorService.validarAdministrador(usuario, clave);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error al obtener el Usuario", "getUsuario:" + ex.getMessage());
        }
    }

    @WebMethod(operationName = "guardarAdministrador")
    public Respuesta guardarAdministrador(@WebParam(name = "Administrador") AdministradorDto Administrador) {
        try {
            Respuesta respuesta = administradorService.guardarAdministrador(Administrador);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }

    @WebMethod(operationName = "eliminarAdministrador")
    public Respuesta EliminarAdministrador(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = administradorService.eliminarAdministrador(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Error al eliminar el Administrador", ex.getMessage());
        }
    }

    @WebMethod(operationName = "getAdministrador")
    public Respuesta getAdministrador(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = administradorService.getAdministrador(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }

    @WebMethod(operationName = "guardarProyecto")
    public Respuesta guardarProyecto(@WebParam(name = "proyecto") ProyectoDto proyecto) {
        try {
            Respuesta respuesta = proyectoService.guardarProyecto(proyecto);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando Proyecto", ex.getMessage());
        }
    }

    @WebMethod(operationName = "eliminarProyecto")
    public Respuesta eliminarProyecto(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = proyectoService.eliminarProyecto(ID);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Error al eliminar el proyecto.", ex.getMessage());
        }
    }
}

