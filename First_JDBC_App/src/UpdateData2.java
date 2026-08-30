import java.sql.*;
import java.util.Scanner;

public class UpdateData2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmnt = null;

        try {
            connection = JdbcUtil.getConnection();

            // Query
            String query = "UPDATE studentInfo SET age = ? WHERE id = ?";
            pstmnt = connection.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter info that needs to be update:");

            System.out.println("Enter the id:");
            int id = sc.nextInt();

            System.out.println("Enter updated age:");
            int age = sc.nextInt();


            sc.close();
            pstmnt.setInt(1, age);
            pstmnt.setInt(2, id);

            int rowAffected = pstmnt.executeUpdate();
            if(rowAffected == 0){
                System.out.println("Updation failed");
            }
            else{
                System.out.println("Updated successfully!");
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
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
