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
        
    public User checkCredentials(String userName, String password)
    { 
        List<User> list = em.createNamedQuery("User.checkLogin").setParameter("userName", userName).setParameter("password", password).getResultList();
        if(!list.isEmpty())
        {
          return list.get(0);
        }
        return null;
    }
    
    public boolean checkUserExists(String userName)
    { 
        List<User> list = em.createNamedQuery("User.findByUsername").setParameter("username", userName).getResultList();
        return !list.isEmpty();
    }
    
    public List<User> getRanking()
    { 
        List<User> list = (List<User>) em.createNamedQuery("User.sortByMoney").setMaxResults(5).getResultList();
        return list;
    }
    
    public User getUser(int id)
    { 
        List<User> list = (List<User>) em.createNamedQuery("User.findById").setParameter("id", id).getResultList();
        if(!list.isEmpty())
        {
          return list.get(0);
        }
        return null;
    }
    
    public void updateUserMoney(User user)
    { 
        List<User> list = (List<User>) em.createNamedQuery("User.findById").setParameter("id",user.getId()).getResultList();
        if(!list.isEmpty())
        {
          list.get(0).setMoney(user.getMoney());
        }
    }
    
    public void saveUser(User user)
    {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public UserFacade() {
        super(User.class);
    }
    
}
