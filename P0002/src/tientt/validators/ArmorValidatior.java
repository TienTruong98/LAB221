/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.validators;

/**
 *
 * @author natton
 */
public interface ArmorValidatior {

    public boolean isArmorIDNull(String armorID);

    public boolean isArmorIDLengthValid(String armorID);

    public boolean isArmorIDValid(String armorID);

    public boolean isClassificationNull(String classification);

    public boolean isClassificationLengthValid(String classification);

    public boolean isDesciptionNull(String description);

    public boolean isDescriptionLengthValid(String description);

    public boolean isDefenseNull(String defenseString);

    public boolean isDefenseAPositiveInt(String defenseString);

    
    public static ArmorValidatior getNewInstance() {
        return new ArmorValidatorImpl();
    }
}
