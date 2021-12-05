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

    Calculator instance;
    Complex[] array;

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
        instance = new Calculator();
        array = new Complex[]{
            new Complex(0, 0), new Complex(0.0, 0.0), new Complex(0, 1), new Complex(0, -1),
            new Complex(0.0, 3.0), new Complex(0.0, -3.0), new Complex(0, 3), new Complex(0, -3),
            new Complex(0.0, 1.0), new Complex(0.0, -1.0), new Complex(5, 3), new Complex(-5, -3),
            new Complex(5, -3), new Complex(-5, 3), new Complex(5, 0), new Complex(-5, 0),
            new Complex(1, 1), new Complex(1, 0), new Complex(-1, -1), new Complex(-1, 0),
            new Complex(1, -1), new Complex(-1, 1), new Complex(5.0, 3.0), new Complex(-5.0, -3.0),
            new Complex(5.0, -3.0), new Complex(-5.0, 3.0), new Complex(5.0, 0.0),
            new Complex(-5.0, 0.0), new Complex(1.0, 1.0), new Complex(1.0, 0.0),
            new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0),
            new Complex(-1.0, 0.0), new Complex(5.7, 3.7), new Complex(-5.7, -3.7),
            new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7),
            new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7),
            new Complex(0.7, 0.7), new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7),
            new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7),
            new Complex(-1.7, 0.7), new Complex(0.7, -1.7)
        };
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of PushComplex method, of class Calculator.
     */
    @Test
    public void testPushComplex() {
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
    }

    @Test
    public void testRecognizer() {
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

        //test per le stack operations       
        assertEquals(7, instance.recognizer("clear"));
        assertEquals(8, instance.recognizer("drop"));
        assertEquals(9, instance.recognizer("dup"));
        assertEquals(10, instance.recognizer("swap"));
        assertEquals(11, instance.recognizer("over"));

        assertEquals(-1, instance.recognizer("cle ar"));
        assertEquals(-1, instance.recognizer("dr op"));
        assertEquals(-1, instance.recognizer("d up"));
        assertEquals(-1, instance.recognizer("swa p"));
        assertEquals(-1, instance.recognizer("ov er"));

        //test per le var operations
        for (char x = 'a'; x <= 'z'; x++) {
            assertEquals(12, instance.recognizer("show " + x));
            //continuare qui
        }

        for (char x = 0; x <= 96; x++) {
            assertEquals(-1, instance.recognizer("show " + x));
        }
        for (char x = 123; x <= 127; x++) {
            assertEquals(-1, instance.recognizer("show" + x));
        }
        assertEquals(-1, instance.recognizer("show" + "  %"));
        assertEquals(-1, instance.recognizer("show" + "  +"));
        assertEquals(-1, instance.recognizer("show" + "  -"));
        assertEquals(-1, instance.recognizer("show" + "  /"));
        assertEquals(-1, instance.recognizer("show" + "  9"));
        assertEquals(-1, instance.recognizer("show" + "  0"));
    }

    @Test
    public void testAddOperands() {
        int i = 0, j = 0;
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
    public void testAddFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        Complex app = array[i];
        while (i > 0) {
            app = array[i - 1].add(app);
            instance.add();
            assertEquals(instance.getStack().getFirst(), app);
            i--;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testAddExceptions() {
        instance.add();
        instance.pushComplex("24+2i");
        instance.add();
    }

    @Test
    public void testSubtractOperands() {
        int i = 0, j = 0;
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
    public void testSubtractFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        Complex app = array[i];
        while (i > 0) {
            app = array[i - 1].subtract(app);
            instance.subtract();
            assertEquals(instance.getStack().getFirst(), app);
            i--;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testSubtractExceptions() {
        instance.subtract();
        instance.pushComplex("24+2i");
        instance.subtract();
    }

    @Test
    public void testMultiplyOperands() {
        int i = 0, j = 0;
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
    public void testMultiplyFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        Complex app = array[i];
        while (i > 0) {
            app = array[i - 1].multiply(app);
            instance.multiply();
            assertEquals(instance.getStack().getFirst(), app);
            i--;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testMultiplyExceptions() {
        instance.multiply();
        instance.pushComplex("24+2i");
        instance.multiply();
    }

    @Test
    public void testDivideOperands() {
        int i = 0, j = 0;
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
    public void testDivideFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        Complex app = array[i];
        while (i > 0) {
            app = array[i - 1].divide(app);
            instance.divide();
            assertEquals(instance.getStack().getFirst(), app);
            i--;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testDivideExceptions() {
        instance.divide();
        instance.pushComplex("24+2i");
        instance.divide();
    }

    @Test
    public void testSqrtOperands() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            instance.sqrt();
            assertEquals(array[i].sqrt(), instance.getStack().pop());
            i++;
        }
    }

    @Test
    public void testSqrtFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        while (i >= 0) {
            instance.sqrt();
            assertEquals(instance.getStack().pop(), array[i].sqrt());
            i--;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testSqrtExceptions() {
        instance.sqrt();
    }

    @Test
    public void testNegateOperands() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            instance.negate();
            assertEquals(array[i].negate(), instance.getStack().pop());
            i++;
        }
    }

    @Test
    public void testNegateFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(array[i].toString());
            i++;
        }
        i--;
        while (i >= 0) {
            instance.negate();
            assertEquals(instance.getStack().pop(), array[i].negate());
            i--;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testNegateExceptions() {
        instance.negate();
    }

    @Test
    public void testClear() {
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
        instance.drop();
    }

    @Test
    public void testDup() {
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
        instance.dup();
    }

    @Test
    public void testSwap() {
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
        instance.swap();
        instance.pushComplex("24+2i");
        instance.swap();
    }

    @Test
    public void testOver() {
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
        instance.dup();
        instance.pushComplex("24+2i");
        instance.swap();
    }

    @Test
    public void testMakeOperation() {
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

    @Test
    public void testMakeVarOperation() {
        //inserimenti necessari per il funzionamento delle operazioni
        instance.pushComplex("2+i");

        VarCollection<Complex> v = instance.getVars();
        v.setVar('a', new Complex(0, 0));
        v.setVar('b', new Complex(0, 1));
        v.setVar('c', new Complex(0.0, 3.0));
        v.setVar('d', new Complex(0, 3));
        v.setVar('e', new Complex(0.0, 1.0));
        v.setVar('f', new Complex(-5, -3));
        v.setVar('g', new Complex(-5, 3));
        v.setVar('h', new Complex(5, 0));
        v.setVar('i', new Complex(1, 1));
        v.setVar('j', new Complex(1, 0));
        v.setVar('k', new Complex(-1, -1));
        v.setVar('l', new Complex(-1, 0));
        v.setVar('m', new Complex(1, -1));
        v.setVar('n', new Complex(-1, 1));
        v.setVar('o', new Complex(5.0, 3.0));
        v.setVar('p', new Complex(-5.0, 3.0));
        v.setVar('q', new Complex(1.0, 1.0));
        v.setVar('r', new Complex(1.0, 0.0));
        v.setVar('s', new Complex(-5.7, -3.7));
        v.setVar('t', new Complex(0.7, 3.7));
        v.setVar('u', new Complex(0.7, -3.7));
        v.setVar('v', new Complex(1.7, 0.7));
        v.setVar('w', new Complex(10.7, 1.7));
        v.setVar('x', new Complex(-5, 0));
        v.setVar('y', new Complex(-1.7, 0.7));
        v.setVar('z', new Complex(0.7, -1.7));

        for (char x = 'a'; x <= 'z'; x++) {
            assertEquals(13, instance.makeVarOperation(13, x));
            assertEquals(14, instance.makeVarOperation(14, x));
            assertEquals(15, instance.makeVarOperation(15, x));
            assertEquals(16, instance.makeVarOperation(16, x));
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testMakeVarOperationExceptions() {
        //inserimenti necessari per il funzionamento delle operazioni
        instance.pushComplex("2+i");

        VarCollection<Complex> v = instance.getVars();
        v.setVar('a', new Complex(0, 0));
        v.setVar('b', new Complex(0, 1));
        v.setVar('c', new Complex(0.0, 3.0));
        v.setVar('d', new Complex(0, 3));
        v.setVar('e', new Complex(0.0, 1.0));
        v.setVar('f', new Complex(-5, -3));
        v.setVar('g', new Complex(-5, 3));
        v.setVar('h', new Complex(5, 0));
        v.setVar('i', new Complex(1, 1));
        v.setVar('j', new Complex(1, 0));
        v.setVar('k', new Complex(-1, -1));
        v.setVar('l', new Complex(-1, 0));
        v.setVar('m', new Complex(1, -1));
        v.setVar('n', new Complex(-1, 1));
        v.setVar('o', new Complex(5.0, 3.0));
        v.setVar('p', new Complex(-5.0, 3.0));
        v.setVar('q', new Complex(1.0, 1.0));
        v.setVar('r', new Complex(1.0, 0.0));
        v.setVar('s', new Complex(-5.7, -3.7));
        v.setVar('t', new Complex(0.7, 3.7));
        v.setVar('u', new Complex(0.7, -3.7));
        v.setVar('v', new Complex(1.7, 0.7));
        v.setVar('w', new Complex(10.7, 1.7));
        v.setVar('x', new Complex(-5, 0));
        v.setVar('y', new Complex(-1.7, 0.7));
        v.setVar('z', new Complex(0.7, -1.7));

        for (char x = 0; x < 96; x++) {
            instance.makeVarOperation(13, x);
            instance.makeVarOperation(14, x);
            instance.makeVarOperation(15, x);
            instance.makeVarOperation(16, x);
        }
        for (char x = 123; x <= 127; x++) {
            instance.makeVarOperation(13, x);
            instance.makeVarOperation(14, x);
            instance.makeVarOperation(15, x);
            instance.makeVarOperation(16, x);
        }

    }

    @Test
    public void testShowVar() {
        VarCollection<Complex> v = instance.getVars();
        v.setVar('a', new Complex(0, 0));
        v.setVar('b', new Complex(0, 1));
        v.setVar('c', new Complex(0.0, 3.0));
        v.setVar('d', new Complex(0, 3));
        v.setVar('e', new Complex(0.0, 1.0));
        v.setVar('f', new Complex(-5, -3));
        v.setVar('g', new Complex(-5, 3));
        v.setVar('h', new Complex(5, 0));
        v.setVar('i', new Complex(1, 1));
        v.setVar('j', new Complex(1, 0));
        v.setVar('k', new Complex(-1, -1));
        v.setVar('l', new Complex(-1, 0));
        v.setVar('m', new Complex(1, -1));
        v.setVar('n', new Complex(-1, 1));
        v.setVar('o', new Complex(5.0, 3.0));
        v.setVar('p', new Complex(-5.0, 3.0));
        v.setVar('q', new Complex(1.0, 1.0));
        v.setVar('r', new Complex(1.0, 0.0));
        v.setVar('s', new Complex(-5.7, -3.7));
        v.setVar('t', new Complex(0.7, 3.7));
        v.setVar('u', new Complex(0.7, -3.7));
        v.setVar('v', new Complex(1.7, 0.7));
        v.setVar('w', new Complex(10.7, 1.7));
        v.setVar('x', new Complex(-5, 0));
        v.setVar('y', new Complex(-1.7, 0.7));
        v.setVar('z', new Complex(0.7, -1.7));
        for (char x = 'a'; x <= 'z'; x++) {
            assertEquals(instance.showVar(x), v.getVar(x));
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testShowVarExceptions() {
        char x;
        for (x = 0; x < 96; x++) {
            instance.showVar(x);
        }
        for (x = 123; x <= 127; x++) {
            instance.showVar(x);
        }
    }

    @Test
    public void testPushToVarOperands() {
        for (char x = 'a'; x <= 'z'; x++) {
            for (Complex y : array) {
                instance.pushComplex(y.toString());
                instance.pushToVar(x);
                assertEquals(instance.getVars().getVar(x), y);
            }
        }
    }

    @Test
    public void testPushToVarFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(x.toString());
            i++;
        }
        i--;
        for (char x = 'a'; x <= 'z'; x++) {
            while (i > 0) {
                instance.pushToVar(x);
                assertEquals(instance.getVars().getVar(x), array[i]);
                i--;
            }
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testPushToVarExceptions1() {
        instance.pushComplex("3+5i");
        instance.pushToVar('0');
        instance.pushToVar('1');
        instance.pushToVar('2');
        instance.pushToVar('3');
        instance.pushToVar('4');
        instance.pushToVar('5');
        instance.pushToVar('6');
        instance.pushToVar('7');
        instance.pushToVar('8');
        instance.pushToVar('9');
        instance.pushToVar('!');
        instance.pushToVar('"');
        instance.pushToVar('£');
        instance.pushToVar('$');
        instance.pushToVar('%');
        instance.pushToVar('&');
        instance.pushToVar('/');
        instance.pushToVar('(');
        instance.pushToVar(')');
        instance.pushToVar('=');
        instance.pushToVar('?');
        instance.pushToVar('à');
        instance.pushToVar('è');
        instance.pushToVar('ì');
        instance.pushToVar('ò');
        instance.pushToVar('ù');
        instance.pushToVar('+');
        instance.pushToVar('-');
        instance.pushToVar('*');
        instance.pushToVar('\\');
        instance.pushToVar(' ');
        instance.pushToVar('\t');
        instance.pushToVar('\n');
        instance.pushToVar('\r');
        instance.pushToVar('.');
        instance.pushToVar(',');
    }

    @Test(expected = NoSuchElementException.class)
    public void testPushToVarExceptions2() {
        for (char x = 'a'; x <= 'z'; x++) {
            instance.pushToVar(x);
        }
    }

    @Test
    public void testPullFromVar() {
        for (char x = 'a'; x <= 'z'; x++) {
            for (Complex y : array) {
                instance.getVars().setVar(x, y);
                instance.pullFromVar(x);
                assertEquals(instance.getVars().getVar(x), instance.getStack().pop());
            }
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testPullFromVarExceptions1() {
        instance.pushComplex("3+5i");
        instance.pullFromVar('0');
        instance.pullFromVar('1');
        instance.pullFromVar('2');
        instance.pullFromVar('3');
        instance.pullFromVar('4');
        instance.pullFromVar('5');
        instance.pullFromVar('6');
        instance.pullFromVar('7');
        instance.pullFromVar('8');
        instance.pullFromVar('9');
        instance.pullFromVar('!');
        instance.pullFromVar('"');
        instance.pullFromVar('£');
        instance.pullFromVar('$');
        instance.pullFromVar('%');
        instance.pullFromVar('&');
        instance.pullFromVar('/');
        instance.pullFromVar('(');
        instance.pullFromVar(')');
        instance.pullFromVar('=');
        instance.pullFromVar('?');
        instance.pullFromVar('à');
        instance.pullFromVar('è');
        instance.pullFromVar('ì');
        instance.pullFromVar('ò');
        instance.pullFromVar('ù');
        instance.pullFromVar('+');
        instance.pullFromVar('-');
        instance.pullFromVar('*');
        instance.pullFromVar('\\');
        instance.pullFromVar(' ');
        instance.pullFromVar('\t');
        instance.pullFromVar('\n');
        instance.pullFromVar('\r');
        instance.pullFromVar('.');
        instance.pullFromVar(',');
    }

    @Test(expected = NullPointerException.class)
    public void testPullFromVarExceptions2() {
        for (char x = 'a'; x <= 'z'; x++) {
            instance.pullFromVar(x);
        }
    }

    @Test
    public void testAddVarOperands() {
        for (char x = 'a'; x <= 'z'; x++) {
            for (Complex y : array) {
                instance.getVars().setVar(x, y);
                for (Complex z : array) {
                    instance.pushComplex(z.toString());
                    instance.addVar(x);
                    assertEquals(y.add(z), instance.getStack().pop());
                }
            }
        }
    }

    @Test
    public void testAddVarFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(x.toString());
            i++;
        }
        i--;
        for (char x = 'a'; x <= 'z'; x++) {
            instance.getVars().setVar(x, array[i]);
            while (i > 0) {
                instance.addVar(x);
                assertEquals(instance.getStack().getFirst(), instance.getVars().getVar(x).add(array[i]));
                instance.getVars().setVar(x, instance.getStack().pop());
                i--;
            }
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testAddVarExceptions1() {
        instance.addVar('0');
        instance.addVar('1');
        instance.addVar('2');
        instance.addVar('3');
        instance.addVar('4');
        instance.addVar('5');
        instance.addVar('6');
        instance.addVar('7');
        instance.addVar('8');
        instance.addVar('9');
        instance.addVar('!');
        instance.addVar('"');
        instance.addVar('£');
        instance.addVar('$');
        instance.addVar('%');
        instance.addVar('&');
        instance.addVar('/');
        instance.addVar('(');
        instance.addVar(')');
        instance.addVar('=');
        instance.addVar('?');
        instance.addVar('à');
        instance.addVar('è');
        instance.addVar('ì');
        instance.addVar('ò');
        instance.addVar('ù');
        instance.addVar('+');
        instance.addVar('-');
        instance.addVar('*');
        instance.addVar('\\');
        instance.addVar(' ');
        instance.addVar('\t');
        instance.addVar('\n');
        instance.addVar('\r');
        instance.addVar('.');
        instance.addVar(',');
    }

    @Test(expected = NoSuchElementException.class)
    public void testAddVarExceptions2() {
        VarCollection<Complex> v = instance.getVars();
        v.setVar('a', new Complex(0, 0));
        v.setVar('b', new Complex(0, 1));
        v.setVar('c', new Complex(0.0, 3.0));
        v.setVar('d', new Complex(0, 3));
        v.setVar('e', new Complex(0.0, 1.0));
        v.setVar('f', new Complex(-5, -3));
        v.setVar('g', new Complex(-5, 3));
        v.setVar('h', new Complex(5, 0));
        v.setVar('i', new Complex(1, 1));
        v.setVar('j', new Complex(1, 0));
        v.setVar('k', new Complex(-1, -1));
        v.setVar('l', new Complex(-1, 0));
        v.setVar('m', new Complex(1, -1));
        v.setVar('n', new Complex(-1, 1));
        v.setVar('o', new Complex(5.0, 3.0));
        v.setVar('p', new Complex(-5.0, 3.0));
        v.setVar('q', new Complex(1.0, 1.0));
        v.setVar('r', new Complex(1.0, 0.0));
        v.setVar('s', new Complex(-5.7, -3.7));
        v.setVar('t', new Complex(0.7, 3.7));
        v.setVar('u', new Complex(0.7, -3.7));
        v.setVar('v', new Complex(1.7, 0.7));
        v.setVar('w', new Complex(10.7, 1.7));
        v.setVar('x', new Complex(-5, 0));
        v.setVar('y', new Complex(-1.7, 0.7));
        v.setVar('z', new Complex(0.7, -1.7));
        for (char x = 'a'; x <= 'z'; x++) {
            instance.addVar(x);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testAddVarExceptions3() {
        instance.pushComplex("24+2i");
        for (char x = 'a'; x <= 'z'; x++) {
            instance.addVar(x);
        }
    }

    @Test
    public void testSubtractVarOperands() {
        for (char x = 'a'; x <= 'z'; x++) {
            for (Complex y : array) {
                instance.getVars().setVar(x, y);
                for (Complex z : array) {
                    instance.pushComplex(z.toString());
                    instance.subtractVar(x);
                    assertEquals(y.subtract(z), instance.getStack().pop());
                }
            }
        }
    }

    @Test
    public void testSubtractVarFullStack() {
        int i = 0;
        for (Complex x : array) {
            instance.pushComplex(x.toString());
            i++;
        }
        i--;
        for (char x = 'a'; x <= 'z'; x++) {
            instance.getVars().setVar(x, array[i]);
            while (i > 0) {
                instance.subtractVar(x);
                assertEquals(instance.getStack().getFirst(), instance.getVars().getVar(x).subtract(array[i]));
                instance.getVars().setVar(x, instance.getStack().pop());
                i--;
            }
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testSubtractVarExceptions1() {
        instance.subtractVar('0');
        instance.subtractVar('1');
        instance.subtractVar('2');
        instance.subtractVar('3');
        instance.subtractVar('4');
        instance.subtractVar('5');
        instance.subtractVar('6');
        instance.subtractVar('7');
        instance.subtractVar('8');
        instance.subtractVar('9');
        instance.subtractVar('!');
        instance.subtractVar('"');
        instance.subtractVar('£');
        instance.subtractVar('$');
        instance.subtractVar('%');
        instance.subtractVar('&');
        instance.subtractVar('/');
        instance.subtractVar('(');
        instance.subtractVar(')');
        instance.subtractVar('=');
        instance.subtractVar('?');
        instance.subtractVar('à');
        instance.subtractVar('è');
        instance.subtractVar('ì');
        instance.subtractVar('ò');
        instance.subtractVar('ù');
        instance.subtractVar('+');
        instance.subtractVar('-');
        instance.subtractVar('*');
        instance.subtractVar('\\');
        instance.subtractVar(' ');
        instance.subtractVar('\t');
        instance.subtractVar('\n');
        instance.subtractVar('\r');
        instance.subtractVar('.');
        instance.subtractVar(',');
    }

    @Test(expected = NoSuchElementException.class)
    public void testSubtractVarExceptions2() {
        VarCollection<Complex> v = instance.getVars();
        v.setVar('a', new Complex(0, 0));
        v.setVar('b', new Complex(0, 1));
        v.setVar('c', new Complex(0.0, 3.0));
        v.setVar('d', new Complex(0, 3));
        v.setVar('e', new Complex(0.0, 1.0));
        v.setVar('f', new Complex(-5, -3));
        v.setVar('g', new Complex(-5, 3));
        v.setVar('h', new Complex(5, 0));
        v.setVar('i', new Complex(1, 1));
        v.setVar('j', new Complex(1, 0));
        v.setVar('k', new Complex(-1, -1));
        v.setVar('l', new Complex(-1, 0));
        v.setVar('m', new Complex(1, -1));
        v.setVar('n', new Complex(-1, 1));
        v.setVar('o', new Complex(5.0, 3.0));
        v.setVar('p', new Complex(-5.0, 3.0));
        v.setVar('q', new Complex(1.0, 1.0));
        v.setVar('r', new Complex(1.0, 0.0));
        v.setVar('s', new Complex(-5.7, -3.7));
        v.setVar('t', new Complex(0.7, 3.7));
        v.setVar('u', new Complex(0.7, -3.7));
        v.setVar('v', new Complex(1.7, 0.7));
        v.setVar('w', new Complex(10.7, 1.7));
        v.setVar('x', new Complex(-5, 0));
        v.setVar('y', new Complex(-1.7, 0.7));
        v.setVar('z', new Complex(0.7, -1.7));
        for (char x = 'a'; x <= 'z'; x++) {
            instance.subtractVar(x);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSubtractVarExceptions3() {
        instance.pushComplex("24+2i");
        for (char x = 'a'; x <= 'z'; x++) {
            instance.subtractVar(x);
        }
    }
}
