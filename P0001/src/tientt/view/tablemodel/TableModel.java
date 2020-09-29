/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.view.tablemodel;

import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author natton
 * @param <E>
 */
public abstract class TableModel<E> extends AbstractTableModel {

    public String[] headers;
    public int[] indexes;
    protected List<E> data;

    public TableModel(String[] headers, int[] indexes) {
        this.headers = headers;
        this.indexes = indexes;
        this.data = new Vector<>();
    }

    public List<E> getData() {
        return data;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    public void loadData(List<E> listE) {
        if (listE == null) {
            return;
        }
        for (E dto : listE) {
            data.add(dto);
        }
    }

    public void delete(int index) {
        this.data.remove(index);
    }

    public void addFirst(E viewObject) {
        this.data.add(0, viewObject);
    }

    public abstract void update(E newViewObject, int index);

}
