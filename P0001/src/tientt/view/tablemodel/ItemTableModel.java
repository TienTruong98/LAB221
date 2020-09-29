/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.view.tablemodel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tientt.dtos.SupplierDTO;
import tientt.logger.CustomLogger;
import tientt.services.interfaces.SupplierService;
import tientt.view.viewobject.ItemViewObject;

/**
 *
 * @author natton
 */
public class ItemTableModel extends TableModel<ItemViewObject> {

    private final SupplierService supplierService;
    private static final Logger LOGGER = CustomLogger.getLogger();

    public ItemTableModel(String[] headers, int[] indexes) {
        super(headers, indexes);
        this.supplierService = SupplierService.getNewInstance();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemViewObject item = this.data.get(rowIndex);
        switch (indexes[columnIndex]) {
            case 1:
                return item.getItemCode();
            case 2:
                return item.getItemName();
            case 3:
                return item.getUnit();
            case 4:
                return item.getPrice();
            case 5:
                String supCode = item.getSupCode();
                if (supCode != null) {
                    try {
                        SupplierDTO supplierDTO = supplierService.findSupplierById(supCode);
                        return supCode + "-" + supplierDTO.getSupName();
                    } catch (ClassNotFoundException | SQLException e) {
                        LOGGER.log(Level.SEVERE, ItemTableModel.class.getName() + "::" + e.getMessage());
                        return supCode;
                    }
                }//end if item supCode is null
                else {
                    return "";
                }
            case 6:
                return item.isSupplying();
        }
        return null;
    }

    @Override
    public void update(ItemViewObject newViewObject, int index) {
        ItemViewObject oldViewObject = this.data.get(index);
        oldViewObject.setItemName(newViewObject.getItemName());
        oldViewObject.setPrice(newViewObject.getPrice());
        oldViewObject.setSupCode(newViewObject.getSupCode());
        oldViewObject.setSupplying(newViewObject.isSupplying());
        oldViewObject.setUnit(newViewObject.getUnit());
    }

}
