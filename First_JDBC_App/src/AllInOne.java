import java.sql.*;

public class AllInOne {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load Driver
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // // Connection establish
            // String url = "jdbc:mysql://localhost:3306/jdbc_demo";
            // String user = "root";
            // String password = "********";

            // connection = DriverManager.getConnection(url, user, password);
            connection = JdbcUtil.getConnection(); // invoke getConnection()


            // statement creation
            statement = connection.createStatement();

            // query
            String sql = "SELECT * FROM studentInfo"; // here we doing select query

            boolean status = statement.execute(sql); // if the operation is Select type then it return true, otherwise false

            // process the result
            if(status){
                // Select Operation (retrive)
                System.out.println("Select Operation Executing");
            
                ResultSet rs = statement.getResultSet();
                while(rs.next()){
                    System.out.println(rs.getInt(1) + " " + rs.getString(2)
                    + " " + rs.getInt(3) + " " + rs.getString(4));
                }
            }
            else{
                // Non-Select Operation (insert, update, delete)
                System.out.println("Non-Select Operation Executing");

                int rowAffected = statement.getUpdateCount();

                if(rowAffected == 0){
                    System.out.println("Operation failed");
                }
                else{
                    System.out.println("Operation Successfull");
                }
            }

            // // close resourses
            // statement.close();
            // connection.close(); // Put these in finally block (bcz if suppose anywhere in the program above from here are getting error/Exception then in that time code will not execute these line also, so resources will also not getting close. Thats why put them in finally block so it will execute always)

        }
        // catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e){ // Handling Exception what we haven't anticipate
            e.printStackTrace();
        }
        finally {
            // close resourses
            try {
                // statement.close();
                // connection.close();
                JdbcUtil.closeConnection(connection, statement);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
