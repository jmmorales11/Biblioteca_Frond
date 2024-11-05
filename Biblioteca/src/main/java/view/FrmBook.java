/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Components.Table;
import Components.Background;
import Components.ScrollBar;
import Controller.CtrBook;
import Controller.CtrUserBooks;
import Modelo.UserBook;
import java.awt.Color;
import javax.swing.JTable;

/**
 *
 * @author ASUS TUF A15
 */
public class FrmBook extends javax.swing.JFrame {
    Background back = new Background();
    /**
     * Creates new form FrmPurchaseBook
     */
    CtrBook ctrbook;
    private CtrUserBooks ctrUserBooks;
    public FrmBook(CtrUserBooks ctrUserBooks) {
        this.setContentPane(back);
        initComponents();
        this.setExtendedState(FrmMenuOptions.MAXIMIZED_BOTH);
        ctrbook= new CtrBook(this);
        ctrbook.loadBooks(JTableBook);
        this.ctrUserBooks= ctrUserBooks;
        
        this.getContentPane().setBackground(Color.white);
        JSCROLL_books.getViewport().setBackground(Color.WHITE);
        JSCROLL_books.setVerticalScrollBar(new ScrollBar());
        
        
        
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

        panelBorder2 = new Components.PanelBorder();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TF_search_book = new Components.TextField();
        jPanel7 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        BTN_back_user = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        panelBorder3 = new Components.PanelBorder();
        JSCROLL_books = new javax.swing.JScrollPane();
        JTableBook = new Components.TableModel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBorder2.setBackground(new java.awt.Color(217, 217, 217));
        panelBorder2.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(217, 217, 217));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel3.setText("Buscar :");

        TF_search_book.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_search_bookKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_search_book, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_search_book, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
        );

        panelBorder2.add(jPanel6);
        jPanel6.setBounds(0, 70, 1350, 70);

        jPanel7.setBackground(new java.awt.Color(217, 217, 217));

        jButton6.setBackground(new java.awt.Color(9, 57, 134));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Continuar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        BTN_back_user.setBackground(new java.awt.Color(9, 57, 134));
        BTN_back_user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTN_back_user.setForeground(new java.awt.Color(255, 255, 255));
        BTN_back_user.setText("Cancelar");
        BTN_back_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_back_userActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(1221, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(32, 32, 32))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(BTN_back_user)
                    .addContainerGap(1237, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(BTN_back_user, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        panelBorder2.add(jPanel7);
        jPanel7.setBounds(0, 540, 1350, 50);

        jPanel8.setBackground(new java.awt.Color(217, 217, 217));
        jPanel8.setLayout(null);

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        JSCROLL_books.setBorder(null);

        JTableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JSCROLL_books.setViewportView(JTableBook);

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSCROLL_books, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSCROLL_books, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.add(panelBorder3);
        panelBorder3.setBounds(124, 6, 1100, 388);

        panelBorder2.add(jPanel8);
        jPanel8.setBounds(0, 140, 1350, 400);

        jPanel9.setBackground(new java.awt.Color(217, 217, 217));
        jPanel9.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(9, 57, 134));
        jLabel4.setText("Sistema de Biblioteca");
        jPanel9.add(jLabel4);
        jLabel4.setBounds(416, 1, 479, 52);

        panelBorder2.add(jPanel9);
        jPanel9.setBounds(0, 10, 1350, 60);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1350;
        gridBagConstraints.ipady = 600;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelBorder2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ctrUserBooks.cargar(JTableBook);
        ctrbook.nextUserBook(this.ctrUserBooks);
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BTN_back_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_back_userActionPerformed
        // TODO add your handling code here:

        ctrbook.backUser();
    }//GEN-LAST:event_BTN_back_userActionPerformed

    private void TF_search_bookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_search_bookKeyReleased
        ctrbook.DataFiltter(TF_search_book);
    }//GEN-LAST:event_TF_search_bookKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserBook userbook = new UserBook();
                CtrUserBooks ctrUserBooks = new CtrUserBooks(userbook);
                new FrmBook(ctrUserBooks).setVisible(true);
            }
        });
        
    }
    public JTable getJTableBook() {
        return JTableBook;
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_back_user;
    private javax.swing.JScrollPane JSCROLL_books;
    private Components.TableModel JTableBook;
    private Components.TextField TF_search_book;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private Components.PanelBorder panelBorder2;
    private Components.PanelBorder panelBorder3;
    // End of variables declaration//GEN-END:variables
}
