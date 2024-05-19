package Authentication;

import Home.HomePage;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author acer
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    private int loginAttempt = 0;
    private int userSessionID;

    public LoginPage() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        pf_password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, -1, -1));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 270, 37));
        getContentPane().add(pf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 270, 37));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Forgot Password?");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Click me!");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, -1, -1));

        btnLogin.setBackground(new java.awt.Color(204, 0, 51));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("SIGN IN");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 270, 40));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Don't have an account yet?");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sign up");
        jLabel3.setToolTipText("");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 580, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_LoginPage.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Get field values
        String username = txt_username.getText();
        String password = pf_password.getText();
        
        // Validate
        if(isValidUsername(username) && isValidPassword(password)){
            getAuthenticatedUser(username, password);
        }else{
            JOptionPane.showMessageDialog(this, "Invalid username or password format.");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        new RegistrationPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        new RecoverPage().setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    // Method for authentication
    private void getAuthenticatedUser(String username, String password) {
        final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
        final String USERNAME = "admin";
        final String PASSWORD = "admin";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Succesfully connected to database...

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Check if user is blocked
            String sqlBlockedCheck = "SELECT UserId, UserBlocked FROM ACCOUNT WHERE Username = ?";
            PreparedStatement preparedStatementBlockedCheck = conn.prepareStatement(sqlBlockedCheck);
            preparedStatementBlockedCheck.setString(1, username);

            ResultSet resultSetBlockedCheck = preparedStatementBlockedCheck.executeQuery();

            if (resultSetBlockedCheck.next()) {
                int UserId = resultSetBlockedCheck.getInt("UserId");
                boolean isBlocked = resultSetBlockedCheck.getBoolean("UserBlocked");

                // Get the current date and time
                LocalDateTime now = LocalDateTime.now();
                // Convert LocalDateTime to java.sql.Timestamp
                Timestamp currentTimestamp = Timestamp.valueOf(now);

                String sqlLogs = "INSERT INTO USER_LOG (UserId, UserAction, ActionDate) VALUES (?,?,?)";
                PreparedStatement preparedStatementLogs = conn.prepareStatement(sqlLogs);
                preparedStatementLogs.setInt(1, UserId);
                preparedStatementLogs.setString(2, "Login");
                preparedStatementLogs.setTimestamp(3, currentTimestamp);

                int rowsInserted = preparedStatementLogs.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("User log was inserted successfully.");
                } else {
                    System.out.println("Sum went wrong homes.");
                }

                if (isBlocked) {
                    JOptionPane.showMessageDialog(null, "User is blocked for exceeding login attempt limit. "
                            + "You may contact an administrator to get your account unblocked.");
                    return;
                }
            }

            // Checks if user exists
            String sqlCredential = "SELECT * FROM ACCOUNT WHERE Username = ? AND UserPassword = ?";
            PreparedStatement preparedStatementCredential = conn.prepareStatement(sqlCredential);
            preparedStatementCredential.setString(1, username);
            preparedStatementCredential.setString(2, password);

            ResultSet resultSetCredential = preparedStatementCredential.executeQuery();

            if (resultSetCredential.next()) {
                Object isBlocked = resultSetCredential.getObject(4);
                if (isBlocked.equals("false")) {
                    userSessionID = resultSetCredential.getInt("UserID");
                    JOptionPane.showMessageDialog(null, "Login Successful.");
                    loginAttempt = 0;
                    HomePage homePage = new HomePage(userSessionID);
                    homePage.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, """
                                                        User was blocked for exceeding login attempt limit.
                                                        You may contact an administrator to get your account unblocked.
                                                        """);
                }
            } else {
                // Handles if user exceeds login limit
                loginAttempt++;
                if (loginAttempt == 3) {
                    String sqlBlocked = "UPDATE ACCOUNT set userBlocked = 'true' WHERE username = ?";
                    PreparedStatement preparedStatementBlocked = conn.prepareStatement(sqlBlocked);
                    preparedStatementBlocked.setString(1, username);

                    int rowsUpdated = preparedStatementBlocked.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, """
                                    Account blocked for exceeding login attempt limit.
                                    You may contact an ADMINISTRATOR to get your account unblocked.
                                    """);
                        loginAttempt = 0;
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update account status.\nUser may not be existing.");
                        loginAttempt = 0;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Username or password is incorrect.\nAttempt " + loginAttempt + " of 3.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private boolean isValidUsername(String username) {
        // Regular expression for username validation
        String regex = "^(?=[A-Za-z0-9]{8}$)(?=(?:.*\\d){2})[A-Za-z0-9]+$";
        return username.matches(regex);
    }
    
    private boolean isValidPassword(String password) {
        // Regular expression for password validation
        String regex = "^(?=[A-Za-z0-9]{8}$)(?=(?:.*\\d){2})[A-Za-z0-9]+$";
        return password.matches(regex);
    }
    
    public void setUserSessionID(int userSessionID) {
        this.userSessionID = userSessionID;
    }

    public int getUserSessionID() {
        return userSessionID;
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
