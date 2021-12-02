/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import com.vm.jcomplex.Complex;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Group3
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
        System.out.println("Testing pushComplex");
        Complex[] expectedArray = {
            new Complex(8, 6),
            new Complex(9, 13),
            new Complex(3, -5),
            new Complex(7.0),
            new Complex(23.34),
            new Complex(54),
            new Complex(53, 22),
            new Complex(67, -45),
            //test per isReal()
            new Complex(3),
            new Complex(3),
            new Complex(-3),
            new Complex(0),
            new Complex(0),
            new Complex(0),
            new Complex(1),
            new Complex(1),
            new Complex(-1),
            new Complex(1.1),
            new Complex(1.1),
            new Complex(-1.1),
            new Complex(.1),
            new Complex(.1),
            new Complex(-.1),
            new Complex(0.0),
            new Complex(0.0),
            new Complex(0.0),
            new Complex(1.),
            new Complex(.0),
            //test interi per isComplex()
            new Complex(3, 1),
            new Complex(3, -1),
            new Complex(3, 1),
            new Complex(3, -1),
            new Complex(-3, 1),
            new Complex(-3, -1),
            new Complex(3, 1),
            new Complex(-3, 1),
            new Complex(3, 1),
            new Complex(-3, 1),
            new Complex(3, -1),
            new Complex(-3, -1),
            new Complex(3, 5),
            new Complex(3, -5),
            new Complex(3, 5),
            new Complex(3, -5),
            new Complex(-3, 5),
            new Complex(-3, -5),
            new Complex(3, 5),
            new Complex(3, -5),
            new Complex(3, 5),
            new Complex(3, -5),
            new Complex(-3, 5),
            new Complex(-3, -5),
            new Complex(3, 5),
            new Complex(-3, 5),
            new Complex(3, 5),
            new Complex(-3, 5),
            new Complex(3, -5),
            new Complex(-3, -5),
            new Complex(3, 5),
            new Complex(-3, 5),
            new Complex(3, 5),
            new Complex(-3, 5),
            new Complex(3, -5),
            new Complex(-3, -5),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0., 0),
            new Complex(.0, 0),
            new Complex(0.5, 0.3),
            new Complex(0.0, 1),
            //test double per isComplex()
            new Complex(3.1, 1),
            new Complex(3.1, -1),
            new Complex(3.1, 1),
            new Complex(3.1, -1),
            new Complex(-3.1, 1),
            new Complex(-3.1, -1),
            new Complex(3.1, 1),
            new Complex(-3.1, 1),
            new Complex(3.1, 1),
            new Complex(-3.1, 1),
            new Complex(3.1, -1),
            new Complex(-3.1, -1),
            new Complex(3.1, 5.9),
            new Complex(3.1, -5.9),
            new Complex(3.1, 5.9),
            new Complex(3.1, -5.9),
            new Complex(-3.1, 5.9),
            new Complex(-3.1, -5.9),
            new Complex(3.1, 5.9),
            new Complex(3.1, -5.9),
            new Complex(3.1, 5.9),
            new Complex(3.1, -5.9),
            new Complex(-3.1, 5.9),
            new Complex(-3.1, -5.9),
            new Complex(3.1, 5.9),
            new Complex(-3.1, 5.9),
            new Complex(3.1, 5.9),
            new Complex(-3.1, 5.9),
            new Complex(3.1, -5.9),
            new Complex(-3.1, -5.9),
            new Complex(3.1, 5.9),
            new Complex(-3.1, 5.9),
            new Complex(3.1, 5.9),
            new Complex(-3.1, 5.9),
            new Complex(3.1, -5.9),
            new Complex(-3.1, -5.9),
            //test aggiuntivi per isComplex()
            new Complex(5, 3.),
            new Complex(3.1, 1),
            new Complex(-0.887, .6),
            new Complex(5, .9),
            new Complex(5, 9.),
            new Complex(5, 0.),
            new Complex(5, 0.),
            new Complex(5, .9),
            //test interi per isImaginary()
            new Complex(0, 5),
            new Complex(0, 5),
            new Complex(0, -5),
            new Complex(0, 5),
            new Complex(0, 5),
            new Complex(0, -5),
            new Complex(0, 1),
            new Complex(0, 1),
            new Complex(0, -1),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 1),
            new Complex(0, 1),
            new Complex(0, -1),
            new Complex(0, 1),
            new Complex(0, 1),
            new Complex(0, -1),
            //test double per isImaginary()
            new Complex(0, 5.9),
            new Complex(0, 5.9),
            new Complex(0, -5.9),
            new Complex(0, 5.9),
            new Complex(0, 5.9),
            new Complex(0, -5.9),
            new Complex(0, 0.0),
            new Complex(0, 0.0),
            new Complex(0, 0.0),
            new Complex(0, 0.0),
            new Complex(0, .0),
            new Complex(0, 0.),
            //test aggiuntivi per isImaginary()
            new Complex(0, .9),
            new Complex(0, 9.),
            new Complex(0, .9)};

        Calculator instance = new Calculator();
        //test iniziale
        assertEquals(true, instance.pushComplex("8+6i"));
        assertEquals(true, instance.pushComplex("9+13i"));
        assertEquals(true, instance.pushComplex("3-5i"));
        assertEquals(true, instance.pushComplex("7"));
        assertEquals(false, instance.pushComplex("test"));
        assertEquals(false, instance.pushComplex("tre453we"));
        assertEquals(true, instance.pushComplex("23.34"));
        assertEquals(true, instance.pushComplex("54"));
        assertEquals(false, instance.pushComplex("23,34"));
        assertEquals(true, instance.pushComplex("53+22i"));
        assertEquals(true, instance.pushComplex("67-45i"));
        assertEquals(false, instance.pushComplex("53+22"));
        assertEquals(false, instance.pushComplex("67-45"));

        //test di numeri complessi puramente reali
        assertEquals(true, instance.pushComplex("3"));
        assertEquals(true, instance.pushComplex("+3"));
        assertEquals(true, instance.pushComplex("-3"));
        assertEquals(true, instance.pushComplex("0"));
        assertEquals(true, instance.pushComplex("+0"));
        assertEquals(true, instance.pushComplex("-0"));
        assertEquals(true, instance.pushComplex("1"));
        assertEquals(true, instance.pushComplex("+1"));
        assertEquals(true, instance.pushComplex("-1"));
        assertEquals(true, instance.pushComplex("1.1"));
        assertEquals(true, instance.pushComplex("+1.1"));
        assertEquals(true, instance.pushComplex("-1.1"));
        assertEquals(true, instance.pushComplex(".1"));
        assertEquals(true, instance.pushComplex("+.1"));
        assertEquals(true, instance.pushComplex("-.1"));
        assertEquals(true, instance.pushComplex("0.0"));
        assertEquals(true, instance.pushComplex("+0.0"));
        assertEquals(true, instance.pushComplex("-0.0"));
        assertEquals(false, instance.pushComplex("1.1.1"));
        assertEquals(false, instance.pushComplex("1+"));
        assertEquals(false, instance.pushComplex("1-"));
        assertEquals(false, instance.pushComplex("1.1+"));
        assertEquals(false, instance.pushComplex("1.1-"));
        assertEquals(false, instance.pushComplex("+1.1-"));
        assertEquals(false, instance.pushComplex("a5"));
        assertEquals(false, instance.pushComplex("j"));
        assertEquals(false, instance.pushComplex("5a"));
        assertEquals(true, instance.pushComplex("1."));
        assertEquals(false, instance.pushComplex("++3"));
        assertEquals(true, instance.pushComplex(".0"));
        assertEquals(false, instance.pushComplex("*5"));
        assertEquals(false, instance.pushComplex("1 + "));
        assertEquals(false, instance.pushComplex("1+   "));
        assertEquals(false, instance.pushComplex("parola"));

        //test interi di numeri complessi
        assertEquals(true, instance.pushComplex("3+i"));
        assertEquals(true, instance.pushComplex("3-i"));
        assertEquals(true, instance.pushComplex("+3+i"));
        assertEquals(true, instance.pushComplex("+3-i"));
        assertEquals(true, instance.pushComplex("-3+i"));
        assertEquals(true, instance.pushComplex("-3-i"));
        assertEquals(true, instance.pushComplex("i+3"));
        assertEquals(true, instance.pushComplex("i-3"));
        assertEquals(true, instance.pushComplex("+i+3"));
        assertEquals(true, instance.pushComplex("+i-3"));
        assertEquals(true, instance.pushComplex("-i+3"));
        assertEquals(true, instance.pushComplex("-i-3"));
        assertEquals(true, instance.pushComplex("3+5i"));
        assertEquals(true, instance.pushComplex("3-5i"));
        assertEquals(true, instance.pushComplex("+3+5i"));
        assertEquals(true, instance.pushComplex("+3-5i"));
        assertEquals(true, instance.pushComplex("-3+5i"));
        assertEquals(true, instance.pushComplex("-3-5i"));
        assertEquals(true, instance.pushComplex("3+i5"));
        assertEquals(true, instance.pushComplex("3-i5"));
        assertEquals(true, instance.pushComplex("+3+i5"));
        assertEquals(true, instance.pushComplex("+3-i5"));
        assertEquals(true, instance.pushComplex("-3+i5"));
        assertEquals(true, instance.pushComplex("-3-i5"));
        assertEquals(true, instance.pushComplex("5i+3"));
        assertEquals(true, instance.pushComplex("5i-3"));
        assertEquals(true, instance.pushComplex("+5i+3"));
        assertEquals(true, instance.pushComplex("+5i-3"));
        assertEquals(true, instance.pushComplex("-5i+3"));
        assertEquals(true, instance.pushComplex("-5i-3"));
        assertEquals(true, instance.pushComplex("i5+3"));
        assertEquals(true, instance.pushComplex("i5-3"));
        assertEquals(true, instance.pushComplex("+i5+3"));
        assertEquals(true, instance.pushComplex("+i5-3"));
        assertEquals(true, instance.pushComplex("-i5+3"));
        assertEquals(true, instance.pushComplex("-i5-3"));
        assertEquals(true, instance.pushComplex("0+0i"));
        assertEquals(true, instance.pushComplex("0+i0"));
        assertEquals(true, instance.pushComplex("+0+0i"));
        assertEquals(true, instance.pushComplex("-0+0i"));
        assertEquals(true, instance.pushComplex("-0-0i"));
        assertEquals(true, instance.pushComplex("+0+i0"));
        assertEquals(true, instance.pushComplex("i0+0"));
        assertEquals(true, instance.pushComplex("+i0+0"));
        assertEquals(true, instance.pushComplex("-0i+0"));
        assertEquals(true, instance.pushComplex("-0i-0"));
        assertEquals(true, instance.pushComplex("0.+0i"));
        assertEquals(true, instance.pushComplex(".0+0i"));
        assertEquals(true, instance.pushComplex("0.5+0.3i"));
        assertEquals(true, instance.pushComplex("i-0.0"));

        //test double di numeri complessi
        assertEquals(true, instance.pushComplex("3.1+i"));
        assertEquals(true, instance.pushComplex("3.1-i"));
        assertEquals(true, instance.pushComplex("+3.1+i"));
        assertEquals(true, instance.pushComplex("+3.1-i"));
        assertEquals(true, instance.pushComplex("-3.1+i"));
        assertEquals(true, instance.pushComplex("-3.1-i"));
        assertEquals(true, instance.pushComplex("i+3.1"));
        assertEquals(true, instance.pushComplex("i-3.1"));
        assertEquals(true, instance.pushComplex("+i+3.1"));
        assertEquals(true, instance.pushComplex("+i-3.1"));
        assertEquals(true, instance.pushComplex("-i+3.1"));
        assertEquals(true, instance.pushComplex("-i-3.1"));
        assertEquals(true, instance.pushComplex("3.1+5.9i"));
        assertEquals(true, instance.pushComplex("3.1-5.9i"));
        assertEquals(true, instance.pushComplex("+3.1+5.9i"));
        assertEquals(true, instance.pushComplex("+3.1-5.9i"));
        assertEquals(true, instance.pushComplex("-3.1+5.9i"));
        assertEquals(true, instance.pushComplex("-3.1-5.9i"));
        assertEquals(true, instance.pushComplex("3.1+i5.9"));
        assertEquals(true, instance.pushComplex("3.1-i5.9"));
        assertEquals(true, instance.pushComplex("+3.1+i5.9"));
        assertEquals(true, instance.pushComplex("+3.1-i5.9"));
        assertEquals(true, instance.pushComplex("-3.1+i5.9"));
        assertEquals(true, instance.pushComplex("-3.1-i5.9"));
        assertEquals(true, instance.pushComplex("5.9i+3.1"));
        assertEquals(true, instance.pushComplex("5.9i-3.1"));
        assertEquals(true, instance.pushComplex("+5.9i+3.1"));
        assertEquals(true, instance.pushComplex("+5.9i-3.1"));
        assertEquals(true, instance.pushComplex("-5.9i+3.1"));
        assertEquals(true, instance.pushComplex("-5.9i-3.1"));
        assertEquals(true, instance.pushComplex("i5.9+3.1"));
        assertEquals(true, instance.pushComplex("i5.9-3.1"));
        assertEquals(true, instance.pushComplex("+i5.9+3.1"));
        assertEquals(true, instance.pushComplex("+i5.9-3.1"));
        assertEquals(true, instance.pushComplex("-i5.9+3.1"));
        assertEquals(true, instance.pushComplex("-i5.9-3.1"));

        //test aggiuntivi di numeri complessi
        assertEquals(false, instance.pushComplex("-i5.9-3.1i"));
        assertEquals(false, instance.pushComplex("-5.9-3.1"));
        assertEquals(false, instance.pushComplex("-ii5.9-3.1"));
        assertEquals(true, instance.pushComplex("5+3.i"));
        assertEquals(false, instance.pushComplex("  3  .  1 +  i  "));
        assertEquals(true, instance.pushComplex("3.1+i"));
        assertEquals(false, instance.pushComplex(".6i  - 0.88   7"));
        assertEquals(true, instance.pushComplex(".6i-0.887"));
        assertEquals(false, instance.pushComplex("6.5 ++8i"));
        assertEquals(false, instance.pushComplex("6.5 * 8i"));
        assertEquals(false, instance.pushComplex("3+i5i"));
        assertEquals(true, instance.pushComplex("5+.9i"));
        assertEquals(true, instance.pushComplex("5+9.i"));
        assertEquals(true, instance.pushComplex("5+0.i"));
        assertEquals(true, instance.pushComplex("-0.i+5"));
        assertEquals(false, instance.pushComplex("3i2+5"));
        assertEquals(false, instance.pushComplex("5+9i."));
        assertEquals(false, instance.pushComplex("5+9i.."));
        assertEquals(false, instance.pushComplex("5+9i.+"));
        assertEquals(false, instance.pushComplex("5+i+"));
        assertEquals(false, instance.pushComplex("5+.i+"));
        assertEquals(false, instance.pushComplex("+9i.+5"));
        assertEquals(false, instance.pushComplex("+.i+5"));
        assertEquals(true, instance.pushComplex("+.9i+5"));
        assertEquals(false, instance.pushComplex(".i9+5"));
        assertEquals(false, instance.pushComplex("5 + i++"));
        assertEquals(false, instance.pushComplex("5++i"));
        assertEquals(false, instance.pushComplex("5+i+8-"));
        assertEquals(false, instance.pushComplex("++5+i+8-"));
        assertEquals(false, instance.pushComplex(".5ii+8"));
        assertEquals(false, instance.pushComplex("5  + i-"));
        assertEquals(false, instance.pushComplex("++5+3i"));
        assertEquals(false, instance.pushComplex("5+3i+++"));
        assertEquals(false, instance.pushComplex("5+3i+"));
        assertEquals(false, instance.pushComplex("++5+3i"));
        assertEquals(false, instance.pushComplex("+++5+3i"));
        assertEquals(false, instance.pushComplex("+5-- +3i"));
        assertEquals(false, instance.pushComplex("5++3i"));
        assertEquals(false, instance.pushComplex("5 + + 3i"));

        //test interi di numeri complessi puramente immaginari
        assertEquals(true, instance.pushComplex("5i"));
        assertEquals(true, instance.pushComplex("+5i"));
        assertEquals(true, instance.pushComplex("-5i"));
        assertEquals(true, instance.pushComplex("i5"));
        assertEquals(true, instance.pushComplex("+i5"));
        assertEquals(true, instance.pushComplex("-i5"));
        assertEquals(true, instance.pushComplex("i"));
        assertEquals(true, instance.pushComplex("+i"));
        assertEquals(true, instance.pushComplex("-i"));
        assertEquals(true, instance.pushComplex("0i"));
        assertEquals(true, instance.pushComplex("i0"));
        assertEquals(true, instance.pushComplex("+0i"));
        assertEquals(true, instance.pushComplex("-0i"));
        assertEquals(true, instance.pushComplex("1i"));
        assertEquals(true, instance.pushComplex("+1i"));
        assertEquals(true, instance.pushComplex("-1i"));
        assertEquals(true, instance.pushComplex("i1"));
        assertEquals(true, instance.pushComplex("+1i"));
        assertEquals(true, instance.pushComplex("-1i"));
        assertEquals(false, instance.pushComplex("1i+"));
        assertEquals(false, instance.pushComplex("1i-"));
        assertEquals(false, instance.pushComplex("+1i+"));
        assertEquals(false, instance.pushComplex("-1i-"));
        assertEquals(false, instance.pushComplex("+ 1 i + "));
        assertEquals(false, instance.pushComplex("- 1 i - "));
        assertEquals(false, instance.pushComplex("+ 1 i - "));
        assertEquals(false, instance.pushComplex("- 1 i + "));
        assertEquals(false, instance.pushComplex("i+"));
        assertEquals(false, instance.pushComplex("i-"));
        assertEquals(false, instance.pushComplex("--i"));
        assertEquals(false, instance.pushComplex("---i"));
        assertEquals(false, instance.pushComplex("++i"));
        assertEquals(false, instance.pushComplex("+++i"));
        assertEquals(false, instance.pushComplex("i---"));
        assertEquals(false, instance.pushComplex("i+++"));
        assertEquals(false, instance.pushComplex("i+-+-"));

        //test double di numeri complessi puramente immaginari
        assertEquals(true, instance.pushComplex("5.9i"));
        assertEquals(true, instance.pushComplex("+5.9i"));
        assertEquals(true, instance.pushComplex("-5.9i"));
        assertEquals(true, instance.pushComplex("i5.9"));
        assertEquals(true, instance.pushComplex("+i5.9"));
        assertEquals(true, instance.pushComplex("-i5.9"));
        assertEquals(true, instance.pushComplex("0.0i"));
        assertEquals(true, instance.pushComplex("+0.0i"));
        assertEquals(true, instance.pushComplex("-0.0i"));
        assertEquals(true, instance.pushComplex("i0.0"));
        assertEquals(false, instance.pushComplex("i."));
        assertEquals(false, instance.pushComplex(".i"));
        assertEquals(true, instance.pushComplex("i.0"));
        assertEquals(true, instance.pushComplex("0.i"));

        //test aggiuntivi di numeri complessi puramente immaginari
        assertEquals(true, instance.pushComplex(".9i"));
        assertEquals(true, instance.pushComplex("9.i"));
        assertEquals(false, instance.pushComplex(".i"));
        assertEquals(false, instance.pushComplex("-.i"));
        assertEquals(false, instance.pushComplex("3i2"));
        assertEquals(false, instance.pushComplex("9i."));
        assertEquals(false, instance.pushComplex("9i.."));
        assertEquals(false, instance.pushComplex("9i.+"));
        assertEquals(false, instance.pushComplex("i+"));
        assertEquals(false, instance.pushComplex(".i+"));
        assertEquals(false, instance.pushComplex("+9i."));
        assertEquals(false, instance.pushComplex("+.i"));
        assertEquals(true, instance.pushComplex("+.9i"));
        assertEquals(false, instance.pushComplex(".i9"));
        assertEquals(false, instance.pushComplex(" i + "));
        assertEquals(false, instance.pushComplex(" i - "));
        assertEquals(false, instance.pushComplex(" i ++ "));
        assertEquals(false, instance.pushComplex(" i + + "));
        assertEquals(false, instance.pushComplex(" +i + "));
        assertEquals(false, instance.pushComplex(" +  i + "));
        assertEquals(false, instance.pushComplex("++i"));
        assertEquals(false, instance.pushComplex("---i"));
        assertEquals(false, instance.pushComplex("+-i"));
        assertEquals(false, instance.pushComplex("i++"));
        assertEquals(false, instance.pushComplex("i+++"));
        assertEquals(false, instance.pushComplex("+i+"));
        assertEquals(false, instance.pushComplex("+i-"));
        assertEquals(false, instance.pushComplex("-i+"));
        assertEquals(false, instance.pushComplex("-i-"));
        assertEquals(false, instance.pushComplex("i.i"));
        assertEquals(false, instance.pushComplex("-i.i"));
        assertEquals(false, instance.pushComplex("i.i+++"));
        assertEquals(false, instance.pushComplex("ii9"));
        assertEquals(false, instance.pushComplex("9ii"));
        assertEquals(false, instance.pushComplex("0ii"));
        assertEquals(false, instance.pushComplex("0i0"));
        assertEquals(false, instance.pushComplex("-0ii"));
        assertEquals(false, instance.pushComplex("-i0i"));
        assertEquals(false, instance.pushComplex("-ii0"));
        assertEquals(false, instance.pushComplex("+iii"));
        assertEquals(false, instance.pushComplex("ii"));
        assertEquals(false, instance.pushComplex("iiii"));
        assertEquals(false, instance.pushComplex("-ii"));
        assertEquals(false, instance.pushComplex(".ii"));
        assertEquals(false, instance.pushComplex("9.ii"));
        assertEquals(false, instance.pushComplex("9.iii"));
        assertEquals(false, instance.pushComplex("ii.9"));
        assertEquals(false, instance.pushComplex("0.3.5i"));
        assertEquals(false, instance.pushComplex("0..3i"));
        assertEquals(false, instance.pushComplex("..3i"));
        assertEquals(false, instance.pushComplex("..i"));
        assertEquals(false, instance.pushComplex("..ii"));
        assertEquals(false, instance.pushComplex("6.8.i.7"));
        assertEquals(false, instance.pushComplex("7.9.i7"));
        assertEquals(false, instance.pushComplex("i.."));
        assertEquals(false, instance.pushComplex("i.7."));
        assertEquals(false, instance.pushComplex("++3+4i"));
        assertEquals(false, instance.pushComplex("++3i"));

        List<Complex> list = Arrays.asList(expectedArray);
        Collections.reverse(list);
        assertArrayEquals(list.toArray(), instance.getStack().toArray());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRecognizer() {
        System.out.println("Testing recognizer");
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
        assertEquals(0, instance.recognizer("i-0.0"));

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
        assertEquals(-1, instance.recognizer("  3  .  1 +  i  "));
        assertEquals(0, instance.recognizer("3.1+i"));
        assertEquals(-1, instance.recognizer(".6i  - 0.88   7"));
        assertEquals(0, instance.recognizer(".6i-0.887"));
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

        //test interi per isImaginary()
        assertEquals(0, instance.recognizer("5i"));
        assertEquals(0, instance.recognizer("+5i"));
        assertEquals(0, instance.recognizer("-5i"));
        assertEquals(0, instance.recognizer("i5"));
        assertEquals(0, instance.recognizer("+i5"));
        assertEquals(0, instance.recognizer("-i5"));
        assertEquals(0, instance.recognizer("i"));
        assertEquals(0, instance.recognizer("+i"));
        assertEquals(0, instance.recognizer("-i"));
        assertEquals(0, instance.recognizer("0i"));
        assertEquals(0, instance.recognizer("i0"));
        assertEquals(0, instance.recognizer("+0i"));
        assertEquals(0, instance.recognizer("-0i"));
        assertEquals(0, instance.recognizer("1i"));
        assertEquals(0, instance.recognizer("+1i"));
        assertEquals(0, instance.recognizer("-1i"));
        assertEquals(0, instance.recognizer("i1"));
        assertEquals(0, instance.recognizer("+1i"));
        assertEquals(0, instance.recognizer("-1i"));
        assertEquals(-1, instance.recognizer("1i+"));
        assertEquals(-1, instance.recognizer("1i-"));
        assertEquals(-1, instance.recognizer("+1i+"));
        assertEquals(-1, instance.recognizer("-1i-"));
        assertEquals(-1, instance.recognizer("+ 1 i + "));
        assertEquals(-1, instance.recognizer("- 1 i - "));
        assertEquals(-1, instance.recognizer("+ 1 i - "));
        assertEquals(-1, instance.recognizer("- 1 i + "));
        assertEquals(-1, instance.recognizer("i+"));
        assertEquals(-1, instance.recognizer("i-"));
        assertEquals(-1, instance.recognizer("--i"));
        assertEquals(-1, instance.recognizer("---i"));
        assertEquals(-1, instance.recognizer("++i"));
        assertEquals(-1, instance.recognizer("+++i"));
        assertEquals(-1, instance.recognizer("i---"));
        assertEquals(-1, instance.recognizer("i+++"));
        assertEquals(-1, instance.recognizer("i+-+-"));

        //test double per isImaginary()
        assertEquals(0, instance.recognizer("5.9i"));
        assertEquals(0, instance.recognizer("+5.9i"));
        assertEquals(0, instance.recognizer("-5.9i"));
        assertEquals(0, instance.recognizer("i5.9"));
        assertEquals(0, instance.recognizer("+i5.9"));
        assertEquals(0, instance.recognizer("-i5.9"));
        assertEquals(0, instance.recognizer("0.0i"));
        assertEquals(0, instance.recognizer("+0.0i"));
        assertEquals(0, instance.recognizer("-0.0i"));
        assertEquals(0, instance.recognizer("i0.0"));
        assertEquals(-1, instance.recognizer("i."));
        assertEquals(-1, instance.recognizer(".i"));
        assertEquals(0, instance.recognizer("i.0"));
        assertEquals(0, instance.recognizer("0.i"));

        //test aggiuntivi per isImaginary()
        assertEquals(0, instance.recognizer(".9i"));
        assertEquals(0, instance.recognizer("9.i"));
        assertEquals(-1, instance.recognizer(".i"));
        assertEquals(-1, instance.recognizer("-.i"));
        assertEquals(-1, instance.recognizer("3i2"));
        assertEquals(-1, instance.recognizer("9i."));
        assertEquals(-1, instance.recognizer("9i.."));
        assertEquals(-1, instance.recognizer("9i.+"));
        assertEquals(-1, instance.recognizer("i+"));
        assertEquals(-1, instance.recognizer(".i+"));
        assertEquals(-1, instance.recognizer("+9i."));
        assertEquals(-1, instance.recognizer("+.i"));
        assertEquals(0, instance.recognizer("+.9i"));
        assertEquals(-1, instance.recognizer(".i9"));
        assertEquals(-1, instance.recognizer(" i + "));
        assertEquals(-1, instance.recognizer(" i - "));
        assertEquals(-1, instance.recognizer(" i ++ "));
        assertEquals(-1, instance.recognizer(" i + + "));
        assertEquals(-1, instance.recognizer(" +i + "));
        assertEquals(-1, instance.recognizer(" +  i + "));
        assertEquals(-1, instance.recognizer("++i"));
        assertEquals(-1, instance.recognizer("---i"));
        assertEquals(-1, instance.recognizer("+-i"));
        assertEquals(-1, instance.recognizer("i++"));
        assertEquals(-1, instance.recognizer("i+++"));
        assertEquals(-1, instance.recognizer("+i+"));
        assertEquals(-1, instance.recognizer("+i-"));
        assertEquals(-1, instance.recognizer("-i+"));
        assertEquals(-1, instance.recognizer("-i-"));
        assertEquals(-1, instance.recognizer("i.i"));
        assertEquals(-1, instance.recognizer("-i.i"));
        assertEquals(-1, instance.recognizer("i.i+++"));
        assertEquals(-1, instance.recognizer("ii9"));
        assertEquals(-1, instance.recognizer("9ii"));
        assertEquals(-1, instance.recognizer("0ii"));
        assertEquals(-1, instance.recognizer("0i0"));
        assertEquals(-1, instance.recognizer("-0ii"));
        assertEquals(-1, instance.recognizer("-i0i"));
        assertEquals(-1, instance.recognizer("-ii0"));
        assertEquals(-1, instance.recognizer("+iii"));
        assertEquals(-1, instance.recognizer("ii"));
        assertEquals(-1, instance.recognizer("iiii"));
        assertEquals(-1, instance.recognizer("-ii"));
        assertEquals(-1, instance.recognizer(".ii"));
        assertEquals(-1, instance.recognizer("9.ii"));
        assertEquals(-1, instance.recognizer("9.iii"));
        assertEquals(-1, instance.recognizer("ii.9"));
        assertEquals(-1, instance.recognizer("0.3.5i"));
        assertEquals(-1, instance.recognizer("0..3i"));
        assertEquals(-1, instance.recognizer("..3i"));
        assertEquals(-1, instance.recognizer("..i"));
        assertEquals(-1, instance.recognizer("..ii"));
        assertEquals(-1, instance.recognizer("6.8.i.7"));
        assertEquals(-1, instance.recognizer("7.9.i7"));
        assertEquals(-1, instance.recognizer("i.."));
        assertEquals(-1, instance.recognizer("i.7."));

        assertEquals(1, instance.recognizer("+"));
        assertEquals(2, instance.recognizer("-"));
        assertEquals(3, instance.recognizer("*"));
        assertEquals(4, instance.recognizer("/"));
        assertEquals(5, instance.recognizer("sqrt"));
        assertEquals(6, instance.recognizer("+-"));

        assertEquals(-1, instance.recognizer("++"));
        assertEquals(-1, instance.recognizer("--"));
        assertEquals(-1, instance.recognizer("+--"));
        assertEquals(-1, instance.recognizer("log"));
        assertEquals(-1, instance.recognizer("srqt"));
        assertEquals(-1, instance.recognizer("-+"));
        assertEquals(-1, instance.recognizer("+ +"));
        assertEquals(-1, instance.recognizer("- -"));
        assertEquals(-1, instance.recognizer("$"));
        assertEquals(1, instance.recognizer(" +"));

    }

    @Test
    public void testAdd() {
        System.out.println("Testing add");
        int i = 0, j = 0;
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            for (Complex y : array) {
                instance.pushComplex(array[j].toString());
                instance.add();
                assertEquals(array[i].add(array[j]), instance.getStack().pop());
                j++;
                instance.pushComplex(array[i].toString());
            }
            j = 0;
            i++;
        }
    }

    @Test
    public void testSubtract() {
        System.out.println("Testing subtract");
        int i = 0, j = 0;
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            for (Complex y : array) {
                instance.pushComplex(array[j].toString());
                instance.subtract();
                assertEquals(array[i].subtract(array[j]), instance.getStack().pop());
                j++;
                instance.pushComplex(array[i].toString());
            }
            j = 0;
            i++;
        }
    }

    @Test
    public void testMultiply() {
        System.out.println("Testing multiply");
        int i = 0, j = 0;
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            for (Complex y : array) {
                instance.pushComplex(array[j].toString());
                instance.multiply();
                assertEquals(array[i].multiply(array[j]), instance.getStack().pop());
                j++;
                instance.pushComplex(array[i].toString());
            }
            j = 0;
            i++;
        }
    }

    @Test
    public void testDivide() {
        System.out.println("Testing divide");
        int i = 0, j = 0;
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            for (Complex y : array) {
                instance.pushComplex(array[j].toString());
                instance.divide();
                assertEquals(array[i].divide(array[j]), instance.getStack().pop());
                j++;
                instance.pushComplex(array[i].toString());
            }
            j = 0;
            i++;
        }
    }

    @Test
    public void testSqrt() {
        System.out.println("Testing sqrt");
        int i = 0;
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            instance.sqrt();
            assertEquals(array[i].sqrt(), instance.getStack().pop());
            i++;
        }
    }

    @Test
    public void testNegate() {
        System.out.println("Testing negate");
        int i = 0;
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            instance.negate();
            assertEquals(array[i].negate(), instance.getStack().pop());
            i++;
        }
    }

    @Test
    public void testClear() {
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};

        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        instance.clear();
        assertEquals(true, instance.getStack().isEmpty());
        instance.pushComplex(array[0].toString());
        instance.clear();
        assertEquals(true, instance.getStack().isEmpty());
        instance.clear();
        assertEquals(true, instance.getStack().isEmpty());
    }

    @Test
    public void testDrop() {
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        while (i >= 0) {
            assertEquals(instance.getStack().getFirst(), array[i]);
            instance.drop();
            i--;
        }
        assertEquals(true, instance.getStack().isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDropExceptions() {
        Calculator instance = new Calculator();
        instance.drop();
    }

    @Test
    public void testDup() {
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        while (i >= 0) {
            instance.dup();
            assertEquals(instance.getStack().pop(), instance.getStack().pop());
            i--;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testDupExceptions() {
        Calculator instance = new Calculator();
        instance.dup();
    }

    @Test
    public void testSwap() {
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        while (i > 0) {
            instance.swap();
            assertEquals(instance.getStack().pop(), array[i - 1]);
            assertEquals(instance.getStack().pop(), array[i]);
            i -= 2;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testSwapExceptions() {
        Calculator instance = new Calculator();
        instance.swap();
        instance.pushComplex("24+2i");
        instance.swap();
    }

    @Test
    public void testOver() {
        Calculator instance = new Calculator();
        Complex array[] = {new Complex(5, 3), new Complex(-5, -3), new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0), new Complex(0, 3), new Complex(0, -3), new Complex(0, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(0, 1), new Complex(-1, -1), new Complex(-1, 0), new Complex(0, -1), new Complex(1, -1), new Complex(-1, 1),
            new Complex(5.0, 3.0), new Complex(-5.0, -3.0), new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0), new Complex(-5.0, 0.0), new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0.0, 0.0),
            new Complex(1.0, 1.0), new Complex(1.0, 0.0), new Complex(0.0, 1.0), new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0), new Complex(-1.0, 0.0), new Complex(0.0, -1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7), new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7), new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7), new Complex(0.7, 0.7),
            new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7), new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7), new Complex(-1.7, 0.7), new Complex(0.7, -1.7)};
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        while (i > 0) {
            instance.over();
            assertEquals(instance.getStack().pop(), array[i - 1]);
            instance.getStack().pop();
            i--;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testOverExceptions() {
        Calculator instance = new Calculator();
        instance.dup();
        instance.pushComplex("24+2i");
        instance.swap();
    }

    @Test
    public void testMakeOperation() {
        System.out.println("Testing makeOperation");
        Calculator instance = new Calculator();
        //inserimenti necessari per il funzionamento delle operazioni
        instance.pushComplex("2+i");
        instance.pushComplex("33");
        instance.pushComplex("i8-4");
        instance.pushComplex("5i");
        instance.pushComplex("i+1");
        instance.pushComplex("84");
        instance.pushComplex("3+i");
        instance.pushComplex("-7i");
        instance.pushComplex("64i");
        instance.pushComplex("5i+3");
        instance.pushComplex("2");
        instance.pushComplex("9+4i");
        instance.pushComplex("19");
        instance.pushComplex("81i");
        instance.pushComplex("19+25i");
        instance.pushComplex("2+3i");
        instance.pushComplex("2+5i");
        instance.pushComplex("25");
        instance.pushComplex("19i");
        instance.pushComplex("i");
        instance.pushComplex("5i");
        instance.pushComplex("19+25i");
        assertEquals(-1, instance.makeOperation(-1));
        assertEquals(-1, instance.makeOperation(0));
        assertEquals(1, instance.makeOperation(1));
        assertEquals(2, instance.makeOperation(2));
        assertEquals(3, instance.makeOperation(3));
        assertEquals(4, instance.makeOperation(4));
        assertEquals(5, instance.makeOperation(5));
        assertEquals(6, instance.makeOperation(6));
        assertEquals(8, instance.makeOperation(8));
        assertEquals(9, instance.makeOperation(9));
        assertEquals(10, instance.makeOperation(10));
        assertEquals(11, instance.makeOperation(11));
        assertEquals(-1, instance.makeOperation(12));
        assertEquals(-1, instance.makeOperation(13));
        assertEquals(-1, instance.makeOperation(14));
        assertEquals(-1, instance.makeOperation(100));
        assertEquals(7, instance.makeOperation(7));

    }

}
