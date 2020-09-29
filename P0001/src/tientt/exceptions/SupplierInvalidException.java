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
public class SupplierInvalidException extends Exception{

    public SupplierInvalidException() {
    }

    public SupplierInvalidException(String message) {
        super(message);
    }

    public SupplierInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public SupplierInvalidException(Throwable cause) {
        super(cause);
    }

    public SupplierInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
}
