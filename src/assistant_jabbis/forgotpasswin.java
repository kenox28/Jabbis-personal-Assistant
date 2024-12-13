
package assistant_jabbis;

import com.formdev.flatlaf.FlatDarkLaf;
import databaseConnection.databaseConnect;
import java.sql.Connection;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.swing.SwingUtilities;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class forgotpasswin extends javax.swing.JFrame {
    private Connection con;

    public forgotpasswin() {
        initComponents();
        
        con = databaseConnect.getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        forgotpassbtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username.setBackground(new java.awt.Color(60, 63, 65));
        Username.setFont(new java.awt.Font("Impact", 1, 14)); // NOI18N
        Username.setForeground(new java.awt.Color(51, 255, 51));
        Username.setBorder(null);
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 300, 30));

        jLabel4.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 51));
        jLabel4.setText("Enter you Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 90, -1));

        forgotpassbtn.setBackground(new java.awt.Color(51, 51, 51));
        forgotpassbtn.setFont(new java.awt.Font("Impact", 1, 12)); // NOI18N
        forgotpassbtn.setForeground(new java.awt.Color(51, 255, 51));
        forgotpassbtn.setText("SEND PASSWORD");
        forgotpassbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotpassbtnActionPerformed(evt);
            }
        });
        jPanel1.add(forgotpassbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 190, 40));

        jLabel10.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 255, 51));
        jLabel10.setText("FORGOT PASSWORD");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setText("LOGIN");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 40, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 255, 51));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 40, 20));

        jSeparator5.setForeground(new java.awt.Color(0, 255, 51));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 300, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-forgot-password-30.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 30, -1));

        jLabel11.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 255, 51));
        jLabel11.setText("back to ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void forgotpassbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotpassbtnActionPerformed
            String userEmail = Username.getText(); // Get the email from the text field

            try {
                // Query to check if the email exists in the master_account table
                String query = "SELECT Passw, fname, lname FROM masters_account WHERE email = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, userEmail);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String password = rs.getString("Passw");
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    String subject = "Your Password Recovery";
                    String content = "Dear " + fname + " " + lname + ",<br>Your password is: " + password;

                    // Call the method to send the email
                    sendEmail(userEmail, subject, content);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Email not found.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, 
                    "Database error: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

    }//GEN-LAST:event_forgotpassbtnActionPerformed

    
    private void sendEmail(String recipientEmail, String subject, String content) {
        // Email configuration
        final String username = "iquenxzx@gmail.com";
        final String password = "lews hdga hdvb glym";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);

            // Create HTML content
            String htmlContent = 
                "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                    "<meta charset='utf-8'>" +
                    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                    "<title>" + subject + "</title>" +
                "</head>" +
                "<body>" +
                    "<p>" + content + "</p>" +
                "</body>" +
                "</html>";

            message.setContent(htmlContent, "text/html; charset=utf-8");

            // Send email
            Transport.send(message);
            JOptionPane.showMessageDialog(this, 
                "Email sent successfully to " + recipientEmail, 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(this, 
                "Error sending email: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new loginwindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(forgotpasswin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotpasswin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotpasswin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotpasswin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatDarkLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotpasswin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Username;
    private javax.swing.JButton forgotpassbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
