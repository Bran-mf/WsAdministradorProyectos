/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.service;

import WebServiceTarea2.model.Proyecto;
import WebServiceTarea2.model.ProyectoDto;
import WebServiceTarea2.util.CodigoRespuesta;
import WebServiceTarea2.util.Respuesta;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.math.BigDecimal;
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
}
