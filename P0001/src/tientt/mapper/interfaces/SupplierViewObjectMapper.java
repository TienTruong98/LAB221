/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mapper.interfaces;

import tientt.dtos.SupplierDTO;
import tientt.mapper.implemetation.SupplierViewObjectMapperImpl;
import tientt.view.viewobject.SupplierViewObject;

/**
 *
 * @author natton
 */
public interface SupplierViewObjectMapper extends 
        ViewObjectGenericMapper<SupplierDTO, SupplierViewObject> {

    public static SupplierViewObjectMapper getNewInstance() {
        return new SupplierViewObjectMapperImpl();
    }
}
