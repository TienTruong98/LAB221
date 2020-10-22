/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mapper;

import tientt.dtos.EmployeeDTO;
import tientt.viewobjects.EmployeeViewObject;

/**
 *
 * @author natton
 */
public interface EmployeeViewObjectMapper 
        extends ViewObjectGenericMapper<EmployeeDTO, EmployeeViewObject>{
    public static EmployeeViewObjectMapper getNewInstance(){
        return new EmployeeViewObjectMapperImpl();
    }
    
}
