/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services;

import java.sql.SQLException;
import java.util.List;
import tientt.dtos.EmployeeDTO;
import tientt.exceptions.EmployeeExistedException;
import tientt.exceptions.EmployeeInvalidException;
import tientt.viewobjects.EmployeeViewObject;

/**
 *
 * @author natton
 */
public interface EmployeeService {

    public static EmployeeService getNewInstance() {
        return new EmployeeServiceImpl();
    }

    public boolean createEmployee(EmployeeViewObject viewObject) throws SQLException,
            ClassNotFoundException, EmployeeInvalidException, EmployeeExistedException;

    public boolean updateEmployee(EmployeeViewObject viewObject) throws SQLException, ClassNotFoundException,
            EmployeeInvalidException;

    public boolean deleteEmployee(String ID) throws SQLException, ClassNotFoundException;

    public List<EmployeeDTO> getAllEmployee() throws ClassNotFoundException,
            SQLException;

    public EmployeeDTO getEmployeeByID(String ID) throws SQLException, ClassNotFoundException;

    public EmployeeDTO getValidatedDTO(EmployeeViewObject viewObject, boolean isAddNew) throws EmployeeInvalidException;
}
