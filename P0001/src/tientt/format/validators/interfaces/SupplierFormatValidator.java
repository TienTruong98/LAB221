/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.validators.interfaces;

import tientt.format.validators.implementations.SupplierFormatValidatorImpl;

/**
 *
 * @author natton
 */
public interface SupplierFormatValidator {

    public boolean isSupCodeNull(String supCode);

    public boolean isSupCodeLengthValidate(String supCode);

    public boolean isSupNameNull(String supName);

    public boolean isSupNameLengthValidate(String supName);

    public boolean isAddressNull(String address);

    public boolean isAddressLengthValidate(String address);

    public static SupplierFormatValidator getNewInstance() {
        return new SupplierFormatValidatorImpl();
    }

}
