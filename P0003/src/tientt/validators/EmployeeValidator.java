/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.validators;

/**
 *
 * @author natton
 */
public interface EmployeeValidator {

    boolean isEmpIDValid(String empID);

    boolean isEmpIDNull(String empID);

    boolean isEmpIDLengthValidate(String empID);

    boolean isFullNameNull(String fullName);

    boolean isFullNameLengthValidate(String fullName);

    boolean isAddressLengthValidate(String address);

    boolean isDateOfBirthValidate(String dateString);

    boolean isPhoneValidate(String phone);

    boolean isEmailValidate(String email);

    static EmployeeValidator getNewInstance() {
        return new EmployeeValidatorImpl();
    }
}
