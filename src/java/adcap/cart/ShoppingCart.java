/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.cart;

import adcap.entity.Item;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author wouter
 */
public class ShoppingCart implements Serializable{
    List<ShoppingCartItem> items;
    int numberOfItems;
    double total;

    public ShoppingCart() {
        items = new ArrayList<>();
        numberOfItems = 0;
        total = 0;
    }
    
    
    /**
     * Adds a ShoppingCartItem to the ShoppingCart's items list.
     * If the specified item already exists, its quantity is incremented.
     * 
     * @param item the item to be added
     */
    public synchronized void addItem(Item item){
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
    
    
    /**
     * Updates the quantity of a specified item in the shoppingcart.
     * If the supplied quantity is 0, the item is removed from the cart.
     * @param item      the item to be updated      
     * @param quantity  the new quantity
     */
    public synchronized void update(Item item, String quantity){
       
        short qty = -1;
        qty = Short.parseShort(quantity);
        
        if(qty >= 0){
            
            //ShoppingCartItem item = null;
            for(ShoppingCartItem scItem : items) {
                if(scItem.getItem().getId() == item.getId()) {
                    if(qty == 0) {
                        items.remove(scItem);
                    }
                    else {
                        scItem.setQuantity(qty);
                    }
                }
            }
        }
    }

    
    /**
     * Returns the list of ShoppingCartItems
     * 
     * @return the item list as a List<ShoppingCartItem>
     */
    public synchronized List<ShoppingCartItem> getItems() {
        return items;
    }

    
    /**
     * Returns the sum of the quantities for all items in the ShoppingCart
     * 
     * @return the number of items as an int
     */
    public int getNumberOfItems() {
        numberOfItems = 0;
        for(ShoppingCartItem scItem : items){
            numberOfItems += scItem.getQuantity();
        }
        return numberOfItems;
    }

    
    /**
     * Returns the sum of the product price multiplied by the quantity for 
     * all items in the ShoppingCart.
     * 
     * @return the cost of everything in the cart as a double
     */
    public double getTotal() {
        total = 0;
         for(ShoppingCartItem scItem : items) { 
            total = scItem.getTotal();
        }
        return total;
    }
    
    public synchronized void clear(){
        items.clear();
        numberOfItems = 0;
        total = 0;
    }

    
    
    
}
