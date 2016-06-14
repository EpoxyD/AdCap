/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.web;

import adcap.bean.LucBean;
import adcap.bean.UserCounterBean;
import adcap.cart.ShoppingCart;
import adcap.entity.Item;
import adcap.entity.User;
import adcap.session.ItemFacade;
import adcap.session.OrderManager;
import adcap.session.UserFacade;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import adcap.session.UserManager;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Karsten
 */
@Controller
@RequestMapping("/main")
//This is a comment

public class MainController {

    OrderManager orderManager = lookupOrderManagerBean();
    UserManager userManager = lookupUserManagerBean();
    UserFacade userFacade = lookupUserFacadeBean();
    ItemFacade itemFacade = lookupItemFacadeBean();
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
        logger.info("MainController GET main method");
        HttpSession session = request.getSession(false);
        User temp = (User) session.getAttribute("user");
        User user = (User) userFacade.getUser(temp.getId());
        logger.info(user);
        ModelAndView model = new ModelAndView("mainPage"); 
        int counter = UserCounterBean.getCounter();
        model.addObject("counter", counter);
        List<User> ranking = userFacade.getRanking();
        model.addObject("ranking", ranking);
        Map userDetails = userManager.getUserDetails(user);
        model.addObject("userDetails", userDetails);
        return model;
    }
    
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView getCart(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView("cart"); 
        User temp = (User) request.getSession(false).getAttribute("user");
        model.addObject("money", (int) userFacade.getUser(temp.getId()).getMoney());
        int counter = UserCounterBean.getCounter();
        model.addObject("counter", counter);
        return model;
    }

    //XML Based REST Client
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView userView(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
        logger.info("MainController GET User method");
        ModelAndView model = new ModelAndView("userView");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8080/AdCap" + "/searchUser/" + id, User.class);
        logger.info(user);
        int counter = UserCounterBean.getCounter();
        User temp = (User) request.getSession(false).getAttribute("user");
        model.addObject("money", (int) userFacade.getUser(temp.getId()).getMoney());
        model.addObject("counter", counter);
        Map userDetails = userManager.getUserDetails(user);
        model.addObject("userDetails", userDetails);
        logger.info(userDetails.toString());
        return model;
    }

    //XML Based REST Client
    @RequestMapping(value = "/luc{id}", method = RequestMethod.GET)
    public ModelAndView lucView(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
        logger.info("MainController GET Luc method");
        ModelAndView model = new ModelAndView("lucView");
        int counter = UserCounterBean.getCounter();
        model.addObject("counter", counter);
        User temp = (User) request.getSession(false).getAttribute("user");
        model.addObject("money", (int) userFacade.getUser(temp.getId()).getMoney());
        RestTemplate restTemplate = new RestTemplate();
        LucBean luc = restTemplate.getForObject("http://localhost:8080/AdCap/" + "/searchLuc/" + id, LucBean.class);
        model.addObject("luc", luc);
        return model;
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public ModelAndView buyStuff(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = null;
        try {
            HttpSession session = request.getSession(false);
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            String itemId = request.getParameter("itemId");
            String quantity = request.getParameter("quantity");
            logger.info(itemId);
            logger.info(quantity);
            int itemID = Integer.parseInt(itemId);
            Item item = itemFacade.find(itemID);
            
            cart.update(item, quantity);
            logger.info(item);
            session.setAttribute("cart", cart);
            logger.info("Items in cart: " + cart.getNumberOfItems());
        } catch (Exception e) {
            logger.info("buy failed with exception");
            logger.info(e);
            return model;
        }
        model = new ModelAndView();
        model.setViewName("redirect:shop");
        return model;
    }
    
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView checkout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = null;
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        int orderId;
        orderId = orderManager.placeOrder(user.getId(), cart);
        if (orderId == 0) {
            logger.info("Buy failed");
            model = new ModelAndView("redirect:shop");
        } else {
            logger.info("Buy Succeeded");
            model = new ModelAndView("redirect:mainPage");
        }
        return model;
    }
    
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public ModelAndView clear(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart.clear();
        session.setAttribute("cart", cart);
        return new ModelAndView("redirect:cart");
    }
    
    @RequestMapping(value = "/framework")
    public ModelAndView framework(){
        return new ModelAndView("MVC Framework");
    }

    @RequestMapping(value = "/shop")
    public ModelAndView getShop(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Go Shopping");
        HttpSession session = request.getSession(false);
        List<Item> inventory = itemFacade.getItemList();
        ModelAndView model = new ModelAndView("shop");
        int counter = UserCounterBean.getCounter();
        model.addObject("counter", counter);
        model.addObject("inventory", inventory);
        User temp = (User) session.getAttribute("user");
        model.addObject("money", (int) userFacade.getUser(temp.getId()).getMoney());
        return model;
    }

    @RequestMapping(value = "/settings")
    public ModelAndView getSettings(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Nosey little fucker aren't you?");
        HttpSession session = request.getSession(false);
        User temp = (User) session.getAttribute("user");
        int money = (int) userFacade.getUser(temp.getId()).getMoney();
        ModelAndView model = new ModelAndView("settings");
        int counter = UserCounterBean.getCounter();
        model.addObject("counter", counter);
        model.addObject("money", money);
        return model;
    }

    private UserFacade lookupUserFacadeBean() {
        try {
            Context c = new InitialContext();
            return (UserFacade) c.lookup("java:global/Distr_AdvCap/UserFacade!adcap.session.UserFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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

    private UserManager lookupUserManagerBean() {
        try {
            Context c = new InitialContext();
            return (UserManager) c.lookup("java:global/Distr_AdvCap/UserManager!adcap.session.UserManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private OrderManager lookupOrderManagerBean() {
        try {
            Context c = new InitialContext();
            return (OrderManager) c.lookup("java:global/Distr_AdvCap/OrderManager!adcap.session.OrderManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
