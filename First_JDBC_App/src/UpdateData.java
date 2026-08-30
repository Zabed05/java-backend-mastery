import java.sql.*;

public class UpdateData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // connection
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "********";

        Connection connect = DriverManager.getConnection(url, user, password);

        // create statement
        Statement statement = connect.createStatement();

        // query
        String sql = "UPDATE studentInfo set age = 20 where id = 2";
        int rowAffected = statement.executeUpdate(sql);

        // process the result
        if(rowAffected == 0){
            System.out.println("Updation failed");
        }
        else{
            System.out.println("Update Successful!");
        }

        // close
        statement.close();
        connect.close();
    }
}