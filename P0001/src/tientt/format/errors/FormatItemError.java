/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.errors;

import tientt.format.validators.interfaces.ItemFormatValidator;
import tientt.view.viewobject.ItemViewObject;

/**
 *
 * @author natton
 */
public class FormatItemError extends FormatError {

    private final ItemFormatValidator validator;

    public FormatItemError(boolean isAddNew) {
        super(isAddNew);
        validator = ItemFormatValidator.getNewInstance();
    }

    public void checkItemCodeNull(String itemCode, String message) {
        if (validator.isItemCodeNull(itemCode)) {
            hasError = true;
            this.errorMessages.add(message);
        }
    }

    public void checkItemCodeLength(String itemCode, String message) {
        if (!validator.isItemCodeLengthValidate(itemCode)) {
            hasError = true;
            this.errorMessages.add(message);
        }
    }

    public void checkItemNameIsNull(String itemName, String message) {
        if (validator.isItemNameNull(itemName)) {
            hasError = true;
            this.errorMessages.add(message);
        }
    }

    public void checkItemNameLength(String itemName, String message) {
        if (!validator.isItemNameLenghtValidate(itemName)) {
            hasError = true;
            this.errorMessages.add(message);
        }
    }

    public void checkUnitIsNull(String unit, String message) {
        if (validator.isUnitNull(unit)) {
            hasError = true;
            this.errorMessages.add(message);
        }
    }

    public void checkUnitLength(String unit, String message) {
        if (!validator.isUnitLengthValidate(unit)) {
            hasError = true;
            this.errorMessages.add(message);
        }
    }

    public void checkPriceIsNull(String priceString, String message) {
        if (validator.isPriceNull(priceString)) {
            hasError = true;
            this.errorMessages.add(message);
        }
    }
    
    public void checkPriceIsAPositiveFloat(String priceString, String message){
        if (!validator.isPriceAPositiveFloat(priceString)){
            hasError = true;
            this.errorMessages.add(message);
        }
    }

    public void checkItemValid(ItemViewObject item) {
        if (isAddNew) {
            //we only need to check item code when user is adding new item
            this.checkItemCodeNull(item.getItemCode(), "Code cannot be null");
            this.checkItemCodeLength(item.getItemCode(), "Code cannot be longer than 10 charactes");
        }
        this.checkItemNameIsNull(item.getItemName(), "Item name cannot be null");
        this.checkItemNameLength(item.getItemName(), "Item name cannot be longer than 50 characters");
        this.checkUnitIsNull(item.getUnit(), "Unit cannot be null");
        this.checkUnitLength(item.getUnit(), "Unit cannot be longer than 50 characters");
        this.checkPriceIsNull(item.getPrice(), "Price cannot be null");
        this.checkPriceIsAPositiveFloat(item.getPrice(), "Price must be a positive float");
    }

}
