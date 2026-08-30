package com.zabed.registrationappmvc;


// Load, Connection, Close resources these are the common in every program so we implement them here and whenever it needed just invoke them

import java.sql.*;

public class JdbcUtil {
    // Load the Driver
    static { // static bcz whenever class is loaded it will execute
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Connection
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "********";

        return DriverManager.getConnection(url, user, password);
    }

    // Resource close
    public static void closeConnection(Connection connection, PreparedStatement statement) throws SQLException{

        statement.close();
        connection.close();
    }
}
