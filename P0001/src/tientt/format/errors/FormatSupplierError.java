/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.errors;

import tientt.view.viewobject.SupplierViewObject;
import tientt.format.validators.interfaces.SupplierFormatValidator;

/**
 *
 * @author natton
 */
public class FormatSupplierError extends FormatError {

    private final SupplierFormatValidator validator;

    public FormatSupplierError(boolean isAddNew) {
        super(isAddNew);
        validator = SupplierFormatValidator.getNewInstance();

    }

    public void checkSupCodeIsNull(String supCode, String message) {
        if (validator.isSupCodeNull(supCode)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkSupCodeLength(String supCode, String message) {
        if (!validator.isSupCodeLengthValidate(supCode)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkSupNameIsNull(String supName, String message) {
        if (validator.isSupNameNull(supName)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkSupNameLength(String supName, String message) {
        if (!validator.isSupNameLengthValidate(supName)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkAddressIsNull(String address, String message) {
        if (validator.isAddressNull(address)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkAddressLength(String address, String message) {
        if (!validator.isAddressLengthValidate(address)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkSupplierValid(SupplierViewObject viewObject) {
        if (isAddNew) {
            //we just need check supCode if user add new
            checkSupCodeIsNull(viewObject.getSupCode(), "Code cannot be null");
            checkSupCodeLength(viewObject.getSupCode(), "Code cannot be longer than 10 characters");
        }
        checkSupNameIsNull(viewObject.getSupName(), "Name cannot be null");
        checkSupNameLength(viewObject.getSupName(), "Name cannot be longer than 50 characters");
        checkAddressIsNull(viewObject.getAddress(), "Address cannot be null");
        checkAddressLength(viewObject.getAddress(), "Address cannot be longer than 50 characters");
    }

}
