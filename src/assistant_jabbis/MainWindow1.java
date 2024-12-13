package assistant_jabbis;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import com.formdev.flatlaf.FlatDarkLaf;
import databaseConnection.databaseConnect;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author USER
 */
public class MainWindow1 extends javax.swing.JFrame implements Runnable {

    private String username;
    private int userId;
    private String alarmTime;
    private Process process;
    private String Fname;
    private String Lname;

    private Connection con;

    /**
     * Creates new form MainWindow
     */
    public MainWindow1(String Fname, String Lname, String username, int userId) {
        this.username = username;
        this.userId = userId;
        initComponents();
        con = databaseConnect.getConnection();
        loadData();
        fetchTableData();

        // You can use the username to update UI elements
        // For example:
        User.setText(Fname + " " + Lname);  // If you have a welcome label

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (process != null && process.isAlive()) {
                    process.destroy();
                    System.out.println("Process terminated.");
                }
                dispose();
            }
        });

        Thread t = new Thread(this);
        t.start();
    }

    // Add getters for the user data
    public String getfname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    // Keep your existing no-arg constructor for compatibility
    private void fetchTableData() {

        String query = "SELECT COUNT(*) AS total FROM todolist WHERE userid = ?";
        String query2 = "SELECT COUNT(*) AS total FROM completed_task WHERE userid = ?";
        String query3 = "SELECT COUNT(*) AS total FROM archive WHERE userid = ?";
        String query4 = "SELECT COUNT(*) AS total FROM alarms";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            PreparedStatement stmt2 = con.prepareStatement(query2);
            PreparedStatement stmt3 = con.prepareStatement(query3);
            PreparedStatement stmt4 = con.prepareStatement(query4);

            // Set userId for the first three queries
            stmt.setInt(1, userId);
            stmt2.setInt(1, userId);
            stmt3.setInt(1, userId);

            // Execute queries
            ResultSet rs = stmt.executeQuery();
            ResultSet rs2 = stmt2.executeQuery();
            ResultSet rs3 = stmt3.executeQuery();
            ResultSet rs4 = stmt4.executeQuery();

            // Check each ResultSet individually
            if (rs.next()) {
                int count = rs.getInt("total");
                this.tasklabel.setText(String.valueOf(count));
            }

            if (rs2.next()) {
                int count2 = rs2.getInt("total");
                this.completeLabel.setText(String.valueOf(count2));
            }

            if (rs3.next()) {
                int count3 = rs3.getInt("total");
                this.archlabel.setText(String.valueOf(count3));
            }

            if (rs4.next()) {
                int count4 = rs4.getInt("total");
                this.alarmlabel.setText(String.valueOf(count4));
            }

            // Close resources
            rs.close();
            rs2.close();
            rs3.close();
            rs4.close();
            stmt.close();
            stmt2.close();
            stmt3.close();
            stmt4.close();

        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "ERROR: " + e.getMessage(),
                    "Database Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) alarmtable.getModel();
        model.setRowCount(0); // Clear existing data

        try {
            con = databaseConnect.getConnection();

            String query = "SELECT * FROM alarms WHERE userid = ?";

            PreparedStatement prstmt = con.prepareStatement(query);
            prstmt.setInt(1, userId);
            ResultSet rs = prstmt.executeQuery();

            while (rs.next()) {
                // Retrieve data from the database
                int id = rs.getInt("id");
                String hours = rs.getString("hours");
                String minutes = rs.getString("minutes");
                // Add row to the table model
                model.addRow(new Object[]{id, hours, minutes});
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

        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        CalculatorVcomandbtn = new javax.swing.JButton();
        WebVComandsBTN = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        VoiceComALLbtn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Speaktodobtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        viewtodobtn = new javax.swing.JButton();
        comTackbtn = new javax.swing.JButton();
        VAlarmbtn = new javax.swing.JButton();
        DeletedTaskbtn = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        tasklabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        completeLabel = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        alarmlabel = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        archlabel = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        searchComf = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        searchbtncom = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        searchfarch = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        searcharchbtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        DonetaskBtn = new javax.swing.JButton();
        SearchTaskF = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        searchtask = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        timelabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        alarmtable = new javax.swing.JTable();
        SetAlarm = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchalarmf = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        searchbtnalarm = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        CalculatorVcomandbtn.setBackground(new java.awt.Color(51, 51, 51));
        CalculatorVcomandbtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        CalculatorVcomandbtn.setForeground(new java.awt.Color(51, 255, 51));
        CalculatorVcomandbtn.setText("Calculator ");
        CalculatorVcomandbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculatorVcomandbtnActionPerformed(evt);
            }
        });

        WebVComandsBTN.setBackground(new java.awt.Color(51, 51, 51));
        WebVComandsBTN.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        WebVComandsBTN.setForeground(new java.awt.Color(51, 255, 51));
        WebVComandsBTN.setText("V-command");
        WebVComandsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WebVComandsBTNActionPerformed(evt);
            }
        });

        VoiceComALLbtn.setBackground(new java.awt.Color(51, 51, 51));
        VoiceComALLbtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        VoiceComALLbtn.setForeground(new java.awt.Color(51, 255, 51));
        VoiceComALLbtn.setText("SETTINGS");
        VoiceComALLbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoiceComALLbtnActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 255, 51));
        jButton6.setText("Add Task ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        Speaktodobtn.setBackground(new java.awt.Color(51, 51, 51));
        Speaktodobtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        Speaktodobtn.setForeground(new java.awt.Color(51, 255, 51));
        Speaktodobtn.setText("Alarm");
        Speaktodobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeaktodobtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Speaktodobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VoiceComALLbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WebVComandsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalculatorVcomandbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(WebVComandsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CalculatorVcomandbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VoiceComALLbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Speaktodobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 220, 510));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/favicon3.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 50, 60));

        viewtodobtn.setBackground(new java.awt.Color(51, 51, 51));
        viewtodobtn.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        viewtodobtn.setForeground(new java.awt.Color(0, 255, 51));
        viewtodobtn.setText("todo task");
        viewtodobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewtodobtnActionPerformed(evt);
            }
        });
        jPanel3.add(viewtodobtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        comTackbtn.setBackground(new java.awt.Color(51, 51, 51));
        comTackbtn.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        comTackbtn.setForeground(new java.awt.Color(0, 255, 51));
        comTackbtn.setText("Completed task");
        comTackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comTackbtnActionPerformed(evt);
            }
        });
        jPanel3.add(comTackbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        VAlarmbtn.setBackground(new java.awt.Color(51, 51, 51));
        VAlarmbtn.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        VAlarmbtn.setForeground(new java.awt.Color(0, 255, 51));
        VAlarmbtn.setText("View Alarm");
        VAlarmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VAlarmbtnActionPerformed(evt);
            }
        });
        jPanel3.add(VAlarmbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, -1));

        DeletedTaskbtn.setBackground(new java.awt.Color(51, 51, 51));
        DeletedTaskbtn.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        DeletedTaskbtn.setForeground(new java.awt.Color(0, 255, 51));
        DeletedTaskbtn.setText("Deleted Task");
        DeletedTaskbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletedTaskbtnActionPerformed(evt);
            }
        });
        jPanel3.add(DeletedTaskbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        logoutbtn.setBackground(new java.awt.Color(51, 51, 51));
        logoutbtn.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        logoutbtn.setForeground(new java.awt.Color(0, 255, 51));
        logoutbtn.setText("LOGOUT");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });
        jPanel3.add(logoutbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 255, 51));
        jLabel9.setText("Jabbis personal voice assistant");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 330, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-username-64 (2).png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 40, 40));

        User.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        User.setForeground(new java.awt.Color(51, 255, 51));
        User.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        User.setText("USERNAME LASTNAME");
        jPanel3.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 80));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tasklabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        tasklabel.setForeground(new java.awt.Color(255, 255, 255));
        tasklabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tasklabel.setText("10");
        jPanel21.add(tasklabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 240, -1));

        jLabel11.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("TASK");
        jPanel21.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 240, -1));

        jPanel9.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 240, 200));

        jPanel49.setBackground(new java.awt.Color(51, 51, 51));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("COMPLETED TASK");
        jPanel49.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 220, -1));

        completeLabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        completeLabel.setForeground(new java.awt.Color(255, 255, 255));
        completeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completeLabel.setText("312");
        jPanel49.add(completeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 220, -1));

        jPanel9.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 220, 200));

        jPanel50.setBackground(new java.awt.Color(51, 51, 51));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alarmlabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        alarmlabel.setForeground(new java.awt.Color(255, 255, 255));
        alarmlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alarmlabel.setText("10");
        jPanel50.add(alarmlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 240, -1));

        jLabel72.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("ALARMS");
        jPanel50.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 240, 20));

        jPanel9.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 240, 200));

        jPanel54.setBackground(new java.awt.Color(51, 51, 51));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        archlabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        archlabel.setForeground(new java.awt.Color(255, 255, 255));
        archlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        archlabel.setText("28");
        jPanel54.add(archlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, -1));

        jLabel73.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("ARCHIVE");
        jPanel54.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 220, 20));

        jPanel9.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 220, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel1.setText("czxzxczxcxzc");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 470));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jabbishompi4.jpg"))); // NOI18N
        jLabel18.setText("jLabel18");
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, -20, 350, -1));

        jTabbedPane1.addTab("tab4", jPanel9);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel12.setText("czxzxczxcxzc");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 592, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel5);

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
        jPanel7.add(searchComf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 283, 40));

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

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel13.setText("czxzxczxcxzc");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        jTabbedPane1.addTab("tab2", jPanel7);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setBackground(new java.awt.Color(60, 63, 65));
        jTable3.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jTable3.setForeground(new java.awt.Color(0, 255, 51));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Task", "Subject", "Do", "Deadline"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel11.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 860, 360));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 255, 51));
        jLabel8.setText("Archive Task");
        jPanel11.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        searchfarch.setBackground(new java.awt.Color(60, 63, 65));
        searchfarch.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searchfarch.setForeground(new java.awt.Color(0, 255, 0));
        searchfarch.setBorder(null);
        searchfarch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfarchActionPerformed(evt);
            }
        });
        jPanel11.add(searchfarch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 283, 40));

        jSeparator8.setForeground(new java.awt.Color(0, 255, 0));
        jPanel11.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 280, 30));

        searcharchbtn.setBackground(new java.awt.Color(51, 51, 51));
        searcharchbtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searcharchbtn.setForeground(new java.awt.Color(0, 255, 51));
        searcharchbtn.setText("Search");
        searcharchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searcharchbtnActionPerformed(evt);
            }
        });
        jPanel11.add(searcharchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 40));

        DeleteBtn.setBackground(new java.awt.Color(51, 51, 51));
        DeleteBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(51, 255, 51));
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        jPanel11.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 160, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel14.setText("czxzxczxcxzc");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        jTabbedPane1.addTab("tab5", jPanel11);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 51));
        jLabel6.setText("TASK TO DO");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTable2.setBackground(new java.awt.Color(60, 63, 65));
        jTable2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 255, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "USERID", "TASK", "SUBJECT", "DO", "DEADLINE"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 860, 350));

        DonetaskBtn.setBackground(new java.awt.Color(51, 51, 51));
        DonetaskBtn.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        DonetaskBtn.setForeground(new java.awt.Color(0, 255, 51));
        DonetaskBtn.setText("Done Task");
        DonetaskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DonetaskBtnActionPerformed(evt);
            }
        });
        jPanel10.add(DonetaskBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, -1));

        SearchTaskF.setBackground(new java.awt.Color(60, 63, 65));
        SearchTaskF.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        SearchTaskF.setForeground(new java.awt.Color(0, 255, 0));
        SearchTaskF.setBorder(null);
        SearchTaskF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTaskFActionPerformed(evt);
            }
        });
        jPanel10.add(SearchTaskF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 283, 40));

        jSeparator7.setForeground(new java.awt.Color(0, 255, 0));
        jPanel10.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 280, 30));

        searchtask.setBackground(new java.awt.Color(51, 51, 51));
        searchtask.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searchtask.setForeground(new java.awt.Color(0, 255, 51));
        searchtask.setText("Search");
        searchtask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtaskActionPerformed(evt);
            }
        });
        jPanel10.add(searchtask, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 40));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel16.setText("czxzxczxcxzc");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 460));

        jTabbedPane1.addTab("tab5", jPanel10);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timelabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        timelabel.setForeground(new java.awt.Color(255, 0, 0));
        timelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timelabel.setText("time");
        timelabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, java.awt.Color.white));
        jPanel12.add(timelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 284, 60));

        alarmtable.setBackground(new java.awt.Color(60, 63, 65));
        alarmtable.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        alarmtable.setForeground(new java.awt.Color(0, 255, 51));
        alarmtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "HOURS", "MINUTES"
            }
        ));
        jScrollPane4.setViewportView(alarmtable);

        jPanel12.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 870, 300));

        SetAlarm.setBackground(new java.awt.Color(51, 51, 51));
        SetAlarm.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        SetAlarm.setForeground(new java.awt.Color(0, 255, 51));
        SetAlarm.setText("Set Alarm");
        SetAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetAlarmActionPerformed(evt);
            }
        });
        jPanel12.add(SetAlarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 220, 40));

        jLabel3.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 51));
        jLabel3.setText("Alarm");
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 40));

        searchalarmf.setBackground(new java.awt.Color(60, 63, 65));
        searchalarmf.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searchalarmf.setForeground(new java.awt.Color(0, 255, 0));
        searchalarmf.setBorder(null);
        searchalarmf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchalarmfActionPerformed(evt);
            }
        });
        jPanel12.add(searchalarmf, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 283, 40));

        jSeparator6.setForeground(new java.awt.Color(0, 255, 0));
        jPanel12.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 280, 30));

        searchbtnalarm.setBackground(new java.awt.Color(51, 51, 51));
        searchbtnalarm.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        searchbtnalarm.setForeground(new java.awt.Color(0, 255, 51));
        searchbtnalarm.setText("Search");
        searchbtnalarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnalarmActionPerformed(evt);
            }
        });
        jPanel12.add(searchbtnalarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 90, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vecteezy_computer-processor-chip-technology-background-design-blue_11641945.jpg"))); // NOI18N
        jLabel15.setText("czxzxczxcxzc");
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        jTabbedPane1.addTab("tab6", jPanel12);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 900, 500));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 540));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/favicon3.png"))); // NOI18N
        jLabel5.setText("jLabel2");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1065, 6, 49, -1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 208, 20));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1120, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CalculatorVcomandbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculatorVcomandbtnActionPerformed
        // TODO add your handling code here:
