/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.logger;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natton
 */
public class CustomLogger {

    private static Logger logger = null;

    private CustomLogger() {
    }

    ;

    private static String getDateToday() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        String date = calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.MONTH)
                + "-" + calendar.get(Calendar.YEAR);
        return date;
    }

    private static String getTodayLogFileName() {
        String name = "log-" + getDateToday() + ".txt";
        return name;
    }

    private static void initLogger() {
        try {
            logger = Logger.getLogger(CustomLogger.class.getName());
            FileHandler fileHandler = new FileHandler(getTodayLogFileName(), true);
            fileHandler.setFormatter(new LogFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(CustomLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    synchronized public static Logger getLogger() {
        if (logger == null) {
            initLogger();
        }
        return logger;
    }
    
    

}
