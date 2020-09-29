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
public class ItemExistedException extends Exception{

    public ItemExistedException() {
    }

    public ItemExistedException(String message) {
        super(message);
    }

    public ItemExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemExistedException(Throwable cause) {
        super(cause);
    }

    public ItemExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
