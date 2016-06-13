/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.session;

import adcap.entity.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karsten
 */
@Stateless
public class ItemFacade extends AbstractFacade<Item> {

    @PersistenceContext(unitName = "Distr_AdvCapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Item> getItemList()
    { 
        List<Item> list = (List<Item>) em.createNamedQuery("Item.findAll").getResultList();
        return list;
    }

    public ItemFacade() {
        super(Item.class);
    }
    
}
