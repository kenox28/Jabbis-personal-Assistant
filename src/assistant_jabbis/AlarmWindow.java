/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assistant_jabbis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.formdev.flatlaf.FlatDarkLaf;
import databaseConnection.databaseConnect;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class AlarmWindow extends javax.swing.JFrame implements Runnable {
    private int userId;
    private String Fname;
    private String lname;
    private String usernameSession;
    private String alarmTime;
    private Connection con;

    public AlarmWindow(int userid, String fname, String lname, String username) {
        initComponents();
        this.userId = userid;
        this.Fname = fname;
        this.lname = lname;
        this.usernameSession = username;
        loadData();

        Thread t = new Thread(this);
        t.start();
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        backbtn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        minutes = new javax.swing.JComboBox<>();
        hours = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        AddAlarm = new javax.swing.JButton();
        alarmf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        SetAlarm = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        Userinput = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backbtn.setBackground(new java.awt.Color(51, 51, 51));
        backbtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        backbtn.setForeground(new java.awt.Color(0, 255, 0));
        backbtn.setText("BACK");
        backbtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbtnMouseClicked(evt);
            }
        });
        jPanel2.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 51));
        jLabel4.setText(" ALARMS");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 11, -1, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 1040, 70));

        jTable1.setBackground(new java.awt.Color(60, 63, 65));
        jTable1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 255, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "USERID", "ALARMNAME", "HOURS", "MINUTES"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 620, 300));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("time");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, java.awt.Color.white));
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 284, 60));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 51));
        jLabel2.setText("Alarm name");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 70, -1));

        minutes.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        minutes.setForeground(new java.awt.Color(0, 255, 51));
        minutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));
        minutes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minutesActionPerformed(evt);
            }
        });
        jPanel3.add(minutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 130, 40));

        hours.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        hours.setForeground(new java.awt.Color(51, 255, 51));
        hours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", " " }));
        jPanel3.add(hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 132, 40));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 51));
        jLabel1.setText("Hours");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 47, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 20));

        AddAlarm.setBackground(new java.awt.Color(51, 51, 51));
        AddAlarm.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        AddAlarm.setForeground(new java.awt.Color(0, 255, 51));
        AddAlarm.setText("Add Alarm");
        AddAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAlarmActionPerformed(evt);
            }
        });
        jPanel3.add(AddAlarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 220, 40));
        jPanel3.add(alarmf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 280, 40));

        jLabel6.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 51));
        jLabel6.setText("minutes");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 47, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 330, 440));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 1040, 40));

        SetAlarm.setBackground(new java.awt.Color(51, 51, 51));
        SetAlarm.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        SetAlarm.setForeground(new java.awt.Color(0, 255, 51));
        SetAlarm.setText("Set Alarm");
        SetAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetAlarmActionPerformed(evt);
            }
        });
        jPanel1.add(SetAlarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 140, 30));

        searchbtn.setBackground(new java.awt.Color(51, 51, 51));
        searchbtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searchbtn.setForeground(new java.awt.Color(0, 255, 51));
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 90, 40));

        Userinput.setBackground(new java.awt.Color(60, 63, 65));
        Userinput.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        Userinput.setForeground(new java.awt.Color(0, 255, 0));
        Userinput.setBorder(null);
        Userinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserinputActionPerformed(evt);
            }
        });
        jPanel1.add(Userinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 283, 40));

        jSeparator6.setForeground(new java.awt.Color(0, 255, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 280, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 700, 410));

        jSeparator7.setForeground(new java.awt.Color(0, 255, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 280, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 255, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 280, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAlarmActionPerformed
        // TODO add your handling code here:
        String aname = alarmf.getText();
        int h = Integer.parseInt(this.hours.getSelectedItem().toString());
        int m = Integer.parseInt(this.minutes.getSelectedItem().toString());
        if(aname.equals("")){
            JOptionPane.showMessageDialog(this,"pLEASE ENTER ALL FEILD");
        }else{
            try {
                // Connect to the database
                con = databaseConnect.getConnection();
                
                // Insert the selected time into the database
                String insertQuery = "INSERT INTO alarms (userid ,alarmname, hours, minutes) VALUES (?, ?, ?, ?)";   
                PreparedStatement pst = con.prepareStatement(insertQuery);
                pst.setInt(1, userId);
                pst.setString(2, aname);
                pst.setInt(3, h);
                pst.setInt(4, m);
                pst.executeUpdate();
                loadData();


            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving alarm: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_AddAlarmActionPerformed

    private void minutesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minutesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minutesActionPerformed
    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        try {
            con = databaseConnect.getConnection();
            
            String query1 = "SELECT * FROM setjabbis";
            PreparedStatement prstmt1 = con.prepareStatement(query1);
            ResultSet rs1 = prstmt1.executeQuery();
            rs1.next();
            int userid1 = rs1.getInt("userid");

            String query = "SELECT * FROM alarms WHERE userid = ?";
            

            PreparedStatement prstmt = con.prepareStatement(query);
            prstmt.setInt(1,userid1);
            ResultSet rs = prstmt.executeQuery();

            while (rs.next()) {
                // Retrieve data from the database
                int id = rs.getInt("id");
                int userid = rs.getInt("userid");

                String aname = rs.getString("alarmname");
                String hours = rs.getString("hours");
                String minutes = rs.getString("minutes");
                // Add row to the table model
                model.addRow(new Object[]{id,userid,aname, hours, minutes});
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void SetAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetAlarmActionPerformed
        // TODO add your handling code here:
        int selected = jTable1.getSelectedRow();
        if (selected != 0) {
            try {
                int id = Integer.parseInt(jTable1.getValueAt(selected, 0).toString());
                String query = "SELECT * FROM alarms WHERE id = ?";
                PreparedStatement prstmt = con.prepareStatement(query);
                prstmt.setInt(1, id);

                ResultSet rs = prstmt.executeQuery();
                if (rs.next()) {
                    int alarmHours = rs.getInt("hours");
                    int alarmMinutes = rs.getInt("minutes");
                    
                    System.out.println(alarmHours + " " + alarmMinutes);
                    alarmTime = String.format("%02d:%02d", alarmHours, alarmMinutes);
                }

            } catch (Exception e) {

            }
        } else {
            JOptionPane.showMessageDialog(this, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_SetAlarmActionPerformed

    private void UserinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserinputActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        // TODO add your handling code here:
            // Retrieve the search input
        String userInput = Userinput.getText().trim();

        // Clear existing data in the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 

        try {
            // Establish a database connection
            con = databaseConnect.getConnection();

            // Define a query to search for alarms matching the user input
            String query = "SELECT * FROM alarms WHERE alarmname LIKE ? or hours LIKE ? OR minutes LIKE ?";
            PreparedStatement prstmt = con.prepareStatement(query);
            prstmt.setString(1, "%" + userInput + "%");
            prstmt.setString(2, "%" + userInput + "%");
            prstmt.setString(3, "%" + userInput + "%");


            // Execute the query
            ResultSet rs = prstmt.executeQuery();

            // Populate the table with the search results
            while (rs.next()) {
                int id = rs.getInt("id");
                String alarmname =rs.getString("alarmname");
                String hours = rs.getString("hours");
                String minutes = rs.getString("minutes");
                model.addRow(new Object[]{id,alarmname ,hours, minutes});
            }

            // Notify user if no records are found
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No matching records found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching records: " + e.getMessage());
        }
    }//GEN-LAST:event_searchbtnActionPerformed

    private void backbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMouseClicked
        // TODO add your handling code here:
        try {
            // Query to get user information
            String query = "SELECT * FROM masters_account WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Get user details from database
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                String email = rs.getString("email");  // or username column name

                // Create new MainWindow1 with user details
                new MainWindow1(firstName, lastName, email, userId).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User information not found!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_backbtnMouseClicked

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
            java.util.logging.Logger.getLogger(AlarmWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlarmWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlarmWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlarmWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new AlarmWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAlarm;
    private javax.swing.JButton SetAlarm;
    private javax.swing.JTextField Userinput;
    private javax.swing.JTextField alarmf;
    private javax.swing.JLabel backbtn;
    private javax.swing.JComboBox<String> hours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> minutes;
    private javax.swing.JButton searchbtn;
    // End of variables declaration//GEN-END:variables

    public void run() {
        while (true) {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat fullTimeFormat = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat alarmFormat = new SimpleDateFormat("HH:mm");
            Date date = c.getTime();

            // Update the time label
            jLabel3.setText(fullTimeFormat.format(date));

            // Check alarm
            String currentTime = alarmFormat.format(date);
            System.out.println("Current time: " + currentTime + ", Alarm time: " + alarmTime); // Debug

            if (alarmTime != null && currentTime.equals(alarmTime)) {
                // Execute the Python script
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder(
                        "C:\\Users\\USER\\AppData\\Local\\Programs\\Python\\Python311\\python.exe",
                        "C:\\Users\\USER\\PycharmProjects\\pythonProject21\\SayTodo.py"
                    );

                    processBuilder.directory(new File("C:\\Users\\USER\\PycharmProjects\\pythonProject21"));

                    // Start the process
                    Process process = processBuilder.start();

                    // Read the output from the Python script
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    StringBuilder output = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        output.append(line).append("\n");
                    }

                    // Wait for the process to complete and get exit code
                    int exitCode = process.waitFor();
                    System.out.println("Python script exited with code: " + exitCode);
                    System.out.println("Python script output:\n" + output.toString());

                    // Clean up resources
                    reader.close();
                    process.destroy();

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    System.err.println("Error executing Python script: " + e.getMessage());
                }

                // Show option dialog for user choice
                Object[] options = {"Stop", "Delete Alarm"};
                int choice = JOptionPane.showOptionDialog(
                        null,
                        "Alarm Triggered! Choose an action:",
                        "Alarm Options",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if (choice == 0) { // Stop
                    JOptionPane.showMessageDialog(null, "Alarm stopped.");
                    alarmTime = null; // Reset alarm
                } else if (choice == 1) { // Delete Alarm
                    try {
                        con = databaseConnect.getConnection();
                        String deleteQuery = "DELETE FROM alarms WHERE id = (SELECT id FROM alarms ORDER BY id ASC LIMIT 1)";
                        PreparedStatement deletePst = con.prepareStatement(deleteQuery);
                        int rowsDeleted = deletePst.executeUpdate();

                        if (rowsDeleted > 0) {
                            JOptionPane.showMessageDialog(null, "Alarm deleted from the database.");
                            System.out.println("Alarm entry deleted from the database.");
                        }

                        deletePst.close();
                        con.close(); // Close the database connection

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error deleting alarm: " + e.getMessage());
                    }
                    alarmTime = null; // Reset alarm after deletion
                }
            }

            try {
                Thread.sleep(1000); // Sleep for 1 second before next check
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