//        if (process != null && process.isAlive()) {
//            process.destroy();
//        }

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "C:\\Users\\USER\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", // Correct Python path
                    "C:\\Users\\USER\\PycharmProjects\\pythonProject21\\VcommandCal.py" // Path to Python script
            );

            processBuilder.directory(new File("C:\\Users\\USER\\PycharmProjects\\pythonProject21"));

            // Start the process and assign it to the class-level variable
            process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
            System.out.println("Output:\n" + output.toString());

            // Terminate the process if it takes too long
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CalculatorVcomandbtnActionPerformed

    private void WebVComandsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WebVComandsBTNActionPerformed
        // TODO add your handling code here:
//        if (process != null && process.isAlive()) {
//            process.destroy();
//        }

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "C:\\Users\\USER\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", // Correct Python path
                    "C:\\Users\\USER\\PycharmProjects\\pythonProject21\\Ai.py" // Path to Python script
            );

            processBuilder.directory(new File("C:\\Users\\USER\\PycharmProjects\\pythonProject21"));

            // Start the process and assign it to the class-level variable
            process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
            System.out.println("Output:\n" + output.toString());

            // Terminate the process if it takes too long
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_WebVComandsBTNActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        todolistWindow2 todolist = new todolistWindow2();

        todolist.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_jButton6ActionPerformed

    private void SpeaktodobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeaktodobtnActionPerformed
        // TODO add your handling code here:
