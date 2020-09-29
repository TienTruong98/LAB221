/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.validators;

import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 *
 * @author natton
 */
public class ArmorValidatorImpl implements ArmorValidatior {

    protected ArmorValidatorImpl() {
    }

    @Override
    public boolean isArmorIDNull(String armorID) {
        return armorID.isEmpty();
    }

    @Override
    public boolean isArmorIDLengthValid(String armorID) {
        return armorID.length() <= 10;
    }

    @Override
    public boolean isArmorIDValid(String armorID) {
        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        return !pattern.matcher(armorID).find();
    }

    @Override
    public boolean isClassificationNull(String classification) {
        return classification.isEmpty();

    }

    @Override
    public boolean isClassificationLengthValid(String classification) {
        return classification.length() <= 30;
    }

    @Override
    public boolean isDesciptionNull(String description) {
        return description.isEmpty();
    }

    @Override
    public boolean isDescriptionLengthValid(String description) {
        return description.length() <= 300;
    }

    @Override
    public boolean isDefenseNull(String defenseString) {
        return defenseString.isEmpty();
    }

    @Override
    public boolean isDefenseAPositiveInt(String defenseString) {
        try {
            BigInteger defense = new BigInteger(defenseString);
            BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
            if (defense.compareTo(maxInt) <= 0 && defense.compareTo(BigInteger.ZERO) > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

}
