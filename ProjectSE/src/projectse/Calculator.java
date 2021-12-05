/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import java.util.Deque;
import com.vm.jcomplex.Complex;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

/**
 *
 * @author Group3
 */
public class Calculator {

    private Deque<Complex> stack;
    private VarCollection<Complex> vars;

    public Calculator() {
        stack = new ArrayDeque<Complex>();
        vars = new VarCollection<>();
    }

    public Deque<Complex> getStack() {
        return stack;
    }

    public VarCollection<Complex> getVars() {
        return vars;
    }

    private boolean isReal(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isImaginary(String input) {
        if (input.charAt(0) == '+' || input.charAt(0) == '-') {
            input = input.substring(1);
        }
        if (input.equals("i")) {
            return true;
        }
        if (input.length() != 0 && ('i' == input.charAt(0) || 'i' == input.charAt(input.length() - 1))) {
            if (!input.replaceFirst("i", "").contains("i")) {
                input = input.replace("i", "");
                if (!input.equals(".") && input.matches("([0-9])*(\\.([0-9])*)?")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isComplex(String input) {
        if (input.contains(" ")) {
            return false;
        }
        if (input.charAt(0) == '+' || input.charAt(0) == '-') {
            input = input.substring(1);
        }
        String[] parts = {"", ""};
        parts = input.split("\\+|-", -1);
        if (parts.length != 2) {
            return false;
        }
        if (parts[0].length() == 0 || parts[1].length() == 0) {
            return false;
        }
        if (!(('i' == parts[0].charAt(0) || 'i' == parts[0].charAt(parts[0].length() - 1)) || ('i' == parts[1].charAt(0) || 'i' == parts[1].charAt(parts[1].length() - 1)))) {
            return false;
        }
        if ((parts[0].contains("i") && parts[1].contains("i")) || (!parts[0].contains("i") && !parts[1].contains("i"))) {
            return false;
        }
        if (parts[0].replaceFirst("i", "").contains("i") || parts[1].replaceFirst("i", "").contains("i")) {
            return false;
        }
        if (parts[0].equals("i")) {
            parts[0] = "1i";
        } else if (parts[1].equals("i")) {
            parts[1] = "1i";
        }
        parts[0] = parts[0].replace("i", "");
        parts[1] = parts[1].replace("i", "");
        if (!isReal(parts[0]) || !isReal(parts[1])) {
            return false;
        }
        return true;
    }

    public int recognizer(String input) {
        input = input.trim();
        if (input.matches("show [a-z]")) {
            return 12;
        }
        if (isReal(input) || isImaginary(input) || isComplex(input)) {
            return 0;
        }
        switch (input) {
            case "+":
                return 1;
            case "-":
                return 2;
            case "*":
                return 3;
            case "/":
                return 4;
            case "sqrt":
                return 5;
            case "+-":
                return 6;
            case "clear":
                return 7;
            case "drop":
                return 8;
            case "dup":
                return 9;
            case "swap":
                return 10;
            case "over":
                return 11;
        }
        return -1;
    }

    public boolean pushComplex(String number) {
        String swap;
        int firstSign = 1;
        int secondSign = 1;
        number = number.trim();

        if (isReal(number)) {
            if (number.matches("-0*(\\.0*)?")) {        //viene fatto poiché la libreria non gestisce correttamente -0 o -0.000...
                number = "0";
            }
            try {
                stack.push(new Complex(Double.parseDouble(number)));
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        if (isImaginary(number)) {
            if (number.charAt(0) == '+') {
                number = number.substring(1);
            } else if (number.charAt(0) == '-') {
                firstSign = -1;
                number = number.substring(1);
            }
            if (number.equals("i")) {
                try {
                    stack.push(new Complex(0, firstSign));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else {
                number = number.replace("i", "");
                if (number.matches("0*(\\.0*)?")) {        //viene fatto poiché la libreria non gestisce correttamente -0 o -0.000...
                    number = "0";
                    firstSign = 1;
                }
                try {
                    stack.push(new Complex(0, firstSign * Double.parseDouble(number)));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }

        if (isComplex(number)) {
            if (number.charAt(0) == '+') {
                number = number.substring(1);
            } else if (number.charAt(0) == '-') {
                firstSign = -1;
                number = number.substring(1);
            }
            String[] parts = {"", ""};
            if (number.contains("-")) {
                secondSign = -1;
            }
            parts = number.split("\\+|-", -1);
            if (parts[1].equals("i")) {
                parts[1] = "1i";
            } else if (parts[0].equals("i")) {
                parts[0] = "1i";
            }
            if (parts[0].contains("i")) {
                swap = parts[0];
                parts[0] = parts[1];
                parts[1] = swap;
                parts[1] = parts[1].replace("i", "");
                if (parts[0].matches("0*(\\.0*)?")) {        //viene fatto poiché la libreria non gestisce correttamente -0 o -0.000...
                    parts[0] = "0";
                    secondSign = 1;
                }
                if (parts[1].matches("0*(\\.0*)?")) {        //viene fatto poiché la libreria non gestisce correttamente -0 o -0.000...
                    parts[1] = "0";
                    firstSign = 1;
                }
                try {
                    stack.push(new Complex(secondSign * Double.parseDouble(parts[0]), firstSign * Double.parseDouble(parts[1])));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else {
                parts[1] = parts[1].replace("i", "");
                if (parts[0].matches("0*(\\.0*)?")) {        //viene fatto poiché la libreria non gestisce correttamente -0 o -0.000...
                    parts[0] = "0";
                    firstSign = 1;
                }
                if (parts[1].matches("0*(\\.0*)?")) {        //viene fatto poiché la libreria non gestisce correttamente -0 o -0.000...
                    parts[1] = "0";
                    secondSign = 1;
                }
                try {
                    stack.push(new Complex(firstSign * Double.parseDouble(parts[0]), secondSign * Double.parseDouble(parts[1])));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }

    public Complex popComplex() {
        return stack.pop();
    }

    public int makeOperation(int id) {
        switch (id) {
            case 1:
                add();
                return 1;
            case 2:
                subtract();
                return 2;
            case 3:
                multiply();
                return 3;
            case 4:
                divide();
                return 4;
            case 5:
                sqrt();
                return 5;
            case 6:
                negate();
                return 6;
            case 7:
                clear();
                return 7;
            case 8:
                drop();
                return 8;
            case 9:
                dup();
                return 9;
            case 10:
                swap();
                return 10;
            case 11:
                over();
                return 11;
            default:
                return -1;
        }
    }

    public void add() throws NoSuchElementException {
        if (stack.size() < 2) {
            throw new NoSuchElementException();
        }
        Complex op1, op2, result;
        op2 = stack.pop();
        op1 = stack.pop();
        result = op1.add(op2);
        stack.push(result);
    }

    public void subtract() throws NoSuchElementException {
        if (stack.size() < 2) {
            throw new NoSuchElementException();
        }
        Complex op1, op2, result;
        op2 = stack.pop();
        op1 = stack.pop();
        result = op1.subtract(op2);
        stack.push(result);
    }

    public void multiply() throws NoSuchElementException {
        if (stack.size() < 2) {
            throw new NoSuchElementException();
        }
        Complex op1, op2, result;
        op2 = stack.pop();
        op1 = stack.pop();
        result = op1.multiply(op2);
        stack.push(result);
    }

    public void divide() throws NoSuchElementException {
        if (stack.size() < 2) {
            throw new NoSuchElementException();
        }
        Complex op1, op2, result;
        op2 = stack.pop();
        op1 = stack.pop();
        result = op1.divide(op2);
        stack.push(result);
    }

    public void sqrt() throws NoSuchElementException {
        Complex op;
        op = stack.pop();
        stack.push(op.sqrt());
    }

    public void negate() throws NoSuchElementException {
        Complex op;
        op = stack.pop();
        stack.push(op.negate());
    }

    public void clear() {
        stack.clear();
    }

    public void drop() throws NoSuchElementException {
        stack.pop();
    }

    public void dup() throws NoSuchElementException {
        Complex op;
        op = stack.getFirst();
        stack.push(op);
    }

    public void swap() throws NoSuchElementException {
        if (stack.size() < 2) {
            throw new NoSuchElementException();
        }
        Complex op1, op2;
        op1 = stack.pop();
        op2 = stack.pop();
        stack.push(op1);
        stack.push(op2);
    }

    public void over() throws NoSuchElementException {
        if (stack.size() < 2) {
            throw new NoSuchElementException();
        }
        Complex op1, op2;
        op1 = stack.pop();
        op2 = stack.getFirst();
        stack.push(op1);
        stack.push(op2);
    }

    public Complex showVar(char c) throws UnacceptableKeyException {
        return vars.getVar(c);
    }

    public void pushToVar(char c) throws UnacceptableKeyException, NoSuchElementException {
        vars.setVar(c, stack.pop());
    }

    public void pullFromVar(char c) throws UnacceptableKeyException, NullPointerException {
        stack.push(vars.getVar(c));
    }

    public void addVar(char c) throws UnacceptableKeyException, NoSuchElementException, NullPointerException {
        Complex op1, op2, result;
        op1 = vars.getVar(c);
        if (op1 != null) {
            op2 = stack.pop();
            result = op1.add(op2);
            stack.push(result);
        } else {
            throw new NullPointerException();
        }
    }
}
