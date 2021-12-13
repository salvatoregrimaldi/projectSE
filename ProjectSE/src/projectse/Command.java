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
public interface Command {

    void execute() throws UserOpNotFoundException;

    void rollback();

    void delete();
}
