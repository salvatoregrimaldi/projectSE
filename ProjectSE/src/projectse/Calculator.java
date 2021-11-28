/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import java.util.Deque;
import com.vm.jcomplex.Complex;
import java.util.ArrayDeque;

/**
 *
 * @author Group3
 */
public class Calculator {

    private Deque<Complex> stack;

    public Calculator() {
        stack = new ArrayDeque<Complex>();
    }

    public Deque<Complex> getStack() {
        return stack;
    }

    public void pushComplex(String number) {
        if(isDouble(number))
            stack.push(new Complex(Double.parseDouble(number)));
        else{
            String[] parts = {"",""};
            if (number.contains("+")){
                parts = number.split("\\+");
                parts[1]=parts[1].replace("i", "");
                stack.push(new Complex(Double.parseDouble(parts[0]),Double.parseDouble(parts[1])));
            }
            else if (number.contains("-")){
                parts = number.split("-");
                parts[1]=parts[1].replace("i", "");
                stack.push(new Complex(Double.parseDouble(parts[0]),-Double.parseDouble(parts[1])));
            }
        }
    }

    public Complex popComplex() {
        return stack.pop();
    }

    private boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    private boolean isComplex(String input){
        if ((input.contains("+") && input.split("\\+").length != 2)||(input.contains("-") && input.split("-").length != 2))
            return false;
        else{
            String[] parts = {"",""};
            if(input.contains("+"))
                parts = input.split("\\+");
            else if (input.contains("-"))
                parts = input.split("-");
            if(!parts[1].contains("i"))
                return false;
            parts[1]=parts[1].replace("i", "");
            if (!isDouble(parts[0]))
                return false;
            if (!isDouble(parts[1]))
                return false;
            return true;
        }
    }

    public int recognizer(String input) {
        if (isDouble(input))
            return 0;
        if (isComplex(input))
            return 0;
        //insert operation strings recognition
        return -1;
    }

    public void makeOperation(int id) {
        //
    }

}
