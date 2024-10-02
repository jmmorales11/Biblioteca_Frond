/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ASUS TUF A15
 */
public class LogIn extends javax.swing.JFrame {
    Background back = new Background();
    /**
     * Creates new form LogIn
     */
    public LogIn() {
        this.setContentPane(back);
        initComponents();
        this.setExtendedState(LogIn.MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PA_login = new javax.swing.JPanel();
        PA_login_form = new javax.swing.JPanel();
        login_title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TF_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TF_password = new javax.swing.JTextField();
        BTN_login = new javax.swing.JButton();
        img_acces = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PA_login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PA_login_form.setBackground(new java.awt.Color(255, 255, 255));

        login_title.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        login_title.setText("Login");

        jLabel3.setText("Usuario");

        jLabel2.setText("Contraseña");

        TF_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_passwordActionPerformed(evt);
            }
        });

        BTN_login.setBackground(new java.awt.Color(9, 57, 134));
        BTN_login.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTN_login.setForeground(new java.awt.Color(255, 255, 255));
        BTN_login.setText("Ingresar");
        BTN_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PA_login_formLayout = new javax.swing.GroupLayout(PA_login_form);
        PA_login_form.setLayout(PA_login_formLayout);
        PA_login_formLayout.setHorizontalGroup(
            PA_login_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PA_login_formLayout.createSequentialGroup()
                .addGroup(PA_login_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PA_login_formLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(PA_login_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_username)
                            .addComponent(TF_password)
                            .addComponent(BTN_login, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PA_login_formLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(login_title)))
                .addContainerGap(362, Short.MAX_VALUE))
        );
        PA_login_formLayout.setVerticalGroup(
            PA_login_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PA_login_formLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(login_title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_username, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TF_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(BTN_login)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        img_acces.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_acc1.png"))); // NOI18N

        javax.swing.GroupLayout PA_loginLayout = new javax.swing.GroupLayout(PA_login);
        PA_login.setLayout(PA_loginLayout);
        PA_loginLayout.setHorizontalGroup(
            PA_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PA_loginLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(PA_login_form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(img_acces, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        PA_loginLayout.setVerticalGroup(
            PA_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PA_loginLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PA_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PA_login_form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(img_acces, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        img_acces.getAccessibleContext().setAccessibleName("");

        getContentPane().add(PA_login, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_loginActionPerformed

    private void TF_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ;

                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_login;
    private javax.swing.JPanel PA_login;
    private javax.swing.JPanel PA_login_form;
    private javax.swing.JTextField TF_password;
    private javax.swing.JTextField TF_username;
    private javax.swing.JLabel img_acces;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel login_title;
    // End of variables declaration//GEN-END:variables

    
  
}
