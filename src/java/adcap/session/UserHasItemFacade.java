/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.session;

import adcap.entity.UserHasItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karsten
 */
@Stateless
public class UserHasItemFacade extends AbstractFacade<UserHasItem> {

    @PersistenceContext(unitName = "Distr_AdvCapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserHasItemFacade() {
        super(UserHasItem.class);
    }
    
    public List<UserHasItem> findByUserId(int id) {
        return em.createNamedQuery("UserHasItem.findByUserId").setParameter("userId", id).getResultList();
    }
    
}
