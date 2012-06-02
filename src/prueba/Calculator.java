/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import java.util.logging.Level;
import java.util.logging.Logger;
import prueba.ExceptionsNegativos;

/**
 *
 * @author usuario
 */
public class Calculator {

    public int add(String numbers) throws ExceptionsNegativos{
        int sum = 0;
        String negativos = "";
        
        if ( numbers.equals("") ) {
            sum = 0;
        }else{
            numbers = cambiarSeparadoresPorComas(numbers);
            String[] numberArray = numbers.split(",");
            for (int i = 0; i < numberArray.length; i++) {
                if (Integer.parseInt( numberArray[i] ) < 0) {
                    negativos += numberArray[i] + ",";
                }else{
                    if ( Integer.parseInt( numberArray[i] ) <= 1000 ) {
                        sum += Integer.parseInt( numberArray[i] );
                    }
                }
            }
            if ( !negativos.equals("") ) {
                throw new ExceptionsNegativos("No puede ingresar numeros negativos tales como: " + negativos);
            }
        }
        return sum;
    }

    public String cambiarSeparadoresPorComas(String numbers) {
        String regEx = "(,)|";
        String temp = "";
        if ( numbers.indexOf("//") == 0 ){
            temp = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
            String[] separadores = generarDelimitadores(temp);
            for (int i = 0; i < separadores.length; i++) {
                regEx += separadores[i] + "|";
            }
            regEx = regEx.substring(0, regEx.length()-1);
            regEx += "|(\n)";
        }else{
            regEx += "(\n)";
        }
        numbers = numbers.replaceAll(regEx, ",");
        return numbers;
    }

    private String[] generarDelimitadores(String numbers){

        if ( numbers.indexOf("[") == 0 ){
            numbers = numbers.replaceAll("\\[", "");
            numbers = numbers.replaceAll("\\]", ",");
            numbers = numbers.substring(0, numbers.length()-1);
        }

        String[] separadores = numbers.split(",");
        for (int i = 0; i < separadores.length; i++) {
            separadores[i] = "(\\Q" + separadores[i] + "\\E)";
        }
        return separadores;
    }

}
