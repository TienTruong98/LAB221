/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import tientt.dtos.ArmorDTO;
import tientt.logger.ClientLogger;
import tientt.utils.Constant;
import tientt.viewobject.ArmorViewObject;

/**
 *
 * @author natton
 */
public class ArmorViewObjectMapperImpl implements ArmorViewObjectMapper {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
    private static final Logger LOGGER = ClientLogger.getLogger();

    @Override
    public ArmorViewObject toViewObject(ArmorDTO dto) {
        if (dto == null) {
            return null;
        }//end if dto is not null
        ArmorViewObject viewObject = new ArmorViewObject();
        viewObject.setArmorID(dto.getArmorID());
        viewObject.setClassification(dto.getClassification());
        viewObject.setDescription(dto.getDescription());
        viewObject.setStatus(dto.getStatus());
        viewObject.setTimeOfCreate(dateFormat.format(dto.getTimeOfCreate()));
        viewObject.setDefense(String.valueOf(dto.getDefense()));
        return viewObject;
    }

    @Override
    public ArmorDTO toDTO(ArmorViewObject viewObject) {
        if (viewObject == null) {
            return null;
        }//end if viewObject not null
        ArmorDTO armorDTO = new ArmorDTO();
        armorDTO.setArmorID(viewObject.getArmorID());
        armorDTO.setClassification(viewObject.getClassification());
        armorDTO.setDescription(viewObject.getDescription());
        armorDTO.setStatus(viewObject.getStatus());
        try {
            armorDTO.setTimeOfCreate(dateFormat.parse(viewObject.getTimeOfCreate()));
        } catch (ParseException ex) {
            LOGGER.log(Level.SEVERE, ArmorViewObjectMapperImpl.class.getName() + "::"
                    + ex.getMessage());
        }
        armorDTO.setDefense(Integer.valueOf(viewObject.getDefense()));
        return armorDTO;
    }

    @Override
    public List<ArmorViewObject> toListViewObject(List<ArmorDTO> listDTO) {
        if (listDTO == null) {
            return null;
        }//end if listDTO is not null
        List<ArmorViewObject> listArmorViewObject = new Vector<>();
        for (ArmorDTO armorDTO : listDTO) {
            ArmorViewObject viewObject = this.toViewObject(armorDTO);
            listArmorViewObject.add(viewObject);
        }
        return listArmorViewObject;
    }

    @Override
    public List<ArmorDTO> toListDTO(List<ArmorViewObject> listViewObject) {
        if (listViewObject == null) {
            return null;
        }//end if listViewObject not null
        List<ArmorDTO> listDTO = new Vector<>();
        for (ArmorViewObject viewObject : listViewObject) {
            ArmorDTO armorDTO = this.toDTO(viewObject);
            listDTO.add(armorDTO);
        }
        return listDTO;
    }

}
