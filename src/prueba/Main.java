/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionsNegativos {
        // TODO code application logic here
        Calculator calc = new Calculator();
        int sum = calc.add("//;\n1;2,1");
        System.out.println(sum);
    }

}
