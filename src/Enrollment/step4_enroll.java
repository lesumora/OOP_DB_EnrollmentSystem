package Enrollment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author acer
 */
public class step4_enroll extends javax.swing.JFrame {

    /**
     * Creates new form step4_enroll
     */
    final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    String campus, status, courseId, section;
    static int userSessionId;
    int studId, registrationId, yearLevel;
    Timestamp registrationDate;

    public step4_enroll(int userSessionID, String campus, String status, int registrationId, Timestamp registrationDate, String courseId, int yearLevel, String section){
        initComponents();
        this.userSessionId = userSessionID;
        this.campus = campus;
        this.status = status;
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.courseId = courseId;
        this.yearLevel = yearLevel;
        this.section = section;
        
        jTextField4.setText(campus);
        jTextField1.setText(status);
        jTextField2.setText("" + registrationId);
        jTextField6.setText("" + registrationDate);
    }
    
    public step4_enroll(int userSessionID) {
        initComponents();
        this.userSessionId = userSessionID;
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Succesfully connected to database...

            String sqlStudent = "SELECT * FROM STUDENT where UserID = ?";
            PreparedStatement preparedStatementStudent = conn.prepareStatement(sqlStudent);
            preparedStatementStudent.setInt(1, userSessionID);
            ResultSet resultSetCourseSubject = preparedStatementStudent.executeQuery();

            if (resultSetCourseSubject.next()) {
                campus = resultSetCourseSubject.getString("Campus");
                status = resultSetCourseSubject.getString("EnrollmentStatus");
                courseId = resultSetCourseSubject.getString("CourseID");
                yearLevel = resultSetCourseSubject.getInt("YearLevel");
                section = resultSetCourseSubject.getString("Section");
                studId = resultSetCourseSubject.getInt("StudID");

                jTextField4.setText(campus);
                jTextField1.setText(status);
            }

            String sqlEnrollment = "SELECT * FROM ENROLLMENT where StudID = ?";
            PreparedStatement preparedStatementEnrollment = conn.prepareStatement(sqlEnrollment);
            preparedStatementEnrollment.setInt(1, studId);
            ResultSet resultSetEnrollment = preparedStatementEnrollment.executeQuery();

            if (resultSetEnrollment.next()) {
                registrationId = resultSetEnrollment.getInt("EnrollmentID");
                registrationDate = resultSetEnrollment.getTimestamp("EnrollmentDate");

                jTextField2.setText("" + registrationId);
                jTextField6.setText("" + registrationDate);
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

        jToolBar9 = new javax.swing.JToolBar();
        jLabel14 = new javax.swing.JLabel();
        jToolBar10 = new javax.swing.JToolBar();
        jToolBar11 = new javax.swing.JToolBar();
        jToolBar12 = new javax.swing.JToolBar();
        jToolBar13 = new javax.swing.JToolBar();
        jToolBar14 = new javax.swing.JToolBar();
        jToolBar15 = new javax.swing.JToolBar();
        jToolBar16 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        jToolBar9.setBackground(new java.awt.Color(187, 15, 15));
        jToolBar9.setRollover(true);

        jLabel14.setBackground(new java.awt.Color(0, 204, 204));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("  Successfully Registered!");
        jToolBar9.add(jLabel14);

        jToolBar10.setBackground(new java.awt.Color(51, 204, 255));
        jToolBar10.setRollover(true);
        jToolBar9.add(jToolBar10);

        jToolBar11.setBackground(new java.awt.Color(187, 15, 15));
        jToolBar11.setRollover(true);
        jToolBar9.add(jToolBar11);

        jToolBar12.setBackground(new java.awt.Color(51, 204, 255));
        jToolBar12.setRollover(true);
        jToolBar9.add(jToolBar12);

        jToolBar13.setBackground(new java.awt.Color(187, 15, 15));
        jToolBar13.setRollover(true);

        jToolBar14.setBackground(new java.awt.Color(51, 204, 255));
        jToolBar14.setRollover(true);
        jToolBar13.add(jToolBar14);

        jToolBar15.setBackground(new java.awt.Color(187, 15, 15));
        jToolBar15.setRollover(true);
        jToolBar13.add(jToolBar15);

        jToolBar16.setBackground(new java.awt.Color(51, 204, 255));
        jToolBar16.setRollover(true);
        jToolBar13.add(jToolBar16);

        jToolBar9.add(jToolBar13);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText(" Academic Year & Term");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 170, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("*");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 70, 50));

        jTextField3.setEditable(false);
        jTextField3.setText("2024-2025 2nd Semester");
        jTextField3.setFocusable(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 430, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("*");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 70, 50));

        jTextField4.setEditable(false);
        jTextField4.setFocusable(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 430, 30));

        jTextField2.setEditable(false);
        jTextField2.setFocusable(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 430, 30));

        jLabel7.setText("Registration ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 120, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("*");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 70, 50));

        jLabel9.setText("  Registration Date");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 140, 50));

        jTextField6.setEditable(false);
        jTextField6.setFocusable(false);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 430, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("*");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 70, 50));

        jLabel11.setText("    Status");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 110, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("*");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 70, 50));

        jTextField1.setEditable(false);
        jTextField1.setFocusable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 430, 30));

        jLabel10.setText("Campus");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 90, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnNext.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 616, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_Step4Enroll.png"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new step5_enroll(userSessionId, campus, status, registrationId, registrationDate, courseId, yearLevel, section).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(step4_enroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(step4_enroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(step4_enroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(step4_enroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new step4_enroll(userSessionId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JToolBar jToolBar10;
    private javax.swing.JToolBar jToolBar11;
    private javax.swing.JToolBar jToolBar12;
    private javax.swing.JToolBar jToolBar13;
    private javax.swing.JToolBar jToolBar14;
    private javax.swing.JToolBar jToolBar15;
    private javax.swing.JToolBar jToolBar16;
    private javax.swing.JToolBar jToolBar9;
    // End of variables declaration//GEN-END:variables
}
