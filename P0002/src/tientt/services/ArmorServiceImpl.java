package tientt.services;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import tientt.dtos.ArmorDTO;
import tientt.error.ArmorError;
import tientt.exceptions.ArmorExistedException;
import tientt.exceptions.ArmorInvalidException;
import tientt.mappers.ArmorViewObjectMapper;
import tientt.server.ArmorInterface;
import tientt.viewobject.ArmorViewObject;

/**
 *
 * @author natton
 */
public class ArmorServiceImpl implements ArmorService {

    private final ArmorInterface armorServer;
    private final ArmorViewObjectMapper mapper;

    protected ArmorServiceImpl() throws NotBoundException, MalformedURLException, RemoteException {
        armorServer = (ArmorInterface) Naming.lookup("rmi://localhost:1098/armor");
        mapper = ArmorViewObjectMapper.getNewInstance();
    }

    @Override
    public ArmorDTO getValidatedArmorDTO(ArmorViewObject viewObject, boolean isAddNew) throws ArmorInvalidException {
        ArmorError error = new ArmorError(isAddNew);
        error.checkArmor(viewObject);
        if (error.isHasError()) {
            throw new ArmorInvalidException(error.getErrorMessages());
        }//end if dont have any error
        ArmorDTO armorDTO = mapper.toDTO(viewObject);
        return armorDTO;
    }

    @Override
    public boolean insertArmor(ArmorViewObject viewObject) throws RemoteException,
            ArmorInvalidException, ArmorExistedException {
        boolean isAddNew = true;
        ArmorDTO armorDTO = this.getValidatedArmorDTO(viewObject, isAddNew);
        //at this point armorDTO is validated
        ArmorDTO existedArmor = this.armorServer.findArmorById(armorDTO.getArmorID());
        if (existedArmor != null) {
            throw new ArmorExistedException();
        }//end if existedArmor not null
        return this.armorServer.createArmor(armorDTO);
    }

    @Override
    public boolean updateArmor(ArmorViewObject viewObject) throws RemoteException,
            ArmorInvalidException {
        boolean isAddNew = false;
        ArmorDTO armorDTO = this.getValidatedArmorDTO(viewObject, isAddNew);
        //at this point armorDTO is validated
        return this.armorServer.updateArmor(armorDTO);
    }

    @Override
    public boolean deleteArmor(String armorID) throws RemoteException {
        return this.armorServer.removeArmor(armorID);
    }

    @Override
    public ArmorDTO findArmorByID(String armorID) throws RemoteException {
        return this.armorServer.findArmorById(armorID);
    }

    @Override
    public List<ArmorDTO> findAllArmors() throws RemoteException {
        return this.armorServer.findAllArmors();
    }

}
