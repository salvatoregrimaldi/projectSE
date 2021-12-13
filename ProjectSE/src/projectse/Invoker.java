/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import exceptions.UserOpNotFoundException;

/**
 *
 * @author Group3
 */
public class Invoker {

    public Invoker() {
    }

    public void execute(Command comm) throws UserOpNotFoundException {
        comm.execute();
    }

    public void rollback(Command comm) {
        comm.rollback();
    }

    public void delete(Command comm) {
        comm.delete();
    }

}
