package Dean;

import Admin.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Jaden
 */
public class SubjectAdd extends javax.swing.JFrame {

    /**
     * Creates new form AdminAdd
     */
    final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    static int userSessionID, empId;
    String subjectCode, subjectTitle, schedule;
    String lectureText, labText, creditText;
    int lecture, lab, credit;
    static String courseId;
    int supervisorId;

    public SubjectAdd(int userSessionID, String courseId, int empId) {
        initComponents();
        this.userSessionID = userSessionID;
        this.courseId = courseId;
        this.empId = empId;
        
        System.out.println(courseId);
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
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

        jLabel1 = new javax.swing.JLabel();
        tfSubjectCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfSubjectTitle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfLecture = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfLab = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCredit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfSchedule = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Subject");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Subject Code");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 32, -1, -1));
        getContentPane().add(tfSubjectCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 54, 120, 30));

        jLabel2.setText("Subject Title");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 32, -1, -1));
        getContentPane().add(tfSubjectTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 54, 120, 30));

        jLabel5.setText("Lecture");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        getContentPane().add(tfLecture, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 40, 30));

        jLabel6.setText("Lab");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));
        getContentPane().add(tfLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 40, 30));

        jLabel7.setText("Credit");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));
        getContentPane().add(tfCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 40, 30));

        jLabel3.setText("Schedule");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, 20));
        getContentPane().add(tfSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 120, 30));

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 179, 35));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        subjectCode = tfSubjectCode.getText();
        subjectTitle = tfSubjectTitle.getText();
        schedule = tfSchedule.getText();
        lectureText = tfLecture.getText();
        labText = tfLab.getText();
        creditText = tfCredit.getText();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            if (subjectCode.isBlank() || subjectTitle.isBlank() || schedule.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Ooops!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (lectureText.isBlank() || labText.isBlank() || creditText.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Ooops!", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                try {
                    lecture = Integer.parseInt(tfLecture.getText());
                    lab = Integer.parseInt(tfLab.getText());
                    credit = Integer.parseInt(tfCredit.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid integer.");
                    return;
                }
            }

            String sqlSubjectAdd = "insert into COURSE_SUBJECT values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementSubjectAdd = conn.prepareStatement(sqlSubjectAdd);
            preparedStatementSubjectAdd.setString(1, subjectCode);
            preparedStatementSubjectAdd.setString(2, subjectTitle);
            preparedStatementSubjectAdd.setInt(3, lecture);
            preparedStatementSubjectAdd.setInt(4, lab);
            preparedStatementSubjectAdd.setInt(5, credit);
            preparedStatementSubjectAdd.setString(6, schedule);
            preparedStatementSubjectAdd.setString(7, courseId);
            int rowsInsertedSubject = preparedStatementSubjectAdd.executeUpdate();
            if (rowsInsertedSubject > 0) {
                JOptionPane.showMessageDialog(this, "Successfully added new subject");
            }
            
            String sqlFacultySubject = "insert into FACULTY_SUBJECT values (?, ?, ?)";
            PreparedStatement preparedStatementFacultySubject = conn.prepareStatement(sqlFacultySubject);
            preparedStatementFacultySubject.setInt(1, empId);
            preparedStatementFacultySubject.setString(2, subjectCode);
            preparedStatementFacultySubject.setInt(3, empId);
            
            int rowsInsertedFacultySubject = preparedStatementFacultySubject.executeUpdate();
            if (rowsInsertedFacultySubject > 0) {
                System.out.println("Successfully added new faculty subject");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(SubjectAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectAdd(userSessionID, courseId, empId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tfCredit;
    private javax.swing.JTextField tfLab;
    private javax.swing.JTextField tfLecture;
    private javax.swing.JTextField tfSchedule;
    private javax.swing.JTextField tfSubjectCode;
    private javax.swing.JTextField tfSubjectTitle;
    // End of variables declaration//GEN-END:variables
}