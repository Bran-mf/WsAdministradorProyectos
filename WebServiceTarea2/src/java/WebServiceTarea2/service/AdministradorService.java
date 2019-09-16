/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.service;

import WebServiceTarea2.util.Respuesta;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        return null;
//        try{
//            Query query = em.createNamedQuery("")
//        }
  }
}
