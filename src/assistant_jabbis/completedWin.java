/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assistant_jabbis;
import databaseConnection.databaseConnect;
import java.sql.PreparedStatement;
import com.formdev.flatlaf.FlatDarkLaf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class completedWin extends javax.swing.JFrame {
    private Connection con;

    /**
     * Creates new form completedWin
     */
    public completedWin() {
        initComponents();
        con = databaseConnect.getConnection();
        loadData();
    }
    private void loadData(){
         // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        try {

            Statement st = con.createStatement();
            String query = "SELECT * FROM archive";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                // Retrieve data from the database
                int id = rs.getInt("id");
                String todo = rs.getString("list");
                String subject = rs.getString("subject");
                String dodate = rs.getString("do");
                String deadline = rs.getString("deadline");
                // Add row to the table model
                System.out.println(id + " " + todo + " " + subject + " " + dodate + " " + deadline);
                model.addRow(new Object[]{id, todo, subject, dodate, deadline});

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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

        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        searchComf = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        searchbtncom = new javax.swing.JButton();
        backbtn = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(60, 63, 65));
        jTable1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 255, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "task", "subject", "DateComplete"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 860, 360));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 51));
        jLabel7.setText("Completed Task");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 130, -1));

        searchComf.setBackground(new java.awt.Color(60, 63, 65));
        searchComf.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searchComf.setForeground(new java.awt.Color(0, 255, 0));
        searchComf.setBorder(null);
        searchComf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComfActionPerformed(evt);
            }
        });
        jPanel7.add(searchComf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 280, 40));

        jSeparator9.setForeground(new java.awt.Color(0, 255, 0));
        jPanel7.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 280, 30));

        searchbtncom.setBackground(new java.awt.Color(51, 51, 51));
        searchbtncom.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searchbtncom.setForeground(new java.awt.Color(0, 255, 51));
        searchbtncom.setText("Search");
        searchbtncom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtncomActionPerformed(evt);
            }
        });
        jPanel7.add(searchbtncom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 40));

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
        jPanel7.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel16.setText("czxzxczxcxzc");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchComfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchComfActionPerformed

    private void searchbtncomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtncomActionPerformed
        // TODO add your handling code here:
        // Retrieve the search input
        String userInput = this.searchComf.getText().trim();

        // Clear existing data in the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        try {
            // Establish a database connection
            con = databaseConnect.getConnection();

            // Define a query to search for alarms matching the user input
            String query = "SELECT * FROM Completed_task WHERE task LIKE ? OR subject LIKE ?";
            PreparedStatement prstmt = con.prepareStatement(query);
            prstmt.setString(1, "%" + userInput + "%");
            prstmt.setString(2, "%" + userInput + "%");

            // Execute the query
            ResultSet rs = prstmt.executeQuery();

            // Populate the table with the search results
            while (rs.next()) {
                // Retrieve data from the database
                int id = rs.getInt("id");
                String todo = rs.getString("task");
                String subject = rs.getString("subject");
                String deadline = rs.getString("CompleteDate");
                // Add row to the table model
                model.addRow(new Object[]{id, todo, subject, deadline});

            }
            // Notify user if no records are found
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No matching records found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching records: " + e.getMessage());
        }
    }//GEN-LAST:event_searchbtncomActionPerformed

    private void backbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMouseClicked
        // TODO add your handling code here:
        new MainWindow1().setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(completedWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(completedWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(completedWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(completedWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new completedWin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backbtn;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchComf;
    private javax.swing.JButton searchbtncom;
    // End of variables declaration//GEN-END:variables
}
