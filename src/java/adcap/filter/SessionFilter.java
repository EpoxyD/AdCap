/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Karsten 
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/main/*"})
public class SessionFilter implements Filter {
      protected final Log logger = LogFactory.getLog(getClass()); 
      
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("You have been filtered.");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        // if session doesn't exist, forward user to welcome page
        if (session == null || session.getAttribute("user") == null) {
            try {
                logger.info("Filter: No /user available.");
                req.getRequestDispatcher("/").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return;
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void destroy() {}
}
