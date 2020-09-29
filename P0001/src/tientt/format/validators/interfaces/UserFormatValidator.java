/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.validators.interfaces;

import tientt.format.validators.implementations.UserFormatValidatorImpl;

/**
 *
 * @author natton
 */
public interface UserFormatValidator {

    public boolean isUsernameNull(String username);

    public boolean isPasswordNull(String password);
    
    public static UserFormatValidator getNewInstance(){
        return new UserFormatValidatorImpl();
    }
}
