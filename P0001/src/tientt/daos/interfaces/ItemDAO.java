/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.daos.interfaces;

import java.sql.SQLException;
import java.util.List;
import tientt.daos.implementations.ItemDAOImpl;
import tientt.dtos.ItemDTO;

/**
 *
 * @author natton
 */
public interface ItemDAO {

    public ItemDTO findItemById(String itemCode) throws SQLException, ClassNotFoundException;

    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean insertItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public List<ItemDTO> findAllItems() throws SQLException, ClassNotFoundException;

    public List<ItemDTO> findItemsBySupCode(String supCode) throws SQLException, ClassNotFoundException;

    public static ItemDAO getNewInstance() {
        return new ItemDAOImpl();
    }
}
