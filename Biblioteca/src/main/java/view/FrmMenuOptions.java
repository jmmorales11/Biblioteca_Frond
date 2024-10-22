/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Components.Background;
import Controller.CtrMenuOptions;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author ASUS TUF A15
 */
public class FrmMenuOptions extends javax.swing.JFrame {

    /**
     * Creates new form MenuOptions
     */
    CtrMenuOptions ctrM ;
    Background back= new Background();
    public FrmMenuOptions() {
        this.setContentPane(back);
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(FrmMenuOptions.MAXIMIZED_BOTH);
        
        back.BackgroundTrasparent(BTN_deliver);
        back.BackgroundTrasparent(BTN_purchase);
        back.BackgroundTrasparent(BTN_manage);
        ctrM= new CtrMenuOptions(this);
        
        
        
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BTN_purchase = new javax.swing.JButton();
        BTN_deliver = new javax.swing.JButton();
        BTN_manage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 57, 134));
        jLabel1.setText("Sistema de Biblioteca");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(430, 40, 440, 90);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        BTN_purchase.setBackground(new java.awt.Color(242, 242, 242));
        BTN_purchase.setOpaque(isVisible());
        BTN_purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_purchaseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel1.add(BTN_purchase, gridBagConstraints);

        BTN_deliver.setBackground(new java.awt.Color(242, 242, 242));
        BTN_deliver.setOpaque(isVisible());
        BTN_deliver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deliverActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel1.add(BTN_deliver, gridBagConstraints);

        BTN_manage.setBackground(new java.awt.Color(242, 242, 242));
        BTN_manage.setOpaque(isVisible());
        BTN_manage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_manageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel1.add(BTN_manage, gridBagConstraints);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 120, 1350, 320);

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton4.setBackground(new java.awt.Color(9, 57, 134));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Seleccionar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 30;
        jPanel3.add(jButton4, gridBagConstraints);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 440, 1350, 110);

        jPanel7.setBackground(new java.awt.Color(217, 217, 217));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adquirir.png"))); // NOI18N
        jPanel8.add(jLabel3);
        jLabel3.setBounds(30, 20, 90, 90);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Adquirir");
        jPanel8.add(jLabel10);
        jLabel10.setBounds(40, 120, 70, 20);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel7.add(jPanel8, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Entregar");
        jPanel9.add(jLabel11);
        jLabel11.setBounds(40, 120, 70, 20);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/entregar.png"))); // NOI18N
        jLabel12.setText("jLabel6");
        jPanel9.add(jLabel12);
        jLabel12.setBounds(30, 20, 100, 100);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel7.add(jPanel9, gridBagConstraints);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestion.png"))); // NOI18N
        jPanel10.add(jLabel13);
        jLabel13.setBounds(30, 20, 90, 90);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Gestion");
        jPanel10.add(jLabel14);
        jLabel14.setBounds(40, 120, 70, 20);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel7.add(jPanel10, gridBagConstraints);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(0, 120, 1350, 320);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1350;
        gridBagConstraints.ipady = 700;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Trasparencia boton
    
    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BTN_purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_purchaseActionPerformed
        
        ctrM.purchaseUser();
    }//GEN-LAST:event_BTN_purchaseActionPerformed

    private void BTN_manageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_manageActionPerformed
        ctrM.menuManagement();
    }//GEN-LAST:event_BTN_manageActionPerformed

    private void BTN_deliverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deliverActionPerformed
        ctrM.loan();
    }//GEN-LAST:event_BTN_deliverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuOptions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_deliver;
    private javax.swing.JButton BTN_manage;
    private javax.swing.JButton BTN_purchase;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
