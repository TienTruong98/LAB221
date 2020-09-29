/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.error;

import java.util.List;
import java.util.Vector;
import tientt.validators.ArmorValidatior;
import tientt.viewobject.ArmorViewObject;

/**
 *
 * @author natton
 */
public class ArmorError {

    private final ArmorValidatior validatior;

    private final List<String> errorMessages;
    private boolean hasError;
    private final boolean isAddNew;

    public ArmorError(boolean isAddNew) {
        validatior = ArmorValidatior.getNewInstance();
        errorMessages = new Vector<>();
        hasError = false;
        this.isAddNew = isAddNew;
    }

    public void checkArmorIDIsNull(String armorID, String message) {
        if (validatior.isArmorIDNull(armorID)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkArmorIDLength(String armorID, String message) {
        if (!validatior.isArmorIDLengthValid(armorID)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkArmorIDValid(String armorID, String message) {
        if (!validatior.isArmorIDValid(armorID)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkClassificationIsNull(String classification, String message) {
        if (validatior.isClassificationNull(classification)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkClassificationLength(String classification, String message) {
        if (!validatior.isClassificationLengthValid(classification)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkDescriptionIsNull(String description, String message) {
        if (validatior.isDesciptionNull(description)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkDescriptionLengthValid(String desciption, String message) {
        if (!validatior.isDescriptionLengthValid(desciption)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkDefenseIsNull(String defenseString, String message) {
        if (validatior.isDefenseNull(defenseString)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public void checkDefenseValid(String defenseString, String message) {
        if (!validatior.isDefenseAPositiveInt(defenseString)) {
            hasError = true;
            errorMessages.add(message);
        }
    }

    public String getErrorMessages() {
        StringBuilder messages = new StringBuilder();
        for (String message : this.errorMessages) {
            messages.append(message).append("\n");
        }
        return messages.toString();
    }

    public boolean isHasError() {
        return hasError;
    }

    public void checkArmor(ArmorViewObject armor) {

        if (isAddNew) {
            //we just need to check ID if user is adding new armor
            checkArmorIDIsNull(armor.getArmorID(), "Armor ID cannot be null");
            checkArmorIDLength(armor.getArmorID(), "Armor ID cannot be longer than 10 characters");
            checkArmorIDValid(armor.getArmorID(), "Armor ID cannot contain speacial characters");
        }
        checkClassificationIsNull(armor.getClassification(), "Classification cannot be null");
        checkClassificationLength(armor.getClassification(), "Classification cannot be longer than 30 characters");
        checkDescriptionIsNull(armor.getDescription(), "Description cannot be null");
        checkDescriptionLengthValid(armor.getDescription(), "Description cannot be longer than 300 characters");
        checkDefenseIsNull(armor.getDefense(), "Defense cannot be null");
        checkDefenseValid(armor.getDefense(), "Defense must be a positive integer");
    }

}
