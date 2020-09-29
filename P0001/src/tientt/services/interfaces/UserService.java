/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services.interfaces;

import java.sql.SQLException;
import tientt.exceptions.UserInactiveExecption;
import tientt.exceptions.UserInvalidPasswordUsernameException;
import tientt.services.implementations.UserServiceImpl;

/**
 *
 * @author natton
 */
public interface UserService {

    public void checkLogin(String username, String password) throws
            ClassNotFoundException, SQLException, 
            UserInactiveExecption, UserInvalidPasswordUsernameException;

    public static UserService getNewInstance(){
        return new UserServiceImpl();
    }
}
