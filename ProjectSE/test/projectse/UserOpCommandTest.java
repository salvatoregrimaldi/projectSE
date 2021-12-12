/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import exceptions.UserOpNotFoundException;
import com.vm.jcomplex.Complex;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Asdrubale
 */
public class UserOpCommandTest {

    private Calculator calculator;
    private Calculator anotherCalc;
    private Deque<Complex> stack1;
    private Deque<Complex> stack2;
    private Object[] array1;
    private Object[] array2;
    private VarCollection<Complex> vars1;
    private VarCollection<Complex> vars2;
    private Map<Character, Complex> map1;
    private Map<Character, Complex> map2;

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
        anotherCalc = new Calculator();
    }

    @After
    public void tearDown() {
    }

    private void calcPopulator(Calculator calc) {
        calc.pushComplex("5+3i");
        calc.pushComplex("3i");
        calc.pushComplex("-5");
        calc.pushComplex("44");
        calc.pushComplex("15-3i");
        calc.pushComplex("58");
        calc.pushComplex("i");
        calc.pushComplex("-3i");
        calc.pushComplex("-5-3i");
        calc.pushComplex("44");
        calc.pushComplex("158i");
        calc.pushComplex("158");
        calc.pushComplex("-12");
        calc.pushComplex("123-76i");
        calc.pushComplex("6i");
        calc.pushComplex("3");
        calc.pushComplex("23+5i");
        calc.pushComplex("100i");
        calc.pushComplex("2");
        calc.pushComplex("1+i");
        calc.pushComplex("-1i");
        calc.pushComplex("72");
        calc.pushComplex("24+10i");
        calc.pushComplex("4");
        calc.pushComplex("15i");
        calc.pushComplex("2+19i");
        calc.pushComplex("-1");
        calc.pushComplex("10+100i");
        calc.getVars().setVar('a', new Complex(34, 12));
        calc.getVars().setVar('b', new Complex(3, 5));
        calc.getVars().setVar('c', new Complex(-34, 12));
        calc.getVars().setVar('d', new Complex(34, -12));
        calc.getVars().setVar('e', new Complex(0, 12));
        calc.getVars().setVar('f', new Complex(34, 0));
        calc.getVars().setVar('g', new Complex(4, 1));
        calc.getVars().setVar('h', new Complex(56, -12));
        calc.getVars().setVar('i', new Complex(3, 1224));
        calc.getVars().setVar('j', new Complex(389, -121));
        calc.getVars().setVar('k', new Complex(43346, 133));
        calc.getVars().setVar('l', new Complex(-89, -1355));
        calc.getVars().setVar('m', new Complex(13, -23));
        calc.getVars().setVar('n', new Complex(34, 12));
        calc.getVars().setVar('o', new Complex(-123, 9685));
        calc.getVars().setVar('p', new Complex(472, 0));
        calc.getVars().setVar('q', new Complex(0, 12));
        calc.getVars().setVar('r', new Complex(12, 0));
        calc.getVars().setVar('s', new Complex(0, 0));
        calc.getVars().setVar('t', new Complex(1, 1));
        calc.getVars().setVar('u', new Complex(-1, -1));
        calc.getVars().setVar('v', new Complex(65, -12));
        calc.getVars().setVar('w', new Complex(118, -2));
        calc.getVars().setVar('x', new Complex(3, 0));
        calc.getVars().setVar('y', new Complex(25, 45));
        calc.getVars().setVar('z', new Complex(38, 12));
    }

    private void compareStacksVars() {
        stack1 = new ArrayDeque<>(calculator.getStack());
        stack2 = new ArrayDeque<>(anotherCalc.getStack());
        vars1 = new VarCollection(calculator.getVars());
        vars2 = new VarCollection(anotherCalc.getVars());
        map1 = vars1.getCollect();
        map2 = vars2.getCollect();
        array1 = stack1.toArray();
        array2 = stack2.toArray();
        assertEquals(array1.length, array2.length);
        for (int i = 0; i < array1.length; i++) {
            assertEquals((Complex) array1[i], (Complex) array2[i]);
        }
        for (char x = 'a'; x <= 'z'; x++) {
            Complex comp1 = (Complex) map1.get(x);
            Complex comp2 = (Complex) map2.get(x);
            assertEquals(true, comp1.equals(comp2));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorExceptions1() {
        UserOpCommand comm1 = new UserOpCommand(" alle enri  ", "+i 3 +i drop >z", calculator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorExceptions2() {
        UserOpCommand comm1 = new UserOpCommand(" salvo  ", "++i 3 +i drop >z", calculator);
    }

    /**
     * Test of execute method, of class UserOpCommand.
     */
    @Test
    public void testExecute() {
        calcPopulator(calculator);
        calcPopulator(anotherCalc);

        UserOpCommand comm1 = new UserOpCommand("alle", "+i 3 +i drop >z", calculator);
        calculator.getUserOpMap().put("alle", comm1);
        UserOpCommand comm2 = new UserOpCommand("salvo", "sqrt 3+4i / 4i 2 dup 3 +-", calculator);
        calculator.getUserOpMap().put("salvo", comm2);
        UserOpCommand comm3 = new UserOpCommand("enri", "5+8i >f <f sqrt -", calculator);
        calculator.getUserOpMap().put("enri", comm3);
        UserOpCommand comm4 = new UserOpCommand("andre", "/ +c -c / 2 sqrt +v + drop", calculator);
        calculator.getUserOpMap().put("andre", comm4);
        UserOpCommand comm5 = new UserOpCommand("enri2", "dup >e 5 over * >x drop <e <x over over 10 alle", calculator);
        calculator.getUserOpMap().put("enri2", comm5);

        /*operazione-utente comm1*/
        comm1.execute();
        anotherCalc.makeVarOperation(15, 'i');
        anotherCalc.pushComplex("3");
        anotherCalc.makeVarOperation(15, 'i');
        anotherCalc.makeOperation(8);
        anotherCalc.makeVarOperation(13, 'z');
        compareStacksVars();

        /*operazione-utente comm2*/
        comm2.execute();
        anotherCalc.makeOperation(5);
        anotherCalc.pushComplex("3+4i");
        anotherCalc.makeOperation(4);
        anotherCalc.pushComplex("4i");
        anotherCalc.pushComplex("2");
        anotherCalc.makeOperation(9);
        anotherCalc.pushComplex("3");
        anotherCalc.makeOperation(6);
        compareStacksVars();

        /*operazione-utente comm3*/
        comm3.execute();
        anotherCalc.pushComplex("5+8i");
        anotherCalc.makeVarOperation(13, 'f');
        anotherCalc.makeVarOperation(14, 'f');
        anotherCalc.makeOperation(5);
        anotherCalc.makeOperation(2);
        compareStacksVars();

        /*operazione-utente comm4*/
        comm4.execute();
        anotherCalc.makeOperation(4);
        anotherCalc.makeVarOperation(15, 'c');
        anotherCalc.makeVarOperation(16, 'c');
        anotherCalc.makeOperation(4);
        anotherCalc.pushComplex("2");
        anotherCalc.makeOperation(5);
        anotherCalc.makeVarOperation(15, 'v');
        anotherCalc.makeOperation(1);
        anotherCalc.makeOperation(8);
        compareStacksVars();

        /*operazione-utente comm5 "dup >e 5 over * >x drop <e <x over over 10 alle" */
        calculator.getUserOpMap().put("alle", comm1);
        comm5.execute();
        anotherCalc.makeOperation(9);
        anotherCalc.makeVarOperation(13, 'e');
        anotherCalc.pushComplex("5");
        anotherCalc.makeOperation(11);
        anotherCalc.makeOperation(3);
        anotherCalc.makeVarOperation(13, 'x');
        anotherCalc.makeOperation(8);
        anotherCalc.makeVarOperation(14, 'e');
        anotherCalc.makeVarOperation(14, 'x');
        anotherCalc.makeOperation(11);
        anotherCalc.makeOperation(11);
        anotherCalc.pushComplex("10");

        anotherCalc.makeVarOperation(15, 'i');
        anotherCalc.pushComplex("3");
        anotherCalc.makeVarOperation(15, 'i');
        anotherCalc.makeOperation(8);
        anotherCalc.makeVarOperation(13, 'z');
        compareStacksVars();
    }

    @Test(expected = UserOpNotFoundException.class)
    public void testExecuteExceptions() {
        calcPopulator(calculator);
        UserOpCommand comm1 = new UserOpCommand("alle", "+i 3 +i drop >z", calculator);
        calculator.getUserOpMap().put("alle", comm1);
        UserOpCommand comm5 = new UserOpCommand("enri", "dup >e 5 over * >x drop <e <x over over 10 alle", calculator);
        calculator.getUserOpMap().put("enri", comm5);
        calculator.getUserOpMap().remove("alle");
        comm5.execute();
    }

    /**
     * Test of rollback method, of class UserOpCommand.
     */
    @Test
    public void testRollBack() {
        stack1 = new ArrayDeque<>();
        vars1 = new VarCollection();

        UserOpCommand comm1 = new UserOpCommand("hello", "4 5i dup clear drop 3i 54", calculator);
        calculator.getUserOpMap().put("hello", comm1);
        try {
            comm1.execute();
        } catch (Exception e) {
            comm1.rollback();
        }

        array1 = stack1.toArray();
        array2 = calculator.getStack().toArray();
        assertEquals(array1.length, array2.length);
        for (int i = 0; i < array1.length; i++) {
            assertEquals((Complex) array1[i], (Complex) array2[i]);
        }

        array1 = vars1.getCollect().values().toArray();
        array2 = calculator.getVars().getCollect().values().toArray();
        assertEquals(array1.length, array2.length);
        for (int i = 0; i < array1.length; i++) {
            assertEquals((Complex) array1[i], (Complex) array2[i]);
        }

        stack1.push(new Complex(5, 3));
        stack1.push(new Complex(0, 3));
        stack1.push(new Complex(-5, 0));
        stack1.push(new Complex(44, 0));
        stack1.push(new Complex(15, -3));
        stack1.push(new Complex(58, 0));
        stack1.push(new Complex(0, 1));
        stack1.push(new Complex(0, -3));
        stack1.push(new Complex(-5, -3));
        stack1.push(new Complex(44, 0));
        stack1.push(new Complex(0, 158));
        stack1.push(new Complex(158, 0));
        stack1.push(new Complex(-12, 0));
        stack1.push(new Complex(123, -76));
        stack1.push(new Complex(0, 6));
        stack1.push(new Complex(3, 0));
        stack1.push(new Complex(23, 5));
        stack1.push(new Complex(0, 100));
        stack1.push(new Complex(2, 0));
        stack1.push(new Complex(1, 1));
        stack1.push(new Complex(0, -1));
        stack1.push(new Complex(72, 0));
        stack1.push(new Complex(24, 10));
        stack1.push(new Complex(4, 0));
        stack1.push(new Complex(0, 15));
        stack1.push(new Complex(2, 19));
        stack1.push(new Complex(-1, 0));
        stack1.push(new Complex(10, 100));

        calcPopulator(calculator);
        calculator.getVars().setVar('a', null);

        vars1.setVar('b', new Complex(3, 5));
        vars1.setVar('c', new Complex(-34, 12));
        vars1.setVar('d', new Complex(34, -12));
        vars1.setVar('e', new Complex(0, 12));
        vars1.setVar('f', new Complex(34, 0));
        vars1.setVar('g', new Complex(4, 1));
        vars1.setVar('h', new Complex(56, -12));
        vars1.setVar('i', new Complex(3, 1224));
        vars1.setVar('j', new Complex(389, -121));
        vars1.setVar('k', new Complex(43346, 133));
        vars1.setVar('l', new Complex(-89, -1355));
        vars1.setVar('m', new Complex(13, -23));
        vars1.setVar('n', new Complex(34, 12));
        vars1.setVar('o', new Complex(-123, 9685));
        vars1.setVar('p', new Complex(472, 0));
        vars1.setVar('q', new Complex(0, 12));
        vars1.setVar('r', new Complex(12, 0));
        vars1.setVar('s', new Complex(0, 0));
        vars1.setVar('t', new Complex(1, 1));
        vars1.setVar('u', new Complex(-1, -1));
        vars1.setVar('v', new Complex(65, -12));
        vars1.setVar('w', new Complex(118, -2));
        vars1.setVar('x', new Complex(3, 0));
        vars1.setVar('y', new Complex(25, 45));
        vars1.setVar('z', new Complex(38, 12));

        UserOpCommand comm2 = new UserOpCommand("ciao", "dup + 3 5i <a", calculator);
        calculator.getUserOpMap().put("ciao", comm2);
        try {
            comm2.execute();
        } catch (Exception e) {
            comm2.rollback();
        }

        array1 = stack1.toArray();
        array2 = calculator.getStack().toArray();
        assertEquals(array1.length, array2.length);
        for (int i = 0; i < array1.length; i++) {
            assertEquals((Complex) array1[i], (Complex) array2[i]);
        }

        map1 = vars1.getCollect();
        map2 = calculator.getVars().getCollect();
        assertNull((Complex) map1.get('a'));
        assertNull((Complex) map2.get('a'));
        for (char x = 'b'; x <= 'z'; x++) {
            Complex comp1 = (Complex) map1.get(x);
            Complex comp2 = (Complex) map2.get(x);
            assertEquals(true, comp1.equals(comp2));
        }
    }

    /**
     * Test of delete method, of class UserOpCommand.
     */
    @Test
    public void testDelete() {
        /*Creazione di alcuni oggetti istanze di UserOpCommand*/
        UserOpCommand comm1 = new UserOpCommand("prova", "dup + drop 5i >a", calculator);
        calculator.getUserOpMap().put("prova", comm1);
        UserOpCommand comm2 = new UserOpCommand("test", "sqrt +- over over", calculator);
        calculator.getUserOpMap().put("test", comm2);
        UserOpCommand comm3 = new UserOpCommand("mix", "* drop - test /", calculator);
        calculator.getUserOpMap().put("mix", comm3);
        UserOpCommand comm4 = new UserOpCommand("enri", "5+8i >f <f sqrt -", calculator);
        calculator.getUserOpMap().put("enri", comm4);
        UserOpCommand comm5 = new UserOpCommand("andre", "/ +c -c / 2 sqrt +v + drop", calculator);
        calculator.getUserOpMap().put("andre", comm5);
        UserOpCommand comm6 = new UserOpCommand("prova0", "dup * +-", calculator);
        calculator.getUserOpMap().put("prova0", comm6);
        UserOpCommand comm7 = new UserOpCommand("prova1", "* drop prova0 <c", calculator);
        calculator.getUserOpMap().put("prova1", comm7);
        UserOpCommand comm8 = new UserOpCommand("prova2", "/ sqrt prova1", calculator);
        calculator.getUserOpMap().put("prova2", comm8);
        UserOpCommand comm9 = new UserOpCommand("prova3", "prova2 + +-", calculator);
        calculator.getUserOpMap().put("prova3", comm9);
        UserOpCommand comm10 = new UserOpCommand("prova4", "+ prova2 clear >a", calculator);
        calculator.getUserOpMap().put("prova4", comm10);

        /*Verifica che i commands siano stati correttamente inseriti*/
        assertEquals(comm1, calculator.getUserOpMap().get("prova"));
        assertEquals(comm2, calculator.getUserOpMap().get("test"));
        assertEquals(comm3, calculator.getUserOpMap().get("mix"));
        assertEquals(comm4, calculator.getUserOpMap().get("enri"));
        assertEquals(comm5, calculator.getUserOpMap().get("andre"));
        assertEquals(comm6, calculator.getUserOpMap().get("prova0"));
        assertEquals(comm7, calculator.getUserOpMap().get("prova1"));
        assertEquals(comm8, calculator.getUserOpMap().get("prova2"));
        assertEquals(comm9, calculator.getUserOpMap().get("prova3"));
        assertEquals(comm10, calculator.getUserOpMap().get("prova4"));

        comm1.delete();
        assertNull(calculator.getUserOpMap().get("prova"));
        comm2.delete();
        assertNull(calculator.getUserOpMap().get("test"));
        comm3.delete();
        assertNull(calculator.getUserOpMap().get("mix"));
        comm4.delete();
        assertNull(calculator.getUserOpMap().get("enri"));
        comm5.delete();
        assertNull(calculator.getUserOpMap().get("andre"));
        comm6.delete();
        assertNull(calculator.getUserOpMap().get("prova0"));
        assertNull(calculator.getUserOpMap().get("prova1"));
        assertNull(calculator.getUserOpMap().get("prova2"));
        assertNull(calculator.getUserOpMap().get("prova3"));
        assertNull(calculator.getUserOpMap().get("prova4"));
    }

}
