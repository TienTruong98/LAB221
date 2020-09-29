/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author natton
 */
public class ArmorDTO implements Serializable {

    private String armorID;
    private String classification;
    private String description;
    private String status;
    private Date timeOfCreate;
    private int defense;

    public ArmorDTO() {
    }

    public ArmorDTO(String armorID, String classification, String description, String status, Date timeOfCreate, int defense) {
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

    public Date getTimeOfCreate() {
        return timeOfCreate;
    }

    public void setTimeOfCreate(Date timeOfCreate) {
        this.timeOfCreate = timeOfCreate;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "ArmorDTO{" + "armorID=" + armorID + ", classification=" + classification + ", description=" + description + ", status=" + status + ", timeOfCreate=" + timeOfCreate + ", defense=" + defense + '}';
    }

    public void copy(ArmorDTO source) {
        this.armorID = source.getArmorID();
        this.classification = source.getClassification();
        this.defense = source.getDefense();
        this.description = source.getDescription();
        this.status = source.getStatus();
        this.timeOfCreate = source.getTimeOfCreate();

    }

}
