import java.sql.*;

public class DeleteData {
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
        String sql = " DELETE FROM studentInfo where id= 4";
        int rowAffected = statement.executeUpdate(sql);

        // process the reselet
        if(rowAffected == 0){
            System.out.println("Deletion failed");
        }
        else{
            System.out.println("Delete Successful!");
        }

        // close
        statement.close();
        connect.close();
    }
}
