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
        Complex[] expectedArray = {new Complex(7.0), new Complex(3, -5), new Complex(8, 6)};
        Calculator instance = new Calculator();
        instance.pushComplex("8+6i");
        instance.pushComplex("9+13i");
        instance.popComplex();
        instance.pushComplex("3-5i");
        instance.pushComplex("7");
        assertArrayEquals(expectedArray, instance.getStack().toArray());

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRecognizer() {
        System.out.println("recognizer");
        Calculator instance = new Calculator();
        assertEquals(-1, instance.recognizer("test"));
        assertEquals(-1, instance.recognizer("tre453we"));
        assertEquals(0, instance.recognizer("23.34"));
        assertEquals(0, instance.recognizer("54"));
        assertEquals(-1, instance.recognizer("23,34"));
        assertEquals(0, instance.recognizer("53+22i"));
        assertEquals(0, instance.recognizer("67-45i"));
        assertEquals(-1, instance.recognizer("53+22"));
        assertEquals(-1, instance.recognizer("67-45"));

        //test per isReal()
        assertEquals(0, instance.recognizer("3"));
        assertEquals(0, instance.recognizer("+3"));
        assertEquals(0, instance.recognizer("-3"));
        assertEquals(0, instance.recognizer("0"));
        assertEquals(0, instance.recognizer("+0"));
        assertEquals(0, instance.recognizer("-0"));
        assertEquals(0, instance.recognizer("1"));
        assertEquals(0, instance.recognizer("+1"));
        assertEquals(0, instance.recognizer("-1"));
        assertEquals(0, instance.recognizer("1.1"));
        assertEquals(0, instance.recognizer("+1.1"));
        assertEquals(0, instance.recognizer("-1.1"));
        assertEquals(0, instance.recognizer(".1"));
        assertEquals(0, instance.recognizer("+.1"));
        assertEquals(0, instance.recognizer("-.1"));
        assertEquals(0, instance.recognizer("0.0"));
        assertEquals(0, instance.recognizer("+0.0"));
        assertEquals(0, instance.recognizer("-0.0"));
        assertEquals(-1, instance.recognizer("1.1.1"));
        assertEquals(-1, instance.recognizer("1+"));
        assertEquals(-1, instance.recognizer("1-"));
        assertEquals(-1, instance.recognizer("1.1+"));
        assertEquals(-1, instance.recognizer("1.1-"));
        assertEquals(-1, instance.recognizer("+1.1-"));
        assertEquals(-1, instance.recognizer("a5"));
        assertEquals(-1, instance.recognizer("j"));
        assertEquals(-1, instance.recognizer("5a"));
        assertEquals(0, instance.recognizer("1."));
        assertEquals(-1, instance.recognizer("++3"));
        assertEquals(0, instance.recognizer(".0"));
        assertEquals(-1, instance.recognizer("*5"));
        assertEquals(-1, instance.recognizer("1 + "));
        assertEquals(-1, instance.recognizer("1+   "));
        assertEquals(-1, instance.recognizer("parola"));

        //test interi per isComplex()
        assertEquals(0, instance.recognizer("3+i"));
        assertEquals(0, instance.recognizer("3-i"));
        assertEquals(0, instance.recognizer("+3+i"));
        assertEquals(0, instance.recognizer("+3-i"));
        assertEquals(0, instance.recognizer("-3+i"));
        assertEquals(0, instance.recognizer("-3-i"));
        assertEquals(0, instance.recognizer("i+3"));
        assertEquals(0, instance.recognizer("i-3"));
        assertEquals(0, instance.recognizer("+i+3"));
        assertEquals(0, instance.recognizer("+i-3"));
        assertEquals(0, instance.recognizer("-i+3"));
        assertEquals(0, instance.recognizer("-i-3"));
        assertEquals(0, instance.recognizer("3+5i"));
        assertEquals(0, instance.recognizer("3-5i"));
        assertEquals(0, instance.recognizer("+3+5i"));
        assertEquals(0, instance.recognizer("+3-5i"));
        assertEquals(0, instance.recognizer("-3+5i"));
        assertEquals(0, instance.recognizer("-3-5i"));
        assertEquals(0, instance.recognizer("3+i5"));
        assertEquals(0, instance.recognizer("3-i5"));
        assertEquals(0, instance.recognizer("+3+i5"));
        assertEquals(0, instance.recognizer("+3-i5"));
        assertEquals(0, instance.recognizer("-3+i5"));
        assertEquals(0, instance.recognizer("-3-i5"));
        assertEquals(0, instance.recognizer("5i+3"));
        assertEquals(0, instance.recognizer("5i-3"));
        assertEquals(0, instance.recognizer("+5i+3"));
        assertEquals(0, instance.recognizer("+5i-3"));
        assertEquals(0, instance.recognizer("-5i+3"));
        assertEquals(0, instance.recognizer("-5i-3"));
        assertEquals(0, instance.recognizer("i5+3"));
        assertEquals(0, instance.recognizer("i5-3"));
        assertEquals(0, instance.recognizer("+i5+3"));
        assertEquals(0, instance.recognizer("+i5-3"));
        assertEquals(0, instance.recognizer("-i5+3"));
        assertEquals(0, instance.recognizer("-i5-3"));
        assertEquals(0, instance.recognizer("0+0i"));
        assertEquals(0, instance.recognizer("0+i0"));
        assertEquals(0, instance.recognizer("+0+0i"));
        assertEquals(0, instance.recognizer("-0+0i"));
        assertEquals(0, instance.recognizer("-0-0i"));
        assertEquals(0, instance.recognizer("+0+i0"));
        assertEquals(0, instance.recognizer("i0+0"));
        assertEquals(0, instance.recognizer("+i0+0"));
        assertEquals(0, instance.recognizer("-0i+0"));
        assertEquals(0, instance.recognizer("-0i-0"));
        assertEquals(0, instance.recognizer("0.+0i"));
        assertEquals(0, instance.recognizer(".0+0i"));
        assertEquals(0, instance.recognizer("0.5+0.3i"));

        //test double per isComplex()
        assertEquals(0, instance.recognizer("3.1+i"));
        assertEquals(0, instance.recognizer("3.1-i"));
        assertEquals(0, instance.recognizer("+3.1+i"));
        assertEquals(0, instance.recognizer("+3.1-i"));
        assertEquals(0, instance.recognizer("-3.1+i"));
        assertEquals(0, instance.recognizer("-3.1-i"));
        assertEquals(0, instance.recognizer("i+3.1"));
        assertEquals(0, instance.recognizer("i-3.1"));
        assertEquals(0, instance.recognizer("+i+3.1"));
        assertEquals(0, instance.recognizer("+i-3.1"));
        assertEquals(0, instance.recognizer("-i+3.1"));
        assertEquals(0, instance.recognizer("-i-3.1"));
        assertEquals(0, instance.recognizer("3.1+5.9i"));
        assertEquals(0, instance.recognizer("3.1-5.9i"));
        assertEquals(0, instance.recognizer("+3.1+5.9i"));
        assertEquals(0, instance.recognizer("+3.1-5.9i"));
        assertEquals(0, instance.recognizer("-3.1+5.9i"));
        assertEquals(0, instance.recognizer("-3.1-5.9i"));
        assertEquals(0, instance.recognizer("3.1+i5.9"));
        assertEquals(0, instance.recognizer("3.1-i5.9"));
        assertEquals(0, instance.recognizer("+3.1+i5.9"));
        assertEquals(0, instance.recognizer("+3.1-i5.9"));
        assertEquals(0, instance.recognizer("-3.1+i5.9"));
        assertEquals(0, instance.recognizer("-3.1-i5.9"));
        assertEquals(0, instance.recognizer("5.9i+3.1"));
        assertEquals(0, instance.recognizer("5.9i-3.1"));
        assertEquals(0, instance.recognizer("+5.9i+3.1"));
        assertEquals(0, instance.recognizer("+5.9i-3.1"));
        assertEquals(0, instance.recognizer("-5.9i+3.1"));
        assertEquals(0, instance.recognizer("-5.9i-3.1"));
        assertEquals(0, instance.recognizer("i5.9+3.1"));
        assertEquals(0, instance.recognizer("i5.9-3.1"));
        assertEquals(0, instance.recognizer("+i5.9+3.1"));
        assertEquals(0, instance.recognizer("+i5.9-3.1"));
        assertEquals(0, instance.recognizer("-i5.9+3.1"));
        assertEquals(0, instance.recognizer("-i5.9-3.1"));

        //test aggiuntivi per isComplex()
        assertEquals(-1, instance.recognizer("-i5.9-3.1i"));
        assertEquals(-1, instance.recognizer("-5.9-3.1"));
        assertEquals(-1, instance.recognizer("-ii5.9-3.1"));
        assertEquals(0, instance.recognizer("5+3.i"));
        assertEquals(0, instance.recognizer("  3  .  1 +  i  "));
        assertEquals(0, instance.recognizer(".6i  - 0.88   7"));
        assertEquals(-1, instance.recognizer("6.5 ++8i"));
        assertEquals(-1, instance.recognizer("6.5 * 8i"));
        assertEquals(-1, instance.recognizer("3+i5i"));
        assertEquals(0, instance.recognizer("5+.9i"));
        assertEquals(0, instance.recognizer("5+9.i"));
        assertEquals(0, instance.recognizer("5+0.i"));
        assertEquals(0, instance.recognizer("-0.i+5"));
        assertEquals(-1, instance.recognizer("3i2+5"));
        assertEquals(-1, instance.recognizer("5+9i."));
        assertEquals(-1, instance.recognizer("5+9i.."));
        assertEquals(-1, instance.recognizer("5+9i.+"));
        assertEquals(-1, instance.recognizer("5+i+"));
        assertEquals(-1, instance.recognizer("5+.i+"));
        assertEquals(-1, instance.recognizer("+9i.+5"));
        assertEquals(-1, instance.recognizer("+.i+5"));
        assertEquals(0, instance.recognizer("+.9i+5"));
        assertEquals(-1, instance.recognizer(".i9+5"));
        assertEquals(-1, instance.recognizer("5 + i++"));
        assertEquals(-1, instance.recognizer("5++i"));
        assertEquals(-1, instance.recognizer("5+i+8-"));
        assertEquals(-1, instance.recognizer("++5+i+8-"));
        assertEquals(-1, instance.recognizer(".5ii+8"));
        assertEquals(-1, instance.recognizer("5  + i-"));
        assertEquals(-1, instance.recognizer("++5+3i"));
        assertEquals(-1, instance.recognizer("5+3i+++"));
        assertEquals(-1, instance.recognizer("5+3i+"));
        assertEquals(-1, instance.recognizer("++5+3i"));
        assertEquals(-1, instance.recognizer("+++5+3i"));
        assertEquals(-1, instance.recognizer("+5-- +3i"));
        assertEquals(-1, instance.recognizer("5++3i"));
        assertEquals(-1, instance.recognizer("5 + + 3i"));

    }

}
