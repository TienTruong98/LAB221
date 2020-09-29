/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.dtos;

/**
 *
 * @author natton
 */
public class UserDTO {

    private String userID;
    private String fullName;
    private String passsword;
    boolean status;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String passsword, boolean status) {
        this.userID = userID;
        this.fullName = fullName;
        this.passsword = passsword;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", fullName=" + fullName + ", passsword=" + passsword + ", status=" + status + '}';
    }
    
    
    
}
