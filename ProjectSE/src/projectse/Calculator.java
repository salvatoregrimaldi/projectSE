/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import exceptions.UnacceptableKeyException;
import java.util.Deque;
import com.vm.jcomplex.Complex;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Group3
 */
/*
La classe Calculator contiene lo Stack, le variabili e le operazioni-utente ad essa associati.
In essa sono presenti, inoltre, i metodi necessari al funzionamento delle operazioni base.
 */
public class Calculator implements Serializable {

    private Deque<Complex> stack;
    private VarCollection<Complex> vars;
    private ConcurrentMap<String, UserOpCommand> userOpMap;

    public Calculator() {
        stack = new ArrayDeque<Complex>();
        vars = new VarCollection<>();
        userOpMap = new ConcurrentHashMap<>();
    }

    public Deque<Complex> getStack() {
        return stack;
    }

    public void setStack(Deque<Complex> stack) {
        this.stack = stack;
    }

    public VarCollection<Complex> getVars() {
        return vars;
    }

    public void setVars(VarCollection<Complex> vars) {
        this.vars = vars;
    }

    public ConcurrentMap<String, UserOpCommand> getUserOpMap() {
        return userOpMap;
    }

    /*
    Il metodo isReal() ritorna "true" se la stringa passata in input è un numero complesso
    puramente reale. Altrimenti ritorna "false".
     */
    private boolean isReal(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /*
    Il metodo isImaginary() ritorna "true" se la stringa passata in input è un numero complesso
    puramente immaginario. Altrimenti ritorna "false".
     */
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

    /*
    Il metodo isComplex() ritorna "true" se la stringa passata in input è un numero complesso 
    costituito da parte reale e parte immaginaria. Altrimenti ritorna "false".
     */
    private boolean isComplex(String input) {
        if (input.contains(" ")) {
            return false;
        }
        if (input.charAt(0) == '+' || input.charAt(0) == '-') {
            input = input.substring(1);
        }

        //viene creato un array per contenere parte reale e parte immaginaria del numero complesso 
        //passato in input
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

        //viene effettuata una sostituzione di i con 1i per poter controllare se parte reale ed immaginaria 
        //sono numeri validi
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

    /*
    Il metodo isUserOp() ritorna "true" se l'operazione passata in input è un'operazione-utente eseguibile
    in quanto è presente nella userOpMap della calcolatrice. Altrimenti ritorna "false".
     */
    private boolean isUserOp(String op) {
        return userOpMap.containsKey(op);
    }

    /*
    Il metodo recUserOp() ritorna "1" se la stringa passata in input è un'operazione-utente valida.
    Altrimenti ritorna "-1".
     */
    public int recUserOp(String input) {
        input = input.trim();
        if (input.contains("  ")) {
            return -1;
        }
        String parts[] = input.split(" ");

        //un'operazione-utente non può avere come nome "show", "del", una lettera dell'alfabeto o un numero
        if (!(parts[0].equals("show")) && !(parts[0].equals("del")) && !(parts[0].matches("[a-z]")) && parts.length > 1 && !(input.substring(parts[0].length()).contains(parts[0]))) {
            int id = recognizer(parts[0]);
            if (!((id >= 0 && id <= 11) || (id >= 13 && id <= 16))) {

                //viene chiamato il metodo recognizer() su ogni operatore dell'operazione per verificare che sia valido
                for (int i = 1; i < parts.length; i++) {
                    id = recognizer(parts[i]);
                    if (!((id >= 0 && id <= 11) || (id >= 13 && id <= 16) || (id == 18))) {
                        return -1;
                    }
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
        return 1;
    }

    /*
    Il metodo recognizer() ritorna un intero da 0 a 19 in base all'operazione riconosciuta.
    Altrimenti ritorna "-1".
     */
    public int recognizer(String input) {
        input = input.trim();
        if (input.matches("show [a-z]")) {
            return 12;
        }
        if (input.matches(">[a-z]")) {
            return 13;
        }
        if (input.matches("<[a-z]")) {
            return 14;
        }
        if (input.matches("\\+[a-z]")) {
            return 15;
        }
        if (input.matches("-[a-z]")) {
            return 16;
        }
        if (isUserOp(input)) {
            return 18;
        }
        if (input.split(" ")[0].equals("del") && input.split(" ").length == 2 && isUserOp(input.split(" ")[1])) {
            return 19;
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

    /*
    Il metodo pushComplex() inserisce il numero complesso passato in input nello stack e ritorna "true"
    se l'operazione è avvenuta con successo. Altrimenti ritorna "false".
     */
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

            //viene controllato e conservato il segno del numero digitato
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
                if (number.matches("0*(\\.0*)?")) {
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

            //viene controllato e conservato il segno del numero digitato in prima posizione
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

            //se il numero digitato in prima posizione contiene i, esso viene scambiato con il numero
            //digitato in seconda posizione
            if (parts[0].contains("i")) {
                swap = parts[0];
                parts[0] = parts[1];
                parts[1] = swap;
                parts[1] = parts[1].replace("i", "");

                //viene controllato e conservato il segno del numero digitato in seconda posizione
                if (parts[0].matches("0*(\\.0*)?")) {
                    parts[0] = "0";
                    secondSign = 1;
                }
                if (parts[1].matches("0*(\\.0*)?")) {
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
                if (parts[0].matches("0*(\\.0*)?")) {
                    parts[0] = "0";
                    firstSign = 1;
                }
                if (parts[1].matches("0*(\\.0*)?")) {
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

    /*
    Il metodo makeOperation() esegue una determinata operazione in base all'id passato in input e ritorna
    l'intero corrispondente all'id. Ritorna "-1" se l'id passato in input non corrisponde ad alcuna operazione
     */
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
        Complex app = op.negate();
        if (app.getReal() == -0.0) {
            app = new Complex(0, app.getImaginary());
        }
        if (app.getImaginary() == -0.0) {
            app = new Complex(app.getReal(), 0);
        }
        stack.push(app);
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

    /*
    Il metodo makeVarOperation() esegue una determinata operazione sulla variabile passata in input
    in base all'id passato in input e ritorna l'intero corrispondente all'id. 
    Ritorna "-1" se l'id passato in input non corrisponde ad alcuna operazione.
    Nel caso in cui la variabile non sia valida, viene rilanciata l'eccezione UnacceptableKeyException
     */
    public int makeVarOperation(int id, char c) throws UnacceptableKeyException {
        switch (id) {
            case 13:
                pushToVar(c);
                return 13;
            case 14:
                pullFromVar(c);
                return 14;
            case 15:
                addVar(c);
                return 15;
            case 16:
                subtractVar(c);
                return 16;
            default:
                return -1;
        }
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
            vars.setVar(c, result);
        } else {
            throw new NullPointerException();
        }
    }

    public void subtractVar(char c) throws UnacceptableKeyException, NoSuchElementException, NullPointerException {
        Complex op1, op2, result;
        op1 = vars.getVar(c);
        if (op1 != null) {
            op2 = stack.pop();
            result = op1.subtract(op2);
            vars.setVar(c, result);
        } else {
            throw new NullPointerException();
        }
    }

    public boolean saveUserOps(File file) {
        if (file != null) {
            try (ObjectOutputStream dout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
                dout.writeObject(userOpMap);
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
        return false;
    }

    public boolean restoreUserOps(File file) {
        if (file != null) {
            ConcurrentMap<String, UserOpCommand> c;
            try (ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
                c = (ConcurrentHashMap) din.readObject();

                //il riferimento della calcolatrice associata alle operazioni-utente salvate
                //su file viene aggiornato con quello della calcolatrice corrente
                for (UserOpCommand x : c.values()) {
                    x.setCalc(this);
                }
                userOpMap.putAll(c);
                return true;
            } catch (IOException | ClassNotFoundException ex) {
                return false;
            }
        }
        return false;
    }

}
