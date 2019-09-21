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
    ProyectoService proyectoService;
    @EJB
    AdministradorService adminService;
    
     @WebMethod(operationName = "getAdministrador")
    public String getAdministrador(@WebParam(name = "Administrador") String Administrador, @WebParam(name = "contrasenna") String contrasenna) {
        //TODO write your implementation code here:
        return "Administrador: " + Administrador + " Contraseña: " + contrasenna;
    }

    @WebMethod(operationName = "getUsuario")
    public Respuesta getUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        try {
            // Consulto el service del Administrador y devuelvo la respuesta al cliente
            Respuesta respuesta = adminService.validarAdministrador(usuario, clave);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error al obtener el Usuario", "getUsuario:"+ex.getMessage());
        }
    }

    
    @WebMethod(operationName = "guardarAdministrador")
    public Respuesta guardarAdministrador(@WebParam(name = "Administrador") AdministradorDto Administrador) {

        try {
            Respuesta respuesta = adminService.guardarAdministrador(Administrador);
            return respuesta;
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error guardando usuario", ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "eliminarAdministrador")
    public String EliminarAdministrador(@WebParam(name = "ID") Long ID) {
        try {
            Respuesta respuesta = adminService.eliminarAdministrador(ID);
            if (!respuesta.getEstado()) {
                return respuesta.getMensaje();
            }
            return respuesta.getMensaje();
        } catch (Exception ex) {
            Logger.getLogger(WS.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al eliminar el Administrador";
        }
    }
    @WebMethod(operationName = "getAdministradorById")
    public AdministradorDto getAdminById(@WebParam(name = "adminId") Long adminId) {
        Administrador admin = adminService.getAdmin(adminId);
        if(admin!=null && admin.getAdmId()!=null){
            AdministradorDto adminDto = new AdministradorDto(admin);
            return adminDto;
        } else {
            return null;
        }
    }
    
    @WebMethod(operationName = "getProyectoPorID") //este regresa el proyecto buscado por id
    public ProyectoDto getProyectoPorID(@WebParam(name = "id") int id) {
        try{
            Respuesta res =  proyectoService.buscarProyecto(id);
            if(!res.getEstado()){
                 
                 System.out.println(res.getMensajeInterno());
                 return null;
            }
            return  (ProyectoDto)res.getResultado("proyecto");//es mejor si lo retorna como en el método de guardar, no retornar una respuesta sino un proyectodto
        } catch(Exception ex){
            printStackTrace();
            return null;
        }
    }



}
