/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.validators.interfaces;

import tientt.format.validators.implementations.ItemFormatValidatorImpl;

/**
 *
 * @author natton
 */
public interface ItemFormatValidator {

    public boolean isItemCodeNull(String itemCode);

    public boolean isItemCodeLengthValidate(String itemCode);

    public boolean isItemNameNull(String itemName);

    public boolean isItemNameLenghtValidate(String itemName);

    public boolean isUnitNull(String unit);

    public boolean isUnitLengthValidate(String unit);

    public boolean isPriceNull(String priceString);

    public boolean isPriceAPositiveFloat(String priceString);

    public static ItemFormatValidator getNewInstance() {
        return new ItemFormatValidatorImpl();
    }

}
