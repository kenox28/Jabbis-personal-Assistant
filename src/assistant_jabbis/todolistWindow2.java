/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assistant_jabbis;
import databaseConnection.databaseConnect;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
/**
 *
 * @author USER
 */
public class todolistWindow2 extends javax.swing.JFrame {
;
    /**
     * Creates new form todolistWindow
     */
    private Connection con;
    public todolistWindow2() {

        initComponents();
        con = databaseConnect.getConnection();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Subject = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Userinput = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        searchbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JTextArea();
        DeleteBtn = new javax.swing.JButton();
        doDate = new com.toedter.calendar.JDateChooser();
        DeadlineDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SystemAnalysisBtn = new javax.swing.JRadioButton();
        ccnaBtn = new javax.swing.JRadioButton();
        EventDBtn = new javax.swing.JRadioButton();
        advanceDbBtn = new javax.swing.JRadioButton();
        SystemIntegBtn = new javax.swing.JRadioButton();
        webBtn = new javax.swing.JRadioButton();
        SpiBtn = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CreatelistBtn = new javax.swing.JButton();
        Updatebtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 51));
        jLabel2.setText("ADD TASK");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/favicon3.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, 52, 60));

        jLabel7.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 51));
        jLabel7.setText("Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(998, 26, -1, -1));

        Userinput.setBackground(new java.awt.Color(60, 63, 65));
        Userinput.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        Userinput.setForeground(new java.awt.Color(0, 255, 0));
        Userinput.setBorder(null);
        Userinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserinputActionPerformed(evt);
            }
        });
        jPanel2.add(Userinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 283, 40));

        jSeparator6.setForeground(new java.awt.Color(0, 255, 0));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 280, 30));

        searchbtn.setBackground(new java.awt.Color(51, 51, 51));
        searchbtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searchbtn.setForeground(new java.awt.Color(0, 255, 51));
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jPanel2.add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 90, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 1080, 20));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list.setBackground(new java.awt.Color(60, 63, 65));
        list.setColumns(20);
        list.setRows(5);
        jScrollPane1.setViewportView(list);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 110));

        DeleteBtn.setBackground(new java.awt.Color(51, 51, 51));
        DeleteBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(51, 255, 51));
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        jPanel4.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, 250, 34));

        doDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        doDate.setForeground(new java.awt.Color(51, 255, 51));
        jPanel4.add(doDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 240, -1));

        DeadlineDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DeadlineDate.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(DeadlineDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 240, -1));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("Deadline On:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 80, 30));

        jLabel3.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 51));
        jLabel3.setText("Do this On:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 70, 30));

        Subject.add(SystemAnalysisBtn);
        SystemAnalysisBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        SystemAnalysisBtn.setForeground(new java.awt.Color(51, 255, 51));
        SystemAnalysisBtn.setText("System analysis and design");
        jPanel4.add(SystemAnalysisBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        Subject.add(ccnaBtn);
        ccnaBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        ccnaBtn.setForeground(new java.awt.Color(51, 255, 51));
        ccnaBtn.setText("CCNA");
        jPanel4.add(ccnaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        Subject.add(EventDBtn);
        EventDBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        EventDBtn.setForeground(new java.awt.Color(51, 255, 51));
        EventDBtn.setText("EVENT DRIVEN PROGRAMMING");
        jPanel4.add(EventDBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        Subject.add(advanceDbBtn);
        advanceDbBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        advanceDbBtn.setForeground(new java.awt.Color(51, 255, 51));
        advanceDbBtn.setText("Advance database");
        jPanel4.add(advanceDbBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        Subject.add(SystemIntegBtn);
        SystemIntegBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        SystemIntegBtn.setForeground(new java.awt.Color(51, 255, 51));
        SystemIntegBtn.setText("System integration ");
        jPanel4.add(SystemIntegBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        Subject.add(webBtn);
        webBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        webBtn.setForeground(new java.awt.Color(51, 255, 51));
        webBtn.setText("Web 2");
        jPanel4.add(webBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        Subject.add(SpiBtn);
        SpiBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        SpiBtn.setForeground(new java.awt.Color(51, 255, 51));
        SpiBtn.setText("Social and profesion issue");
        jPanel4.add(SpiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        jTable1.setBackground(new java.awt.Color(60, 63, 65));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "TASK", "SUBJECT", "DO", "DEADLINE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 650, 340));

        CreatelistBtn.setBackground(new java.awt.Color(51, 51, 51));
        CreatelistBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        CreatelistBtn.setForeground(new java.awt.Color(51, 255, 51));
        CreatelistBtn.setText("Save");
        CreatelistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatelistBtnActionPerformed(evt);
            }
        });
        jPanel4.add(CreatelistBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 350, 34));

        Updatebtn.setBackground(new java.awt.Color(51, 51, 51));
        Updatebtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        Updatebtn.setForeground(new java.awt.Color(51, 255, 51));
        Updatebtn.setText("Update");
        Updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebtnActionPerformed(evt);
            }
        });
        jPanel4.add(Updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 230, 34));

        jLabel5.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 51));
        jLabel5.setText("Add your Task list here");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel16.setText("czxzxczxcxzc");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 510));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1080, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        try {
            // Query to get the user ID from the setjabbis table
            String query1 = "SELECT * FROM setjabbis";
            PreparedStatement prstmt = con.prepareStatement(query1);
            ResultSet rs1 = prstmt.executeQuery();

            // Check if there are results
            if (rs1.next()) {
                int userid = rs1.getInt("userid");

                // Query to get tasks from the todoList table for the specific user
                String query = "SELECT * FROM todoList WHERE userid = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setInt(1, userid);
                ResultSet rs = pstmt.executeQuery();

                // Loop through the results and add them to the table model
                while (rs.next()) {
                    // Retrieve data from the database
                    int id = rs.getInt("id");
                    String todo = rs.getString("list");
                    String subject = rs.getString("subject");
                    String dodate = rs.getString("do");
                    String deadline = rs.getString("deadline");
                    // Add row to the table model
                    model.addRow(new Object[]{id, todo, subject, dodate, deadline});
                }
            } else {
                System.out.println("No user found in setjabbis.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
        
    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString()); // Get ID from database todolist

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String todo, subject, dodate, deadline;

                // Correct the SELECT query usage
                String query = "SELECT * FROM todoList WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery(); // Use executeQuery() for SELECT statements

                if (rs.next()) {
                    String queryInsert = "INSERT INTO archive(userid ,list, subject, do, deadline) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement Ds = con.prepareStatement(queryInsert);
                    int iduser = rs.getInt("userid");
                    todo = rs.getString("list");
                    subject = rs.getString("subject");
                    dodate = rs.getString("do");
                    deadline = rs.getString("deadline");

                    // Add data to the insert query
                    Ds.setInt(1, iduser);
                    Ds.setString(2, todo);
                    Ds.setString(3, subject);
                    Ds.setString(4, dodate);
                    Ds.setString(5, deadline);
                    Ds.executeUpdate();
                }

                // Delete the row from the todoList table
                String queryDelete = "DELETE FROM todoList WHERE id = ?";
                PreparedStatement deleteStmt = con.prepareStatement(queryDelete);
                deleteStmt.setInt(1, id);
                deleteStmt.executeUpdate();

                // Remove the row from the table model
                ((DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Task deleted successfully.");
                loadData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_DeleteBtnActionPerformed
    

    private void CreatelistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatelistBtnActionPerformed
        // TODO add your handling code here:
        String tolist, doDate, deadline, Subject;

        try {
            // Query to get the user ID from the setjabbis table
            String query1 = "SELECT * FROM setjabbis";
            PreparedStatement prstmt = con.prepareStatement(query1);
            ResultSet rs1 = prstmt.executeQuery();

            // Check if there are results
            if (rs1.next()) {
                int userid = rs1.getInt("userid");

                // Format dates
                SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                doDate = sdf.format(this.doDate.getDate());
                deadline = sdf.format(this.DeadlineDate.getDate());
                tolist = this.list.getText();

                // Determine the subject based on selected radio button
                if (this.ccnaBtn.isSelected()) {
                    Subject = "CCNA";
                } else if (this.webBtn.isSelected()) {
                    Subject = "WEB 2";
                } else if (this.advanceDbBtn.isSelected()) {
                    Subject = "ADVANCE DATABASE";
                } else if (this.SystemAnalysisBtn.isSelected()) {
                    Subject = "SYSTEM ANALYSIS AND DESIGN";
                } else if (this.SystemIntegBtn.isSelected()) {
                    Subject = "SYSTEM INTEGRATION";
                } else if (this.EventDBtn.isSelected()) {
                    Subject = "EVENT DRIVEN PROGRAMMING";
                } else if (this.SpiBtn.isSelected()) {
                    Subject = "SOCIAL AND PROFESSIONAL ISSUE";
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a subject.");
                    return;
                }

                // Check if any required field is empty
                if (tolist.isEmpty() || doDate.isEmpty() || deadline.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all the fields.");
                    return; // Exit the method if fields are empty
                }

                // Insert the new task into the database
                String query = "INSERT INTO todoList(userid, list, subject, do, deadline) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setInt(1, userid); // Use the retrieved userid
                    pstmt.setString(2, tolist);
                    pstmt.setString(3, Subject);
                    pstmt.setString(4, doDate);
                    pstmt.setString(5, deadline);

                    pstmt.executeUpdate();  // Execute the insert statement

                    JOptionPane.showMessageDialog(this, "Task added successfully.");
                    System.out.println("Insertion successful.");
                    loadData(); // Refresh the data in the table
                }
            } else {
                JOptionPane.showMessageDialog(this, "No user found in setjabbis.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_CreatelistBtnActionPerformed


    private void UpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            String tolist, doDate, deadline, Subject;

            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                String query1 = "SELECT * FROM setjabbis";
//                PreparedStatement prstmt = con.prepareStatement(query1);
//                ResultSet rs1 = prstmt.executeQuery();
//                rs1.next();
//                int userid = rs1.getInt("userid");
                
                
                SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
                doDate = sdf.format(this.doDate.getDate());
                deadline = sdf.format(this.DeadlineDate.getDate());
                tolist = this.list.getText();

                // Determine the subject based on selected radio button
                if (this.ccnaBtn.isSelected()) {
                    Subject = "CCNA";
                } else if (this.webBtn.isSelected()) {
                    Subject = "WEB 2";
                } else if (this.advanceDbBtn.isSelected()) {
                    Subject = "ADVANCE DATABASE";
                } else if (this.SystemAnalysisBtn.isSelected()) {
                    Subject = "SYSTEM ANALYSIS AND DESIGN";
                } else if (this.SystemIntegBtn.isSelected()) {
                    Subject = "SYSTEM INTEGRATION";
                } else if (this.EventDBtn.isSelected()) {
                    Subject = "EVENT DRIVEN PROGRAMMING";
                } else if (this.SpiBtn.isSelected()) {
                    Subject = "SOCIAL AND PROFESSIONAL ISSUE";
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a subject.");
                    return;
                }

                // Check if any required field is empty
                if (tolist.isEmpty() || doDate.isEmpty() || deadline.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all the fields.");
                } else {
                    String query = "UPDATE todoList SET list = ?, subject = ?, do = ?, deadline = ? WHERE id = ?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, tolist);
                    pstmt.setString(2, Subject);
                    pstmt.setString(3, doDate);
                    pstmt.setString(4, deadline);
                    pstmt.setInt(5, id);

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Task updated successfully.");
                        System.out.println("Update successful.");
                        loadData();  // Refresh the table
                    } else {
                        JOptionPane.showMessageDialog(this, "No records were updated.");
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "Error updating task: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
        }

    }//GEN-LAST:event_UpdatebtnActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        try {
            String query1 = "SELECT * FROM setjabbis";
            PreparedStatement prstmt = con.prepareStatement(query1);
            ResultSet rs1 = prstmt.executeQuery();
            rs1.next();
            int userid = rs1.getInt("userid");
            // Query to get user information
            String query = "SELECT * FROM masters_account WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userid);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Get user details from database
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                String email = rs.getString("email");  // or username column name

                // Create new MainWindow1 with user details
                new MainWindow1(firstName, lastName, email, userid).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User information not found!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabel7MouseClicked

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
            String query = "SELECT * FROM todoList WHERE list LIKE ? OR subject LIKE ?";
            PreparedStatement prstmt = con.prepareStatement(query);
            prstmt.setString(1, "%" + userInput + "%");
            prstmt.setString(2, "%" + userInput + "%");

            // Execute the query
            ResultSet rs = prstmt.executeQuery();

            // Populate the table with the search results
            while (rs.next()) {
                // Retrieve data from the database
                int id = rs.getInt("id");
                String todo = rs.getString("list");
                String subject = rs.getString("subject");
                String dodate = rs.getString("do");
                String deadline = rs.getString("deadline");
                // Add row to the table model
                model.addRow(new Object[]{id,todo,subject ,dodate, deadline});
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
            java.util.logging.Logger.getLogger(todolistWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(todolistWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(todolistWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(todolistWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new todolistWindow2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatelistBtn;
    private com.toedter.calendar.JDateChooser DeadlineDate;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JRadioButton EventDBtn;
    private javax.swing.JRadioButton SpiBtn;
    private javax.swing.ButtonGroup Subject;
    private javax.swing.JRadioButton SystemAnalysisBtn;
    private javax.swing.JRadioButton SystemIntegBtn;
    private javax.swing.JButton Updatebtn;
    private javax.swing.JTextField Userinput;
    private javax.swing.JRadioButton advanceDbBtn;
    private javax.swing.JRadioButton ccnaBtn;
    private com.toedter.calendar.JDateChooser doDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea list;
    private javax.swing.JButton searchbtn;
    private javax.swing.JRadioButton webBtn;
    // End of variables declaration//GEN-END:variables


}
