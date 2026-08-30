import java.sql.*;

public class BatchUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmnt = null;

        try {
            connection = JdbcUtil.getConnection();

            String query = "UPDATE studentInfo SET age = ? WHERE id = ?";
            pstmnt = connection.prepareStatement(query);

            pstmnt.setInt(1, 20);
            pstmnt.setInt(2, 1);
            pstmnt.addBatch();
            pstmnt.setInt(1, 22);
            pstmnt.setInt(2, 2);
            pstmnt.addBatch();
            pstmnt.setInt(1, 23);
            pstmnt.setInt(2, 3);
            pstmnt.addBatch();

            pstmnt.executeBatch();
            System.out.println("Check the DB to see the result");


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                JdbcUtil.closeConnection(connection, pstmnt);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
