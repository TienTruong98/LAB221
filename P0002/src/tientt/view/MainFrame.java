/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.view;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tientt.dtos.ArmorDTO;
import tientt.exceptions.ArmorExistedException;
import tientt.exceptions.ArmorInvalidException;
import tientt.logger.ClientLogger;
import tientt.mappers.ArmorViewObjectMapper;
import tientt.services.ArmorService;
import tientt.tablemodel.ArmorTableModel;
import tientt.utils.Constant;
import tientt.viewobject.ArmorViewObject;

/**
 *
 * @author natton
 */
public class MainFrame extends javax.swing.JFrame {
    
    private final String[] HEADERS = {"ID", "Classification", "TimeOfCreate", "Defense"};
    private final int[] INDEXES = {1, 2, 5, 6};
    private ArmorTableModel armorTableModel;
    private ArmorService armorService;
    private final ArmorViewObjectMapper mapper;
    private boolean isAddNew = true;
    private SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
    private static final Logger LOGGER = ClientLogger.getLogger();
    
    public MainFrame() {
        initComponents();
        mapper = ArmorViewObjectMapper.getNewInstance();
        try {
            armorService = ArmorService.getNewInstance();
        } catch (RemoteException | MalformedURLException | NotBoundException ex) {
            LOGGER.log(Level.SEVERE, MainFrame.class.getName() + "::" + ex.getMessage());
            displayMessage("Server does not response. App will shutdown");
            System.exit(0);
        }
        initTable();
    }
    
    private void initTable() {
        
        armorTableModel = new ArmorTableModel(HEADERS, INDEXES);
        tblArmor.setModel(armorTableModel);
        loadData();
        tblArmor.updateUI();
    }
    
    private void loadData() {
        try {
            List<ArmorDTO> listArmorDTO = armorService.findAllArmors();
            List<ArmorViewObject> listViewObject = mapper.toListViewObject(listArmorDTO);
            armorTableModel.loadData(listViewObject);
        } catch (RemoteException ex) {
            LOGGER.log(Level.SEVERE, MainFrame.class.getName() + "::" + ex.getMessage());
            displayMessage("Server does not response. App will shutdown");
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblArmor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtArmorID = new javax.swing.JTextField();
        txtClassification = new javax.swing.JTextField();
        txtTimeOfCreate = new javax.swing.JTextField();
        txtDefense = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblArmor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArmorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArmor);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Armor's Details"));

        jLabel1.setText("ArmorID");

        jLabel2.setText("Classification");

        jLabel3.setText("TimeOfCreate");

        jLabel4.setText("Defense");

        jLabel5.setText("Description");

        jLabel6.setText("Status");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        btnCreate.setText("Create");
        btnCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateMouseClicked(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });

        btnFind.setText("Find By ArmorID");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTimeOfCreate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                        .addComponent(txtClassification, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtArmorID, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDefense)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFind)
                            .addComponent(btnReset)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCreate)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtArmorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTimeOfCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindActionPerformed

    private void tblArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArmorMouseClicked
        int selectedRow = tblArmor.getSelectedRow();
        ArmorViewObject viewObject = armorTableModel.getData().get(selectedRow);
        
        txtArmorID.setText(viewObject.getArmorID());
        txtClassification.setText(viewObject.getClassification());
        txtTimeOfCreate.setText(viewObject.getTimeOfCreate());
        txtDefense.setText(String.valueOf(viewObject.getDefense()));
        txtDescription.setText(viewObject.getDescription());
        txtStatus.setText(viewObject.getStatus());
        
        txtArmorID.setEnabled(false);
        txtTimeOfCreate.setEnabled(false);
        isAddNew = false;

    }//GEN-LAST:event_tblArmorMouseClicked
    
    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    private ArmorViewObject getNewArmorInfo() {
        ArmorViewObject viewObject = new ArmorViewObject();
        viewObject.setArmorID(txtArmorID.getText());
        viewObject.setClassification(txtClassification.getText());
        viewObject.setDefense(txtDefense.getText());
        viewObject.setDescription(txtDescription.getText());
        viewObject.setStatus(txtStatus.getText());
        viewObject.setTimeOfCreate(txtTimeOfCreate.getText());
        return viewObject;
    }
    private void btnCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateMouseClicked
        try {
            if (!isAddNew) {
                btnResetMouseClicked(null);
                return;
            }//end if reset detail field
            Date now = new Date();
            ArmorViewObject viewObject = getNewArmorInfo();
            viewObject.setTimeOfCreate(dateFormat.format(now));
            //call model
            boolean result = armorService.insertArmor(viewObject);
            if (result) {
                armorTableModel.addFirst(viewObject);
                //update view
                tblArmor.changeSelection(0, 0, false, false);
                tblArmor.updateUI();
                isAddNew = false;
                txtTimeOfCreate.setText(viewObject.getTimeOfCreate());
                txtTimeOfCreate.setEnabled(false);
                txtArmorID.setEnabled(false);
                //show success message
                displayMessage("Add successfully");
            }
            
        } catch (RemoteException ex) {
            LOGGER.log(Level.SEVERE, MainFrame.class.getName() + "::" + ex.getMessage());
            displayMessage("Server does not response. App will shutdown");
            System.exit(0);
        } catch (ArmorInvalidException ex) {
            displayMessage(ex.getMessage());
        } catch (ArmorExistedException ex) {
            displayMessage("Armor already exists");
        }
    }//GEN-LAST:event_btnCreateMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        txtArmorID.setText("");
        txtClassification.setText("");
        txtDefense.setText("");
        txtDescription.setText("");
        txtStatus.setText("");
        txtTimeOfCreate.setText("");
        tblArmor.getSelectionModel().clearSelection();
        txtArmorID.setEnabled(true);
        txtTimeOfCreate.setEnabled(true);
        isAddNew = true;
        tblArmor.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        if (isAddNew) {
            displayMessage("Please select an armor");
            return;
        }
        ArmorViewObject viewObject = getNewArmorInfo();
        try {
            int selectedRow = tblArmor.getSelectedRow();
            //call model
            boolean result = armorService.updateArmor(viewObject);
            if (result) {
                armorTableModel.update(viewObject, selectedRow);
                //update view
                tblArmor.updateUI();
                ////show success message
                displayMessage("Save successfully");
            }
            
        } catch (RemoteException ex) {
            LOGGER.log(Level.SEVERE, MainFrame.class.getName() + "::" + ex.getMessage());
            displayMessage("Server does not response. App will shutdown");
            System.exit(0);
        } catch (ArmorInvalidException ex) {
            displayMessage(ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        if (isAddNew) {
            displayMessage("Please select an armor");
            return;
        }
        int selectedRow = tblArmor.getSelectedRow();
        String armorID = txtArmorID.getText();
        try {
            //call model
            boolean result = armorService.deleteArmor(armorID);
            if (result) {
                armorTableModel.remove(selectedRow);
                //update view
                btnResetMouseClicked(null);
                tblArmor.updateUI();
            }
        } catch (RemoteException ex) {
            LOGGER.log(Level.SEVERE, MainFrame.class.getName() + "::" + ex.getMessage());
            displayMessage("Server does not response. App will shutdown");
            System.exit(0);
        }
    }//GEN-LAST:event_btnRemoveMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblArmor;
    private javax.swing.JTextField txtArmorID;
    private javax.swing.JTextField txtClassification;
    private javax.swing.JTextField txtDefense;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTimeOfCreate;
    // End of variables declaration//GEN-END:variables
}
