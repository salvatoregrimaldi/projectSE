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

    private boolean isReal(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isImaginary(String input) {
        input = input.replace(" ", "");
        if (input.charAt(0) == '+' || input.charAt(0) == '-') {
            input = input.substring(1);
        }
        if (input.equals("i")) {
            return true;
        }
        if ('i' == input.charAt(0) || 'i' == input.charAt(input.length() - 1)) {
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
        input = input.replace(" ", "");
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
        if (isReal(input)) {
            return 0;
        }
        if (isImaginary(input)) {
            return 0;
        }
        if (isComplex(input)) {
            return 0;
        }
        //insert operation strings recognition
        return -1;
    }

    public boolean pushComplex(String number) {
        String swap;
        int firstSign = 1;
        int secondSign = 1;
        number = number.replace(" ", "");

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

    public void makeOperation(int id) {
        //
    }

}
