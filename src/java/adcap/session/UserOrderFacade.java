/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.session;

import adcap.entity.UserOrder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karsten
 */
@Stateless
public class UserOrderFacade extends AbstractFacade<UserOrder> {

    @PersistenceContext(unitName = "Distr_AdvCapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserOrderFacade() {
        super(UserOrder.class);
    }
    
}
