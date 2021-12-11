/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

/**
 *
 * @author Group3
 */
public class UserOpCommand implements Command {

    private String name;
    private String operation;
    private Calculator calc;

    public UserOpCommand(String name, String operation, Calculator calc) {
        name = name.trim();
        if (name.contains(" ")) {
            throw new IllegalArgumentException();
        }
        operation = operation.trim();
        if (calc.recUserOp(name + " " + operation) == -1) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.operation = operation;
        this.calc = calc;
    }

    @Override
    public String toString() {
        return name + " " + operation;
    }

    @Override
    public void execute() {
        String operator[] = operation.split(" ");
        for (String op : operator) {
            int id = calc.recognizer(op);
            if (id == 0) {
                calc.pushComplex(op);
            } else if (id > 0 && id <= 11) {
                calc.makeOperation(id);
            } else if (id >= 13 && id <= 16) {
                calc.makeVarOperation(id, op.charAt(1));
            } else if (id == 18) {
                calc.getUserOpMap().get(op).execute();
            } else {
                throw new UserOpNotFoundException();
            }
        }
    }

}
