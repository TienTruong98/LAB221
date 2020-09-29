/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services.interfaces;

import java.sql.SQLException;
import java.util.List;
import tientt.dtos.ItemDTO;
import tientt.exceptions.ItemExistedException;
import tientt.exceptions.ItemInvalidException;
import tientt.services.implementations.ItemServiceImpl;
import tientt.view.viewobject.ItemViewObject;

/**
 *
 * @author natton
 */
public interface ItemService {

    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ItemViewObject viewObject) throws SQLException, 
            ClassNotFoundException, ItemInvalidException;

    public boolean insertItem(ItemViewObject viewObject) throws SQLException, 
            ClassNotFoundException, ItemInvalidException, ItemExistedException;

    public ItemDTO findItemByID(String itemCode) throws SQLException, ClassNotFoundException;

    public List<ItemDTO> findAllItems() throws SQLException, ClassNotFoundException;

    public ItemDTO getValidatedItem(ItemViewObject viewObject, boolean isAddNew) throws ItemInvalidException;

    public static ItemService getNewInstance() {
        return new ItemServiceImpl();
    }
}
