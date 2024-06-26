package Admin.AdminFunctions;

import Authentication.ForgotPassword;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Jaden
 */
public class AdminAdd extends javax.swing.JFrame {

    /**
     * Creates new form AdminAdd
     */
    final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    String email, username, password, confirmPassword;

    public AdminAdd() {
        initComponents();
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
        tfEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        pfConfirmPassword = new javax.swing.JPasswordField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Admin Account");
        setIconImage(getIconImage());
        setResizable(false);

        jLabel1.setText("Email");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Confirm Password");

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(tfEmail)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pfConfirmPassword)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Get field values
        email = tfEmail.getText();
        username = tfUsername.getText();
        password = pfPassword.getText();
        confirmPassword = pfConfirmPassword.getText();

        // Validate
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            if (email.isBlank() || username.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Ooops!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Invalid email");
                return;
            }

            // Check if email is taken
            if (isEmailTaken(email)) {
                JOptionPane.showMessageDialog(this, "Email is already taken");
                return;
            }

            // Check if username is taken
            if (isUsernameTaken(username)) {
                JOptionPane.showMessageDialog(this, "Username is already taken");
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Password do not match");
                return;
            }
           
            // Insert data to database
            String sqlAdminAdd = "insert into ACCOUNT (Username, UserPassword, Email, UserType) values (?, ?, ?, ?)";
            PreparedStatement preparedStatementAdminAdd = conn.prepareStatement(sqlAdminAdd, Statement.RETURN_GENERATED_KEYS);
            preparedStatementAdminAdd.setString(1, username);
            preparedStatementAdminAdd.setString(2, password);
            preparedStatementAdminAdd.setString(3, email);
            preparedStatementAdminAdd.setString(4, "administrator");

            int rowsInserted = preparedStatementAdminAdd.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = preparedStatementAdminAdd.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int userId = generatedKeys.getInt(1);
                    new ForgotPassword(userId).setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private boolean isValidEmail(String email) {
        // Regular expression for email validation
        String regex = "^[a-zA-Z0-9._!#$%&'*+/=?`{|}~-]+@(?:[a-zA-Z0-9-]+\\.)*gmail\\.com$";
        return email.matches(regex);
    }

    private boolean isEmailTaken(String email) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); PreparedStatement stmt = conn.prepareStatement("SELECT 1 FROM ACCOUNT WHERE Email = ?")) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Returns true if email exists
            }
        }
    }

    private boolean isUsernameTaken(String username) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); PreparedStatement stmt = conn.prepareStatement("SELECT 1 FROM ACCOUNT WHERE Username = ?")) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Returns true if username exists
            }
        }
    }

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
            java.util.logging.Logger.getLogger(AdminAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfConfirmPassword;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
