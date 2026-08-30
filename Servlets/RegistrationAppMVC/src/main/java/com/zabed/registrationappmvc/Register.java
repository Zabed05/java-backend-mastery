package com.zabed.registrationappmvc;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/Register")
public class Register extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Model model = new Model();
        model.setName(name);
        model.setEmail(email);
        model.setPassword(password);

        int rowAffected = model.register();

        HttpSession session = request.getSession();
        session.setAttribute("name", name);

        // means registration failed
        if(rowAffected == 0){
            response.sendRedirect("/RegistrationAppMVC/failure.jsp");
        }
        // means registration success
        else{
            response.sendRedirect("/RegistrationAppMVC/success.jsp");
        }
    }
}