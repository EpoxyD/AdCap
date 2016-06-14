/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.bean;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author wouter
 */
public class InterceptorBean extends HandlerInterceptorAdapter{
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("pre-handle interception");
        String quantity = request.getParameter("quantity");
        boolean isNumeric = quantity.chars().allMatch( Character::isDigit );
        if(isNumeric && Short.parseShort(quantity) > 0) return true;
        else {
            // feedback msg
            //servlet code
            PrintWriter out = response.getWriter();  
            response.setContentType("text/html");  
            out.println("<script type=\"text/javascript\">");  
            out.println("if(!alert(\"Please enter a valid number\")) window.location.href = '/AdCap/main/shop';"); 
            out.println("</script>");
           
            return false;
        }
    }
}