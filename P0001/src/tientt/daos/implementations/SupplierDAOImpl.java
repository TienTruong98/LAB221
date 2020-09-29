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
import java.util.List;
import java.util.Vector;
import tientt.daos.interfaces.SupplierDAO;
import tientt.dtos.SupplierDTO;
import tientt.utils.DBHelpers;

/**
 *
 * @author natton
 */
public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public SupplierDTO findSupplierById(String supCode) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SupplierDTO dto = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "SELECT supName, address, collaborating FROM "
                        + "tblSuppliers WHERE supCode = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, supCode);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String supName = resultSet.getString("supName");
                    String address = resultSet.getString("address");
                    boolean collaborating = resultSet.getBoolean("collaborating");
                    dto = new SupplierDTO(supCode, supName, address, collaborating);

                }//end if resultSet has next
            }//end if connection is not null
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return dto;
    }

    @Override
    public boolean deleteSupplier(String supCode) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "DELETE FROM tblSuppliers WHERE supCode = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, supCode);

                int result = statement.executeUpdate();
                if (result > 0) {
                    return true;
                }

            }//end if connection is not null
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "UPDATE tblSuppliers SET supName = ?, address = ?, collaborating = ? "
                        + "WHERE supCode = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, dto.getSupName());
                statement.setString(2, dto.getAddress());
                statement.setBoolean(3, dto.isCollaborating());
                statement.setString(4, dto.getSupCode());
                int result = statement.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }//end if connection is not null
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    public boolean insertSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "INSERT tblSuppliers(supCode, supName, address, collaborating) "
                        + "VALUES(?, ?, ?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, dto.getSupCode());
                statement.setString(2, dto.getSupName());
                statement.setString(3, dto.getAddress());
                statement.setBoolean(4, dto.isCollaborating());
                int result = statement.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }//end if connection is not null
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    public List<SupplierDTO> findAllSuppliers() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<SupplierDTO> listDTO = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "SELECT supCode, supName, address, collaborating FROM "
                        + "tblSuppliers";
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    if (listDTO == null){
                        listDTO = new Vector<>();
                    }
                    String supCode = resultSet.getString("supCode");
                    String supName = resultSet.getString("supName");
                    String address = resultSet.getString("address");
                    boolean collaborating = resultSet.getBoolean("collaborating");
                    listDTO.add(new SupplierDTO(supCode, supName, address, collaborating));
                }//end while iterate resultSet
            }//end if connection is not null
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return listDTO;
    }

}
