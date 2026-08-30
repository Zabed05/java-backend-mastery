// Suppose we want to insert data at the runtime. then we will write like this
// here we dont hardcoded the values, we will take from users during runtime

// also we are using PreparedStatement instead of Statement

import java.sql.*;
import java.util.Scanner;

public class InsertData2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pStatement = null;

        try {
            connection = JdbcUtil.getConnection();

            // query
            String sql = "INSERT INTO studentInfo(id, name, age, city) VALUES(?, ?, ?, ?)";
            pStatement = connection.prepareStatement(sql);

            // takes input from user
            System.out.println("Enter the following details to be stored in DB :");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Id:");
            int id = sc.nextInt();

            System.out.println("Enter Your Name:");
            String name = sc.next();

            System.out.println("Enter your Age:");
            int age = sc.nextInt();

            System.out.println("Enter Your City:");
            String city = sc.next();

            sc.close();
            // set data into the DB
            pStatement.setInt(1, id);
            pStatement.setString(2, name);
            pStatement.setInt(3, age);
            pStatement.setString(4, city);

            int rowAffected = pStatement.executeUpdate();

            // Process the result
            if(rowAffected == 0){
                System.out.println("Unable to insert the data");
            }
            else{
                System.out.println("Data inserted successfully!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                JdbcUtil.closeConnection(connection, pStatement);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }   
}