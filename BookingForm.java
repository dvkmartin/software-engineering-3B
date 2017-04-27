/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inse_app;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author UP735175
 * @author UP762633
 * @author UP775061
 * @author UP759167
 * @author UP784356
 */
public class BookingForm extends javax.swing.JFrame implements ListSelectionListener {

    Mysql mysql = new Mysql("213.131.183.194", "insedb", "INSE", "INSE3B");
    static String searchDate = "20170101";
    String UserEmail = "";
    ArrayList<String> users = new ArrayList<>();
    ArrayList<String> emails = new ArrayList<>();
    static ArrayList<String> startTime = new ArrayList<>();
    static ArrayList<String> endTime = new ArrayList<>();
    String Person = "";
    static String today = "";

    /**
     * Creates new form Booking
     *
     * @param email allows for passing of user email throughout
     */
    public BookingForm(String email) {
        UserEmail = email;
        initComponents();
        TableData.getSelectionModel().addListSelectionListener(this);
        FillYear();
        fetchUsers();
        FillPersons();
        searchDB();
        today = getSearchYr();
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
        CmbDay = new javax.swing.JComboBox();
        CmbMnth = new javax.swing.JComboBox();
        CmbYr = new javax.swing.JComboBox();
        BtnBook = new javax.swing.JButton();
        BtnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableData = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        CmbPerson = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Meetings");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Date:");

        CmbDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        CmbDay.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CmbDayPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        CmbMnth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        CmbMnth.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CmbMnthPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        CmbYr.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CmbYrPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        BtnBook.setText("Book Meeting");
        BtnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBookActionPerformed(evt);
            }
        });

        BtnSearch.setText("Search");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        TableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Start Time", "End Time", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableData.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableData);

        jLabel2.setText("Person:");

        CmbPerson.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CmbPersonPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CmbPerson, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CmbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CmbMnth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CmbYr, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnBook)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CmbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbMnth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbYr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBook)
                    .addComponent(BtnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CmbPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CmbDayPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CmbDayPopupMenuWillBecomeInvisible
        getSearchYr();
        searchDB();
    }//GEN-LAST:event_CmbDayPopupMenuWillBecomeInvisible

    private void CmbYrPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CmbYrPopupMenuWillBecomeInvisible
        getSearchYr();
        searchDB();
    }//GEN-LAST:event_CmbYrPopupMenuWillBecomeInvisible

    private void BtnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBookActionPerformed
        new BookMeeting(UserEmail, Person).setVisible(true);
    }//GEN-LAST:event_BtnBookActionPerformed

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        searchDB();
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void CmbPersonPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CmbPersonPopupMenuWillBecomeInvisible
        getSearchYr();
        searchDB();
    }//GEN-LAST:event_CmbPersonPopupMenuWillBecomeInvisible

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        getSearchYr();
        searchDB();
    }//GEN-LAST:event_formWindowGainedFocus

    private void CmbMnthPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CmbMnthPopupMenuWillBecomeInvisible
        getSearchYr();
        searchDB();
    }//GEN-LAST:event_CmbMnthPopupMenuWillBecomeInvisible

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new HomeForm(UserEmail).setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingForm("test@test.com").setVisible(true);
            }
        });
    }

    /**
     * Table listener
     *
     * @param le event
     */
    public void valueChanged(ListSelectionEvent le) {
        if (le.getValueIsAdjusting() == false) {
            //Do Stuff Here

        }
    }

    /**
     * Retrieve all users And the associated email
     */
    public void fetchUsers() {
        try {
            ResultSet rs = mysql.getUsers();
            while (rs.next()) {
                users.add(rs.getString(1));
                emails.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Search the DB for all events by a person on a day
     */
    public void searchDB() {
        String email = getEmail();
        Person = email;
        ResultSet results = mysql.searchByEmailDate(email, searchDate);
        FillTable(results);
    }

    /**
     * Return the email based on who the user selected
     *
     * @return (String) Email of user
     */
    public String getEmail() {
        int user = CmbPerson.getSelectedIndex();
        String email = emails.get(user);
        return email;
    }

    /**
     * Make a suitable MySQL date format
     *
     * @return a date E.G 20171225
     */
    public String getSearchYr() {
        searchDate = "";
        searchDate += CmbYr.getSelectedItem();
        switch (CmbMnth.getSelectedIndex()) {
            case 0:
                searchDate += "01";
                break;
            case 1:
                searchDate += "02";
                break;
            case 2:
                searchDate += "03";
                break;
            case 3:
                searchDate += "04";
                break;
            case 4:
                searchDate += "05";
                break;
            case 5:
                searchDate += "06";
                break;
            case 6:
                searchDate += "07";
                break;
            case 7:
                searchDate += "08";
                break;
            case 8:
                searchDate += "09";
                break;
            case 9:
                searchDate += "10";
                break;
            case 10:
                searchDate += "11";
                break;
            case 11:
                searchDate += "12";
                break;
        }
        switch (CmbDay.getSelectedIndex()) {
            case 0:
                searchDate += "01";
                break;
            case 1:
                searchDate += "02";
                break;
            case 2:
                searchDate += "03";
                break;
            case 3:
                searchDate += "04";
                break;
            case 4:
                searchDate += "05";
                break;
            case 5:
                searchDate += "06";
                break;
            case 6:
                searchDate += "07";
                break;
            case 7:
                searchDate += "08";
                break;
            case 8:
                searchDate += "09";
                break;
            default:
                searchDate += CmbDay.getSelectedItem();
                break;
        }

        return searchDate;
    }

    /**
     * Populate the Year comboBox
     */
    private void FillYear() {
        Calendar today = Calendar.getInstance();
        for (int i = today.get(Calendar.YEAR) + 3; i > today.get(Calendar.YEAR) - 97; i--) {
            CmbYr.addItem(Integer.toString(i));
        }
        CmbDay.setSelectedIndex(today.get(Calendar.DATE) - 1);
        CmbMnth.setSelectedIndex(today.get(Calendar.MONTH));
        CmbYr.setSelectedItem(Integer.toString(today.get(Calendar.YEAR)));
        getSearchYr();
    }

    /**
     * Populate the Persons comboBox
     */
    private void FillPersons() {
        for (String usr : users) {
            CmbPerson.addItem(usr);
        }
    }

    /**
     * Populate the Table with a ResultSet
     *
     * @param rs the ResultSet to fill the table with
     */
    public static void FillTable(ResultSet rs) {

        DefaultTableModel model;
        model = (DefaultTableModel) TableData.getModel();
        TableData.clearSelection();
        model.setNumRows(0);
        try {
            while (rs.next()) {
                String date = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                String desc = rs.getString(6);
                String newstart = start.substring(0, 2) + start.substring(3);
                newstart = newstart.substring(0, 4);
                String newend = end.substring(0, 2) + end.substring(3);
                newend = newend.substring(0, 4);
                startTime.add(newstart);
                endTime.add(newend);
                Object[] content = {date, start, end, desc};

                model.addRow(content);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBook;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JComboBox CmbDay;
    private javax.swing.JComboBox CmbMnth;
    private javax.swing.JComboBox CmbPerson;
    private javax.swing.JComboBox CmbYr;
    private static javax.swing.JTable TableData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
