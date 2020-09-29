/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.daos.interfaces;

import java.sql.SQLException;
import tientt.daos.implementations.UserDAOImpl;
import tientt.dtos.UserDTO;

/**
 *
 * @author natton
 */
public interface UserDAO {

    public UserDTO findUserByUserIDAndPassword(String username, String password) throws SQLException, ClassNotFoundException;

    public static UserDAO getNewInstance() {
        return new UserDAOImpl();
    }
}
