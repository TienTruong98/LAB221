/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.viewobject;

/**
 *
 * @author natton
 */
public class ArmorViewObject {
    private String armorID;
    private String classification;
    private String description;
    private String status;
    private String timeOfCreate;
    private String defense;

    public ArmorViewObject() {
    }

    public ArmorViewObject(String armorID, String classification, String description, String status, String timeOfCreate, String defense) {
        this.armorID = armorID;
        this.classification = classification;
        this.description = description;
        this.status = status;
        this.timeOfCreate = timeOfCreate;
        this.defense = defense;
    }

    public String getArmorID() {
        return armorID;
    }

    public void setArmorID(String armorID) {
        this.armorID = armorID;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeOfCreate() {
        return timeOfCreate;
    }

    public void setTimeOfCreate(String timeOfCreate) {
        this.timeOfCreate = timeOfCreate;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }
    
    
}
