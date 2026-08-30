package com.zabed.registrationapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Register")
public class Register extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        System.out.println("Control in Servlet");

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // loading the driver and establishing the connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/jdbc_demo";
            String user = "root";
            String dbPassword = "********";

            Connection connect = DriverManager.getConnection(url, user, dbPassword);

            PreparedStatement pstmnt = connect.prepareStatement("INSERT INTO usersinfo (name, email, password)"
                    + "VALUES(?, ?, ?)");

            pstmnt.setString(1, name);
            pstmnt.setString(2, email);
            pstmnt.setString(3, password);

            int rowsAffected = pstmnt.executeUpdate();
            PrintWriter writer = response.getWriter();

            if(rowsAffected != 0){
                writer.println("<h1>Registration Success!</h1>");
            }
            else{
                writer.println("<h1>Registration Failed!</h1>");
            }

            pstmnt.close();
            connect.close();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
The way we have return is not usually accepted , Servlet is only responsible for creating response not for showing
everything on clients browser (like here we write also "("<h1>Registration Success!</h1>");" these things also.
Servlet is only act as controller, Whatever code for viewPage or etc we should not to do in Servlet.

We will do those on a seperate page or file,That's where MVC(Model View Controller) comes to the picture.
 */