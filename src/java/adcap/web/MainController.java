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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Karsten
 */
@Controller
@RequestMapping("/")
//This is a comment

public class MainController {

    UserFacade userFacade = lookupUserFacadeBean();
    protected final Log logger = LogFactory.getLog(getClass()); 

    @RequestMapping(value="/main", method=RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
        logger.info("MainController GET method");
        HttpSession session = request.getSession(false);
        ModelAndView model = new ModelAndView("mainPage");
        List<User> ranking = userFacade.getRanking();
	model = new ModelAndView("mainPage");
        model.addObject("ranking", ranking);

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
