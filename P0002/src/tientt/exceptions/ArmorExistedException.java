/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.exceptions;

/**
 *
 * @author natton
 */
public class ArmorExistedException extends Exception{

    public ArmorExistedException() {
    }

    public ArmorExistedException(String message) {
        super(message);
    }

    public ArmorExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArmorExistedException(Throwable cause) {
        super(cause);
    }

    public ArmorExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
