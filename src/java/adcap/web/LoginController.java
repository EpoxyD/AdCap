/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.web;

import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import adcap.bean.LoginBean;
import adcap.bean.UserCounterBean;
import adcap.cart.ShoppingCart;
import adcap.entity.User;
import adcap.session.UserFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karsten
 */
@Controller
public class LoginController {

    UserFacade userFacade = lookupUserFacadeBean();

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Logincontroller GET Login Method");
        ModelAndView model = new ModelAndView("login");
        if (request.getSession(false) != null && request.getSession(false).getAttribute("user") != null) //if there is a session and a user
        {
            logger.info("Logincontroller user found, redirecting to main");
            model.setViewName("redirect:main/mainPage");
            return model;
        }
        logger.info("Logincontroller user not found");
        int counter = UserCounterBean.getCounter();
        model.addObject("counter", counter);
        LoginBean loginBean = new LoginBean();
        model.addObject("loginBean", loginBean);
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean") LoginBean loginBean) {
        ModelAndView model = null;
        try {
            logger.info("Logincontroller POST Login Method");
            logger.info(loginBean.getUsername());
            logger.info(loginBean.getPassword());
            User user = userFacade.checkCredentials(loginBean.getUsername(), loginBean.getPassword());
            if (user != null) {
                logger.info("User Login Successful");
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                ShoppingCart cart = new ShoppingCart();
                session.setAttribute("cart", cart);
                model = new ModelAndView();
                model.setViewName("redirect:main/mainPage");
            } else {
                logger.info("User Login Failed");
                model = new ModelAndView();
                model.setViewName("redirect:");
            }
        } catch (Exception e) {
            logger.info(e);
        }

        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Logincontroller POST method Logout");
        HttpSession session = request.getSession(false);
        session.invalidate();
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/");
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
}
