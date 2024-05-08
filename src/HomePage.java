/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Jaden
 */
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    String enrollmentStatus;
    static int userSessionID;

    public HomePage(int userSessionID) {
        initComponents();
        {
            jButton1.setOpaque(false); // Make the button transparent
            jButton1.setContentAreaFilled(false); // Don't fill the button area with background
            jButton1.setBorderPainted(false); // Remove the default button border
            jButton1.setForeground(Color.WHITE); // Set text color
            jButton1.setFocusPainted(false); // Remove focus border
            jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            jButton3.setOpaque(false); // Make the button transparent
            jButton3.setContentAreaFilled(false); // Don't fill the button area with background
            jButton3.setBorderPainted(false); // Remove the default button border
            jButton3.setForeground(Color.WHITE); // Set text color
            jButton3.setFocusPainted(false); // Remove focus border
            jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            jButton4.setOpaque(false); // Make the button transparent
            jButton4.setContentAreaFilled(false); // Don't fill the button area with background
            jButton4.setBorderPainted(false); // Remove the default button border
            jButton4.setForeground(Color.WHITE); // Set text color
            jButton4.setFocusPainted(false); // Remove focus border
            jButton4.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            jButton5.setOpaque(false); // Make the button transparent
            jButton5.setContentAreaFilled(false); // Don't fill the button area with background
            jButton5.setBorderPainted(false); // Remove the default button border
            jButton5.setForeground(Color.WHITE); // Set text color
            jButton5.setFocusPainted(false); // Remove focus border
            jButton5.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        this.userSessionID = userSessionID;
        jLabel2.setText("ID IS " + HomePage.userSessionID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton5.setText("ACADEMICS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 98, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton3.setText("ABOUT BULSU");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 98, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton1.setText("DASHBOARD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 98, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton4.setText("ENROLLMENT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 98, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_HomePage.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new aboutbulsu(userSessionID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sqlEnrollmentStatus = "SELECT EnrollmentStatus FROM STUDENT WHERE UserID = ?";
            PreparedStatement preparedStatementEnrollmentStatus = conn.prepareStatement(sqlEnrollmentStatus);
            preparedStatementEnrollmentStatus.setInt(1, userSessionID);
            ResultSet resultSetEnrollmentStatus = preparedStatementEnrollmentStatus.executeQuery();

            if (resultSetEnrollmentStatus.next()) {
                enrollmentStatus = resultSetEnrollmentStatus.getString("EnrollmentStatus");
                if (!enrollmentStatus.equalsIgnoreCase("enrolled")) {
                    new step1_enroll(userSessionID).setVisible(true);
                    this.dispose();
                }else{
                    new step5_enroll(userSessionID).setVisible(true);
                    this.dispose();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new academics(userSessionID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage(userSessionID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
