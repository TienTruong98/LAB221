/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.validators;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author natton
 */
public class EmployeeValidatorImplTest {

    EmployeeValidatorImpl instance;

    public EmployeeValidatorImplTest() {
        instance = new EmployeeValidatorImpl();
    }

    @Test
    public void testIsEmailValidate() {
        assertEquals(true, instance.isEmailValidate("tien@gmail.com"));
        assertEquals(false, instance.isEmailValidate("tien@gmail"));
        assertEquals(false, instance.isEmailValidate("tiengmail.com"));
        assertEquals(false, instance.isEmailValidate("tien@@gmail.com"));
        assertEquals(false, instance.isEmailValidate("tien@gmail..com"));
        assertEquals(false, instance.isEmailValidate("tien@gmailcom"));
        assertEquals(true, instance.isEmailValidate("tien@g.mail.com"));
        assertEquals(false, instance.isEmailValidate("tien@.mail.com"));
    }

}
