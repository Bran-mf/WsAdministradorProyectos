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
 * @author Jose Pablo Bermudez
 */
@Stateless
@LocalBean
public class AdministradorService {
    @PersistenceContext(unitName = "WebServiceTarea2PU")
    private EntityManager em;
    public Respuesta validarAdministrador(String usuario, String clave){
       try{
          Query query = em.createNamedQuery("Administrador.findbyUsuClave",Administrador.class);
          query.setParameter("usuario", usuario);
          query.setParameter("clave", clave);
          return  new Respuesta(true, CodigoRespuesta.CORRECTO,"","","Administrador",new AdministradorDto((Administrador) query.getSingleResult()));
       }catch(NoResultException ex){
         return  new Respuesta(false,CodigoRespuesta.ERROR_NOENCONTRADO,"No existe un usuario con las credenciales ingresadas","alidar usuario No result exception");  
       } catch(Exception es){
           return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error con la consulta","Error desconocido Exception");
       }
  }
    public Respuesta cargarAdministradores(){
        try{
            Query query  = em.createNamedQuery("Administrador.findAll");
            List<Administrador> adminsitradorList = query.getResultList();
            List<AdministradorDto> administradorDtoList = new ArrayList<>();
            for(Administrador administrador: adminsitradorList){
                administradorDtoList.add(new AdministradorDto(administrador));
            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO,"","","Administradores",administradorDtoList);
        }catch(NoResultException ex){
            return new Respuesta (false,CodigoRespuesta.ERROR_NOENCONTRADO,"no existen adminsitradores en este momento","No ResultException");
        } catch(Exception ex){
            return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO,"error desconocido","excepton");
        }
    }
    public Respuesta GuardarAdministrador(AdministradorDto administradorDto){
        try{
            Administrador administrador;
            if(administradorDto.getID()!= null &&administradorDto.getID()>0){
                administrador = em.find(Administrador.class, administradorDto.getID());
                if(administrador ==null){
                    return new Respuesta(false,CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontro el empleado a modificar","guardar empleado NoResult");
                }
                administrador.actualizarAdministrador(administradorDto);
                em.persist(administrador);
            } else {
                administrador = new Administrador(administradorDto);
                em.persist(administrador);
            }
            em.flush();
            return new Respuesta(true,CodigoRespuesta.CORRECTO,"","","administrador",new AdministradorDto(administrador));
        } catch (Exception ex){
            return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al guardar el empleado","guardar empleado");
        }
        
    }
    
}
