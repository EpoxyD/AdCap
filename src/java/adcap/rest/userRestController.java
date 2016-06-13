/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.rest;

import adcap.bean.LucBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import adcap.entity.User;
import adcap.session.UserFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;




/**
 *
 * @author Karsten
 */
@RestController
public class userRestController {

    UserFacade userFacade = lookupUserFacadeBean();
    protected final Log logger = LogFactory.getLog(getClass()); 
   
    //This is called through AJAX, technically not a REST client
    @RequestMapping(value = "/main/mainPage/userMoney/{money}/id/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> updateUserMoney(@PathVariable("money") int money, @PathVariable("id") int id) {
        logger.info("REST user monney is getting increased with "+money+". id is "+id);
         
        User currentUser = userFacade.getUser(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id+ " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setMoney(money);    
        userFacade.updateUserMoney(currentUser);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
    
    //Called through REST client
    @RequestMapping(value = "/searchUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<User> getNumberOfUsers(@PathVariable("id") int id) {
        logger.info("Fetching User with id " + id);
        User user = userFacade.getUser(id);
        if (user == null) {
            logger.info("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setPassword("SECURITYBLOCK");
        logger.info("User succesfully found " + id);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/searchLuc/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<LucBean> getLuc(@PathVariable("id") String id) throws IOException {
        //ModelAndView model = new ModelAndView("lucView");
        logger.info("Fetching Luc with id " + id);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://webwsq.aps.kuleuven.be/esap/public/odata/sap/zh_person_srv/Persons('"+id+"')?$format=json";
        String response = restTemplate.getForObject(url, String.class);
        JSONObject object = new JSONObject(response);
        JSONObject obj = object.getJSONObject("d");
        LucBean luc = new LucBean();
        luc.setFacultyAffiliation(obj.getString("facultyAffiliation"));
        luc.setGender(obj.getString("gender"));
        luc.setNr(obj.getString("nr"));
        luc.setPreferredMailAdress(obj.getString("preferredMailAddress"));
        luc.setPreferredName(obj.getString("preferredName"));
        luc.setSurname(obj.getString("surname"));
        logger.info("Returning luc with id " + id);
        return new ResponseEntity<LucBean>(luc, HttpStatus.OK);
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
