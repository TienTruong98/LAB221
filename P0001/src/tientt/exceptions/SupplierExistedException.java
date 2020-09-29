        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.exceptions;

/**
 *
 * @author natton
 */
public class SupplierExistedException extends Exception {

    public SupplierExistedException() {
    }

    public SupplierExistedException(String message) {
        super(message);
    }

    public SupplierExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SupplierExistedException(Throwable cause) {
        super(cause);
    }

    public SupplierExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
