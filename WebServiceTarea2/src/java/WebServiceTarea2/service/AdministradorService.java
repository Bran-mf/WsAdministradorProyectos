/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.service;

import WebServiceTarea2.model.Administrador;
import WebServiceTarea2.model.AdministradorDto;
import WebServiceTarea2.util.CodigoRespuesta;
import WebServiceTarea2.util.Respuesta;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public Respuesta validarUsuario(String usuario, String clave){
       try{
          Query query = em.createNamedQuery("Aminsitrador.findbyUsuClave",Administrador.class);
          query.setParameter("usuario", usuario);
          query.setParameter("clave", clave);
          return  new Respuesta(true, CodigoRespuesta.CORRECTO,"","","Administrador",new AdministradorDto((Administrador) query.getSingleResult()));
       }catch(NoResultException ex){
         return  new Respuesta(false,CodigoRespuesta.ERROR_NOENCONTRADO,"No existe un usuario con las credenciales ingresadas","alidar usuario No result exception");  
       } catch(Exception es){
           return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error con la consulta","Error desconocido Exception");
       }
  }
    
}
