/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.format.errors;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natton
 */
public abstract class FormatError {

    List<String> errorMessages;
    boolean hasError;
    boolean isAddNew;

    public FormatError(boolean isAddNew) {
        this.isAddNew = isAddNew;
        errorMessages = new ArrayList<>();
        hasError = false;
    }

    public boolean isHasError() {
        return hasError;
    }

    public String getErrorMessage() {
        StringBuilder messages = new StringBuilder();
        for (String message : this.errorMessages) {
            messages.append(message).append("\n");
        }
        return messages.toString();
    }
    
}
