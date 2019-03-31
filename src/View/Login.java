
package View;

import Controller.BCrypt;
import Controller.CSVWriter;
import Controller.SQLite;
import Model.User;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;

public class Login extends javax.swing.JPanel {
    int attempts = 0;
    int delay = 5000;
    public SQLite sqlite;
    public Frame frame;
    public boolean loggedIn = false;   
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");  
    Date date = new Date(); 
    String driverURL = "jdbc:sqlite:" + "database.db";
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("LOGIN");
        jButton2.setMaximumSize(new java.awt.Dimension(157, 37));
        jButton2.setMinimumSize(new java.awt.Dimension(157, 37));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.setBackground(new java.awt.Color(240, 240, 240));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordField1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
        Timer timer = new Timer(delay, new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2.setEnabled(true);
        jButton1.setEnabled(true);
        jTextField1.setEnabled(true);
        jPasswordField1.setEnabled(true);
    }
});
        timer.setRepeats(false);
        String username = jTextField1.getText(); // USERNAME
        String password = jPasswordField1.getText(); //PASSWORD
        String generatedSecuredPasswordHash = Controller.BCrypt.hashpw(password, Controller.BCrypt.gensalt(12)); //HASHING
        CSVWriter csv = new CSVWriter(username, password);
        csv.writeCSV(username, password);
        
        ArrayList<User> users = frame.main.sqlite.getUsers();
        for (int nCtr = 0; nCtr < users.size(); nCtr++) {
            if (username.equals(users.get(nCtr).getUsername())) { //CHECKS USERNAME
                jLabel3.setText("");
                if (BCrypt.checkpw(password, users.get(nCtr).getPassword())) { // PASSWORD HASHED AND ORIG PASSWORD
                    if(users.get(nCtr).getLocked() != 1){
                        if(users.get(nCtr).getRole() != 1){
        //                    System.out.println(password);
        //                    System.out.println(generatedSecuredPasswordHash);
                            loggedIn = true;
                            frame.setCurrUser(users.get(nCtr).getUsername(), users.get(nCtr).getPassword(), users.get(nCtr).getRole());
                            jLabel3.setText("");
                            frame.mainNav();
                            nCtr = users.size() + 1;
                            attempts = 0;
//                            sqlite.addLogs("NOTICE", username, "Successful login", formatter.format(date));
                            String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + "NOTICE" + "','" + username + "','" + "Successful login" + "','" + formatter.format(date) + "')";
        
                            try (Connection conn = DriverManager.getConnection(driverURL);
                                Statement stmt = conn.createStatement()){
                                stmt.execute(sql);
                            } catch (Exception ex) {}
                            }
                        else if(users.get(nCtr).getRole() == 1){
                            nCtr = users.size() +1;
                            jLabel3.setText("Login failed: Your account has been disabled");
//                            sqlite.addLogs("NOTICE", username, "Unsuccessful login", formatter.format(date));
                            String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + "NOTICE" + "','" + username + "','" + "Unsuccessful login" + "','" + formatter.format(date) + "')";
        
                            try (Connection conn = DriverManager.getConnection(driverURL);
                                Statement stmt = conn.createStatement()){
                                stmt.execute(sql);
                            } catch (Exception ex) {}
                        }
                    }
                    else if(users.get(nCtr).getLocked() == 1){
                        nCtr = users.size() +1;
                        jLabel3.setText("Login failed: You have been locked out of your account");
//                        sqlite.addLogs("NOTICE", username, "Unsuccessful login", formatter.format(date));
                        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + "NOTICE" + "','" + username + "','" + "Unsuccessful login" + "','" + formatter.format(date) + "')";
        
                            try (Connection conn = DriverManager.getConnection(driverURL);
                                Statement stmt = conn.createStatement()){
                                stmt.execute(sql);
                            } catch (Exception ex) {}
                    }
                }
                else {
                    jLabel3.setText("Login failed: Invalid username or password");
                    nCtr = users.size() + 1;
                        attempts++;
//                    sqlite.addLogs("NOTICE", username, "Unsuccessful login", formatter.format(date));
                    String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + "NOTICE" + "','" + username + "','" + "Unsuccessful login" + "','" + formatter.format(date) + "')";
        
                            try (Connection conn = DriverManager.getConnection(driverURL);
                                Statement stmt = conn.createStatement()){
                                stmt.execute(sql);
                            } catch (Exception ex) {}
                }
            }
            else if (!username.equals(users.get(nCtr).getUsername())) {
                jLabel3.setText("Login failed: Invalid username or password");
            }
            if(attempts == 5){
                jLabel3.setText("Attempts have already exceeded. You have to wait " + delay/1000 + " seconds");
                delay = delay * 2;
                jButton2.setEnabled(false);
                jButton1.setEnabled(false);
                jTextField1.setEnabled(false);
                jPasswordField1.setEnabled(false);
                timer.start();
                attempts = 0;
            }
        }
        
        jTextField1.setText("");
        jPasswordField1.setText("");
        System.out.println(attempts);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame.registerNav();
        jLabel3.setText("");
        jTextField1.setText("");
        jPasswordField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
