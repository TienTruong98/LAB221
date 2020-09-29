/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.daos.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tientt.daos.interfaces.UserDAO;
import tientt.dtos.UserDTO;
import tientt.utils.DBHelpers;

/**
 *
 * @author natton
 */
public class UserDAOImpl implements UserDAO{

    @Override
    public UserDTO findUserByUserIDAndPassword(String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        UserDTO dto = null;
        try{
            connection = DBHelpers.getConnection();
            if (connection != null){
                String sql = "SELECT fullName, status FROM tblUsers WHERE userID = ?  "
                        + "AND password =? ";
                statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                resultSet = statement.executeQuery();
                if (resultSet.next()){
                    String fullName = resultSet.getString("fullName");
                    boolean status = resultSet.getBoolean("status");
                    dto = new UserDTO(username, fullName, password, status);
                }//end if resultSet is not null
            }//end if connection is not null
        } finally {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return dto;
    }

   
    
}
