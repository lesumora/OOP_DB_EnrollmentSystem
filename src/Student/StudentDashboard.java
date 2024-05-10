package Student;

import Enrollment.step1_enroll;
import Enrollment.step4_enroll;
import Home.Dashboard;
import java.awt.Cursor;
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
 * @author acer
 */
public class StudentDashboard extends javax.swing.JFrame {

    /**
     * Creates new form DashboardStudent
     */
    final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    static int userSessionID;
    boolean isEnrolled = false;
    
    public StudentDashboard(int userSessionID) {
        initComponents();
        this.userSessionID = userSessionID;
        {
            btnBack.setOpaque(false); // Make the button transparent
            btnBack.setContentAreaFilled(false); // Don't fill the button area with background
            btnBack.setBorderPainted(false); // Remove the default button border
            btnBack.setFocusPainted(false); // Remove focus border
            btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnPersonal.setOpaque(false); // Make the button transparent
            btnPersonal.setContentAreaFilled(false); // Don't fill the button area with background
            btnPersonal.setBorderPainted(false); // Remove the default button border
            btnPersonal.setFocusPainted(false); // Remove focus border
            btnPersonal.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnSubject.setOpaque(false); // Make the button transparent
            btnSubject.setContentAreaFilled(false); // Don't fill the button area with background
            btnSubject.setBorderPainted(false); // Remove the default button border
            btnSubject.setFocusPainted(false); // Remove focus border
            btnSubject.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnEnroll.setOpaque(false); // Make the button transparent
            btnEnroll.setContentAreaFilled(false); // Don't fill the button area with background
            btnEnroll.setBorderPainted(false); // Remove the default button border
            btnEnroll.setFocusPainted(false); // Remove focus border
            btnEnroll.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sqlEnroll = "select EnrollmentStatus from STUDENT where UserID = ?";
            PreparedStatement preparedStatementEnroll = conn.prepareStatement(sqlEnroll);
            preparedStatementEnroll.setInt(1, userSessionID);
            ResultSet resultSetEnroll = preparedStatementEnroll.executeQuery();

            if (resultSetEnroll.next()) {
                if(resultSetEnroll.getString("EnrollmentStatus").equalsIgnoreCase("enrolled"))
                    isEnrolled = true;
            }
        } catch (Exception e) {
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

        btnBack = new javax.swing.JButton();
        btnSubject = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
        btnEnroll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackMousePressed(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 73, 30, 30));

        btnSubject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        btnSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubjectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubjectMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSubjectMousePressed(evt);
            }
        });
        btnSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 279, 204, 222));

        btnPersonal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPersonalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPersonalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPersonalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPersonalMouseReleased(evt);
            }
        });
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });
        getContentPane().add(btnPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 279, 204, 222));

        btnEnroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 2, true));
        btnEnroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnrollMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnrollMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEnrollMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEnrollMouseReleased(evt);
            }
        });
        btnEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrollActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 279, 204, 222));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_StudentDashboard.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubjectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubjectMouseEntered
        btnSubject.setBorderPainted(true);
    }//GEN-LAST:event_btnSubjectMouseEntered

    private void btnSubjectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubjectMouseExited
        btnSubject.setBorderPainted(false);
    }//GEN-LAST:event_btnSubjectMouseExited

    private void btnSubjectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubjectMousePressed
        btnSubject.setContentAreaFilled(true);
    }//GEN-LAST:event_btnSubjectMousePressed

    private void btnSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubjectActionPerformed
        
    }//GEN-LAST:event_btnSubjectActionPerformed

    private void btnPersonalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMouseEntered
        btnPersonal.setBorderPainted(true);
    }//GEN-LAST:event_btnPersonalMouseEntered

    private void btnPersonalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMouseExited
        btnPersonal.setBorderPainted(false);
    }//GEN-LAST:event_btnPersonalMouseExited

    private void btnPersonalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMousePressed
        btnPersonal.setContentAreaFilled(true);
    }//GEN-LAST:event_btnPersonalMousePressed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        new StudentInformation(userSessionID).setVisible(true);
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void btnEnrollMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollMouseEntered
        btnEnroll.setBorderPainted(true);
    }//GEN-LAST:event_btnEnrollMouseEntered

    private void btnEnrollMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollMouseExited
        btnEnroll.setBorderPainted(false);
    }//GEN-LAST:event_btnEnrollMouseExited

    private void btnEnrollMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollMousePressed
        btnEnroll.setContentAreaFilled(true);
    }//GEN-LAST:event_btnEnrollMousePressed

    private void btnEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollActionPerformed
        if(isEnrolled){
            new step4_enroll(userSessionID).setVisible(true);
            this.dispose();
        }else{
            new step1_enroll(userSessionID).setVisible(true);
            this.dispose();
        }      
    }//GEN-LAST:event_btnEnrollActionPerformed

    private void btnPersonalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMouseReleased
        btnPersonal.setContentAreaFilled(false);
    }//GEN-LAST:event_btnPersonalMouseReleased

    private void btnEnrollMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollMouseReleased
        btnEnroll.setContentAreaFilled(false);
    }//GEN-LAST:event_btnEnrollMouseReleased

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setBorderPainted(true);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setBorderPainted(false);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        btnBack.setContentAreaFilled(true);
    }//GEN-LAST:event_btnBackMousePressed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new Dashboard(userSessionID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard(userSessionID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEnroll;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnSubject;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}