/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import tientt.dtos.ArmorDTO;
import tientt.server.ArmorInterface;
import tientt.server.ArmorServer;

/**
 *
 * @author natton
 */
public class test {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");

    void readLine() {
        try {
            File file = new File("ArmorData.txt");
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeLine() {
        try {
            String[] lines = {"Line 1", "Line 2", "Line 3"};
            File file = new File("ArmorData.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String line : lines) {
                bw.write(line);
                bw.write("\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadData() {
        File file = null;
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            file = new File("ArmorData.txt");
            fr = new FileReader(file);
            bf = new BufferedReader(fr);

            String line;
            while ((line = bf.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "-;-");
                String armorID = tokenizer.nextToken();
                String classification = tokenizer.nextToken();
                String description = tokenizer.nextToken();
                String status = tokenizer.nextToken();
                String timeOfCreateString = tokenizer.nextToken();
                String defenseString = tokenizer.nextToken();

                Date timeOfCreate = FORMAT.parse(timeOfCreateString);
                int defense = Integer.parseInt(defenseString);

                ArmorDTO dto = new ArmorDTO(armorID, classification,
                        description, status, timeOfCreate, defense);
            }

            if (fr != null) {
                fr.close();
            }
            if (bf != null) {
                bf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String a = "SE1-;-heavy-;-1-;--;-10:01:31 28/09/2020-;-1";
        String[] b = a.split("-;-");
        System.out.println(b.length);
    }
}
