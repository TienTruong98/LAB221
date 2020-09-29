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
public class UserInvalidPasswordUsernameException extends Exception {

    public UserInvalidPasswordUsernameException() {
    }

    public UserInvalidPasswordUsernameException(String message) {
        super(message);
    }

    public UserInvalidPasswordUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInvalidPasswordUsernameException(Throwable cause) {
        super(cause);
    }

    public UserInvalidPasswordUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
