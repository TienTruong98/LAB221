/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.errors;

import java.util.List;

/**
 *
 * @author natton
 */
public abstract class FormatError {

    List<String> errorMessages = null;
    boolean hasError = false;
    boolean isAddNew;

    public FormatError(boolean isAddNew) {
        this.isAddNew = isAddNew;
    }

    public boolean isHasError() {
        return hasError;
    }
    
    public String getErrorMessages() {
        if (errorMessages == null) {
            return "";
        }
        StringBuilder messages = new StringBuilder();
        for (String message : this.errorMessages) {
            messages.append(message);
            messages.append("\n");
        }
        return messages.toString();
    }

}
