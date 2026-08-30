package com.zabed.registrationappmvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
    private String name;
    private String email;
    private String password;

    private Connection connect = null;
    private PreparedStatement pstmnt = null;
    int rowAffected = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  int register(){
        try {
            connect = JdbcUtil.getConnection();
            String sql = "INSERT INTO usersinfo (name, email, password) VALUES (?, ?, ?, ?)";
            pstmnt = connect.prepareStatement(sql);

            pstmnt.setString(1, name);
            pstmnt.setString(2, email);
            pstmnt.setString(3, password);

            rowAffected = pstmnt.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                JdbcUtil.closeConnection(connect, pstmnt);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

        return rowAffected;
    }
}
