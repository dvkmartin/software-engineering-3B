/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.sql.*;

public class Login {

    private Connection con;
    private Statement st;
    private boolean status;

    public void DBConnect() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://213.131.183:3306/insedb", "INSE", "INSE3B");
            st = con.createStatement();

        } catch (Exception ex) {

            System.out.println("Error: " + ex);
        }
    }

    public void Login(String user, String pass) {

        try {

            String query = "SELECT count(*) AS match_found FROM userinfo WHERE username=? && password=?";

            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://213.131.183:3306/insedb", "INSE", "INSE3B");
            if (conn != null) {
                System.out.println("Connected");
            }

            PreparedStatement prepst = conn.prepareStatement(query);

            prepst.setString(1, user);
            prepst.setString(2, pass);

            prepst.executeQuery();
            //st.close();

            ResultSet rs = prepst.executeQuery();
            boolean loginSuccess;

            if (rs.next()) {
                loginSuccess = rs.getBoolean("match_found");
                setStatus(loginSuccess);
                System.out.println(loginSuccess);
            }

        } catch (Exception ex) {

            System.err.println(ex.getMessage());

        }

    }

    public void Signup(String fn, String ln, String un, String em, String p) {

        try {
            String query = "INSERT INTO userinfo ( firstName, lastName, userName, email, password ) VALUES (?, ?, ?, ?, ?)";

            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://213.131.183:3306/insedb", "INSE", "INSE3B");
            if (conn != null) {
                System.out.println("Connected");
            }
            
            PreparedStatement prepst = conn.prepareStatement(query);
            
            prepst.setString(1, fn);
            prepst.setString(2, ln);
            prepst.setString(3, un);
            prepst.setString(4, em);
            prepst.setString(5, p);
            
            prepst.executeUpdate();
            
            prepst.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void setStatus(boolean success) {
        status = success;
    }

    public boolean getStatus() {
        return status;
    }

}
