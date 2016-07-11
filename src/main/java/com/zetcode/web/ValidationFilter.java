package com.zetcode.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.apache.commons.validator.routines.EmailValidator;

@WebFilter(filterName = "ValidationFilter", urlPatterns = {"/Greet"})
public class ValidationFilter implements Filter {

    public ValidationFilter() { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
              
        String erpg = "valError.jsp";

        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        boolean valid = EmailValidator.getInstance().isValid(email);

        if (userName == null || "".equals(userName)
                || email == null || "".equals(email)) {

            request.setAttribute("errMsg", "One or both fields are empty");

            RequestDispatcher rd = request.getRequestDispatcher(erpg);
            rd.include(request, response);

        } else if (!valid) {
            
            request.setAttribute("errMsg", "Email format not valid");
            RequestDispatcher rd = request.getRequestDispatcher(erpg);
            rd.include(request, response);
        } else {
            
            chain.doFilter(request, response); 
        }

    }

    @Override
    public void destroy() { }

    @Override
    public void init(FilterConfig filterConfig) { }

}
