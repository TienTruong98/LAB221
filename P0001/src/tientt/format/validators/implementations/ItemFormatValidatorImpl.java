/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.validators.implementations;

import java.math.BigDecimal;
import tientt.format.validators.interfaces.ItemFormatValidator;

/**
 *
 * @author natton
 */
public class ItemFormatValidatorImpl implements ItemFormatValidator {

    public ItemFormatValidatorImpl() {
    }

    @Override
    public boolean isItemCodeNull(String itemCode) {
        return itemCode.trim().isEmpty();
    }

    @Override
    public boolean isItemCodeLengthValidate(String itemCode) {
        return itemCode.trim().length() <= 10;
    }

    @Override
    public boolean isItemNameNull(String itemName) {
        return itemName.trim().isEmpty();

    }

    @Override
    public boolean isItemNameLenghtValidate(String itemName) {
        return itemName.trim().length() <= 50;
    }

    @Override
    public boolean isUnitNull(String unit) {
        return unit.trim().isEmpty();
    }

    @Override
    public boolean isUnitLengthValidate(String unit) {
        return unit.trim().length() <= 50;
    }

    @Override
    public boolean isPriceNull(String priceString) {
        return priceString.trim().isEmpty();
    }

    @Override
    public boolean isPriceAPositiveFloat(String priceString) {
        try {
            BigDecimal floatMax = BigDecimal.valueOf(Float.MAX_VALUE);
            BigDecimal price = new BigDecimal(priceString);
            if (price.compareTo(floatMax) <= 0 && price.compareTo(BigDecimal.ZERO) > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

}
