/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mapper.implemetation;

import java.util.List;
import java.util.Vector;
import tientt.dtos.ItemDTO;
import tientt.mapper.interfaces.ItemViewObjectMapper;
import tientt.view.viewobject.ItemViewObject;

/**
 *
 * @author natton
 */
public class ItemViewObjectMapperImpl implements ItemViewObjectMapper {

    @Override
    public ItemViewObject toViewObject(ItemDTO dto) {
        if (dto == null) {
            return null;
        }
        ItemViewObject viewObject = new ItemViewObject();
        viewObject.setItemCode(dto.getItemCode());
        viewObject.setItemName(dto.getItemName());
        viewObject.setUnit(dto.getUnit());
        viewObject.setSupplying(dto.isSupplying());
        viewObject.setPrice(String.valueOf(dto.getPrice()));
        viewObject.setSupCode(dto.getSupCode());
        return viewObject;
    }

    @Override
    public ItemDTO toDTO(ItemViewObject viewObject) {
        if (viewObject == null) {
            return null;
        }
        ItemDTO dto = new ItemDTO();
        dto.setItemCode(viewObject.getItemCode());
        dto.setItemName(viewObject.getItemName());
        dto.setUnit(viewObject.getUnit());
        dto.setPrice(Float.valueOf(viewObject.getPrice()));
        dto.setSupplying(viewObject.isSupplying());
        dto.setSupCode(viewObject.getSupCode());
        return dto;
    }

    @Override
    public List<ItemViewObject> toListViewObject(List<ItemDTO> listDTO) {
        if (listDTO == null) {
            return null;
        }
        List<ItemViewObject> listViewObject = new Vector<>();
        ItemViewObject viewObject;
        for (ItemDTO dto : listDTO) {
            viewObject = this.toViewObject(dto);
            listViewObject.add(viewObject);
        }
        return listViewObject;
    }

    @Override
    public List<ItemDTO> toListDTO(List<ItemViewObject> listViewObject) {
        if (listViewObject == null) {
            return null;
        }
        List<ItemDTO> listDTO = new Vector<>();
        ItemDTO dto;
        for (ItemViewObject viewObject : listViewObject) {
            dto = this.toDTO(viewObject);
            listDTO.add(dto);
        }
        return listDTO;
    }

}
