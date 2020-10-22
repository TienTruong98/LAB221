/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services;

import java.sql.SQLException;
import java.util.List;
import tientt.daos.EmployeeDAO;
import tientt.dtos.EmployeeDTO;
import tientt.errors.EmployeeFormatError;
import tientt.exceptions.EmployeeExistedException;
import tientt.exceptions.EmployeeInvalidException;
import tientt.mapper.EmployeeViewObjectMapper;
import tientt.viewobjects.EmployeeViewObject;

/**
 *
 * @author natton
 */
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO dao = EmployeeDAO.getNewInstance();
    private final EmployeeViewObjectMapper mapper = EmployeeViewObjectMapper.getNewInstance();

    @Override
    public boolean createEmployee(EmployeeViewObject viewObject) throws SQLException, 
            ClassNotFoundException, EmployeeInvalidException, EmployeeExistedException {
        boolean isAddNew = true;
        EmployeeDTO dto = this.getValidatedDTO(viewObject, isAddNew);
        //to this point dto is validated
        EmployeeDTO existedEmployee = this.getEmployeeByID(dto.getEmpID());
        if (existedEmployee != null) {
            throw new EmployeeExistedException();
        }
        boolean result = dao.create(dto);
        return result;
    }

    @Override
    public boolean updateEmployee(EmployeeViewObject viewObject) throws SQLException, ClassNotFoundException, EmployeeInvalidException {
        boolean isAddNew = false;
        EmployeeDTO dto = this.getValidatedDTO(viewObject, isAddNew);
        //to this point dto is validated
        boolean result = dao.update(dto);
        return result;
    }

    @Override
    public boolean deleteEmployee(String ID) throws SQLException, ClassNotFoundException {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpID(ID);
        boolean result = dao.remove(dto);
        return result;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() throws ClassNotFoundException, SQLException {
        return dao.getAll();
    }

    @Override
    public EmployeeDTO getEmployeeByID(String ID) throws SQLException, ClassNotFoundException {
        return dao.getByID(ID);
    }

    @Override
    public EmployeeDTO getValidatedDTO(EmployeeViewObject viewObject, boolean isAddNew) 
            throws EmployeeInvalidException {
        EmployeeFormatError error = new EmployeeFormatError(viewObject, isAddNew);
        if (error.isHasError()) {
            throw new EmployeeInvalidException(error.getErrorMessages());
        }
        EmployeeDTO dto = mapper.toDTO(viewObject);
        return dto;
    }

}
