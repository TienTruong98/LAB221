/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.tablemodel;

import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import tientt.viewobject.ArmorViewObject;

/**
 *
 * @author natton
 */
public class ArmorTableModel extends AbstractTableModel {

    private final String[] headers;
    private final int[] indexes;
    private final List<ArmorViewObject> data;

    public ArmorTableModel(String[] headers, int[] indexes) {
        this.headers = headers;
        this.indexes = indexes;
        data = new Vector<>();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArmorViewObject viewObject = data.get(rowIndex);
        switch (indexes[columnIndex]) {
            case 1:
                return viewObject.getArmorID();
            case 2:
                return viewObject.getClassification();
            case 3:
                return viewObject.getDescription();
            case 4:
                return viewObject.getStatus();
            case 5:
                return viewObject.getTimeOfCreate();
            case 6:
                return viewObject.getDefense();
        }
        return null;
    }

    public List<ArmorViewObject> getData() {
        return data;
    }

    public void loadData(List<ArmorViewObject> listViewObject) {
        if (listViewObject == null){
            return;
        }
        for (ArmorViewObject viewObject : listViewObject) {
            this.data.add(viewObject);
        }
    }

    public void addFirst(ArmorViewObject viewObject) {
        this.data.add(0, viewObject);
    }

    public void update(ArmorViewObject newViewObject, int index) {
        ArmorViewObject oldViewObject = this.data.get(index);
        oldViewObject.setClassification(newViewObject.getClassification());
        oldViewObject.setDefense(newViewObject.getDefense());
        oldViewObject.setDescription(newViewObject.getDescription());
        oldViewObject.setStatus(newViewObject.getStatus());
    }

    public void remove(int index) {
        this.data.remove(index);
    }

}
