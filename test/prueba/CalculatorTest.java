/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class CalculatorTest {

    public CalculatorTest() {
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd() throws ExceptionsNegativos {
        System.out.println("TEST");
        Calculator instance = new Calculator();
        assertEquals(0, instance.add(""));
        assertEquals(1, instance.add("1"));
        assertEquals(3, instance.add("1,2"));
        assertEquals(6, instance.add("1\n2,3"));
        assertEquals(3, instance.add("//;\n1;2"));
        assertEquals(6, instance.add("//[***]\n1***2***3"));
        assertEquals(36, instance.add("//[***][:]\n1***2***3:1001,10\n20"));
        //assertEquals(36, instance.add("//[***][:]\n1***2***3:1001,10\n20"));
    }

}