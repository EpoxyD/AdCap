/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.cart;

import adcap.entity.Item;

/**
 *
 * @author wouter
 */
public class ShoppingCartItem {
    Item item;
    short quantity;
    
    public ShoppingCartItem(Item item) {
        this.item = item;
        this.quantity = 1;
    }

    public Item getItem() {
        return item;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
    
    public void incrementQuantity(){
        quantity++;
    }
    
    public void decrementQuantity(){
        quantity--;
    }
    
    public double getTotal(){
        double amount = 0;
        double price = 5;   //TODO: retrieve price from product--> item.getPrice().doubleValue(); -->currently price is stored as a string
        amount = price * this.getQuantity();
        return amount;
    }
}
