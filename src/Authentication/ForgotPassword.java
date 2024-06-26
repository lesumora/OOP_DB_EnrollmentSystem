/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaden
 */
public class ForgotPassword extends javax.swing.JFrame {

    /**
     * Creates new form ForgotPassword
     */
    final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    String question, answer;
    static int userId;

    public ForgotPassword(int userId) {
        initComponents();
        this.userId = userId;

        question = (String) cbQuestion.getSelectedItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbQuestion = new javax.swing.JComboBox<>();
        tfAnswer = new javax.swing.JTextField();
        btnFinish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Security Question");
        setFocusCycleRoot(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cbQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name of the teacher has you scared for your life?", "In what city did your parents meet?", "What is your favorite movie that you watched as a child?", "What was the name of your first-grade teacher?", "That one moment you'll never forget?" }));

        btnFinish.setText("FINISH");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAnswer))
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(btnFinish)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinish)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Set new forgot password way
    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        question = (String) cbQuestion.getSelectedItem();
        answer = tfAnswer.getText();

        if (answer.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter an answer");
            return;
        }

        // Valiadation
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sqlRegister = "insert into FORGOT_PASSWORD "
                    + "values (?, ?, ?)";
            PreparedStatement preparedStatementRegister = conn.prepareStatement(sqlRegister, new String[]{"UserID"});
            preparedStatementRegister.setInt(1, userId);
            preparedStatementRegister.setString(2, question);
            preparedStatementRegister.setString(3, answer);

            int rowsInserted = preparedStatementRegister.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Successfully added a new account");

                // Get the current date and time
                LocalDateTime now = LocalDateTime.now();
                // Convert LocalDateTime to java.sql.Timestamp
                Timestamp currentTimestamp = Timestamp.valueOf(now);

                String sqlInsertLog = "insert into USER_LOG (UserID, UserAction, ActionDate) values (?,?,?)";
                PreparedStatement preparedStatementInsertLog = conn.prepareStatement(sqlInsertLog);
                preparedStatementInsertLog.setInt(1, userId);
                preparedStatementInsertLog.setString(2, "Added new account");
                preparedStatementInsertLog.setTimestamp(3, currentTimestamp);

                int insertedRow = preparedStatementInsertLog.executeUpdate();
                if (insertedRow > 0) {
                    System.out.println("User log updated");
                }

                this.dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnFinishActionPerformed

    // Checks for form close
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?\nThis will cancel your registration",
                "Confirm Exit", JOptionPane.YES_NO_OPTION);
        
        // If user exits, cancels the account creation
        if (choice == JOptionPane.YES_OPTION) {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                String sqlDelete = "update ACCOUNT set UserDeleted = ? "
                        + "where UserID = ?";
                PreparedStatement preparedStatementRegister = conn.prepareStatement(sqlDelete);
                preparedStatementRegister.setString(1, "true");
                preparedStatementRegister.setInt(2, userId);

                int rowsDeleted = preparedStatementRegister.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Account creation cancelled brpo");
                } else {
                    System.out.println("No account deleted somehow");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }

            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JComboBox<String> cbQuestion;
    private javax.swing.JTextField tfAnswer;
    // End of variables declaration//GEN-END:variables
}
