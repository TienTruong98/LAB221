/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.daos;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author natton
 */
public interface GenericDAO <T> {
   public T getByID(String id) throws SQLException, ClassNotFoundException;
   public boolean create(T t) throws SQLException, ClassNotFoundException;
   public boolean update(T t) throws SQLException, ClassNotFoundException;
   public boolean remove(T t) throws SQLException, ClassNotFoundException;
   public List<T> getAll() throws SQLException, ClassNotFoundException;
   
   
   
}
