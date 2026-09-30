package com.zabed.studentapi.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionTest {

    public static void main(String[] args) {

        String sql = "SELECT id, name, email FROM students";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            System.out.println("Database connected successfully!");
            System.out.println("Students from database:");

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("id") + " | " +
                                resultSet.getString("name") + " | " +
                                resultSet.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}