/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.view.tablemodel;

import tientt.view.viewobject.SupplierViewObject;

/**
 *
 * @author natton
 */
public class SupplierTableModel extends TableModel<SupplierViewObject> {
    
    public SupplierTableModel(String[] headers, int[] indexes) {
        super(headers, indexes);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SupplierViewObject viewObject = data.get(rowIndex);
        switch (indexes[columnIndex]) {
            case 1:
                return viewObject.getSupCode();
            case 2:
                return viewObject.getSupName();
            case 3:
                return viewObject.getAddress();
            case 4:
                return viewObject.isCollaborating();
        }
        return null;
    }
    
    @Override
    public void update(SupplierViewObject newViewObject, int index) {
        SupplierViewObject oldViewObject = this.data.get(index);
        oldViewObject.setSupName(newViewObject.getSupName());
        oldViewObject.setAddress(newViewObject.getAddress());
        oldViewObject.setCollaborating(newViewObject.isCollaborating());
    }
    
}
