package com.zabed.servletlifecycle;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/ServletLife")
public class ServletLife extends HttpServlet {
    static {
        System.out.println("Servlet is loaded");
    }
    public ServletLife() {
        System.out.println("servlet object is created");
    }

    public void init(ServletConfig config) {
        System.out.println("Servlet initialized");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("Service method to handle http request and response");
    }
    public void destroy() {

    }
}