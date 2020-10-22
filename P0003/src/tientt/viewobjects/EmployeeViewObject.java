/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.viewobjects;

/**
 *
 * @author natton
 */
public class EmployeeViewObject {
    private String empID;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String dateOfbirth;

    public EmployeeViewObject() {
    }

    public EmployeeViewObject(String empID, String fullName, String phone, String email, String address, String dateOfbirth) {
        this.empID = empID;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfbirth = dateOfbirth;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    @Override
    public String toString() {
        return "EmployeeViewObject{" + "empID=" + empID + ", fullName=" + fullName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", dateOfbirth=" + dateOfbirth + '}';
    }
    
    
    
}
