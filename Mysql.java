/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mysql {

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    public Mysql(String ip, String db, String username, String password) {
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(("jdbc:mysql://" + ip + ":3306" + "/" + db), username, password);

            /* myStmt.executeUpdate("CREATE TABLE IF NOT EXISTS Calendar ("
             + "ID int(11) NOT NULL AUTO_INCREMENT,"
             + "Email varchar(100) NOT NULL,"
             + "EventDate date NOT NULL,"
             + "EventTimeStart time NOT NULL,"
             + "EventTimeEnd time NOT NULL,"
             + "EventDescription varchar(500) NOT NULL,"
             + "EventLocation varchar(500) NOT NULL,"
             + "PRIMARY KEY (ID),"
             + "UNIQUE KEY ID_UNIQUE (ID))");*/
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public ResultSet insert(String email, String date, String strtTme, String endTme, String desc, String loc, String pic, String searchDate) {
        ResultSet mySs = null;
        try {
            myStmt = myConn.createStatement();

            myStmt.executeUpdate("INSERT INTO Calendar (Email, EventDate, EventTimeStart, EventTimeEnd, EventDescription, EventLocation, PictureRef) "
                    + "VALUES ('"
                    + email + "','"
                    + date + "','"
                    + strtTme + "','"
                    + endTme + "','"
                    + desc + "','"
                    + loc + "','"
                    + pic
                    + "')");
            mySs = myStmt.executeQuery("SELECT * FROM Calendar WHERE EventDate =" + searchDate + ";");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return mySs;
    }

    public ResultSet search(String date) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Calendar WHERE EventDate =" + date + ";");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;

    }

    public ResultSet query(String qry) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(qry);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    public void close() {
        try {
            myRs.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            myStmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            myConn.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}