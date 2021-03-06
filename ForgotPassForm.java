/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inse_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author UP735175
 * @author UP762633
 * @author UP775061
 * @author UP759167
 * @author UP784356
 */
public class ForgotPassForm extends javax.swing.JFrame {
    Mysql mysql = new Mysql("213.131.183.194", "insedb", "INSE", "INSE3B");
    /**
     * Creates new form ForgotPassForm
     */
    public ForgotPassForm() {
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

        description2Label = new javax.swing.JLabel();
        description1Label = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        reqEmailLabel = new javax.swing.JLabel();
        requestPassBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Reset");

        description2Label.setText("*Your password will be sent to the email you registered with.");

        description1Label.setText("Enter the email address you registered your account with below. ");

        reqEmailLabel.setText("Email address: ");

        requestPassBtn.setText("Request password*");
        requestPassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestPassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(description1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(reqEmailLabel)
                        .addGap(18, 18, 18)
                        .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(requestPassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(description2Label)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(description1Label)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqEmailLabel))
                .addGap(43, 43, 43)
                .addComponent(requestPassBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(description2Label)
                .addGap(39, 39, 39))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void requestPassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestPassBtnActionPerformed
         boolean result;
        result = mysql.forgot(TxtEmail.getText());
        if (result == true) {
            resetPass();
            JOptionPane.showMessageDialog(this, "Email Sent!", "Success", JOptionPane.INFORMATION_MESSAGE);
            new MainMenu().setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "No User Found", "User Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_requestPassBtnActionPerformed

 
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
            java.util.logging.Logger.getLogger(ForgotPassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassForm().setVisible(true);
            }
        });
    }
    
    /**
     * This function will check the DB for a user and then email them their password
     */
    private void resetPass(){
        String pass ="";
        try {
            ResultSet rs = mysql.getPass(TxtEmail.getText());
            while (rs.next()) {
               pass = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        Email mail = new Email();
            mail.Email(TxtEmail.getText(),
                "Forgotten Password",
                pass,
                "Your Password is: ");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JLabel description1Label;
    private javax.swing.JLabel description2Label;
    private javax.swing.JLabel reqEmailLabel;
    private javax.swing.JButton requestPassBtn;
    // End of variables declaration//GEN-END:variables
}
