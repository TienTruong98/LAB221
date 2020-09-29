/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services.interfaces;

import java.sql.SQLException;
import java.util.List;
import tientt.dtos.SupplierDTO;
import tientt.exceptions.SupplierExistedException;
import tientt.exceptions.SupplierForeignConstraintException;
import tientt.exceptions.SupplierInvalidException;
import tientt.services.implementations.SupplierServiceImpl;
import tientt.view.viewobject.SupplierViewObject;

/**
 *
 * @author natton
 */
public interface SupplierService {

    public boolean deleteSupplier(String supCode) throws SQLException, ClassNotFoundException, SupplierForeignConstraintException;

    public boolean updateSupplier(SupplierViewObject viewObject)
            throws SQLException, ClassNotFoundException, SupplierInvalidException, SupplierForeignConstraintException;

    public boolean insertSupplier(SupplierViewObject viewObject) throws SQLException,
            ClassNotFoundException, SupplierInvalidException, SupplierExistedException;

    public SupplierDTO findSupplierById(String supCode) throws SQLException,
            ClassNotFoundException;

    public List<SupplierDTO> findAllSuppliers() throws SQLException, ClassNotFoundException;

    public SupplierDTO getValidatedSupplierDTO(SupplierViewObject viewObject, boolean isAddNew) throws SupplierInvalidException;

    public static SupplierService getNewInstance() {
        return new SupplierServiceImpl();
    }

}