//        new AlarmWindow().setVisible(true);
//        this.dispose();
        AlarmWindow alarmwin = new AlarmWindow(userId, this.Fname, this.Lname, this.username);
        alarmwin.setVisible(true);
        this.dispose();
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder(
//                    "C:\\Users\\USER\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", // Correct Python path
//                    "C:\\Users\\USER\\PycharmProjects\\pythonProject21\\SayTodo.py" // Path to Python script
//            );
//
//            processBuilder.directory(new File("C:\\Users\\USER\\PycharmProjects\\pythonProject21"));
//
//            // Start the process and assign it to the class-level variable
//            process = processBuilder.start();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            StringBuilder output = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line).append("\n");
//            }
//
//            int exitCode = process.waitFor();
//            System.out.println("Exited with code: " + exitCode);
//            System.out.println("Output:\n" + output.toString());
//
//            // Terminate the process if it takes too long
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }

    }//GEN-LAST:event_SpeaktodobtnActionPerformed

    private void viewtodobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewtodobtnActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(4);
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Clear existing data

        try {

            String query = "SELECT * FROM todoList WHERE userid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Retrieve data from the database
                int id = rs.getInt("id");
                int userid = rs.getInt("userid");
                String todo = rs.getString("list");
                String subject = rs.getString("subject");
                String dodate = rs.getString("do");
                String deadline = rs.getString("deadline");
                // Add row to the table model
                System.out.println(id + " " + todo + " " + subject + " " + dodate + " " + deadline);
                model.addRow(new Object[]{id, userid, todo, subject, dodate, deadline});

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_viewtodobtnActionPerformed

    private void comTackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comTackbtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data
        try {

            String query = "SELECT * FROM Completed_task WHERE userid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Retrieve data from the database
                int id = rs.getInt("id");
                int iduser = rs.getInt("userid");

                String todo = rs.getString("task");
                String subject = rs.getString("subject");
                String deadline = rs.getString("CompleteDate");
                // Add row to the table model
                model.addRow(new Object[]{id, iduser, todo, subject, deadline});

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }//GEN-LAST:event_comTackbtnActionPerformed

    private void DeletedTaskbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletedTaskbtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0); // Clear existing data

        try {

            String query = "SELECT * FROM archive WHERE userid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Retrieve data from the database
                int id = rs.getInt("id");
                int iduser = rs.getInt("userid");

                String todo = rs.getString("list");
                String subject = rs.getString("subject");
                String dodate = rs.getString("do");
                String deadline = rs.getString("deadline");
                // Add row to the table model
                System.out.println(id + " " + todo + " " + subject + " " + dodate + " " + deadline);
                model.addRow(new Object[]{id, iduser, todo, subject, dodate, deadline});

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }//GEN-LAST:event_DeletedTaskbtnActionPerformed

    private void VAlarmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VAlarmbtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);


    }//GEN-LAST:event_VAlarmbtnActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            // Clear session data
            this.username = null;
            this.userId = 0;

            // Close any running processes
            if (process != null && process.isAlive()) {
                process.destroy();
            }

            // Return to login window
            new loginwindow().setVisible(true);
            this.dispose();
        }
        jTabbedPane1.setSelectedIndex(1);


    }//GEN-LAST:event_logoutbtnActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_jLabel2MouseClicked

    private void DonetaskBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DonetaskBtnActionPerformed
        // TODO add your handling code here:
        int selected = jTable2.getSelectedRow();
        System.out.println(selected);
        if (selected != 1) {
            try {
                int id = Integer.parseInt(jTable2.getValueAt(selected, 0).toString());
                String query = "SELECT * FROM todoList WHERE id = ?";
                PreparedStatement prstmt = con.prepareStatement(query);
                prstmt.setInt(1, id);

                ResultSet rs = prstmt.executeQuery();
                if (rs.next()) {
                    int iduser = rs.getInt("userid");
                    String task = rs.getString("list");
                    String subject = rs.getString("subject");

                    String query2 = "INSERT INTO Completed_task(userid,task,subject)VALUES(?,?,?)";
                    PreparedStatement pstmt2 = con.prepareStatement(query2);
                    pstmt2.setInt(1, iduser);
                    pstmt2.setString(2, task);
                    pstmt2.setString(3, subject);
                    pstmt2.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Are you sure your Done with this task", "Success", JOptionPane.YES_NO_CANCEL_OPTION);

                    String queryDelete = "DELETE FROM todoList WHERE id = ?";
                    PreparedStatement deleteStmt = con.prepareStatement(queryDelete);
                    deleteStmt.setInt(1, id);
                    deleteStmt.executeUpdate();

                    // Remove the row from the table model
                    ((DefaultTableModel) jTable2.getModel()).removeRow(selected);

                } else {
                    JOptionPane.showMessageDialog(this, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } catch (Exception e) {

            }
        } else {
            JOptionPane.showMessageDialog(this, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_DonetaskBtnActionPerformed

    private void VoiceComALLbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoiceComALLbtnActionPerformed
        // TODO add your handling code here:
//        new settingWin().setVisible(true);
//        this.dispose();
        settingWin setwin = new settingWin(userId, this.Fname, this.Lname, this.username);
        setwin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VoiceComALLbtnActionPerformed

    private void SetAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetAlarmActionPerformed
        // TODO add your handling code here:
        int selected = alarmtable.getSelectedRow();
        if (selected != 0) {
            try {
                int id = Integer.parseInt(alarmtable.getValueAt(selected, 0).toString());
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

    private void searchalarmfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchalarmfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchalarmfActionPerformed

    private void searchbtnalarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnalarmActionPerformed
        // TODO add your handling code here:
        // Retrieve the search input
        String userInput = searchalarmf.getText().trim();

        // Clear existing data in the table
        DefaultTableModel model = (DefaultTableModel) this.alarmtable.getModel();
        model.setRowCount(0);

        try {
            // Establish a database connection
            con = databaseConnect.getConnection();

            // Define a query to search for alarms matching the user input
            String query = "SELECT * FROM alarms WHERE hours LIKE ? OR minutes LIKE ?";
            PreparedStatement prstmt = con.prepareStatement(query);
            prstmt.setString(1, "%" + userInput + "%");
            prstmt.setString(2, "%" + userInput + "%");

            // Execute the query
            ResultSet rs = prstmt.executeQuery();

            // Populate the table with the search results
            while (rs.next()) {
                int id = rs.getInt("id");
                String hours = rs.getString("hours");
                String minutes = rs.getString("minutes");
                model.addRow(new Object[]{id, hours, minutes});
            }

            // Notify user if no records are found
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No matching records found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching records: " + e.getMessage());
        }
    }//GEN-LAST:event_searchbtnalarmActionPerformed

    private void SearchTaskFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTaskFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTaskFActionPerformed

    private void searchtaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtaskActionPerformed
        // TODO add your handling code here:
        // Retrieve the search input
        String userInput = SearchTaskF.getText().trim();

        // Clear existing data in the table
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
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
                model.addRow(new Object[]{id, todo, subject, dodate, deadline});
            }

            // Notify user if no records are found
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No matching records found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching records: " + e.getMessage());
        }
    }//GEN-LAST:event_searchtaskActionPerformed

    private void searchfarchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfarchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchfarchActionPerformed

    private void searcharchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searcharchbtnActionPerformed
        // TODO add your handling code here:
        // Retrieve the search input
        String userInput = this.searchfarch.getText().trim();

        // Clear existing data in the table
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);

        try {
            // Establish a database connection
            con = databaseConnect.getConnection();

            // Define a query to search for alarms matching the user input
            String query = "SELECT * FROM archive WHERE list LIKE ? OR subject LIKE ?";
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
                System.out.println(id + " " + todo + " " + subject + " " + dodate + " " + deadline);
                model.addRow(new Object[]{id, todo, subject, dodate, deadline});

            }
            // Notify user if no records are found
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No matching records found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching records: " + e.getMessage());
        }
    }//GEN-LAST:event_searcharchbtnActionPerformed

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
                    String queryInsert = "INSERT INTO archive(list, subject, do, deadline) VALUES (?, ?, ?, ?)";
                    PreparedStatement Ds = con.prepareStatement(queryInsert);

                    todo = rs.getString("list");
                    subject = rs.getString("subject");
                    dodate = rs.getString("do");
                    deadline = rs.getString("deadline");

                    // Add data to the insert query
                    Ds.setString(1, todo);
                    Ds.setString(2, subject);
                    Ds.setString(3, dodate);
                    Ds.setString(4, deadline);
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
            java.util.logging.Logger.getLogger(MainWindow1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new MainWindow1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalculatorVcomandbtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DeletedTaskbtn;
    private javax.swing.JButton DonetaskBtn;
    private javax.swing.JTextField SearchTaskF;
    private javax.swing.JButton SetAlarm;
    private javax.swing.JButton Speaktodobtn;
    private javax.swing.JLabel User;
    private javax.swing.JButton VAlarmbtn;
    private javax.swing.JButton VoiceComALLbtn;
    private javax.swing.JButton WebVComandsBTN;
    private javax.swing.JLabel alarmlabel;
    private javax.swing.JTable alarmtable;
    private javax.swing.JLabel archlabel;
    private javax.swing.JButton comTackbtn;
    private javax.swing.JLabel completeLabel;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextField searchComf;
    private javax.swing.JTextField searchalarmf;
    private javax.swing.JButton searcharchbtn;
    private javax.swing.JButton searchbtnalarm;
    private javax.swing.JButton searchbtncom;
    private javax.swing.JTextField searchfarch;
    private javax.swing.JButton searchtask;
    private javax.swing.JLabel tasklabel;
    private javax.swing.JLabel timelabel;
    private javax.swing.JButton viewtodobtn;
    // End of variables declaration//GEN-END:variables
    public void run() {

        while (true) {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat fullTimeFormat = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat alarmFormat = new SimpleDateFormat("HH:mm");
            Date date = c.getTime();

            // Update the time label
            timelabel.setText(fullTimeFormat.format(date));

            // Check alarm
            String currentTime = alarmFormat.format(date);
            System.out.println("Current time: " + currentTime + ", Alarm time: " + alarmTime); // Debug

            if (alarmTime != null && currentTime.equals(alarmTime)) {
                // Execute the Python script
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder(
                            "C:\\Users\\USER\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", // Correct Python path
                            "C:\\Users\\USER\\PycharmProjects\\pythonProject21\\SayTodo.py" // Path to Python script
                    );

                    processBuilder.directory(new File("C:\\Users\\USER\\PycharmProjects\\pythonProject21"));

                    // Start the process
                    Process process = processBuilder.start();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    StringBuilder output = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        output.append(line).append("\n");
                    }

                    int exitCode = process.waitFor();
                    System.out.println("Exited with code: " + exitCode);
                    System.out.println("Output:\n" + output.toString());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
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

                // ... existing code ...
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
