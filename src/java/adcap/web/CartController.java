/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.web;

import adcap.cart.ShoppingCart;
import adcap.entity.Item;
import adcap.entity.User;
import adcap.session.ItemFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wouter
 */
@Controller
public class CartController {

    ItemFacade itemFacade = lookupItemFacadeBean();
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/main/checkout", method = RequestMethod.GET)
    public ModelAndView showCheckout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = null;        
        try {
            HttpSession session = request.getSession(false);
            if(session==null)logger.info("doofus ge hed gn session");

            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            if(cart == null) logger.info("doofus ge krijgt uw cart nie");
            
            Item item = itemFacade.find(1);
            if(item == null) logger.info("ey dumbass, haalt ne keer uwe item tegoei binnen");
           
            cart.addItem(item);
            
            session.setAttribute("cart", cart);


        } catch (Exception e) {
            
            logger.info("caught execption:");
            logger.info(e);
        }
        
        
        
        logger.info("Checkout get method");
        model = new ModelAndView("checkout");

        return model;
    }

    @RequestMapping(value = "/main/addToCart", method = RequestMethod.POST)
    public ModelAndView addToCart(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = null;
        logger.info("addtocart called");
        
        try {
            HttpSession session = request.getSession(false);
            if(session==null)logger.info("doofus ge hed gn session");

            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            if(cart == null) logger.info("doofus ge krijgt uw cart nie");
            
            Item item = itemFacade.find(1);
            if(item == null) logger.info("ey dumbass, haalt ne keer uwe item tegoei binnen");
           
            cart.addItem(item);
            
            session.setAttribute("cart", cart);


        } catch (Exception e) {
            
            logger.info("caught execption:");
            logger.info(e);
        }
        model = new ModelAndView("checkout");
        return model;
    }
    
    
    
    
    
    
    
    
    
    private ItemFacade lookupItemFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ItemFacade) c.lookup("java:global/Distr_AdvCap/ItemFacade!adcap.session.ItemFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
