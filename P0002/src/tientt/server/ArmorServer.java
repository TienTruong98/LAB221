/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import tientt.dtos.ArmorDTO;
import tientt.logger.ServerLogger;
import tientt.utils.Constant;

/**
 *
 * @author natton
 */
public class ArmorServer extends UnicastRemoteObject implements ArmorInterface {

    private List<ArmorDTO> listArmor = new Vector<>();
    private static final String FILE_NAME = "ArmorData.txt";
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat(Constant.DATE_FORMAT);
    private static final Logger LOGGER = ServerLogger.getLogger();

    public ArmorServer() throws RemoteException {
        super();
        loadData();
    }

    private ArmorDTO parseStringToDTO(String line) throws ParseException {
        String[] elements = line.split(Constant.DATA_DELIMITER);
        String armorID = elements[0];
        String classification = elements[1];
        String description = elements[2];
        String status = elements[3];
        String timeOfCreateString = elements[4];
        String defenseString = elements[5];

        Date timeOfCreate = FORMAT.parse(timeOfCreateString);
        int defense = Integer.parseInt(defenseString);

        ArmorDTO dto = new ArmorDTO(armorID, classification,
                description, status, timeOfCreate, defense);
        return dto;
    }

    private String parseDTOToString(ArmorDTO armorDTO) {
        StringBuilder sb = new StringBuilder();
        sb.append(armorDTO.getArmorID());
        sb.append(Constant.DATA_DELIMITER);
        sb.append(armorDTO.getClassification());
        sb.append(Constant.DATA_DELIMITER);
        sb.append(armorDTO.getDescription());
        sb.append(Constant.DATA_DELIMITER);
        sb.append(armorDTO.getStatus());
        sb.append(Constant.DATA_DELIMITER);
        sb.append(FORMAT.format(armorDTO.getTimeOfCreate()));
        sb.append(Constant.DATA_DELIMITER);
        sb.append(armorDTO.getDefense());
        return sb.toString();
    }

    synchronized private void loadData() {
        File file = null;
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            file = new File(FILE_NAME);
            fr = new FileReader(file);
            bf = new BufferedReader(fr);

            String line;
            while ((line = bf.readLine()) != null) {
                ArmorDTO dto = parseStringToDTO(line);
                listArmor.add(dto);
            }
        } catch (IOException | NumberFormatException | ParseException e) {
            LOGGER.log(Level.SEVERE, ArmorServer.class.getName() + "::" + e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, ArmorServer.class.getName() + "::" + e.getMessage());
            }
        }
    }

    synchronized private void writeData() {
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            file = new File(FILE_NAME);
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (ArmorDTO armorDTO : listArmor) {
                String line = parseDTOToString(armorDTO);
                bw.write(line);
                bw.write("\n");
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, ArmorServer.class.getName() + "::" + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, ArmorServer.class.getName() + "::" + e.getMessage());
            }

        }
    }

    @Override
    public ArmorDTO findArmorById(String id) throws RemoteException {
        if (this.listArmor == null) {
            return null;
        }
        for (ArmorDTO armor : listArmor) {
            if (armor.getArmorID().equals(id)) {
                return armor;
            }
        }
        return null;
    }

    @Override
    public List<ArmorDTO> findAllArmors() throws RemoteException {
        return listArmor;
    }

    @Override
    public boolean removeArmor(String id) throws RemoteException {
        ArmorDTO armor = this.findArmorById(id);
        if (armor != null) {
            listArmor.remove(armor);
            this.writeData();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateArmor(ArmorDTO dto) throws RemoteException {
        ArmorDTO armor = this.findArmorById(dto.getArmorID());
        if (armor != null) {
            armor.copy(dto);
            writeData();
            return true;
        }
        return false;
    }

    @Override
    public boolean createArmor(ArmorDTO dto) throws RemoteException {
        this.listArmor.add(dto);
        this.writeData();
        return true;
    }

}
