/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.bean;
import adcap.entity.ShoppingCartItem;
import adcap.entity.Item;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wouter
 */
@Local
public interface Cart {
   
    /**
     * Adds a ShoppingCartItem to the ShoppingCart's items list.
     * If the specified item already exists, its quantity is incremented.
     * 
     * @param item the item to be added
     */
    void addItem(Item item);
    
    
    /**
     * Updates the quantity of a specified item in the shoppingcart.
     * If the supplied quantity is 0, the item is removed from the cart.
     * @param item      the item to be updated      
     * @param quantity  the new quantity
     */
    void update(Item item, String quantity);

    
    /**
     * Returns the list of ShoppingCartItems
     * 
     * @return the item list as a List<ShoppingCartItem>
     */
    List<ShoppingCartItem> getItems();

    
    /**
     * Returns the sum of the quantities for all items in the ShoppingCart
     * 
     * @return the number of items as an int
     */
    int getNumberOfItems();

    
    /**
     * Returns the sum of the product price multiplied by the quantity for 
     * all items in the ShoppingCart.
     * 
     * @return the cost of everything in the cart as a double
     */
    int getTotal();
    
    void clear();
}
