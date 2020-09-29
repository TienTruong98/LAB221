/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.validators.implementations;

import tientt.format.validators.interfaces.SupplierFormatValidator;

/**
 *
 * @author natton
 */
public class SupplierFormatValidatorImpl implements SupplierFormatValidator {

    public SupplierFormatValidatorImpl() {
    }

    @Override
    public boolean isSupCodeNull(String supCode) {
        return supCode.trim().isEmpty();
    }

    @Override
    public boolean isSupCodeLengthValidate(String supCode) {
        return supCode.trim().length() <= 10;
    }

    @Override
    public boolean isSupNameNull(String supName) {
        return supName.trim().isEmpty();
    }

    @Override
    public boolean isSupNameLengthValidate(String supName) {
        return supName.trim().length() <= 50;
    }

    @Override
    public boolean isAddressNull(String address) {
        return address.trim().isEmpty();
    }

    @Override
    public boolean isAddressLengthValidate(String address) {
        return address.trim().length() <= 50;
    }

}
