/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Components.Background;
import Controller.CtrUser;
import Controller.CtrUserBooks;
import Modelo.UserBook;
import java.awt.Color;
import javax.swing.ListSelectionModel;

/**
 *
 * @author ASUS TUF A15
 */
public class FrmUser extends javax.swing.JFrame {

    /**
     * Creates new form MenuOptions
     */
    Background back = new Background();
    CtrUser ctrUser;
    private CtrUserBooks ctrUserBooks;
    public FrmUser() {
        this.setContentPane(back);
        initComponents();
        UserBook userbook = new UserBook();
        this.ctrUserBooks = new CtrUserBooks(userbook);
        
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(FrmUser.MAXIMIZED_BOTH);
        ctrUser = new CtrUser(this);
        ctrUser.loadUsers(JTableUser);
        JSCROLL_tableUser.setVerticalScrollBar(new ScrollBar());
        JSCROLL_tableUser.getViewport().setBackground(Color.WHITE);
       // this.JTableUser.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelBorder2 = new view.PanelBorder();
        jPanel5 = new javax.swing.JPanel();
        panelBorder3 = new view.PanelBorder();
        JSCROLL_tableUser = new javax.swing.JScrollPane();
        JTableUser = new view.TableUser();
        jPanel6 = new javax.swing.JPanel();
        BTN_nexUser = new javax.swing.JButton();
        BTN_back_menu = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TF_search_user = new Components.TextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBorder2.setBackground(new java.awt.Color(217, 217, 217));
        panelBorder2.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(217, 217, 217));

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        JSCROLL_tableUser.setBorder(null);

        JTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Tipo de Usuario", "Nombre", "Apellido", "Grado", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JSCROLL_tableUser.setViewportView(JTableUser);

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSCROLL_tableUser, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSCROLL_tableUser, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelBorder2.add(jPanel5);
        jPanel5.setBounds(0, 140, 1350, 400);

        jPanel6.setBackground(new java.awt.Color(217, 217, 217));

        BTN_nexUser.setBackground(new java.awt.Color(9, 57, 134));
        BTN_nexUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTN_nexUser.setForeground(new java.awt.Color(255, 255, 255));
        BTN_nexUser.setText("Siguiente");
        BTN_nexUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_nexUserActionPerformed(evt);
            }
        });

        BTN_back_menu.setBackground(new java.awt.Color(9, 57, 134));
        BTN_back_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTN_back_menu.setForeground(new java.awt.Color(255, 255, 255));
        BTN_back_menu.setText("Cancelar");
        BTN_back_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_back_menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(1222, Short.MAX_VALUE)
                .addComponent(BTN_nexUser)
                .addGap(34, 34, 34))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(BTN_back_menu)
                    .addContainerGap(1224, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_nexUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_back_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)))
        );

        panelBorder2.add(jPanel6);
        jPanel6.setBounds(0, 540, 1350, 50);

        jPanel7.setBackground(new java.awt.Color(217, 217, 217));

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(9, 57, 134));
        jLabel6.setText("Sistema de Biblioteca");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        panelBorder2.add(jPanel7);
        jPanel7.setBounds(0, 10, 1350, 70);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));

        TF_search_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_search_userActionPerformed(evt);
            }
        });
        TF_search_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_search_userKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Buscar :");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconmas3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TF_search_user, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(498, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TF_search_user, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(43, 43, 43))))
        );

        panelBorder2.add(jPanel1);
        jPanel1.setBounds(0, 70, 1350, 75);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1350;
        gridBagConstraints.ipady = 600;
        gridBagConstraints.insets = new java.awt.Insets(17, 16, 6, 6);
        getContentPane().add(panelBorder2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_nexUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_nexUserActionPerformed
        
        ctrUser.purchaseBook(this.ctrUserBooks);
        ctrUserBooks.selectUser(JTableUser);
    }//GEN-LAST:event_BTN_nexUserActionPerformed

    private void BTN_back_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_back_menuActionPerformed
        // TODO add your handling code here:
        ctrUser.menu();
    }//GEN-LAST:event_BTN_back_menuActionPerformed

    private void TF_search_userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_search_userKeyReleased
        ctrUser.DataFiltter(TF_search_user);
    }//GEN-LAST:event_TF_search_userKeyReleased

    private void TF_search_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_search_userActionPerformed
       
    }//GEN-LAST:event_TF_search_userActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_back_menu;
    private javax.swing.JButton BTN_nexUser;
    private javax.swing.JScrollPane JSCROLL_tableUser;
    private view.TableUser JTableUser;
    private Components.TextField TF_search_user;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private view.PanelBorder panelBorder2;
    private view.PanelBorder panelBorder3;
    // End of variables declaration//GEN-END:variables
}
