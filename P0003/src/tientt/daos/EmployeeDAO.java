/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.daos;

import tientt.dtos.EmployeeDTO;

/**
 *
 * @author natton
 */
public interface EmployeeDAO extends GenericDAO<EmployeeDTO> {

    static EmployeeDAO getNewInstance() {
        return new EmployeeDAOImpl();
    }
}
