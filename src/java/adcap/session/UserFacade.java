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
import javax.persistence.Query;

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
        Query q = em.createQuery("SELECT u FROM User U WHERE u.username = :userName AND u.password = :password");
        q.setParameter("userName", userName);
        q.setParameter("password", password);
        List<User> list = q.getResultList();
        if(list.size()==1)
        {
            return true;
        }
        return false;
    }

    public UserFacade() {
        super(User.class);
    }
    
}
