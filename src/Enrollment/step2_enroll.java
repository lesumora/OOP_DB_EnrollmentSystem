package Enrollment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author acer
 */
public class step2_enroll extends javax.swing.JFrame {

    /**
     * Creates new form step2_enroll
     */
    final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    static String selectedCourse, curriculum, campus, courseID, courseName, section;
    static int userSessionID, yearLevel;
    List<String> enrolledCode = new ArrayList<>();
    List<String> subjectCode = new ArrayList<>();
    List<String> faculty = new ArrayList<>();
    String facultyFirstName, facultyLastName, facultyMiddleName, facultyFullName;
    DefaultTableModel model = new DefaultTableModel();

    public step2_enroll(int userSessionID, String selectedCourse, String curriculum, String campus, String courseID, String courseName, int yearLevel) {
        initComponents();
        this.userSessionID = userSessionID;
        this.selectedCourse = selectedCourse;
        this.curriculum = curriculum;
        this.campus = campus;
        this.courseID = courseID;
        this.courseName = courseName;
        this.yearLevel = yearLevel;

        section = (String) jComboBox1.getSelectedItem();
        System.out.println(campus);

        model = (DefaultTableModel) jTable1.getModel();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Succesfully connected to database...

            String sqlCourseSubject = "SELECT SubjectCode, SubjectTitle, Lecture, Lab, Credit, Schedule FROM COURSE_SUBJECT WHERE CourseID = ?";
            PreparedStatement preparedStatementCourseSubject = conn.prepareStatement(sqlCourseSubject);
            preparedStatementCourseSubject.setString(1, courseID);
            ResultSet resultSetCourseSubject = preparedStatementCourseSubject.executeQuery();

            while (resultSetCourseSubject.next()) {

                Object[] row = new Object[8];
                row[0] = false;
                row[1] = resultSetCourseSubject.getObject("SubjectCode");
                row[2] = resultSetCourseSubject.getObject("SubjectTitle");
                row[3] = resultSetCourseSubject.getObject("Lecture");
                row[4] = resultSetCourseSubject.getObject("Lab");
                row[5] = resultSetCourseSubject.getObject("Credit");
                row[6] = resultSetCourseSubject.getObject("Schedule");
                row[7] = facultyFullName;

                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public step2_enroll(int userSessionID, String selectedCourse, String curriculum, String campus, String courseID, String courseName, String section, List<String> enrolledCode, int yearLevel) {
        initComponents();
        jComboBox1.setSelectedItem(section);
        this.enrolledCode.clear();
        this.section = section;
        this.enrolledCode = enrolledCode;
        this.campus = campus;
        this.yearLevel = yearLevel;

        System.out.println(campus);

        model = (DefaultTableModel) jTable1.getModel();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Successfully connected to the database...

            String sqlCourseSubject = "SELECT SubjectCode, SubjectTitle, Lecture, Lab, Credit, Schedule FROM COURSE_SUBJECT WHERE CourseID = ?";
            PreparedStatement preparedStatementCourseSubject = conn.prepareStatement(sqlCourseSubject, Statement.RETURN_GENERATED_KEYS);
            preparedStatementCourseSubject.setString(1, courseID);
            ResultSet resultSetCourseSubject = preparedStatementCourseSubject.executeQuery();

            while (resultSetCourseSubject.next()) {
                Object[] row = new Object[8];
                String subjectCode = resultSetCourseSubject.getString("SubjectCode");
                boolean isSelected = enrolledCode.contains(subjectCode); // Check if the code is in enrolledCode list
                row[0] = isSelected;
                row[1] = subjectCode;
                row[2] = resultSetCourseSubject.getObject("SubjectTitle");
                row[3] = resultSetCourseSubject.getObject("Lecture");
                row[4] = resultSetCourseSubject.getObject("Lab");
                row[5] = resultSetCourseSubject.getObject("Credit");
                row[6] = resultSetCourseSubject.getObject("Schedule");
                row[7] = facultyFullName;

                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Section A", "Section B", "Section C", "Section D" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 350, 30));

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Please select. Thank You!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, 30));

        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Class Section");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, 30));

        btnNext.setBackground(new java.awt.Color(0, 153, 255));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Register selected");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 620, 140, 40));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "CODE", "TITLE", "LEC", "LAB", "UNIT", "SCHEDULE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1180, 410));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnBack.png"))); // NOI18N
        btnBack.setOpaque(true);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 616, 40, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_Step2Enroll.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        enrolledCode.clear();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Boolean isSelected = (Boolean) jTable1.getValueAt(i, 0);
            if (isSelected != null && isSelected) {
                String subjectCode = (String) jTable1.getValueAt(i, 1);
                String enrolledSubject = subjectCode;
                enrolledCode.add(enrolledSubject);
            }
        }
        new step1_enroll(userSessionID, selectedCourse, curriculum, campus, courseID, courseName, yearLevel, section, enrolledCode).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked

    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedIndex() != -1) {
            section = (String) jComboBox1.getSelectedItem();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        enrolledCode.clear();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Boolean isSelected = (Boolean) jTable1.getValueAt(i, 0);
            if (isSelected != null && isSelected) {
                String subjectCode = (String) jTable1.getValueAt(i, 1);
                String enrolledSubject = subjectCode;
                enrolledCode.add(enrolledSubject);
            }
        }
        System.out.println("Code :" + enrolledCode);
        new step3_enroll(userSessionID, selectedCourse, curriculum, campus, courseID, courseName, section, enrolledCode, yearLevel).setVisible(true);
        this.dispose();
        System.out.println("Code :" + enrolledCode);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked

    }//GEN-LAST:event_btnNextMouseClicked

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
            java.util.logging.Logger.getLogger(step2_enroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(step2_enroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(step2_enroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(step2_enroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new step2_enroll(userSessionID, selectedCourse, curriculum, campus, courseID, courseName, yearLevel).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
