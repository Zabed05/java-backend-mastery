package com.zabed.servletgetpost;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/ServletApp")
public class ServletApp extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Control in Servlet");

        String name = request.getParameter("username");
        String city = request.getParameter("ucity");

        if(name.equals("Zabed") && city.equals("Kolkata")){
            System.out.println("Success ! He is the right Zabed logged in");
        }
        else{
            System.out.println("Different Zabed logged in");
        }
    }

    public void destroy() {
    }
}