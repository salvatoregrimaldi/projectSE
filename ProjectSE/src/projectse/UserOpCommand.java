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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
