/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Faculty;

import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author Jaden
 */
public class DashboardDean extends javax.swing.JFrame {

    /**
     * Creates new form DashboardDean
     */
    static int userSessionId;
    
    public DashboardDean(int userSessionId) {
        initComponents();
        this.userSessionId = userSessionId;
        
        {
            btnBack.setOpaque(false); // Make the button transparent
            btnBack.setContentAreaFilled(false); // Don't fill the button area with background
            btnBack.setBorderPainted(false); // Remove the default button border
            btnBack.setForeground(Color.WHITE); // Set text color
            btnBack.setFocusPainted(false); // Remove focus border
            btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnSubject.setOpaque(false); // Make the button transparent
            btnSubject.setContentAreaFilled(false); // Don't fill the button area with background
            btnSubject.setBorderPainted(false); // Remove the default button border
            btnSubject.setForeground(Color.WHITE); // Set text color
            btnSubject.setFocusPainted(false); // Remove focus border
            btnSubject.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
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

        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnSubject = new javax.swing.JButton();
        btnFaculty = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
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

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 135, -1, 20));

        btnSubject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 3, true));
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSubjectMouseReleased(evt);
            }
        });
        btnSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 270, 245, 271));

        btnFaculty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 3, true));
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
        getContentPane().add(btnFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 270, 245, 271));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_DashboardDean.png"))); // NOI18N
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
        new FacultyManagement(userSessionId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFacultyActionPerformed

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
        new DashboardFaculty(userSessionId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubjectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubjectMouseReleased
        btnBack.setContentAreaFilled(false);
    }//GEN-LAST:event_btnSubjectMouseReleased

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
            java.util.logging.Logger.getLogger(DashboardDean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardDean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardDean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardDean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardDean(userSessionId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFaculty;
    private javax.swing.JButton btnSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
