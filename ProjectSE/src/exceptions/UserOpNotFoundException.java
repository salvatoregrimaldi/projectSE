/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Group3
 */
public class UserOpNotFoundException extends RuntimeException {

    /**
     * Creates a new instance of <code>UserOpNotFoundException</code> without
     * detail message.
     */
    public UserOpNotFoundException() {
    }

    /**
     * Constructs an instance of <code>UserOpNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserOpNotFoundException(String msg) {
        super(msg);
    }
}
