/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services.implementations;

import java.sql.SQLException;
import tientt.daos.interfaces.UserDAO;
import tientt.dtos.UserDTO;
import tientt.exceptions.UserInactiveExecption;
import tientt.exceptions.UserInvalidPasswordUsernameException;
import tientt.services.interfaces.UserService;
import tientt.format.validators.interfaces.UserFormatValidator;

/**
 *
 * @author natton
 */
public class UserServiceImpl implements UserService {

    private final UserDAO dao = UserDAO.getNewInstance();
    private final UserFormatValidator validator = UserFormatValidator.getNewInstance();

    @Override
    public void checkLogin(String username, String password) throws
            ClassNotFoundException, SQLException, UserInactiveExecption, UserInvalidPasswordUsernameException {
        if (validator.isUsernameNull(username) || validator.isPasswordNull(password)) {
            throw new UserInvalidPasswordUsernameException("Username or password cannot null");
        }//end if username and password not empty
        UserDTO dto = dao.findUserByUserIDAndPassword(username, password);
        if (dto == null) {
            throw new UserInvalidPasswordUsernameException("Wrong username or password");
        }//end if dto is not null
        if (!dto.isStatus()) {
            throw new UserInactiveExecption("Account inactivated");
        }//end if validator is not null
    }
}
