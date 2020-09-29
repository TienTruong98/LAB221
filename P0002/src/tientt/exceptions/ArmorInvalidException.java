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
public class ArmorInvalidException extends Exception{

    public ArmorInvalidException() {
    }

    public ArmorInvalidException(String message) {
        super(message);
    }

    public ArmorInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArmorInvalidException(Throwable cause) {
        super(cause);
    }

    public ArmorInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
