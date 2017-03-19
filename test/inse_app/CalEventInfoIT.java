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
public class CalEventInfoIT {
    
    public CalEventInfoIT() {
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
     * Test of getEventID method, of class CalEventInfo.
     */
    @Test
    public void testGetEventID() {
        String ID = "1";
        CalEventInfo info = new CalEventInfo(ID);
        String result = info.getEventID();
        String expResult = "1";
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setEventID method, of class CalEventInfo.
     */
    @Test
    public void testSetEventID() {
        String ID = "1";
        CalEventInfo info = new CalEventInfo(ID);
        info.setEventID("2");
        String result = info.getEventID();
        String expResult = "2";
        assertEquals(expResult, result);
    }
    
}
