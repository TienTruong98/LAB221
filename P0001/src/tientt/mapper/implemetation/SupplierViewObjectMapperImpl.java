/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mapper.implemetation;

import java.util.List;
import java.util.Vector;
import tientt.dtos.SupplierDTO;
import tientt.mapper.interfaces.SupplierViewObjectMapper;
import tientt.view.viewobject.SupplierViewObject;

/**
 *
 * @author natton
 */
public class SupplierViewObjectMapperImpl implements SupplierViewObjectMapper {

    @Override
    public SupplierViewObject toViewObject(SupplierDTO dto) {
        if (dto == null) {
            return null;
        }//end if dto is not null
        SupplierViewObject viewObject = new SupplierViewObject();
        viewObject.setSupName(dto.getSupName());
        viewObject.setSupCode(dto.getSupCode());
        viewObject.setAddress(dto.getAddress());
        viewObject.setCollaborating(dto.isCollaborating());
        return viewObject;
    }

    @Override
    public SupplierDTO toDTO(SupplierViewObject viewObject) {
        if (viewObject == null) {
            return null;
        }//end if viewObject is not null
        SupplierDTO dto = new SupplierDTO();
        dto.setSupCode(viewObject.getSupCode());
        dto.setSupName(viewObject.getSupName());
        dto.setAddress(viewObject.getAddress());
        dto.setCollaborating(viewObject.isCollaborating());
        return dto;
    }

    @Override
    public List<SupplierViewObject> toListViewObject(List<SupplierDTO> listDTO) {
        if (listDTO == null) {
            return null;
        }//end if listDTO is not null
        List<SupplierViewObject> listViewObject = new Vector<>();
        SupplierViewObject viewObject;
        for (SupplierDTO supplierDTO : listDTO) {
            viewObject = this.toViewObject(supplierDTO);
            listViewObject.add(viewObject);
        }
        return listViewObject;
    }

    @Override
    public List<SupplierDTO> toListDTO(List<SupplierViewObject> listViewObject) {
        if (listViewObject == null) {
            return null;
        }
        List<SupplierDTO> listDTO = new Vector<>();
        SupplierDTO supplierDTO;
        for (SupplierViewObject viewObject : listViewObject) {
            supplierDTO = this.toDTO(viewObject);
            listDTO.add(supplierDTO);
        }
        return listDTO;
    }

}
