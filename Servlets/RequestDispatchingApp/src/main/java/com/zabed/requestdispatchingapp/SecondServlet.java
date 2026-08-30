package com.zabed.requestdispatchingapp;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    public SecondServlet() {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("control in second servlet");

        // we are taking the data from FirstServlet
        HttpSession session = request.getSession(false);

        String name = (String) session.getAttribute("name");
        String city = (String) session.getAttribute("city");

        PrintWriter writer = response.getWriter();
        writer.println("<h1> Response from Second Servlet</h1>");
        writer.println("<h1>" + "Name: " + name + " City: " + city + "</h1>");
        writer.close();

    }
}