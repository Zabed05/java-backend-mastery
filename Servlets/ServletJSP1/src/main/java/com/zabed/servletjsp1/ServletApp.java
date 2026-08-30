package com.zabed.servletjsp1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/ServletApp")
public class ServletApp extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + name + "</h1>");
        out.println("</body></html>");
    }
}

//Servlet is faster compare to JSP
// bcz in jsp whatever code we write that will be converted in Servlet and then servlet will execute that
// jsp -> Servlet -> then servlet execute on server ( process is lengthy, that's why Jsp is slower than servlet)

// In Servlet : if any changes we have made, we have to redeploy it
// But in JSP we don't need to redeploy