/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mapper.interfaces;

import tientt.dtos.ItemDTO;
import tientt.mapper.implemetation.ItemViewObjectMapperImpl;
import tientt.view.viewobject.ItemViewObject;

/**
 *
 * @author natton
 */
public interface ItemViewObjectMapper extends ViewObjectGenericMapper<ItemDTO, ItemViewObject> {

    public static ItemViewObjectMapper getNewInstance() {
        return new ItemViewObjectMapperImpl();
    }
}
