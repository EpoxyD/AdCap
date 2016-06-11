/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.session;

import adcap.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karsten
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "Distr_AdvCapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
        
    public boolean checkCredentials(String userName, String password)
    { 
        List<User> list = em.createNamedQuery("User.checkLogin").setParameter("userName", userName).setParameter("password", password).getResultList();
        return !list.isEmpty();
    }
    
    public List<User> getRanking()
    { 
        List<User> list = (List<User>) em.createNamedQuery("User.sortByMoney").setMaxResults(5).getResultList();
        return list;
    }

    public UserFacade() {
        super(User.class);
    }
    
}
