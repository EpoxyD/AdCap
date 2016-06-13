/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.session;

import adcap.cart.ShoppingCart;
import adcap.cart.ShoppingCartItem;
import adcap.entity.Item;
import adcap.entity.OrderedItem;
import adcap.entity.OrderedItemPK;
import adcap.entity.User;
import adcap.entity.UserHasItem;
import static adcap.entity.UserHasItem_.user;
import adcap.entity.UserOrder;
import java.util.Date;
import java.util.List;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author wouter
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderManager {

    protected final Log logger = LogFactory.getLog(getClass());

    @EJB
    private ItemFacade itemFacade;

    @EJB
    private UserFacade userFacade;
    
    @EJB 
    private UserHasItemFacade userHasItemFacade;

    @PersistenceContext(unitName = "Distr_AdvCapPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int placeOrder(int userId, ShoppingCart cart) {
        try {
            // get user
            User user = userFacade.find(userId);

            // set up user order
            UserOrder order = addOrder(user, cart);
            // add items to order
            int rc = addOrderedItems(order, cart);
            if ( rc != -1) {
                return order.getId();
            }
            // on failure
            context.setRollbackOnly();
            return 0;

        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }
    }

    private Item lowerStock(int itemId, int amount) {
        Item item = (Item) itemFacade.find(itemId);
        int newStock = item.getStock() - amount;

        if (newStock < 0) {
            return null;   //insufficient stock
        }
        item.setStock(newStock);
        return item;
    }

    private UserOrder addOrder(User user, ShoppingCart cart) {
        // Set up customer order
        UserOrder order = new UserOrder();
        order.setUserId(user);
        order.setAmount(cart.getTotal());

        //generate confirmation number
        Random random = new Random();
        int i = random.nextInt(999);
        order.setConfirmationNumber(i);
        
        //set timestamp
        Date timestamp = new Date();
        order.setDateCreated(timestamp);

        //store order
        em.persist(order);
        em.flush();
        return order;
    }

    private int addOrderedItems(UserOrder order, ShoppingCart cart) {
        em.flush(); //make sure the database is updated so we get the orderId
        List<ShoppingCartItem> items = cart.getItems();
        
        //iterate
        for (ShoppingCartItem scItem : items) {
            if (lowerStock(scItem.getItem().getId(), scItem.getQuantity()) == null) {
                return -1;
            }
                    
            int itemId = scItem.getItem().getId();

            //set up primary key object
            OrderedItemPK orderedItemPK = new OrderedItemPK();
            orderedItemPK.setUserOrderId(order.getId());
            orderedItemPK.setItemId(itemId);

            //create ordered item using PK object
            OrderedItem orderedItem = new OrderedItem(orderedItemPK);

            //set quantity
            orderedItem.setQuantity(scItem.getQuantity());

            em.persist(orderedItem);
            em.flush();

            List<UserHasItem> ownedItems = userHasItemFacade.findByUserId(order.getUserId().getId());
            boolean found = false;
            for(UserHasItem uhi : ownedItems){
                if(scItem.getItem().getId() == uhi.getItem().getId()){
                    logger.info("prepare to update uhi");
                    found = true;
                    uhi.setQuantity(uhi.getQuantity() + scItem.getQuantity());
                    logger.info("updated uhi");
                    break;
                }
            }
            if(!found){
                logger.info("prepare to add uhi");
                UserHasItem uhi = new UserHasItem(scItem.getItem().getId(), order.getUserId().getId());
                uhi.setQuantity(scItem.getQuantity());
                em.persist(uhi);
                em.flush();
                logger.info("new uhi added");
            }
            
            // Get user money
            int totalprice = cart.getTotal();
            User user = userFacade.find(order.getUserId().getId());
            user.setMoney(user.getMoney() - totalprice);
            if (user.getMoney() < 0) {
                cart.clear();
                return -1;
            }
        }
        cart.clear();
        return 0;
    }
    
}