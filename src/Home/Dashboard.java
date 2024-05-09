package Home;

import Admin.AdminDashboard;

import java.awt.Color;
import java.awt.Cursor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Jaden
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        {
            btnAdmin.setOpaque(false); // Make the button transparent
            btnAdmin.setContentAreaFilled(false); // Don't fill the button area with background
            btnAdmin.setBorderPainted(false); // Remove the default button border
            btnAdmin.setForeground(Color.WHITE); // Set text color
            btnAdmin.setFocusPainted(false); // Remove focus border
            btnAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnStudent.setOpaque(false); // Make the button transparent
            btnStudent.setContentAreaFilled(false); // Don't fill the button area with background
            btnStudent.setBorderPainted(false); // Remove the default button border
            btnStudent.setForeground(Color.WHITE); // Set text color
            btnStudent.setFocusPainted(false); // Remove focus border
            btnStudent.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnFaculty.setOpaque(false); // Make the button transparent
            btnFaculty.setContentAreaFilled(false); // Don't fill the button area with background
            btnFaculty.setBorderPainted(false); // Remove the default button border
            btnFaculty.setForeground(Color.WHITE); // Set text color
            btnFaculty.setFocusPainted(false); // Remove focus border
            btnFaculty.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
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

        btnFaculty = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFaculty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        btnFaculty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFacultyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFacultyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFacultyMousePressed(evt);
            }
        });
        btnFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacultyActionPerformed(evt);
            }
        });
        getContentPane().add(btnFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 234, 244, 262));

        btnStudent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        btnStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStudentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnStudentMousePressed(evt);
            }
        });
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        getContentPane().add(btnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 234, 244, 262));

        btnAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        btnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdminMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAdminMousePressed(evt);
            }
        });
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 234, 245, 262));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_Dashboard.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        new AdminDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseEntered
        btnAdmin.setBorderPainted(true);
    }//GEN-LAST:event_btnAdminMouseEntered

    private void btnAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseExited
        btnAdmin.setBorderPainted(false);
    }//GEN-LAST:event_btnAdminMouseExited

    private void btnAdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMousePressed
        btnAdmin.setContentAreaFilled(true);
    }//GEN-LAST:event_btnAdminMousePressed

    private void btnStudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentMouseEntered
        btnStudent.setBorderPainted(true);
    }//GEN-LAST:event_btnStudentMouseEntered

    private void btnStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentMouseExited
        btnStudent.setBorderPainted(false);
    }//GEN-LAST:event_btnStudentMouseExited

    private void btnStudentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentMousePressed
        btnStudent.setContentAreaFilled(true);
    }//GEN-LAST:event_btnStudentMousePressed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnFacultyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacultyMouseEntered
        btnFaculty.setBorderPainted(true);
    }//GEN-LAST:event_btnFacultyMouseEntered

    private void btnFacultyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacultyMouseExited
        btnFaculty.setBorderPainted(false);
    }//GEN-LAST:event_btnFacultyMouseExited

    private void btnFacultyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacultyMousePressed
        btnFaculty.setContentAreaFilled(true);
    }//GEN-LAST:event_btnFacultyMousePressed

    private void btnFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacultyActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnFaculty;
    private javax.swing.JButton btnStudent;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
