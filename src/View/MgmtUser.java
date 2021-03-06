/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SQLite;
import Model.User;
import static java.lang.Character.isUpperCase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beepxD
 */
public class MgmtUser extends javax.swing.JPanel {

    public boolean Password_Validation(String s) {
        
         if (s == null || s.trim().isEmpty()) {
             System.out.println("Incorrect format of string");
             return false;
         }
         Pattern p = Pattern.compile("[^A-Za-z0-9]"); //symbols
         Matcher m = p.matcher(s);
         boolean symbols = m.find();      
         
         Pattern p1 = Pattern.compile("[0-9]"); //numbers
         Matcher m1 = p1.matcher(s);
         boolean numbers = m1.find();
         
         Pattern p2 = Pattern.compile("[a-z]"); //lowercase
         Matcher m2 = p2.matcher(s);
         boolean lower = m2.find();
         
         Pattern p3 = Pattern.compile("[A-Z]"); //uppercase
         Matcher m3 = p3.matcher(s);
         boolean upper = m3.find();
         
         if (symbols && numbers && lower && upper && s.length()>= 8 && s.length() <= 32){
            System.out.println("There is a special character, number, lowercase and uppercase in my string & 8 characters long");
            System.out.println(s);
            return true;
         }
         else{
            System.out.println("Invalid password");
            return false;
         }
    }
    
    public SQLite sqlite;
    public DefaultTableModel tableModel;
    public String u;
    
    public MgmtUser(SQLite sqlite) {
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        
//        UNCOMMENT TO DISABLE BUTTONS
//        editBtn.setVisible(false);
//        deleteBtn.setVisible(false);
//        lockBtn.setVisible(false);
//        chgpassBtn.setVisible(false);
    }
    
