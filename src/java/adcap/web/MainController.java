/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.web;

import org.springframework.web.servlet.ModelAndView; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 
import java.util.Date; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Karsten
 */
@Controller
@RequestMapping("/main")
public class MainController {
    protected final Log logger = LogFactory.getLog(getClass()); 
    
//    @RequestMapping(method=RequestMethod.GET)
//    public ModelAndView test(){
//        String now = (new Date()).toString();
//        logger.info("Returning exampleView view with " + now); 
//        return new ModelAndView("login", "now", now);
//    } 
    
    @RequestMapping(value = "/shop")
    public ModelAndView getShop() {
        logger.info("Build a new Shop");
        return new ModelAndView("shop");
    }
    
}
