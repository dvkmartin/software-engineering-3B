/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inse_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * @author UP735175
 * @author UP762633
 * @author UP775061
 * @author UP759167
 * @author UP784356
 */
public class BookMeeting extends javax.swing.JFrame {

    Mysql mysql = new Mysql("213.131.183.194", "insedb", "INSE", "INSE3B");
    String UserEmail = "";
    String Person = "";

    /**
     * BookMeeting constructor
     *
     * @param email (String) logged in user email
     * @param person (String) user to book meeting with
     */
    public BookMeeting(String email, String person) {
        initComponents();
        UserEmail = email;
        Person = person;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtEnd = new javax.swing.JTextField();
        TxtStart = new javax.swing.JTextField();
        TxtDate = new javax.swing.JTextField();
        TxtDesc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Book A Meeting");

        TxtEnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtEndKeyTyped(evt);
            }
        });

        TxtStart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtStartKeyTyped(evt);
            }
        });

        TxtDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDateKeyTyped(evt);
            }
        });

        TxtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDescKeyTyped(evt);
            }
        });

        jLabel5.setText("Description:");

        jLabel9.setText("In the format YYYYMMDD e.g 20170206");

        jLabel4.setText("End Time:");

        jLabel8.setText("In the formart HH:MM e.g 12:27");

        jLabel3.setText("Start Time:");

        jLabel7.setText("In the formart HH:MM e.g 11:27");

        jLabel2.setText("Event Date:");

        BtnCreate.setText("Create New Event");
        BtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TxtDesc)
                            .addGap(143, 143, 143))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TxtStart, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                        .addComponent(TxtEnd))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9)))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(BtnCreate)
                .addGap(80, 80, 80))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(TxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(TxtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(TxtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addContainerGap(141, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtEndKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEndKeyTyped
        if (TxtEnd.getText().length() >= 5) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtEndKeyTyped

    private void TxtStartKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtStartKeyTyped
        if (TxtStart.getText().length() >= 5) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtStartKeyTyped

    private void TxtDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDateKeyTyped
        if (TxtDate.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtDateKeyTyped

    private void TxtDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDescKeyTyped
        if (TxtDesc.getText().length() >= 500) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtDescKeyTyped

    private void BtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreateActionPerformed
        boolean proceed = true;
        Pattern TimeVal = Pattern.compile("^(([0-9])|([0-1][0-9])|([2][0-3])):(([0-9])|([0-5][0-9]))$");
        String startTime = "";
        String endTime = "";
        for (String digits : TxtStart.getText().split(":")) {
            startTime += digits;
        }
        for (String digits : TxtEnd.getText().split(":")) {
            endTime += digits;
        }

        if (Integer.parseInt(TxtDate.getText()) < Integer.parseInt(BookingForm.today)) {
            int reply = JOptionPane.showConfirmDialog(this, "The date is set in the past are you sure you want to proceed?", "Date Warning", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                proceed = true;
            } else {
                proceed = false;
            }
        }
        if (proceed == true) {
            if (TimeVal.matcher(TxtStart.getText()).matches() == true && TimeVal.matcher(TxtEnd.getText()).matches() == true) {
                if (Integer.parseInt(startTime) < Integer.parseInt(endTime)) {

                    if (checkTime(TxtStart.getText(), TxtEnd.getText()) == true) {
                        ResultSet eventUpdate = mysql.insert(Person, TxtDate.getText(), TxtStart.getText(), TxtEnd.getText(), TxtDesc.getText(), "", "", BookingForm.searchDate);
                        ResultSet eventUpdate2 = mysql.insert(UserEmail, TxtDate.getText(), TxtStart.getText(), TxtEnd.getText(), TxtDesc.getText(), "", "", BookingForm.searchDate);
                        BookingForm.FillTable(eventUpdate);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "These times would clash with an existing appointment", "Meeting collision Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "The end time must be greater than the start time", "Time Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a valid time", "Time Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_BtnCreateActionPerformed

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
            java.util.logging.Logger.getLogger(BookMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookMeeting("Test@Test.com", "Test2@test.com").setVisible(true);
            }
        });
    }

    private boolean checkTime(String start, String end) {
        boolean viable = true;
        String newstart = start.substring(0, 2) + start.substring(3);
        newstart = newstart.substring(0, 4);
        String newend = start.substring(0, 2) + start.substring(3);
        newend = newend.substring(0, 4);
        for (int i = 0; i < BookingForm.startTime.size(); i++) {
            if (Integer.parseInt(newstart) >= Integer.parseInt(BookingForm.startTime.get(i)) && Integer.parseInt(newstart) <= Integer.parseInt(BookingForm.endTime.get(i))) {
                viable = false;
            } else {
                viable = true;
            }
            if (Integer.parseInt(newend) >= Integer.parseInt(BookingForm.startTime.get(i)) && Integer.parseInt(newend) <= Integer.parseInt(BookingForm.endTime.get(i))) {
                viable = false;
            } else {
                viable = true;
            }
            if (Integer.parseInt(newstart) <= Integer.parseInt(BookingForm.startTime.get(i)) && Integer.parseInt(newend) >= Integer.parseInt(BookingForm.endTime.get(i))) {
                viable = false;
            } else {
                viable = true;
            }
        }
        return viable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCreate;
    private javax.swing.JTextField TxtDate;
    private javax.swing.JTextField TxtDesc;
    private javax.swing.JTextField TxtEnd;
    private javax.swing.JTextField TxtStart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
