package com.zabed.secondwebapp;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/firstServlet")
public class FirstServletApp extends HttpServlet {

    public FirstServletApp(){
        System.out.println("Servlet obj is created internally by container");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String city = request.getParameter("ucity");

        PrintWriter writer = response.getWriter();
        writer.println("<html> <head> </head> <body bgcolor = 'aqua'> <h1><marquee> Welcome to our Dynamic App </marquee></h1>");
        writer.println("Hello " + name);
        writer.println("I know you're from " + city);
        writer.println("</body>");
        writer.println("</html>");

        writer.close();
    }
}