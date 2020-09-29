/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.services;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import tientt.dtos.ArmorDTO;
import tientt.exceptions.ArmorExistedException;
import tientt.exceptions.ArmorInvalidException;
import tientt.viewobject.ArmorViewObject;

/**
 *
 * @author natton
 */
public interface ArmorService {

    public boolean insertArmor(ArmorViewObject viewObject) throws RemoteException,
            ArmorInvalidException, ArmorExistedException;

    public boolean updateArmor(ArmorViewObject viewObject) throws RemoteException,
            ArmorInvalidException;

    public boolean deleteArmor(String armorID) throws RemoteException;

    public ArmorDTO findArmorByID(String armorID) throws RemoteException;

    public List<ArmorDTO> findAllArmors() throws RemoteException;

    public ArmorDTO getValidatedArmorDTO(ArmorViewObject viewObject, boolean isAddnew) 
            throws ArmorInvalidException;

    public static ArmorService getNewInstance() throws RemoteException, MalformedURLException,
            NotBoundException {
        return new ArmorServiceImpl();
    }

}
