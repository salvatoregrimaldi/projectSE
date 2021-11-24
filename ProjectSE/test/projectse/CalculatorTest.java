/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import com.vm.jcomplex.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class CalculatorTest {
    
    public CalculatorTest() {
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
     * Test of PushComplex method, of class Calculator.
     */
    @Test
    public void testPushComplex() {
        System.out.println("pushComplex");
        Complex[] expectedArray = {new Complex(7.0),new Complex(3,-5),new Complex(8,6)};
        Calculator instance = new Calculator();
        instance.pushComplex("8+6i");
        instance.pushComplex("9+13i");
        instance.popComplex();
        instance.pushComplex("3-5i");
        instance.pushComplex("7");
        assertArrayEquals(expectedArray,instance.getStack().toArray());
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testRecognizer() {
        System.out.println("recognizer");
        Calculator instance = new Calculator();
        assertEquals(-1,instance.recognizer("test"));
        assertEquals(-1,instance.recognizer("tre453we"));
        assertEquals(0,instance.recognizer("23.34"));
        assertEquals(0,instance.recognizer("54"));
        assertEquals(-1,instance.recognizer("23,34"));        
        assertEquals(0,instance.recognizer("53+22i"));
        assertEquals(0,instance.recognizer("67-45i"));
        assertEquals(-1,instance.recognizer("53+22"));
        assertEquals(-1,instance.recognizer("67-45"));
    }
    
}
