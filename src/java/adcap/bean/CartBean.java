/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.bean;

import adcap.entity.ShoppingCartItem;
import adcap.entity.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author wouter
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value=20)
public class CartBean implements Cart{
    List<ShoppingCartItem> items;
    int numberOfItems;
    int total;
        protected final Log logger = LogFactory.getLog(getClass());

    @PostConstruct
    private void initializeBean(){
        logger.info("cartbean initialized!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        items = new ArrayList<>();
        numberOfItems = 0;
        total = 0;
    }

    @Override
    public void addItem(Item item) {
        boolean newItem = true;
        
        for(ShoppingCartItem scItem : items) {
            if(scItem.getItem().getId() == item.getId()){
                newItem = false;
                scItem.incrementQuantity();
            }
        }
        if(newItem){
            ShoppingCartItem scItem = new ShoppingCartItem(item);
            items.add(scItem);
        }
    }

    @Override
    public void update(Item item, String quantity) {
        short qty = -1;
        qty = Short.parseShort(quantity);
        
        if(qty >= 0){
            
            boolean found = false;
            
            //ShoppingCartItem item = null;
            for(ShoppingCartItem scItem : items) {
                if(Objects.equals(scItem.getItem().getId(), item.getId())) {
                    found = true;
                    if(qty == 0) {
                        items.remove(scItem);
                    }
                    else {
                        scItem.setQuantity(qty);
                    }
                }
            }
            if (!found){
                ShoppingCartItem scItem = new ShoppingCartItem(item);
                scItem.setQuantity(qty);
                items.add(scItem);
            }
        }
    }

    @Override
    public List<ShoppingCartItem> getItems() {
        return items;    
    }

    @Override
    public int getNumberOfItems() {
        numberOfItems = 0;
        for(ShoppingCartItem scItem : items){
            numberOfItems += scItem.getQuantity();
        }
        return numberOfItems;
    }

    @Override
    public int getTotal() {
        total = 0;
         for(ShoppingCartItem scItem : items) { 
            total = (int) scItem.getTotal();
        }
        return total;
    }

    @Override
    public void clear() {
        items.clear();
        numberOfItems = 0;
        total = 0;
    }   
}