    public void init(){
        //      CLEAR TABLE
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        
//      LOAD CONTENTS
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            if(users.get(nCtr).getUsername().equals(sqlite.username)){
                u = users.get(nCtr).getUsername();
            }
            switch(sqlite.role){
                    case 2:
                        if(users.get(nCtr).getRole() == 2 && users.get(nCtr).getUsername().equals(sqlite.username)){
                        tableModel.addRow(new Object[]{
                            users.get(nCtr).getUsername(), 
                            users.get(nCtr).getPassword(), 
                            users.get(nCtr).getRole(), 
                            users.get(nCtr).getLocked()});
                        }
                        editRoleBtn.setVisible(false);
                        deleteBtn.setVisible(false);
                        lockBtn.setVisible(false);
                        chgpassBtn.setVisible(true);
                        break;
                    case 3:
                        if(users.get(nCtr).getRole() == 2 || users.get(nCtr).getRole() == 3){
                        tableModel.addRow(new Object[]{
                            users.get(nCtr).getUsername(), 
                            users.get(nCtr).getPassword(), 
                            users.get(nCtr).getRole(), 
                            users.get(nCtr).getLocked()});
                        }
                        editRoleBtn.setVisible(false);
                        deleteBtn.setVisible(false);
                        lockBtn.setVisible(false);
                        chgpassBtn.setVisible(true);
                        break;
                    case 4:
                        if(users.get(nCtr).getRole() == 2 || users.get(nCtr).getRole() == 3 || users.get(nCtr).getRole() == 4 ){
                        tableModel.addRow(new Object[]{
                            users.get(nCtr).getUsername(), 
                            users.get(nCtr).getPassword(), 
                            users.get(nCtr).getRole(), 
                            users.get(nCtr).getLocked()});
                        }
                        editRoleBtn.setVisible(true);
                        deleteBtn.setVisible(true);
                        lockBtn.setVisible(true);
                        chgpassBtn.setVisible(true);
                        break;
                    case 5:
                        tableModel.addRow(new Object[]{
                            users.get(nCtr).getUsername(), 
                            users.get(nCtr).getPassword(), 
                            users.get(nCtr).getRole(), 
                            users.get(nCtr).getLocked()});
                        editRoleBtn.setVisible(true);
                        deleteBtn.setVisible(true);
                        lockBtn.setVisible(true);
                        chgpassBtn.setVisible(true);
                        break;
            }
        }
    }

    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
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
        table = new javax.swing.JTable();
        editRoleBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        lockBtn = new javax.swing.JButton();
        chgpassBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Role", "Locked"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(160);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        editRoleBtn.setBackground(new java.awt.Color(255, 255, 255));
        editRoleBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editRoleBtn.setText("EDIT ROLE");
        editRoleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoleBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        lockBtn.setBackground(new java.awt.Color(255, 255, 255));
        lockBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lockBtn.setText("LOCK/UNLOCK");
        lockBtn.setToolTipText("");
        lockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockBtnActionPerformed(evt);
            }
        });

        chgpassBtn.setBackground(new java.awt.Color(255, 255, 255));
        chgpassBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chgpassBtn.setText("CHANGE PASS");
        chgpassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chgpassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editRoleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lockBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(chgpassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chgpassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editRoleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editRoleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoleBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            String[] options = {"1-DISABLED","2-CLIENT","3-STAFF","4-MANAGER","5-ADMIN"};
            JComboBox optionList = new JComboBox(options);
            
            optionList.setSelectedIndex((int)tableModel.getValueAt(table.getSelectedRow(), 2) - 1);
            
            String result = (String) JOptionPane.showInputDialog(null, "USER: " + tableModel.getValueAt(table.getSelectedRow(), 0), 
                "EDIT USER ROLE", JOptionPane.QUESTION_MESSAGE, null, options, options[(int)tableModel.getValueAt(table.getSelectedRow(), 2) - 1]);
            
            if(result != null){
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                System.out.println(result.charAt(0));
                if(sqlite.role == 4){
                    if(Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) == 2 || Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) == 3){
                        sqlite.editRole(tableModel.getValueAt(table.getSelectedRow(), 0).toString(), result.charAt(0));
                        sqlite.addLogs("NOTICE", sqlite.username, "Successfully changed role of " + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                    }
                }
                else if(sqlite.role == 5){
                    sqlite.editRole(tableModel.getValueAt(table.getSelectedRow(), 0).toString(), result.charAt(0));
                    sqlite.addLogs("NOTICE", sqlite.username, "Successfully changed role of " + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                }
                
//                ErrorBox("Successfully edited role.", "Edit successful");
                init();
            
            }
        }
    }//GEN-LAST:event_editRoleBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                if(sqlite.role == 4){
                    if(Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) == 2 || Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) == 3){
                        sqlite.removeUser(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
                    }
                }
                else if(sqlite.role == 5){
                    sqlite.removeUser(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
                    sqlite.addLogs("NOTICE", sqlite.username, "Successfully deleted " + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                }
                
//                ErrorBox("Successfully deleted.", "Delete successful");
                init();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void lockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockBtnActionPerformed
        int i = 0;
        if(table.getSelectedRow() >= 0){
            String state = "lock";
            if("1".equals(tableModel.getValueAt(table.getSelectedRow(), 3) + "")){
                state = "unlock";
            }
            if(state.equals("unlock")){
                i = 0;
            }
            else if(state.equals("lock")){
                i = 1;
            }
            
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + state + " " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                if(sqlite.role == 3){
                    if(Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) == 2){
                        sqlite.lockUser(tableModel.getValueAt(table.getSelectedRow(), 0).toString(), i);
                        sqlite.addLogs("NOTICE", sqlite.username, "Successfully "+ state + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                    }
                }
                else if(sqlite.role == 4){
                    if(Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) == 2 || Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) == 3){
                        sqlite.lockUser(tableModel.getValueAt(table.getSelectedRow(), 0).toString(), i);
                        sqlite.addLogs("NOTICE", sqlite.username, "Successfully "+ state + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                    }
                }
                else if(sqlite.role == 5){
                    sqlite.lockUser(tableModel.getValueAt(table.getSelectedRow(), 0).toString(), i);
                    sqlite.addLogs("NOTICE", sqlite.username, "Successfully "+ state + "ed " + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                }
                System.out.println(result);
//                ErrorBox("Successfully "+ state+"ed.", "Update successful");
                init();
            }
        }
    }//GEN-LAST:event_lockBtnActionPerformed

    private void chgpassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chgpassBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            JTextField password = new JPasswordField();
            JTextField confpass = new JPasswordField();
            designer(password, "PASSWORD");
            designer(confpass, "CONFIRM PASSWORD");
            
            Object[] message = {
                "Enter New Password:", password, confpass
            };

            int result = JOptionPane.showConfirmDialog(null, message, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
            if (result == JOptionPane.OK_OPTION) {
                System.out.println(password.getText());
                System.out.println(confpass.getText());
                
                    if(password.getText().equals(confpass.getText()) && (!password.getText().equals("")) && (!confpass.getText().equals("")) && (!password.getText().contains(" ")) && Password_Validation(password.getText()) && (sqlite.username.equals(tableModel.getValueAt(table.getSelectedRow(), 0)) || sqlite.role == 4 || sqlite.role == 5)) 
                    {
                        ErrorBox("Password successfully changed!", "Changed password");
                        String generatedSecuredPasswordHash = Controller.BCrypt.hashpw(password.getText(), Controller.BCrypt.gensalt(12));
                        sqlite.changePassword(tableModel.getValueAt(table.getSelectedRow(), 0).toString(), generatedSecuredPasswordHash);
                        sqlite.addLogs("NOTICE", sqlite.username, "Successfully changed password of " + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                        System.out.println(result);
                        init();
                    }
                    else if (!password.getText().equals(confpass.getText()) && (password.getText().equals("") || confpass.getText().equals(""))) 
                    {
                        //if username is unique && passwords DON'T match && either pass or cPassword is blank 
                        sqlite.addLogs("NOTICE", sqlite.username, "Failed password changed of " + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                        sqlite.addEnabledLogs("NOTICE", sqlite.username, "Failed password change", "Empty password field", new Timestamp(new Date().getTime()).toString());
                        ErrorBox("Password field is empty", "Invalid Password");
                    }
                    else if(!password.getText().equals(confpass.getText()) && (!password.getText().equals("")) && (!confpass.getText().equals("")))
                    {
                        //if username is unique && passwords DON'T match && password fields are NOT empty
                        sqlite.addLogs("NOTICE", sqlite.username, "Failed password change of " + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                        sqlite.addEnabledLogs("NOTICE", sqlite.username, "Failed password change", "Passwords do not match", new Timestamp(new Date().getTime()).toString());
                        ErrorBox("Passwords do not match! Try again.", "Invalid Password");
                    }
                    else if((password.getText().equals("") || confpass.getText().equals("")))
                    {
                        //if username is unique && passwords match && password fields are BLANK
                        sqlite.addLogs("NOTICE", sqlite.username, "Failed password change of " + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                        sqlite.addEnabledLogs("NOTICE", sqlite.username, "Failed password change", "Empty password field", new Timestamp(new Date().getTime()).toString());
                        ErrorBox("Password field is empty.", "Invalid Password");
                    }
                    else if(password.getText().contains(" ") || confpass.getText().contains(" ")){
                        sqlite.addLogs("NOTICE", sqlite.username, "Failed password change of " + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                        sqlite.addEnabledLogs("NOTICE", sqlite.username, "Failed password change", "Contains space", new Timestamp(new Date().getTime()).toString());
                        ErrorBox("Cannot contain a space", "Invalid Password");
                    }
                    else if(!(Password_Validation(password.getText()))){
                        sqlite.addLogs("NOTICE", sqlite.username, "Failed password change " + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                        sqlite.addEnabledLogs("NOTICE", sqlite.username, "Failed password change", "Weak password", new Timestamp(new Date().getTime()).toString());
                        ErrorBox("Password should contain special characters, numbers, upper and lowercase letters and be 8-32 characters long", "Invalid Password");
                    }
                    else if(!sqlite.username.equals(tableModel.getValueAt(table.getSelectedRow(), 0))){
                        sqlite.addEnabledLogs("NOTICE", sqlite.username, "Failed password change", "Can only change own password", new Timestamp(new Date().getTime()).toString());
                        sqlite.addLogs("NOTICE", sqlite.username, "Failed password change of " + "" + tableModel.getValueAt(table.getSelectedRow(), 0).toString(),  new Timestamp(new Date().getTime()).toString());
                        
                        ErrorBox("You can only change your own password.", "Error");
                    }
            }
        }
    }//GEN-LAST:event_chgpassBtnActionPerformed

     public static void ErrorBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Error: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chgpassBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editRoleBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lockBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
