import java.sql.*;

public class RetrieveData {
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
        String sql = "SELECT * FROM studentInfo";
        ResultSet rs = statement.executeQuery(sql); // Retrive operation is Select operation, thats why use use .executeQuery()

        // process the result
        while(rs.next()){
            // int id = rs.getInt(1);
            // String name = rs.getString(2); // instead of this we do -->

            // System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            //we also can get the value by passing Column name -->
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age") + " " + rs.getString("city"));
        }

        // close resorces
        rs.close();
        statement.close();
        connect.close();
    }
}
