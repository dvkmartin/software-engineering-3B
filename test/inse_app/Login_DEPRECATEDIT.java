/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inse_app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alan
 */
public class Login_DEPRECATEDIT {
    
    public Login_DEPRECATEDIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setStatus method, of class Login_DEPRECATED.
     */
    @Test
    public void testSetStatus() {
        boolean success = false;
        Login_DEPRECATED login = new Login_DEPRECATED();
        login.setStatus(success);
        boolean expResult = false;
        boolean result = login.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Login_DEPRECATED.
     */
    @Test
    public void testGetStatus() {
        boolean success = true;
        Login_DEPRECATED login = new Login_DEPRECATED();
        login.setStatus(success);
        boolean expResult = true;
        boolean result = login.getStatus();
        assertEquals(expResult, result);
    }
    
}
