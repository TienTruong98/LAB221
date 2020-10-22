/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.errors;

import java.util.ArrayList;
import tientt.utlils.Constant;
import tientt.validators.EmployeeValidator;
import tientt.viewobjects.EmployeeViewObject;

/**
 *
 * @author natton
 */
public class EmployeeFormatError extends FormatError {

    private final EmployeeValidator validator = EmployeeValidator.getNewInstance();
    private EmployeeViewObject viewObject;

    public EmployeeFormatError(EmployeeViewObject viewObject, boolean isAddNew) {
        super(isAddNew);
        this.viewObject = viewObject;
        checkEmployeeFormat();
    }

    public EmployeeFormatError(boolean isAddNew) {
        super(isAddNew);
    }
    

    public void checkEmpIDIsNull(String empID, String message) {
        if (validator.isEmpIDNull(empID)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }

    public void checkEmpIDIsValid(String empID, String message) {
        if (!validator.isEmpIDValid(empID)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }

    public void checkEmpIDLength(String empID, String message) {
        if (!validator.isEmpIDLengthValidate(empID)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }

    public void checkFullNameIsNull(String fullName, String message) {
        if (validator.isFullNameNull(fullName)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }

    public void checkFullNameLength(String fullName, String message) {
        if (!validator.isFullNameLengthValidate(fullName)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }

    public void checkAddressLength(String address, String message) {
        if (!validator.isAddressLengthValidate(address)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }

    public void checkDateOfBirth(String dateString, String message) {
        if (!validator.isDateOfBirthValidate(dateString)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }

    public void checkPhoneNumber(String phone, String message) {
        if (!validator.isPhoneValidate(phone)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }

    public void checkEmail(String email, String message) {
        if (!validator.isEmailValidate(email)) {
            hasError = true;
            if (errorMessages == null){
                errorMessages = new ArrayList<>();
            }
            errorMessages.add(message);
        }
    }
    
    private void checkEmployeeFormat(){
        if (isAddNew){
            checkEmpIDIsNull(viewObject.getEmpID(), "ID cannot null");
            checkEmpIDLength(viewObject.getEmpID(), "ID cannot excess 10 characters");
            checkEmpIDIsValid(viewObject.getEmpID(), "ID cannot contain special characters");
        }
        checkAddressLength(viewObject.getAddress(), "Address cannot excess 300 characters");
        checkDateOfBirth(viewObject.getDateOfbirth(), "Date invalid. Birthday cannot be after today. Use "+Constant.DATE_FORMAT);
        checkEmail(viewObject.getEmail(), "Invalid email");
        checkFullNameIsNull(viewObject.getFullName(), "Name cannot null");
        checkFullNameLength(viewObject.getFullName(), "Name cannot excess 30 characters");
        checkPhoneNumber(viewObject.getPhone(), "Invalid phone number");
    }

}
