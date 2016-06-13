/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.bean;

import adcap.session.ItemFacade;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author Karsten
 */
@Singleton
public class TimerBean {

    @EJB
    private ItemFacade itemFacade;
    


    @Schedule(dayOfWeek = "*", month = "*", hour = "*/12", dayOfMonth = "*", year = "*", minute = "*", second = "*", persistent = false)    
    public void myTimer() {
        itemFacade.incrementAllStock();
    }


}
