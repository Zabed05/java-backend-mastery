package com.zabed.requestdispatchingapp;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    public FirstServlet() {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("control in first servlet");

        //Now we are collecting data from the Form
        String name = request.getParameter("username");
        String city = request.getParameter("city");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/SecondServlet");

        //now if we want to give the data to another servlets we have to use of concepts of sessions
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("city", city);

        session.setMaxInactiveInterval(10000); // it means these data will be available only for 1 min, after 1 min if we try to access these data from another Servlet it will not work. bcz session is end

        dispatcher.forward(request, response); // using forward method
//        dispatcher.include(request, response);  // using include method

        PrintWriter writer = response.getWriter();
        writer.println("<h1> Response from First servlet</h1>");
        writer.close();
//        System.out.println("control again in first servlet");
    }
}