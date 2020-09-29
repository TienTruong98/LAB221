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
import tientt.daos.interfaces.ItemDAO;
import tientt.dtos.ItemDTO;
import tientt.utils.DBHelpers;

/**
 *
 * @author natton
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public ItemDTO findItemById(String itemCode) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ItemDTO dto = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "SELECT itemName, unit, price, supplying, supCode FROM "
                        + "tblItems WHERE itemCode = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, itemCode);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String itemName = resultSet.getString("itemName");
                    String unit = resultSet.getString("unit");
                    float price = resultSet.getFloat("price");
                    boolean supplying = resultSet.getBoolean("supplying");
                    String supCode = resultSet.getString("supCode");
                    dto = new ItemDTO(itemCode, itemName, unit, price, supplying, supCode);
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
    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "DELETE FROM tblItems WHERE itemCode = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, itemCode);

                int result = statement.executeUpdate();
                return result > 0;

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
    public boolean insertItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "INSERT tblItems(itemCode, itemName, unit, price, supplying, supCode) "
                        + "VALUES(?, ?, ?, ?, ?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, dto.getItemCode());
                statement.setString(2, dto.getItemName());
                statement.setString(3, dto.getUnit());
                statement.setFloat(4, dto.getPrice());
                statement.setBoolean(5, dto.isSupplying());
                statement.setString(6, dto.getSupCode());
                int result = statement.executeUpdate();
                return result > 0;
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
    public List<ItemDTO> findAllItems() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ItemDTO> listDTO = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "SELECT itemCode, itemName, unit, price, supplying, supCode FROM "
                        + "tblItems";
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    if (listDTO == null) {
                        listDTO = new Vector<>();
                    }
                    String itemCode = resultSet.getString("itemCode");
                    String itemName = resultSet.getString("itemName");
                    String unit = resultSet.getString("unit");
                    float price = resultSet.getFloat("price");
                    boolean supplying = resultSet.getBoolean("supplying");
                    String supCode = resultSet.getString("supCode");

                    listDTO.add(new ItemDTO(itemCode, itemName, unit, price, supplying, supCode));
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

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "UPDATE tblItems SET itemName = ?, unit = ?, price = ?, "
                        + "supplying = ?, supCode = ? WHERE itemCode = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, dto.getItemName());
                statement.setString(2, dto.getUnit());
                statement.setFloat(3, dto.getPrice());
                statement.setBoolean(4, dto.isSupplying());
                statement.setString(5, dto.getSupCode());
                statement.setString(6, dto.getItemCode());

                int result = statement.executeUpdate();
                return result > 0;
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
    public List<ItemDTO> findItemsBySupCode(String supCode) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ItemDTO> listDTO = null;
        try {
            connection = DBHelpers.getConnection();
            if (connection != null) {
                String sql = "SELECT itemCode, itemName, unit, price, supplying FROM "
                        + "tblItems WHERE supCode = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, supCode);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    if (listDTO == null) {
                        listDTO = new Vector<>();
                    }
                    String itemCode = resultSet.getString("itemCode");
                    String itemName = resultSet.getString("itemName");
                    String unit = resultSet.getString("unit");
                    float price = resultSet.getFloat("price");
                    boolean supplying = resultSet.getBoolean("supplying");
                    listDTO.add(new ItemDTO(itemCode, itemName, unit, price, supplying, supCode));
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
