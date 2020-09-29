/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services.implementations;

import java.sql.SQLException;
import java.util.List;
import tientt.daos.interfaces.ItemDAO;
import tientt.dtos.ItemDTO;
import tientt.exceptions.ItemExistedException;
import tientt.format.errors.FormatItemError;
import tientt.exceptions.ItemInvalidException;
import tientt.mapper.interfaces.ItemViewObjectMapper;
import tientt.services.interfaces.ItemService;
import tientt.view.viewobject.ItemViewObject;

/**
 *
 * @author natton
 */
public class ItemServiceImpl implements ItemService {

    private final ItemDAO itemDAO;
    private final ItemViewObjectMapper mapper;

    public ItemServiceImpl() {
        this.itemDAO = ItemDAO.getNewInstance();
        this.mapper = ItemViewObjectMapper.getNewInstance();

    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException {
        boolean result = itemDAO.deleteItem(itemCode);
        return result;
    }

    @Override
    public boolean updateItem(ItemViewObject viewObject) throws SQLException,
            ClassNotFoundException, ItemInvalidException {
        boolean isAddNew = false;
        ItemDTO itemDTO = this.getValidatedItem(viewObject, isAddNew);
        //at this point itemDTO is validated
        boolean result = this.itemDAO.updateItem(itemDTO);
        return result;
    }

    @Override
    public boolean insertItem(ItemViewObject viewObject) throws SQLException,
            ClassNotFoundException, ItemInvalidException, ItemExistedException {
        boolean isAddNew = true;
        ItemDTO itemDTO = this.getValidatedItem(viewObject, isAddNew);
        //at this point itemDTO is validated
        //check for existed Item
        ItemDTO existedItem = itemDAO.findItemById(itemDTO.getItemCode());
        if (existedItem != null) {
            throw new ItemExistedException();
        }//end if no dupplicate item
        boolean result = itemDAO.insertItem(itemDTO);
        return result;
    }

    @Override
    public ItemDTO findItemByID(String itemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.findItemById(itemCode);
    }

    @Override
    public List<ItemDTO> findAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.findAllItems();
    }

    @Override
    public ItemDTO getValidatedItem(ItemViewObject viewObject, boolean isAddNew) throws ItemInvalidException {
        FormatItemError itemError = new FormatItemError(isAddNew);
        itemError.checkItemValid(viewObject);
        if (itemError.isHasError()) {
            throw new ItemInvalidException(itemError.getErrorMessage());
        }
        ItemDTO itemDTO = mapper.toDTO(viewObject);
        return itemDTO;
    }

}
