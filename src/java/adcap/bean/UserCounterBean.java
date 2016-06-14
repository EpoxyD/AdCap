/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.bean;

import javax.ejb.Singleton;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Evert
 */
@Singleton
@WebListener
public class UserCounterBean implements HttpSessionListener{
    
    private static int usercounter = 0;
    protected final Log logger = LogFactory.getLog(getClass()); 

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("Add a user");
        usercounter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("Delete a user");
        usercounter--;
    }
    
    public static int getCounter(){
        return usercounter;
    }
}
