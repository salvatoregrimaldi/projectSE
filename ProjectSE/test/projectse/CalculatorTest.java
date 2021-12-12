/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import exceptions.UnacceptableKeyException;
import com.vm.jcomplex.Complex;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
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

    private Calculator instance;
    private Complex[] array;

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
        //assertEquals(0, instance.recognizer("+i"));
        //assertEquals(0, instance.recognizer("-i"));
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
            assertEquals(13, instance.recognizer(">" + x));
            assertEquals(14, instance.recognizer("<" + x));
            assertEquals(15, instance.recognizer("+" + x));
            assertEquals(16, instance.recognizer("-" + x));
        }

        for (char x = 0; x <= 96; x++) {
            assertEquals(-1, instance.recognizer("show " + x));
        }
        for (char x = 123; x <= 127; x++) {
            assertEquals(-1, instance.recognizer("show" + x));
        }

        for (char x = 0; x <= 96; x++) {
            assertEquals(-1, instance.recognizer(">" + x));
        }
        for (char x = 123; x <= 127; x++) {
            assertEquals(-1, instance.recognizer(">" + x));
        }

        for (char x = 0; x <= 96; x++) {
            assertEquals(-1, instance.recognizer("<" + x));
        }
        for (char x = 123; x <= 127; x++) {
            assertEquals(-1, instance.recognizer("<" + x));
        }

        assertEquals(-1, instance.recognizer("show" + "  %"));
        assertEquals(-1, instance.recognizer("show" + "  +"));
        assertEquals(-1, instance.recognizer("show" + "  -"));
        assertEquals(-1, instance.recognizer("show" + "  /"));
        assertEquals(-1, instance.recognizer("show" + "  9"));
        assertEquals(-1, instance.recognizer("show" + "  0"));

        assertEquals(-1, instance.recognizer(">" + "  %"));
        assertEquals(-1, instance.recognizer(">" + " $"));
        assertEquals(-1, instance.recognizer("<  1"));
        assertEquals(-1, instance.recognizer("<  " + "1"));
        assertEquals(-1, instance.recognizer("<" + " %"));
        assertEquals(-1, instance.recognizer("<" + "  $"));
        assertEquals(-1, instance.recognizer("<" + " /"));

        assertEquals(-1, instance.recognizer("+" + "  1"));
        assertEquals(-1, instance.recognizer("+" + " %"));
        assertEquals(-1, instance.recognizer("+" + "  $"));
        assertEquals(-1, instance.recognizer("+" + " 3"));
        assertEquals(-1, instance.recognizer("+" + "  %"));
        assertEquals(-1, instance.recognizer("+" + " $"));

        assertEquals(-1, instance.recognizer("-" + " 1"));
        assertEquals(-1, instance.recognizer("-" + " %"));
        assertEquals(-1, instance.recognizer("-" + "  $"));
        assertEquals(-1, instance.recognizer("-" + " 3"));
        assertEquals(-1, instance.recognizer("-" + "  %"));
        assertEquals(-1, instance.recognizer("-" + " $"));

        //test per le user-operation
        instance.getUserOpMap().put("prova", new UserOpCommand("prova", "dup + drop 5i >a", instance));
        instance.getUserOpMap().put("test", new UserOpCommand("test", "sqrt +- over over", instance));
        instance.getUserOpMap().put("mix", new UserOpCommand("mix", "* prova - test /", instance));
        assertEquals(18, instance.recognizer("prova"));
        assertEquals(18, instance.recognizer("  test  "));
        assertEquals(18, instance.recognizer("mix"));
        assertEquals(-1, instance.recognizer("prrova"));
        assertEquals(-1, instance.recognizer("  te st  "));
        assertEquals(-1, instance.recognizer("mix_"));
        assertEquals(-1, instance.recognizer("new"));

        assertEquals(19, instance.recognizer("del prova"));
        assertEquals(19, instance.recognizer("del test"));
        assertEquals(19, instance.recognizer("del mix"));
        assertEquals(-1, instance.recognizer("deel prova"));
        assertEquals(-1, instance.recognizer("del prrova"));
        assertEquals(-1, instance.recognizer("del  test"));
        assertEquals(-1, instance.recognizer(" del  te st  "));
        assertEquals(-1, instance.recognizer("del mix_"));
        assertEquals(-1, instance.recognizer("del new"));
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
    public void testAddExceptions1() {
        instance.add();
    }

    @Test(expected = NoSuchElementException.class)
    public void testAddExceptions2() {
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
    public void testSubtractExceptions1() {
        instance.subtract();
    }

    @Test(expected = NoSuchElementException.class)
    public void testSubtractExceptions2() {
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
    public void testMultiplyExceptions1() {
        instance.multiply();
    }

    @Test(expected = NoSuchElementException.class)
    public void testMultiplyExceptions2() {
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
    public void testDivideExceptions1() {
        instance.divide();
    }

    @Test(expected = NoSuchElementException.class)
    public void testDivideExceptions2() {
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
            //test dei numeri non pur. reali e non pur. immaginari
            if (!(x.getReal() == 0.0 || x.getImaginary() == 0.0)) {
                assertEquals(array[i].negate(), instance.getStack().pop());
            }
            i++;
        }

        instance.pushComplex("3");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(-3, 0));
        instance.pushComplex("3i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, -3));

        instance.pushComplex("-3");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(3, 0));
        instance.pushComplex("-3i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, 3));

        instance.pushComplex("3.0");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(-3.0, 0));
        instance.pushComplex("3.0i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, -3.0));

        instance.pushComplex("-3.0");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(3.0, 0));
        instance.pushComplex("-3.0i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, 3.0));

        instance.pushComplex("3.7");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(-3.7, 0));
        instance.pushComplex("3.7i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, -3.7));

        instance.pushComplex("-3.7");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(3.7, 0));
        instance.pushComplex("-3.7i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, 3.7));

        instance.pushComplex("1");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(-1, 0));
        instance.pushComplex("i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, -1));

        instance.pushComplex("-1");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(1, 0));
        instance.pushComplex("-1i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, 1));

        instance.pushComplex("1.0");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(-1.0, 0));
        instance.pushComplex("1.0i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, -1.0));

        instance.pushComplex("-1.0");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(1, 0));
        instance.pushComplex("-1.0i");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, 1));

        instance.pushComplex("0.0");
        instance.negate();
        assertEquals(instance.getStack().pop(), new Complex(0, 0));
    }

    @Test
    public void testNegateFullStack() {
        Complex arrayY[];
        arrayY = new Complex[]{new Complex(5, 3), new Complex(-5, -3),
            new Complex(5, -3), new Complex(-5, 3),
            new Complex(1, 1), new Complex(-1, -1),
            new Complex(1, -1), new Complex(-1, 1), new Complex(5.0, 3.0), new Complex(-5.0, -3.0),
            new Complex(5.0, -3.0), new Complex(-5.0, 3.0),
            new Complex(1.0, 1.0),
            new Complex(-1.0, -1.0), new Complex(1.0, -1.0), new Complex(-1.0, 1.0),
            new Complex(5.7, 3.7), new Complex(-5.7, -3.7),
            new Complex(5.7, -3.7), new Complex(-5.7, 3.7), new Complex(5.7, 0.7),
            new Complex(-5.7, 0.7), new Complex(0.7, 3.7), new Complex(0.7, -3.7),
            new Complex(0.7, 0.7), new Complex(1.7, 1.7), new Complex(1.7, 0.7), new Complex(0.7, 1.7),
            new Complex(-1.7, -1.7), new Complex(1.7, -1.7), new Complex(-1.7, 1.7),
            new Complex(-1.7, 0.7), new Complex(0.7, -1.7)
        };
        int i = 0;
        for (Complex x : arrayY) {
            instance.pushComplex(arrayY[i].toString());
            i++;
        }
        i--;
        while (i >= 0) {
            instance.negate();
            assertEquals(instance.getStack().pop(), arrayY[i].negate());
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
    public void testSwapExceptions1() {
        instance.swap();
    }

    @Test(expected = NoSuchElementException.class)
    public void testSwapExceptions2() {
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
    public void testOverExceptions1() {
        instance.over();
    }

    @Test(expected = NoSuchElementException.class)
    public void testOverExceptions2() {
        instance.pushComplex("24+2i");
        instance.over();
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
        for (Complex x : array) {
            instance.getStack().push(x);
            instance.getStack().push(x);
        }

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
    public void testMakeVarOperationExceptions1() {
        instance.pushComplex("2+i");
        instance.makeVarOperation(13, '%');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testMakeVarOperationExceptions2() {
        instance.pushComplex("2+i");
        instance.makeVarOperation(14, 'ì');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testMakeVarOperationExceptions3() {
        instance.pushComplex("2+i");
        instance.makeVarOperation(15, '1');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testMakeVarOperationExceptions4() {
        instance.pushComplex("2+i");
        instance.makeVarOperation(16, '*');
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
    public void testShowVarExceptions1() {
        instance.showVar('£');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testShowVarExceptions2() {
        instance.showVar('$');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testShowVarExceptions3() {
        instance.showVar('€');
    }

    @Test
    public void testRecUserOp() {
        /*la dichiarazione dell'operazione-utente non può contenere due o più whitespaces*/
        assertEquals(-1, instance.recUserOp("oper  drop dup 65i >a"));
        assertEquals(-1, instance.recUserOp("oper drop   dup 65i swap + >a"));

        /*la dichiarazione dell'operazione-utente non può avere "show" o "del" come nome dell'operazione*/
        assertEquals(-1, instance.recUserOp("show drop dup 65i swap + >a"));
        assertEquals(-1, instance.recUserOp("show +- sqrt +a"));
        assertEquals(-1, instance.recUserOp("del drop dup 65i swap + >a"));
        assertEquals(-1, instance.recUserOp("del +- sqrt +a"));

        /*la dichiarazione dell'operazione-utente non può avere una lettera [a-z] come nome dell'operazione*/
        for (char x = 'a'; x <= 'z'; x++) {
            assertEquals(-1, instance.recUserOp(x + " +- sqrt +a"));
        }

        /*la dichiarazione dell'operazione-utente non può contenere un'unica parola (non avrebbe senso un'operazione-utente vuota)*/
        assertEquals(-1, instance.recUserOp("ciao"));
        assertEquals(-1, instance.recUserOp("ciaociao"));

        /*la dichiarazione dell'operazione-utente non può contenere un riferimento a se stessa*/
        assertEquals(-1, instance.recUserOp("oper oper"));
        assertEquals(-1, instance.recUserOp("ciao ciao >a +a drop"));
        assertEquals(-1, instance.recUserOp("oper + - dup oper sqrt"));
        assertEquals(-1, instance.recUserOp("ciao >a +a drop ciao"));

        /*Il nome di un'operazione-utente non può corrispondere ad un numero complesso*/
        assertEquals(-1, instance.recUserOp("0 + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("67 + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("67i + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("-67i + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("5+3i + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("+5+3i + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("5-3i + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("-5-3i + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("i3+5 + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("3i+5 + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("1 + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("-1 + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("i + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("-1i + swap >d +h over"));
        assertEquals(-1, instance.recUserOp("+1i + swap >d +h over"));

        /*Il nome di un'operazione-utente non può corrispondere ad un'operazione standard (+, -, ...)*/
        assertEquals(-1, instance.recUserOp("+ / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("- / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("* / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("/ / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("sqrt / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("+- / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("clear / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("drop / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("dup / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("swap / dup clear 34+9i <a"));
        assertEquals(-1, instance.recUserOp("over / dup clear 34+9i <a"));
        for (char x = 'a'; x <= 'z'; x++) {
            assertEquals(-1, instance.recUserOp("<" + x + " / dup clear 34+9i <a"));
            assertEquals(-1, instance.recUserOp(">" + x + " / dup clear 34+9i <a"));
            assertEquals(-1, instance.recUserOp("+" + x + " / dup clear 34+9i <a"));
            assertEquals(-1, instance.recUserOp("-" + x + " / dup clear 34+9i <a"));
        }

        /*Un'operazione-utente non può contenere nomi di operazioni-utente non precedentemente definite*/
        assertEquals(-1, instance.recUserOp("oper / oper2 clear <c"));
        assertEquals(-1, instance.recUserOp("oper / oper3 clear <c"));

        /*Un'operazione-utente non può contenere la stringa show*/
        assertEquals(-1, instance.recUserOp("oper / show <c"));

        /*Un'operazione-utente può contenere anche operazioni-utente precedentemente definite*/
        instance.getUserOpMap().put("prova", new UserOpCommand("prova", "dup + drop 5i >a", instance));
        instance.getUserOpMap().put("test", new UserOpCommand("test", "sqrt +- over over", instance));
        instance.getUserOpMap().put("mix", new UserOpCommand("mix", "* prova - test /", instance));
        assertEquals(1, instance.recUserOp("oper prova / clear <c"));
        assertEquals(1, instance.recUserOp("oper clear <c swap dup -a prova"));
        assertEquals(1, instance.recUserOp("oper clear <c swap prova dup -a"));
        assertEquals(1, instance.recUserOp("oper test / clear <c"));
        assertEquals(1, instance.recUserOp("oper clear <c swap dup -a test"));
        assertEquals(1, instance.recUserOp("oper clear <c swap test dup -a"));
        assertEquals(1, instance.recUserOp("oper mix / clear <c"));
        assertEquals(1, instance.recUserOp("oper clear <c swap dup -a mix"));
        assertEquals(1, instance.recUserOp("oper clear <c swap mix dup -a"));

        /*test vari*/
        assertEquals(1, instance.recUserOp("salvo sqrt 3+4i / 4i clear dup 3 +-"));
        assertEquals(1, instance.recUserOp("enri 5+8i >f <f sqrt -"));
        assertEquals(1, instance.recUserOp("alle dup swap over -b"));
        assertEquals(1, instance.recUserOp("  andre / +c -c / clear sqrt +v + drop   "));
        assertEquals(1, instance.recUserOp("salvo1 clear drop drop swap * >z / *"));
        assertEquals(1, instance.recUserOp("enri1 8 * * -h 88i dup dup *"));
        assertEquals(1, instance.recUserOp("alle1 sqrt +a <n 19 clear"));
        assertEquals(1, instance.recUserOp("andre1 * clear over 33 dup +- +-"));
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
        instance.pushToVar('1');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testPushToVarExceptions2() {
        instance.pushComplex("3+5i");
        instance.pushToVar('@');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testPushToVarExceptions3() {
        instance.pushComplex("3+5i");
        instance.pushToVar('à');
    }

    @Test(expected = NoSuchElementException.class)
    public void testPushToVarExceptions4() {
        instance.pushToVar('j');
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
        instance.pullFromVar('1');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testPullFromVarExceptions2() {
        instance.pushComplex("3+5i");
        instance.pullFromVar('§');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testPullFromVarExceptions3() {
        instance.pushComplex("3+5i");
        instance.pullFromVar('ò');
    }

    @Test(expected = NullPointerException.class)
    public void testPullFromVarExceptions4() {
        instance.pullFromVar('k');
    }

    @Test
    public void testAddVarOperands() {
        for (char x = 'a'; x <= 'z'; x++) {
            for (Complex y : array) {
                instance.getVars().setVar(x, y);
                for (Complex z : array) {
                    instance.pushComplex(z.toString());
                    instance.addVar(x);
                    assertEquals(y.add(z), instance.getVars().getVar(x));
                    instance.getVars().setVar(x, y);
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
                Complex app = instance.getVars().getVar(x);
                instance.addVar(x);
                assertEquals(instance.getVars().getVar(x), app.add(array[i]));
                instance.getVars().setVar(x, app);
                i--;
            }
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testAddVarExceptions1() {
        instance.addVar('0');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testAddVarExceptions2() {
        instance.addVar('[');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testAddVarExceptions3() {
        instance.addVar('ù');
    }

    @Test(expected = NoSuchElementException.class)
    public void testAddVarExceptions4() {
        VarCollection<Complex> v = instance.getVars();
        v.setVar('a', new Complex(0, 0));
        instance.addVar('a');
    }

    @Test(expected = NullPointerException.class)
    public void testAddVarExceptions5() {
        instance.pushComplex("24+2i");
        instance.addVar('d');
    }

    @Test
    public void testSubtractVarOperands() {
        for (char x = 'a'; x <= 'z'; x++) {
            for (Complex y : array) {
                instance.getVars().setVar(x, y);
                for (Complex z : array) {
                    instance.pushComplex(z.toString());
                    instance.subtractVar(x);
                    assertEquals(y.subtract(z), instance.getVars().getVar(x));
                    instance.getVars().setVar(x, y);
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
                Complex app = instance.getVars().getVar(x);
                instance.subtractVar(x);
                assertEquals(instance.getVars().getVar(x), app.subtract(array[i]));
                instance.getVars().setVar(x, app);
                i--;
            }
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testSubtractVarExceptions1() {
        instance.subtractVar('1');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testSubtractVarExceptions2() {
        instance.subtractVar(']');
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testSubtractVarExceptions3() {
        instance.subtractVar('è');
    }

    @Test(expected = NoSuchElementException.class)
    public void testSubtractVarExceptions4() {
        VarCollection<Complex> v = instance.getVars();
        v.setVar('s', new Complex(0, 0));
        instance.subtractVar('s');
    }

    @Test(expected = NullPointerException.class)
    public void testSubtractVarExceptions5() {
        instance.pushComplex("24+2i");
        instance.subtractVar('w');
    }

    @Test
    public void testSaveUserOps() throws FileNotFoundException, IOException, ClassNotFoundException {
        UserOpCommand comm1 = new UserOpCommand("alle", "+i 3 +i drop >z", instance);
        instance.getUserOpMap().put("alle", comm1);
        UserOpCommand comm2 = new UserOpCommand("salvo", "sqrt 3+4i / 4i 2 dup 3 +-", instance);
        instance.getUserOpMap().put("salvo", comm2);
        UserOpCommand comm3 = new UserOpCommand("enri", "5+8i >f <f sqrt -", instance);
        instance.getUserOpMap().put("enri", comm3);
        UserOpCommand comm4 = new UserOpCommand("andre", "/ +c -c / 2 sqrt +v + drop", instance);
        instance.getUserOpMap().put("andre", comm4);
        UserOpCommand comm5 = new UserOpCommand("enri2", "dup >e 5 over * >x drop <e <x over over 10 alle", instance);
        instance.getUserOpMap().put("enri2", comm5);

        File file = new File("saveFile.bin");
        instance.saveUserOps(file);
        ConcurrentMap<String, UserOpCommand> c;
        try (ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            c = (ConcurrentHashMap) din.readObject();
            assertEquals(c.size(), instance.getUserOpMap().size());
            for (UserOpCommand x : c.values()) {
                assertEquals(x.getOperation(), instance.getUserOpMap().get(x.getName()).getOperation());
            }
            din.close();
        }
    }

    @Test
    public void testSaveUserOpExceptions() {
        assertEquals(false, instance.saveUserOps(null));
    }
    
    @Test
    public void testRestoreUserOps() throws IOException {
        UserOpCommand comm1 = new UserOpCommand("alle", "+i 3 +i drop >z", instance);
        instance.getUserOpMap().put("alle", comm1);
        UserOpCommand comm2 = new UserOpCommand("salvo", "sqrt 3+4i / 4i 2 dup 3 +-", instance);
        instance.getUserOpMap().put("salvo", comm2);
        UserOpCommand comm3 = new UserOpCommand("enri", "5+8i >f <f sqrt -", instance);
        instance.getUserOpMap().put("enri", comm3);
        UserOpCommand comm4 = new UserOpCommand("andre", "/ +c -c / 2 sqrt +v + drop", instance);
        instance.getUserOpMap().put("andre", comm4);
        UserOpCommand comm5 = new UserOpCommand("enri2", "dup >e 5 over * >x drop <e <x over over 10 alle", instance);
        instance.getUserOpMap().put("enri2", comm5);
        UserOpCommand comm6 = new UserOpCommand("prova0", "dup * +-", instance);
        instance.getUserOpMap().put("prova0", comm6);
        UserOpCommand comm7 = new UserOpCommand("prova1", "* drop prova0 <c", instance);
        instance.getUserOpMap().put("prova1", comm7);
        UserOpCommand comm8 = new UserOpCommand("prova2", "/ sqrt prova1", instance);
        instance.getUserOpMap().put("prova2", comm8);
        UserOpCommand comm9 = new UserOpCommand("prova3", "prova2 + +-", instance);
        instance.getUserOpMap().put("prova3", comm9);
        UserOpCommand comm10 = new UserOpCommand("prova4", "+ prova2 clear >a", instance);
        instance.getUserOpMap().put("prova4", comm10);

        File file = new File("restoreFile.bin");
        try (ObjectOutputStream dout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            dout.writeObject(instance.getUserOpMap());
            dout.close();
        }

        instance.getUserOpMap().get("alle").delete();
        instance.getUserOpMap().get("salvo").delete();
        instance.getUserOpMap().get("enri").delete();
        instance.getUserOpMap().get("andre").delete();
        instance.getUserOpMap().get("prova0").delete();

        instance.restoreUserOps(file);
        assertEquals("alle +i 3 +i drop >z", instance.getUserOpMap().get("alle").toString());
        assertEquals("salvo sqrt 3+4i / 4i 2 dup 3 +-", instance.getUserOpMap().get("salvo").toString());
        assertEquals("enri 5+8i >f <f sqrt -", instance.getUserOpMap().get("enri").toString());
        assertEquals("andre / +c -c / 2 sqrt +v + drop", instance.getUserOpMap().get("andre").toString());
        assertEquals("enri2 dup >e 5 over * >x drop <e <x over over 10 alle", instance.getUserOpMap().get("enri2").toString());
        assertEquals("prova0 dup * +-", instance.getUserOpMap().get("prova0").toString());
        assertEquals("prova1 * drop prova0 <c", instance.getUserOpMap().get("prova1").toString());
        assertEquals("prova2 / sqrt prova1", instance.getUserOpMap().get("prova2").toString());
        assertEquals("prova3 prova2 + +-", instance.getUserOpMap().get("prova3").toString());
        assertEquals("prova4 + prova2 clear >a", instance.getUserOpMap().get("prova4").toString());
    }

    @Test
    public void testRestoreUserOpExceptions() {
        assertEquals(false, instance.saveUserOps(null));
    }

}
