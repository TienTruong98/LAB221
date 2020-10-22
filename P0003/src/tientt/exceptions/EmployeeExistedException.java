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
public class EmployeeExistedException extends Exception{

    public EmployeeExistedException() {
    }

    public EmployeeExistedException(String message) {
        super(message);
    }

    public EmployeeExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeExistedException(Throwable cause) {
        super(cause);
    }

    public EmployeeExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
