/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author natton
 */
public class LogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getLevel() + "::" + new Date(record.getMillis()) + "::" + record.getMessage() + "\n";
    }

}
