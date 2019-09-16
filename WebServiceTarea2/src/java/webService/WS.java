/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;


import WebServiceTarea2.model.Proyecto;
import WebServiceTarea2.model.ProyectoDto;
import WebServiceTarea2.service.ProyectoService;
import WebServiceTarea2.util.Respuesta;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.math.BigDecimal;
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
    private ProyectoService proyectoService;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */

    public String guardar(@WebParam(name = "usuario") Proyecto usuario) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public Proyecto operation(@WebParam(name = "id") BigDecimal id) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getProyectoPorID") //este regresa el proyecto buscado por id
    public ProyectoDto getProyectoPorID(@WebParam(name = "id") int id) {
        try{
            Respuesta res =  proyectoService.buscarProyecto(id);
            if(!res.getEstado()){
                 
                 System.out.println(res.getMensajeInterno());
                 return null;
            }
            return  (ProyectoDto)res.getResultado("proyecto");
        } catch(Exception ex){
            printStackTrace();
            return null;
        }
    }



}
