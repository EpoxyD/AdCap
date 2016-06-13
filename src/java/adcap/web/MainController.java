/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.web;

import adcap.entity.User;
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
<<<<<<< HEAD
@RequestMapping("/main")
=======
@RequestMapping("/")
//This is a comment

>>>>>>> master
public class MainController {

    UserManager userManager = lookupUserManagerBean();       
    
    UserFacade userFacade = lookupUserFacadeBean();
    
    protected final Log logger = LogFactory.getLog(getClass()); 
<<<<<<< HEAD
    
//    @RequestMapping(method=RequestMethod.GET)
//    public ModelAndView test(){
//        String now = (new Date()).toString();
//        logger.info("Returning exampleView view with " + now); 
//        return new ModelAndView("login", "now", now);
//    } 
    
    @RequestMapping(value = "/mainpage")
    public ModelAndView getHome() {
        logger.info("Go Home");
        return new ModelAndView("mainPage");
    }
    
    @RequestMapping(value = "/shop")
    public ModelAndView getShop() {
        logger.info("Go Shopping");
        return new ModelAndView("shop");
    }
    
    @RequestMapping(value = "/settings")
    public ModelAndView getSettings() {
        logger.info("Nosey little fucker aren't you?");
        return new ModelAndView("settings");
    }
=======

    @RequestMapping(value="/main", method=RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
        logger.info("MainController GET main method");
        HttpSession session = request.getSession(false);
        User temp = (User) session.getAttribute("user");
        User user = (User) userFacade.getUser(temp.getId());
        logger.info(user);
        ModelAndView model = new ModelAndView("mainPage");
        List<User> ranking = userFacade.getRanking();
	model = new ModelAndView("mainPage");
        model.addObject("ranking", ranking);
        Map userDetails = userManager.getUserDetails(user);
        model.addObject("userDetails", userDetails);
        return model;
    } 
>>>>>>> master
    
    //XML Based REST Client
    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id){
        logger.info("MainController GET User method");
        ModelAndView model = new ModelAndView("userView");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:57225/AdCap"+"/searchUser/"+id, User.class);
        logger.info(user);
        Map userDetails = userManager.getUserDetails(user);
        model.addObject("userDetails", userDetails);
        logger.info(userDetails.toString());
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

    private UserManager lookupUserManagerBean() {
        try {
            Context c = new InitialContext();
            return (UserManager) c.lookup("java:global/Distr_AdvCap/UserManager!adcap.session.UserManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


    
}
