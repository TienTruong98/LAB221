/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tientt.dtos.EmployeeDTO;
import tientt.logger.CustomLogger;
import tientt.utlils.Constant;
import tientt.viewobjects.EmployeeViewObject;

/**
 *
 * @author natton
 */
public class EmployeeViewObjectMapperImpl implements EmployeeViewObjectMapper {
    
    private static final SimpleDateFormat FORMATTER
            = new SimpleDateFormat(Constant.DATE_FORMAT);
    private static final Logger LOGGER = CustomLogger.getLogger();
    
    @Override
    public EmployeeDTO toDTO(EmployeeViewObject viewObject) {
        if (viewObject == null) {
            return null;
        }
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpID(viewObject.getEmpID());
        dto.setFullName(viewObject.getFullName());
        dto.setEmail(viewObject.getEmail());
        dto.setPhone(viewObject.getPhone());
        dto.setAddress(viewObject.getAddress());
        try {
            dto.setDateOfbirth(FORMATTER.parse(viewObject.getDateOfbirth()));
        } catch (ParseException ex) {
            LOGGER.log(Level.SEVERE, "{0}::{1}", new Object[]{EmployeeViewObjectMapperImpl.class.getName(), ex.getMessage()});
        }
        return dto;
    }
    
    @Override
    public EmployeeViewObject toViewObject(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        EmployeeViewObject viewObject = new EmployeeViewObject();
        viewObject.setEmpID(dto.getEmpID());
        viewObject.setFullName(dto.getFullName());
        viewObject.setAddress(dto.getAddress());
        viewObject.setPhone(dto.getPhone());
        viewObject.setEmail(dto.getEmail());
        if (dto.getDateOfbirth() != null) {
            viewObject.setDateOfbirth(FORMATTER.format(dto.getDateOfbirth()));
        } else {
            viewObject.setDateOfbirth("");
        }
        
        return viewObject;
    }
    
    @Override
    public List<EmployeeDTO> toListDTOs(List<EmployeeViewObject> listViewObjects) {
        if (listViewObjects == null) {
            return null;
        }
        List<EmployeeDTO> listDTOs = null;
        for (EmployeeViewObject viewObject : listViewObjects) {
            if (listDTOs == null) {
                listDTOs = new ArrayList<>();
            }
            listDTOs.add(this.toDTO(viewObject));
        }
        return listDTOs;
    }
    
    @Override
    public List<EmployeeViewObject> toListViewObjects(List<EmployeeDTO> listDTOs) {
        if (listDTOs == null) {
            return null;
        }
        List<EmployeeViewObject> listViewObjects = null;
        for (EmployeeDTO dto : listDTOs) {
            if (listViewObjects == null) {
                listViewObjects = new ArrayList<>();
            }
            listViewObjects.add(this.toViewObject(dto));
        }
        return listViewObjects;
    }
    
}
