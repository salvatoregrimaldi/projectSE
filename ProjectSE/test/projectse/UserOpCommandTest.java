/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Asdrubale
 */
public class UserOpCommandTest {
    
    private Calculator calculator;
    
    public UserOpCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorExceptions1() {
        UserOpCommand comm1 = new UserOpCommand(" alle enri  ", "+i 3 +i drop >z", calculator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorExceptions2() {
        UserOpCommand comm1 = new UserOpCommand(" salvo  ", "++i 3 +i drop >z", calculator);
    }
    
}
