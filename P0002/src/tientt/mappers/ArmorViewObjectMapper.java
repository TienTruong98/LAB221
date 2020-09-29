/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mappers;

import tientt.dtos.ArmorDTO;
import tientt.viewobject.ArmorViewObject;

/**
 *
 * @author natton
 */
public interface ArmorViewObjectMapper extends ViewObjectGenericMapper<ArmorDTO, ArmorViewObject>{
    public static ArmorViewObjectMapper getNewInstance(){
        return new ArmorViewObjectMapperImpl();
    }
}
