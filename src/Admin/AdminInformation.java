package Admin;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author acer
 */
public class AdminInformation extends javax.swing.JFrame {

    /**
     * Creates new form admin1
     */
    final String DB_URL = "jdbc:sqlserver://localhost\\DESKTOP-FT3D7QK:1433;databaseName=enrollment;encrypt=true;trustServerCertificate=true";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    static int userSessionID, accountId;
    String search, username, password, userBlocked, email, userType;
    int userId;
    DefaultTableModel model = new DefaultTableModel();
     List<Boolean> multipleSelectedCheck = new ArrayList<>();

    public AdminInformation(int userSessionID) {
        initComponents();
        this.userSessionID = userSessionID;
        {
            btnAdd.setOpaque(false); // Make the button transparent
            btnAdd.setContentAreaFilled(false); // Don't fill the button area with background
            btnAdd.setBorderPainted(false); // Remove the default button border
            btnAdd.setFocusPainted(false); // Remove focus border
            btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnUpdate.setOpaque(false); // Make the button transparent
            btnUpdate.setContentAreaFilled(false); // Don't fill the button area with background
            btnUpdate.setBorderPainted(false); // Remove the default button border
            btnUpdate.setFocusPainted(false); // Remove focus border
            btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnRemove.setOpaque(false); // Make the button transparent
            btnRemove.setContentAreaFilled(false); // Don't fill the button area with background
            btnRemove.setBorderPainted(false); // Remove the default button border
            btnRemove.setFocusPainted(false); // Remove focus border
            btnRemove.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }

        model = (DefaultTableModel) jTable1.getModel();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Succesfully connected to database...

            String sqlUpdateAdmin = "select * from ACCOUNT where UserType = ? and UserDeleted = ? and not(UserID = ?)";
            PreparedStatement preparedStatementUpdateAdmin = conn.prepareStatement(sqlUpdateAdmin);
            preparedStatementUpdateAdmin.setString(1, "administrator");
            preparedStatementUpdateAdmin.setString(2, "false");
            preparedStatementUpdateAdmin.setInt(3, userSessionID);
            ResultSet resultSetAdmin = preparedStatementUpdateAdmin.executeQuery();

            while (resultSetAdmin.next()) {
                Object[] row = new Object[7];
                row[0] = false;
                row[1] = resultSetAdmin.getObject("UserID");
                row[2] = resultSetAdmin.getObject("Username");
                row[3] = resultSetAdmin.getObject("UserPassword");
                row[4] = resultSetAdmin.getObject("UserBlocked");
                row[5] = resultSetAdmin.getObject("Email");
                row[6] = resultSetAdmin.getObject("UserType");
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // Search button
    public AdminInformation(int userSessionID, int userId, String username, String password, String userBlocked, String email, String userType){
        initComponents();
        this.userSessionID = userSessionID;
        {
            btnAdd.setOpaque(false); // Make the button transparent
            btnAdd.setContentAreaFilled(false); // Don't fill the button area with background
            btnAdd.setBorderPainted(false); // Remove the default button border
            btnAdd.setFocusPainted(false); // Remove focus border
            btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnUpdate.setOpaque(false); // Make the button transparent
            btnUpdate.setContentAreaFilled(false); // Don't fill the button area with background
            btnUpdate.setBorderPainted(false); // Remove the default button border
            btnUpdate.setFocusPainted(false); // Remove focus border
            btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        {
            btnRemove.setOpaque(false); // Make the button transparent
            btnRemove.setContentAreaFilled(false); // Don't fill the button area with background
            btnRemove.setBorderPainted(false); // Remove the default button border
            btnRemove.setFocusPainted(false); // Remove focus border
            btnRemove.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor
        }
        
        model = (DefaultTableModel) jTable1.getModel();
        
        Object[] row = new Object[7];
                row[0] = false;
                row[1] = userId;
                row[2] = username;
                row[3] = password;
                row[4] = userBlocked;
                row[5] = email;
                row[6] = userType;
                model.addRow(row);
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
        tfSearch = new javax.swing.JTextField();
        btnGo = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 67, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Type in the username you want to search.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        tfSearch.setToolTipText("email");
        tfSearch.setName(""); // NOI18N
        getContentPane().add(tfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 280, 30));

        btnGo.setText("GO");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 60, 30));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, -1, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "UserID", "Username", "Password", "User Blocked", "Email", "User Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 830, 360));

        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 4, true));
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddMouseReleased(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 370, 207, 46));

        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 4, true));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUpdateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUpdateMouseReleased(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 425, 207, 46));

        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 4, true));
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoveMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRemoveMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRemoveMouseReleased(evt);
            }
        });
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(936, 482, 209, 48));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg_AdminInformation.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new AdminAdd().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        btnAdd.setBorderPainted(true);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        btnAdd.setBorderPainted(false);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMousePressed
        btnAdd.setContentAreaFilled(true);
    }//GEN-LAST:event_btnAddMousePressed

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setBorderPainted(true);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBorderPainted(false);
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMousePressed
        btnUpdate.setContentAreaFilled(true);
    }//GEN-LAST:event_btnUpdateMousePressed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Boolean isSelected = (Boolean) jTable1.getValueAt(i, 0);
            if (isSelected != null && isSelected) {
                accountId = (int) jTable1.getValueAt(i, 1);
                multipleSelectedCheck.add(isSelected);
            }
        }
        System.out.println(multipleSelectedCheck);

        int numberOfSelected = multipleSelectedCheck.size();
        switch (numberOfSelected) {
            case 1 ->
                new AdminUpdateAdmin(accountId).setVisible(true);
            case 0 ->
                JOptionPane.showMessageDialog(this, "No account selected.");
            default ->
                JOptionPane.showMessageDialog(this, "Select only one (1) account to update.");
        }
        System.out.println(accountId);
        multipleSelectedCheck.clear();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseEntered
        btnRemove.setBorderPainted(true);
    }//GEN-LAST:event_btnRemoveMouseEntered

    private void btnRemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseExited
        btnRemove.setBorderPainted(false);
    }//GEN-LAST:event_btnRemoveMouseExited

    private void btnRemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMousePressed
        btnRemove.setContentAreaFilled(true);
    }//GEN-LAST:event_btnRemoveMousePressed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Boolean isSelected = (Boolean) jTable1.getValueAt(i, 0);
            if (isSelected != null && isSelected) {
                accountId = (int) jTable1.getValueAt(i, 1);
                multipleSelectedCheck.add(isSelected);
            }
        }
        System.out.println(multipleSelectedCheck);

        int numberOfSelected = multipleSelectedCheck.size();
        switch (numberOfSelected) {
            case 1 -> {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Deleting account\nDo you want to PROCEED?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    try {
                        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                        // Delete account from accounts table
                        String deleteAccountSQL = "update ACCOUNT set UserDeleted = ? WHERE UserID = ?";
                        PreparedStatement deleteAccountStatement = conn.prepareStatement(deleteAccountSQL);
                        deleteAccountStatement.setString(1, "true");
                        deleteAccountStatement.setInt(2, accountId);
                        int accountsDeleted = deleteAccountStatement.executeUpdate();

                        // Check if any records were deleted
                        if (accountsDeleted > 0) {
                            JOptionPane.showMessageDialog(this, "Account deleted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(this, "No account found with ID: " + accountId);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error deleting account: " + e.getMessage());
                    }
                }
            }
            case 0 ->
                JOptionPane.showMessageDialog(this, "No account selected.");
            default ->
                JOptionPane.showMessageDialog(this, "Dangerous to delete multiple accounts.\nSelect only one (1) account to delete.");
        }
        System.out.println(accountId);
        multipleSelectedCheck.clear();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseReleased
        btnAdd.setContentAreaFilled(false);
    }//GEN-LAST:event_btnAddMouseReleased

    private void btnUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseReleased
        btnUpdate.setContentAreaFilled(false);
    }//GEN-LAST:event_btnUpdateMouseReleased

    private void btnRemoveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseReleased
        btnRemove.setContentAreaFilled(false);
    }//GEN-LAST:event_btnRemoveMouseReleased

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        new AdminInformation(userSessionID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new AdminDashboard(userSessionID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
        if (!tfSearch.getText().isBlank()){
            search = tfSearch.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Field is empty");
            return;
        }
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Succesfully connected to database...

            String sqlUsername = "select * from ACCOUNT where username = ? and UserType = ?";
            PreparedStatement preparedStatementUsername = conn.prepareStatement(sqlUsername);
            preparedStatementUsername.setString(1, search);
            preparedStatementUsername.setString(2, "administrator");
            ResultSet resultSetUsername = preparedStatementUsername.executeQuery();

            if (resultSetUsername.next()) {
                userId = resultSetUsername.getInt("UserID");
                username = resultSetUsername.getString("Username");   
                password = resultSetUsername.getString("UserPassword");
                userBlocked = resultSetUsername.getString("UserBlocked");
                email = resultSetUsername.getString("Email");
                userType = resultSetUsername.getString("UserType");
            }else {
                JOptionPane.showMessageDialog(this, "User not found");
                return;
            }
            new AdminInformation(userSessionID, userId, username, password, userBlocked, email, userType).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
        
    }//GEN-LAST:event_btnGoActionPerformed

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
            java.util.logging.Logger.getLogger(AdminInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminInformation(userSessionID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
