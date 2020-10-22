/*
 * To change this license headers, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tientt.dtos.EmployeeDTO;
import tientt.mapper.EmployeeViewObjectMapper;
import tientt.viewobjects.EmployeeViewObject;

/**
 *
 * @author natton
 */
public class CustomTableModel extends AbstractTableModel {

    private final EmployeeViewObjectMapper mapper = EmployeeViewObjectMapper.getNewInstance();
    private List<EmployeeViewObject> data = null;
    private String[] headers = null;
    private int[] indexes = null;

    public CustomTableModel(String[] headers, int[] indexes) {
        this.headers = headers;
        this.indexes = indexes;
    }

    @Override
    public int getRowCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EmployeeViewObject viewObject = data.get(rowIndex);
        if (viewObject == null){
            return null;
        }
        switch (indexes[columnIndex]) {
            case 1:
                return viewObject.getEmpID();
            case 2:
                return viewObject.getFullName();
            case 3:
                return viewObject.getPhone();
            case 4:
                return viewObject.getEmail();
            case 5:
                return viewObject.getAddress();
            case 6:
                return viewObject.getDateOfbirth();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    public void loadDataListViewObject(List<EmployeeViewObject> listViewObject) {
        if (listViewObject == null) {
            return;
        }
        for (EmployeeViewObject viewObject : listViewObject) {
            if (data == null) {
                data = new ArrayList<>();
            }
            data.add(viewObject);
        }
    }

    public void loadDataListDTO(List<EmployeeDTO> listDTOs) {
        if (listDTOs == null) {
            return;
        }
        List<EmployeeViewObject> listViewObjects = mapper.toListViewObjects(listDTOs);
        this.loadDataListViewObject(listViewObjects);
    }

    public void addFirst(EmployeeViewObject viewObject) {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.add(0, viewObject);
    }

    public void remove(int index) {
        this.data.remove(index);
        if (data.isEmpty()) {
            data = null;
        }
    }

    public void update(EmployeeViewObject employee) {
        for (EmployeeViewObject viewObject : data) {
            if (viewObject.getEmpID().equals(employee.getEmpID())) {
                viewObject.setAddress(employee.getAddress());
                viewObject.setDateOfbirth(employee.getDateOfbirth());
                viewObject.setEmail(employee.getEmail());
                viewObject.setFullName(employee.getFullName());
                viewObject.setPhone(employee.getPhone());
                break;
            }
        }
    }

    public List<EmployeeViewObject> getData() {
        return data;
    }

    public void resetData() {
        this.data = null;
    }

}
