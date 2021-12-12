/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import exceptions.UnacceptableKeyException;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Salvatore
 */
public class VarCollectionTest {

    VarCollection<Object> instance;

    public VarCollectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new VarCollection<>();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getVar method, of class VarCollection.
     */
    @Test
    public void testGetVar() {
        Map map = instance.getCollect();
        for (char x = 'a'; x <= 'z'; x++) {
            Object obj = new Object();
            map.put(x, obj);
            assertEquals(obj, instance.getVar(x));
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testGetVarExceptions() {
        char x;
        for (x = 0; x < 96; x++) {
            instance.getVar(x);
        }
        for (x = 123; x <= 127; x++) {
            instance.getVar(x);
        }
    }

    /**
     * Test of setVar method, of class VarCollection.
     */
    @Test
    public void testSetVar() {
        Map map = instance.getCollect();
        for (char x = 'a'; x <= 'z'; x++) {
            Object obj = new Object();
            instance.setVar(x, obj);
            assertEquals(obj, map.get(x));
        }
    }

    @Test(expected = UnacceptableKeyException.class)
    public void testSetVarExceptions() {
        char x;
        for (x = 0; x < 96; x++) {
            instance.setVar(x, new Object());
        }
        for (x = 123; x <= 127; x++) {
            instance.setVar(x, new Object());
        }
    }

}
