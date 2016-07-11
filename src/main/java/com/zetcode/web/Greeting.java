package com.zetcode.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Greeting", urlPatterns = {"/Greet"})
public class Greeting extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = "/hello.jsp";
        RequestDispatcher disp = getServletContext().getRequestDispatcher(page);
        disp.forward(request, response);

    }
}
