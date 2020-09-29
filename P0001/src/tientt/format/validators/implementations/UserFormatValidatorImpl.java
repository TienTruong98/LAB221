/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.validators.implementations;

import tientt.format.validators.interfaces.UserFormatValidator;

/**
 *
 * @author natton
 */
public class UserFormatValidatorImpl implements UserFormatValidator{

    @Override
    public boolean isUsernameNull(String username) {
        return username.isEmpty();
    }

    @Override
    public boolean isPasswordNull(String password) {
        return password.isEmpty();
    }

    
    
}
