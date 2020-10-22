/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tientt.daos.EmployeeDAO;
import tientt.dtos.EmployeeDTO;
import tientt.utlils.DBHelpers;

/**
 *
 * @author natton
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public EmployeeDTO getByID(String id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        EmployeeDTO dto = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "SELECT fullName, phone, email, address, dateOfBirth "
                        + "FROM tbl_Employee WHERE empID = ? AND isDelete = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    Date dateOfbirth = rs.getDate("dateOfBirth");
                    dto = new EmployeeDTO(id, fullName, phone, email, address, dateOfbirth);
                }
            }//end if con not null
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dto;
    }

    @Override
    public boolean create(EmployeeDTO t) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tbl_Employee(empID, fullName, phone, email, "
                        + "address, dateOfBirth, isDelete) values(?, ?, ?, ?, ?, ?, 0)";
                stm = con.prepareStatement(sql);
                stm.setString(1, t.getEmpID());
                stm.setString(2, t.getFullName());
                stm.setString(3, t.getPhone());
                stm.setString(4, t.getEmail());
                stm.setString(5, t.getAddress());
                stm.setDate(6, new java.sql.Date(t.getDateOfbirth().getTime()));
                int result = stm.executeUpdate();
                if (result != 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    @Override
    public boolean update(EmployeeDTO t) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "UPDATE tbl_Employee SET fullName = ?, phone = ?, "
                        + "email = ?, address = ?, dateOfBirth = ? "
                        + "WHERE empID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, t.getFullName());
                stm.setString(2, t.getPhone());
                stm.setString(3, t.getEmail());
                stm.setString(4, t.getAddress());
                stm.setDate(5, new java.sql.Date(t.getDateOfbirth().getTime()));
                stm.setString(6, t.getEmpID());
                int result = stm.executeUpdate();
                if (result != 0) {
                    return true;
                }
            }//end if con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    @Override
    public boolean remove(EmployeeDTO t) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "Update tbl_Employee SET isDelete = 1 WHERE empID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, t.getEmpID());
                int result = stm.executeUpdate();
                if (result != 0) {
                    return true;
                }
            }//end if con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    @Override
    public List<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EmployeeDTO> listDTOs = null;
        try{
            con = DBHelpers.getConnection();
            if (con != null){
                String sql = "SELECT empID, fullName, phone, email, address, dateOfBirth "
                        + "FROM tbl_Employee WHERE isDelete = 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                EmployeeDTO dto;
                while (rs.next()){
                    String empID = rs.getString("empID");
                    String fullname = rs.getString("fullName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    Date date = rs.getDate("dateOfBirth");
                    dto = new EmployeeDTO(empID, fullname, phone, email, address, date);
                    
                    if (listDTOs == null){
                        listDTOs = new ArrayList<EmployeeDTO> ();
                    }
                    listDTOs.add(dto);
                }
            }//end if con not null
        }finally{
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return listDTOs;
    }

}
