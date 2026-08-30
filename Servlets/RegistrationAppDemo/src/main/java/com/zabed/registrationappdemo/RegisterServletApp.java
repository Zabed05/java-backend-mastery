package com.zabed.registrationappdemo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/Register")
public class RegisterServletApp extends HttpServlet {

   public RegisterServletApp() {
       System.out.println("Servlet Object is created");
   }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String city = request.getParameter("ucity");
        System.out.println("Name: " + name + " City: " + city);

//        response.sendRedirect(request.getContextPath() + "/success.html");
        response.sendRedirect(request.getContextPath() + "/success.jsp");
    }

}