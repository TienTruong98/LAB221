/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import tientt.utlils.Constant;

/**
 *
 * @author natton
 */
public class EmployeeValidatorImpl implements EmployeeValidator {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(Constant.DATE_FORMAT);

    static {
        FORMATTER.setLenient(false);
    }

    @Override
    public boolean isEmpIDValid(String empID) {
        Pattern pattern = Pattern.compile("\\W+");
        boolean result = pattern.matcher(empID).find();
        return !result;
    }

    @Override
    public boolean isEmpIDNull(String empID) {
        return empID.trim().isEmpty();
    }

    @Override
    public boolean isEmpIDLengthValidate(String empID) {
        return empID.trim().length() <= 10;
    }

    @Override
    public boolean isFullNameNull(String fullName) {
        return fullName.trim().isEmpty();
    }

    @Override
    public boolean isFullNameLengthValidate(String fullName) {
        return fullName.trim().length() <= 30;
    }

    @Override
    public boolean isAddressLengthValidate(String address) {
        return address.trim().length() <= 300;
    }

    @Override
    public boolean isDateOfBirthValidate(String dateString) {
        try {
            Date date = FORMATTER.parse(dateString);
            Date today = new Date();
            if (date.getTime() > today.getTime()) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isPhoneValidate(String phone) {
        Pattern pattern = Pattern.compile("^\\d{1,15}$");
        return pattern.matcher(phone).matches();
    }

    @Override
    public boolean isEmailValidate(String email) {
        Pattern pattern = Pattern.compile("[\\w]+@[\\w]+[.][\\w]+");
        boolean result = pattern.matcher(email).find();
        return result;
    }
    
    

}
