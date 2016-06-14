/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.soap;

import adcap.entity.Item;
import adcap.session.ItemFacade;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Evert
 */
@WebService(serviceName = "RateCalculator")
public class RateCalculator {

    @EJB
    private ItemFacade itemFacade;
    

    @WebMethod(operationName = "CalculateRate")
    public String CalculateRate(@WebParam(name = "LucId") String LucId, @WebParam(name = "ammount") int ammount) {
        Item luc = itemFacade.findItemOnLucId(LucId);
        int totalRate = 0;
        if (luc != null) {
            totalRate = luc.getRate() * ammount;
            return " " + ammount + " " + luc.getName() + " will generate " + totalRate + " euro in total!";
        }
        return " This is not the Luc you are looking for.";

    }
}
