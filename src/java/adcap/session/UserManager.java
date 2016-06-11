/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.session;


import adcap.entity.Item;
import adcap.entity.OrderedItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import adcap.session.UserFacade;
import adcap.entity.User;
import adcap.entity.UserHasItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Karsten
 */
@Stateless
public class UserManager {

    @EJB
    private ItemFacade itemFacade;

    @EJB
    private UserHasItemFacade userHasItemFacade;

    @EJB
    private UserFacade userFacade;
    
            
    
    protected final Log logger = LogFactory.getLog(getClass()); 
    
    
    public Map getUserDetails(User user) {
        logger.info("Grabbing userDetails");
        Map detailMap = new HashMap();
        int totalRate = 0;

        
        // get all owned items
        List<UserHasItem> ownedItems = userHasItemFacade.findByUserId(user.getId()); //ItemID, userID and quantity
        logger.info(ownedItems.get(0).getQuantity());
        
        //get the the details of all owned items
        List<Item> items = new ArrayList<Item>(); //name,price,rate etc
        for(UserHasItem uhi : ownedItems)
        {
            Item i = (Item) itemFacade.find(uhi.getUserHasItemPK().getItemId());
            totalRate += uhi.getQuantity() * i.getRate(); //calculate the speed that your monney will increase every second
            items.add(i);
        }
        
        logger.info(totalRate);

        

        // add each item to detailMap
        detailMap.put("user", user);
        detailMap.put("ownedItems", ownedItems);
        detailMap.put("itemInfo", items);
        detailMap.put("totalRate", totalRate);

        return detailMap;
    }    
    
    
}
