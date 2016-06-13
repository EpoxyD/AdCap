/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.session;

import adcap.entity.Item;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Evert
 */
@Stateless
public class ItemFacade extends AbstractFacade<Item> {

    @PersistenceContext(unitName = "Distr_AdvCapPU")
    private EntityManager em;
    
    protected final Log logger = LogFactory.getLog(getClass()); 

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
    
    public void incrementAllStock()
    {
        logger.info("The stock is being updated!!!");
        List<Item> items = getItemList();
        Collections.sort(items,Item.Comparators.STOCK); //order from low to high LAMBDA!!!
        int half = items.size()/2;
        int counter = 0;
        items.stream().forEach((item) -> {
            if(counter <=half)
            {
                item.setStock(20+item.getStock()*4);
                item.setRate(5+item.getRate()/2);
            }
            else
            {
                item.setStock(20+item.getStock()*2);
                item.setRate(item.getRate()*2);                
            }
        });
    }
    

    
}
