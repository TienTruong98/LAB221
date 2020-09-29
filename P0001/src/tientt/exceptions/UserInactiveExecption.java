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
public class UserInactiveExecption extends Exception{

    public UserInactiveExecption() {
    }

    public UserInactiveExecption(String message) {
        super(message);
    }

    public UserInactiveExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInactiveExecption(Throwable cause) {
        super(cause);
    }

    public UserInactiveExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
}
