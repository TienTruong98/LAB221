/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natton
 */
public class ServerLogger {

    private static Logger logger = null;

    private ServerLogger() {
    }

    private static String getTodayDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(new Date());
    }

    private static String getFileName() {
        return "server-log-" + getTodayDate() + ".txt";
    }

    private static void initLogger() {
        try {
            logger = Logger.getLogger(ServerLogger.class.getName());
            LogFormatter formatter = new LogFormatter();
            FileHandler handler = new FileHandler(getFileName(), true);
            handler.setFormatter(formatter);
            logger.addHandler(handler);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(ServerLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized Logger getLogger() {
        if (logger == null) {
            initLogger();
        }
        return logger;
    }
}
