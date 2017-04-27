/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inse_app;

/**
 * @author UP735175
 * @author UP762633
 * @author UP775061
 * @author UP759167
 * @author UP784356
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mysql {

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    /**
     * MySQL constructor
     *
     * @param ip The IP Address of the MySQL server
     * @param db The Database you wish to use
     * @param username The username
     * @param password the Password
     */
    public Mysql(String ip, String db, String username, String password) {
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(("jdbc:mysql://" + ip + ":3306" + "/" + db + "?verifyServerCertificate=false&useSSL=true"), username, password);

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

    /**
     * Insert a new event into the calendar table and return the new Database
     *
     * @param email (String) Users email to bind event to
     * @param date (String) Event Date E.G 20171225
     * @param strtTme (String) Event Start Time E.G 14:00
     * @param endTme (String) Event end Time E.G 14:00
     * @param desc (String) The Event description
     * @param loc (String) The location of the Event
     * @param pic (String) The Picture reference
     * @param searchDate The date to search the DB for
     * @return The new Database
     */
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
            mySs = myStmt.executeQuery("SELECT * FROM Calendar WHERE Email ='" + email + "'AND EventDate ='" + searchDate + "';");
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return mySs;
    }

    /**
     * Search the calendar for all events from all users on a date
     *
     * @param date (String) Event Date E.G 20171225
     * @return MySQL ResultSet of data
     */
    public ResultSet search(String date) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Calendar WHERE EventDate =" + date + ";");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    /**
     * Search the calendar for all event by a certain user
     *
     * @param email (String) the email to look for
     * @return MySQL ResultSet of data
     */
    public ResultSet searchByEmail(String email) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Calendar WHERE Email ='" + email + "';");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    /**
     * Search the Calendar by user for a certain date
     *
     * @param email (String) The user to look for
     * @param date (String) The date to look for E.G 20171225
     * @return MySQL ResultSet of data
     */
    public ResultSet searchByEmailDate(String email, String date) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Calendar WHERE Email ='" + email + "'AND EventDate ='" + date + "';");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    /**
     * Search calendar by event ID
     *
     * @param id (String) Event ID
     * @return MySQL ResultSet of the data
     */
    public ResultSet searchByID(String id) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Calendar WHERE ID =" + id + ";");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    /**
     * Delete event from calendar by ID
     *
     * @param id (string) Event ID
     */
    public void deleteByID(String id) {
        try {
            myStmt = myConn.createStatement();
            myStmt.executeUpdate("DELETE FROM Calendar WHERE ID =" + id + ";");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * A custom MySQL Query
     *
     * @param qry (String) The SQL statement to execute
     * @return MySQL ResultSet of data
     */
    public ResultSet query(String qry) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(qry);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    /**
     * Retrieve Users Password based on Email
     *
     * @param email (String) Email to look for
     * @return MySQL Result of data
     */
    public ResultSet getPass(String email) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT password FROM userinfo WHERE email ='" + email + "';");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    /**
     * Check data base for login details
     *
     * @param user (String) Username
     * @param pass (String) Password
     * @return True if correct details | False if incorrect
     */
    public boolean login(String user, String pass) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM userinfo WHERE username='" + user + "' && password='" + pass + "';");

            if (myRs.isBeforeFirst()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return false;//unreachable statement
    }

    /**
     * Retrieve all data on a user based on username
     *
     * @param user (String) Username
     * @return MySQL ResultSet of data
     */
    public ResultSet searchByUserName(String user) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM userinfo WHERE userName ='" + user + "';");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    /**
     *Check if Provided Email is attached to a user
     * @param email (String) Email
     * @return (Boolean) true if valid | false if invalid
     */
    public boolean forgot(String email) {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM userinfo WHERE email='" + email + "';");

            if (myRs.isBeforeFirst()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return false;//unreachable statement
    }

    /**
     * Retrieve all userNames and Emails
     * @return MySQL ResultSet of data
     */
    public ResultSet getUsers() {
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT userName,email FROM userinfo ;");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    }

    /**
     * Insert a new user account into the DB
     * @param fn (String) First Name
     * @param ln (String) Last Name
     * @param userName (String) User Name
     * @param eMail (String) Email Address
     * @param pass  (String) Password
     */
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

    /**
     * Close MySQL Connection
     */
    public void close() {
        try {
            myRs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CalendarForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            myStmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CalendarForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            myConn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CalendarForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
