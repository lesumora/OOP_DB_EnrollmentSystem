package Home;


import Home.AcademicsPage;
import Authentication.LoginPage;
import Home.HomePage;
import java.awt.Color;
import java.awt.Cursor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author acer
 */
public class AboutBulsuPage extends javax.swing.JFrame {

    /**
     * Creates new form AboutBulsuPage
     */
    static int userSessionID;
    
    public AboutBulsuPage(int userSessionID) {
        initComponents();
        this.userSessionID = userSessionID;
        
        {
        btnHome.setOpaque(false); // Make the button transparent
        btnHome.setContentAreaFilled(false); // Don't fill the button area with background
        btnHome.setBorderPainted(false); // Remove the default button border
        btnHome.setForeground(Color.WHITE); // Set text color
        btnHome.setFocusPainted(false); // Remove focus border
        btnHome.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
        btnAcademics.setOpaque(false); // Make the button transparent
        btnAcademics.setContentAreaFilled(false); // Don't fill the button area with background
        btnAcademics.setBorderPainted(false); // Remove the default button border
        btnAcademics.setForeground(Color.WHITE); // Set text color
        btnAcademics.setFocusPainted(false); // Remove focus border
        btnAcademics.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
        btnAboutBulsu.setOpaque(false); // Make the button transparent
        btnAboutBulsu.setContentAreaFilled(false); // Don't fill the button area with background
        btnAboutBulsu.setBorderPainted(false); // Remove the default button border
        btnAboutBulsu.setForeground(Color.WHITE); // Set text color
        btnAboutBulsu.setFocusPainted(false); // Remove focus border
        btnAboutBulsu.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
        btnLogout.setOpaque(false); // Make the button transparent
        btnLogout.setContentAreaFilled(false); // Don't fill the button area with background
        btnLogout.setBorderPainted(false); // Remove the default button border
        btnLogout.setForeground(Color.WHITE); // Set text color
        btnLogout.setFocusPainted(false); // Remove focus border
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnAcademics = new javax.swing.JButton();
        btnAboutBulsu = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1250, 2652));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 98, -1, -1));

        btnAcademics.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnAcademics.setText("ACADEMICS");
        btnAcademics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcademicsActionPerformed(evt);
            }
        });
        jPanel1.add(btnAcademics, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 98, -1, -1));

        btnAboutBulsu.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnAboutBulsu.setText("ABOUT BULSU");
        btnAboutBulsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutBulsuActionPerformed(evt);
            }
        });
        jPanel1.add(btnAboutBulsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 98, -1, -1));

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 98, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_AboutBulsu1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_AboutBulsu2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_AboutBulsu3.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1330, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_AboutBulsu4.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2030, -1, 620));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        new HomePage(userSessionID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnAcademicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcademicsActionPerformed
        new AcademicsPage(userSessionID).setVisible(true);
        this.dispose();
        /*try {
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
        }*/
    }//GEN-LAST:event_btnAcademicsActionPerformed

    private void btnAboutBulsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutBulsuActionPerformed
        
    }//GEN-LAST:event_btnAboutBulsuActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(AboutBulsuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutBulsuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutBulsuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutBulsuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutBulsuPage(userSessionID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAboutBulsu;
    private javax.swing.JButton btnAcademics;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}