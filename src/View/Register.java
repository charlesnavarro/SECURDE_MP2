
package View;

import Controller.SQLite;
import Model.User;
import static java.lang.Character.isUpperCase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends javax.swing.JPanel {
public boolean Password_Validation(String s) {
        //to check if it has uppercase
        boolean upper = false;
        for(int i = 0; i < s.length(); i++){
            if(isUpperCase(password.getText().charAt(i))){
                upper = true;
                } 
            }  
        
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
         
         if (symbols && numbers && lower && upper && s.length()>= 8){
            System.out.println("There is a special character, number, lowercase and uppercase in my string & 8 characters long");
            System.out.println(s);
            return true;
         }
         else{
            System.out.println("Invalid password");
            return false;
         }
    }

    public Frame frame;
    public SQLite sqlite;
    String driverURL = "jdbc:sqlite:" + "database.db";
    public Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        confpass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        username.setBackground(new java.awt.Color(240, 240, 240));
        username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        password.setBackground(new java.awt.Color(240, 240, 240));
        password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        password.setMinimumSize(new java.awt.Dimension(12, 46));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        confpass.setBackground(new java.awt.Color(240, 240, 240));
        confpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confpass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        confpass.setMinimumSize(new java.awt.Dimension(12, 45));

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confpass, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user = username.getText();
        String pass = password.getText();
        String cPassword = confpass.getText();
        ArrayList<User> users = frame.main.sqlite.getUsers();
        int ctr = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");  
        Date date = new Date();  

        System.out.println("users array size: " + users.size());
        
        for(int i=0; i<users.size(); i++)
        {
            if(user.contains(" ")){
                jLabel2.setText("You can't have a space for your username");
            }
            //if username is not unique
            if(user.equalsIgnoreCase(users.get(i).getUsername())){
                ctr++;
                jLabel2.setText("User already exists");
            }
            else if(user.equalsIgnoreCase("")){
                //if empty
                jLabel2.setText("Please input username ");
            }
            else    //if unique
                System.out.println("username is: " + users.get(i).getUsername());
        }
        
        System.out.println("ctr: " + ctr);
        if(ctr==0 && pass.equals(cPassword) && (!pass.equals("")) && (!cPassword.equals("")) && (!pass.contains(" ")) && Password_Validation(pass)) 
        {
            System.out.println(pass.length());
            //if username is unique && passwords match && passwords not empty
            String generatedSecuredPasswordHash = Controller.BCrypt.hashpw(pass, Controller.BCrypt.gensalt(12));
            System.out.println(generatedSecuredPasswordHash);
            frame.registerAction(username.getText(), generatedSecuredPasswordHash, confpass.getText());
            frame.loginNav();
            jLabel2.setText("");
            jLabel3.setText("");
            String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + "NOTICE" + "','" + username.getText().toString() + "','" + "User creation successful" + "','" + formatter.format(date) + "')";
        
            try (Connection conn = DriverManager.getConnection(driverURL);
                Statement stmt = conn.createStatement()){
                stmt.execute(sql);
            } catch (Exception ex) {}
        }
        else if (ctr==0 && !pass.equals(cPassword) && (pass.equals("") || cPassword.equals(""))) 
        {
            //if username is unique && passwords DON'T match && either pass or cPassword is blank 
            jLabel3.setText("Passwords do not match AND password field is empty");
        }
        else if(ctr==0 && !pass.equals(cPassword) && (!pass.equals("")) && (!cPassword.equals("")))
        {
            //if username is unique && passwords DON'T match && password fields are NOT empty
            jLabel3.setText("Passwords do not match! Try again.");
        }
        else if(ctr==0 && (pass.equals("") || cPassword.equals("")))
        {
            //if username is unique && passwords match && password fields are BLANK
            jLabel3.setText("Password field is empty.");
        }
        else if(pass.contains(" ") || cPassword.contains(" ")){
            jLabel3.setText("You can't use a space for your password");
        }
        else if(!(Password_Validation(pass))){
            jLabel3.setText("Password should contain special characters, numbers, upper and lowercase letters and be 8 characters long");
        }
        
         
        
        //System.out.println(pass + cPassword);
       username.setText("");
       password.setText("");
       confpass.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       //back button
       frame.loginNav();
       username.setText("");
       password.setText("");
       confpass.setText("");
       jLabel2.setText("");
       jLabel3.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confpass;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
