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
public class EmployeeInvalidException extends Exception{

    public EmployeeInvalidException() {
    }

    public EmployeeInvalidException(String message) {
        super(message);
    }

    public EmployeeInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeInvalidException(Throwable cause) {
        super(cause);
    }

    public EmployeeInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
