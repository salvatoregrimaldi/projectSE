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
public class UnacceptableKeyException extends RuntimeException {

    /**
     * Creates a new instance of <code>UnacceptableException</code> without
     * detail message.
     */
    public UnacceptableKeyException() {
    }

    /**
     * Constructs an instance of <code>UnacceptableException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnacceptableKeyException(String msg) {
        super(msg);
    }
}
