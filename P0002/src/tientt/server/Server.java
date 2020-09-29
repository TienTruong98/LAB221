/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import tientt.logger.ServerLogger;

/**
 *
 * @author natton
 */
public class Server {

    private static final Logger LOGGER = ServerLogger.getLogger();

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1098);
            ArmorInterface armorServer = new ArmorServer();
            String name = "rmi://localhost:1098/armor";
            Naming.rebind(name, armorServer);
            System.out.println("Server is running at: " + name);
        } catch (MalformedURLException | RemoteException e) {
            LOGGER.log(Level.SEVERE, Server.class.getName() + "::" + e.getMessage());
        }
    }
}
