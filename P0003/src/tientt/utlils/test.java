/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.utlils;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tientt.daos.EmployeeDAO;
import tientt.errors.EmployeeFormatError;
import tientt.validators.EmployeeValidator;
import tientt.viewobjects.EmployeeViewObject;

/**
 *
 * @author natton
 */
public class test {
    public static void main(String[] args) throws ParseException {
        EmployeeViewObject viewObject = new EmployeeViewObject();
        viewObject.setEmpID("@@");
        EmployeeFormatError error = new EmployeeFormatError(true);
        error.checkEmpIDIsValid("abc123", "abc");
        System.out.println(error.isHasError());
        
    }
}
