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

/**
 *
 * @author Evert
 */
@Singleton
@WebListener
public class UserCounterBean implements HttpSessionListener{
    
    private static int usercounter = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Add a user");
        usercounter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Delete a user");
        usercounter--;
    }
    
    public static int getCounter(){
        return usercounter;
    }
}
