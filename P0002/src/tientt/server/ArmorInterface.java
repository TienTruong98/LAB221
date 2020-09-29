/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import tientt.dtos.ArmorDTO;

/**
 *
 * @author natton
 */
public interface ArmorInterface extends Remote{
    boolean createArmor(ArmorDTO dto) throws RemoteException;

    ArmorDTO findArmorById(String id) throws RemoteException;

    List<ArmorDTO> findAllArmors() throws RemoteException;

    boolean removeArmor(String id) throws RemoteException;

    boolean updateArmor(ArmorDTO dto) throws RemoteException;
}
