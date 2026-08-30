// Now want to retrieve data of specific id 
import java.sql.*;
import java.util.Scanner;

public class RetrieveData2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmnt = null;
        ResultSet rs = null;

        try {
            connection = JdbcUtil.getConnection();

            //query
            String query = "SELECT id, name, age, city FROM studentInfo WHERE id = ?";
            pstmnt = connection.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your id for retrieve:");
            int id = sc.nextInt();

            sc.close();
            pstmnt.setInt(1, id);

            rs = pstmnt.executeQuery();
            if(rs.next()){
                int sid = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String city = rs.getString(4);

                System.out.println(sid + " " + name + " " + age + " " + city);
            }
            else{
                System.out.println("There is no record with id:" + id);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        finally {
            try {
                JdbcUtil.closeConnection(connection, pstmnt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}