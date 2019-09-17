/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceTarea2.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bran
 */
public class ActividadesService {
    @PersistenceContext(unitName = "WebServiceTarea2PU")
    private EntityManager em ;
    public EntityManager getem(){
        return em;
    }
}
