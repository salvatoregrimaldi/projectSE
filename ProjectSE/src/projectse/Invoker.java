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
public class Invoker {

    public Invoker() {
    }

    public void execute(Command comm) {
        comm.execute();
    }
    
}
