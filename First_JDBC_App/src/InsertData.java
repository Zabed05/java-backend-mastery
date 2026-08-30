import java.sql.*;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load and register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // we also can load like this

        // Establish the connection
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "********";

        Connection connect = DriverManager.getConnection(url, username, password);

        // Create the statement
        Statement statement = connect.createStatement();

        // Execute query
        String sql = "INSERT INTO studentInfo(id, name, age, city) VALUES(2, 'Rahul', 21, 'Kolkata')";
        int rowAffected = statement.executeUpdate(sql);

        // Process the result
        if(rowAffected == 0){
            System.out.println("Unable to insert the data");
        }
        else{
            System.out.println("Data Inserted Successfully!");
        }

        // close the resources
        statement.close();
        connect.close();

    }
}