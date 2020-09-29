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
public class ItemInvalidException extends Exception {

    public ItemInvalidException() {
    }

    public ItemInvalidException(String message) {
        super(message);
    }

    public ItemInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemInvalidException(Throwable cause) {
        super(cause);
    }

    public ItemInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
