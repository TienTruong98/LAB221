/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.daos.interfaces;

import java.sql.SQLException;
import java.util.List;
import tientt.daos.implementations.SupplierDAOImpl;
import tientt.dtos.SupplierDTO;

/**
 *
 * @author natton
 */
public interface SupplierDAO {

    public SupplierDTO findSupplierById(String supCode) throws SQLException, ClassNotFoundException;

    public boolean deleteSupplier(String supCode) throws SQLException, ClassNotFoundException;

    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException;

    public boolean insertSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException;

    public List<SupplierDTO> findAllSuppliers() throws SQLException, ClassNotFoundException;

    public static SupplierDAO getNewInstance() {
        return new SupplierDAOImpl();
    }
}
