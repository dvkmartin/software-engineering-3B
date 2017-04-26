/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inse_app;

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

    public ResultSet searchByEmail(String email) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Calendar WHERE Email ='" + email + "';");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }
    
    public ResultSet searchByEmailDate(String email,String date) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Calendar WHERE Email ='" + email + "'AND EventDate ='"+date+"';");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    public ResultSet searchByID(String id) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Calendar WHERE ID =" + id + ";");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    public void deleteByID(String id) {
        try {
            myStmt = myConn.createStatement();
            myStmt.executeUpdate("DELETE FROM Calendar WHERE ID =" + id + ";");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
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

    public boolean login(String user, String pass) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM userinfo WHERE username='" + user + "' && password='" + pass + "';");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        if (myRs != null) {
            return true;
        } else {
            return false;
        }
    }
    
     public ResultSet searchByUserName(String user) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM userinfo WHERE userName ='" + user + "';");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    public ResultSet getUsers() {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT userName,email FROM userinfo ;");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    public void signup(String fn, String ln, String userName, String eMail, String pass) {
        try {
            myStmt = myConn.createStatement();

            myStmt.executeUpdate("INSERT INTO userinfo ( firstName, lastName, userName, email, password ) "
                    + "VALUES ('"
                    + fn + "','"
                    + ln + "','"
                    + userName + "','"
                    + eMail + "','"
                    + pass + "')");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
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
