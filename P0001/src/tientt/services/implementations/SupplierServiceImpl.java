/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services.implementations;

import java.sql.SQLException;
import java.util.List;
import tientt.daos.interfaces.ItemDAO;
import tientt.daos.interfaces.SupplierDAO;
import tientt.dtos.ItemDTO;
import tientt.dtos.SupplierDTO;
import tientt.format.errors.FormatSupplierError;
import tientt.exceptions.SupplierExistedException;
import tientt.exceptions.SupplierForeignConstraintException;
import tientt.exceptions.SupplierInvalidException;
import tientt.mapper.interfaces.SupplierViewObjectMapper;
import tientt.services.interfaces.SupplierService;
import tientt.view.viewobject.SupplierViewObject;

/**
 *
 * @author natton
 */
public class SupplierServiceImpl implements SupplierService {

    SupplierDAO supplierDAO;
    ItemDAO itemDAO;
    SupplierViewObjectMapper mapper;
    
    public SupplierServiceImpl(){
        this.mapper = SupplierViewObjectMapper.getNewInstance();
        this.itemDAO = ItemDAO.getNewInstance();
        this.supplierDAO = SupplierDAO.getNewInstance();
        
    }

    public boolean checkDependentItems(String supCode) throws SQLException, ClassNotFoundException {
        List<ItemDTO> listItemDTOs = itemDAO.findItemsBySupCode(supCode);
        return listItemDTOs != null;
    }

    @Override
    public boolean deleteSupplier(String supCode) throws SQLException,
            ClassNotFoundException, SupplierForeignConstraintException {
        //check for dependent items
        if (checkDependentItems(supCode)) {
            throw new SupplierForeignConstraintException();
        }
        boolean result = supplierDAO.deleteSupplier(supCode);
        return result;
    }

    @Override
    public boolean updateSupplier(SupplierViewObject viewObject) throws SQLException,
            ClassNotFoundException, SupplierInvalidException,
            SupplierForeignConstraintException {
        SupplierDTO supplierDTO = getValidatedSupplierDTO(viewObject, false);
        //to this point supplierDTO is valid
        //check for dependent items
        //if new supplier has no collaborating but still has dependent items
        if (!supplierDTO.isCollaborating() && checkDependentItems(supplierDTO.getSupCode())) {
            throw new SupplierForeignConstraintException();
        }
        //update new info model
        boolean result = supplierDAO.updateSupplier(supplierDTO);
        return result;
    }

    @Override
    public boolean insertSupplier(SupplierViewObject viewObject) throws SQLException,
            ClassNotFoundException, SupplierInvalidException, SupplierExistedException {
        SupplierDTO supplierDTO = this.getValidatedSupplierDTO(viewObject, true);
        //to this point supplierDTO is valid
        //check existed supplier
        SupplierDTO existedDTO = supplierDAO.findSupplierById(supplierDTO.getSupCode());
        if (existedDTO != null) {
            throw new SupplierExistedException();
        }//end if no duplicate supplier
        boolean result = supplierDAO.insertSupplier(supplierDTO);
        return result;
    }

    @Override
    public SupplierDTO findSupplierById(String supCode) throws SQLException, ClassNotFoundException {
        return supplierDAO.findSupplierById(supCode);
    }

    @Override
    public List<SupplierDTO> findAllSuppliers() throws SQLException, ClassNotFoundException {
        return supplierDAO.findAllSuppliers();
    }

    @Override
    public SupplierDTO getValidatedSupplierDTO(SupplierViewObject viewObject, boolean isAddNew) throws SupplierInvalidException {
        FormatSupplierError supplierError = new FormatSupplierError(isAddNew);
        supplierError.checkSupplierValid(viewObject);
        if (supplierError.isHasError()) {
            throw new SupplierInvalidException(supplierError.getErrorMessage());
        }//end if dont have any error
        SupplierDTO supplierDTO = mapper.toDTO(viewObject);
        return supplierDTO;
    }
}
