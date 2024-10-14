/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;

/**
 *
 * @author ASUS TUF A15
 */
public class FrmMenuManagement extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuManagement
     */
    public FrmMenuManagement() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(FrmUserBook.MAXIMIZED_BOTH);
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

        panelBorder1 = new Components.PanelBorder();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BTN_back_menu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        panelBorder5 = new Components.PanelBorder();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelBorder6 = new Components.PanelBorder();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelBorder7 = new Components.PanelBorder();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panelBorder2 = new Components.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelBorder3 = new Components.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelBorder4 = new Components.PanelBorder();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBorder1.setBackground(new java.awt.Color(217, 217, 217));
        panelBorder1.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 57, 134));
        jLabel1.setText("Gestion de Biblioteca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 34;
        jPanel1.add(jLabel1, gridBagConstraints);

        panelBorder1.add(jPanel1);
        jPanel1.setBounds(6, 6, 1290, 100);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));

        BTN_back_menu.setBackground(new java.awt.Color(9, 57, 134));
        BTN_back_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTN_back_menu.setForeground(new java.awt.Color(255, 255, 255));
        BTN_back_menu.setText("Regresar");
        BTN_back_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_back_menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BTN_back_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1159, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(BTN_back_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBorder1.add(jPanel2);
        jPanel2.setBounds(10, 520, 1280, 75);

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder5.setLayout(null);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ver_usuarios.png"))); // NOI18N
        panelBorder5.add(jLabel8);
        jLabel8.setBounds(20, 10, 110, 110);

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel9.setText("Ver Usuario");
        panelBorder5.add(jLabel9);
        jLabel9.setBounds(20, 120, 110, 16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel3.add(panelBorder5, gridBagConstraints);

        panelBorder6.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder6.setLayout(null);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ver_libro.png"))); // NOI18N
        panelBorder6.add(jLabel10);
        jLabel10.setBounds(20, 10, 110, 100);

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel11.setText("Ver Libro");
        panelBorder6.add(jLabel11);
        jLabel11.setBounds(40, 120, 70, 16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel3.add(panelBorder6, gridBagConstraints);

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder7.setLayout(null);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conteo_libro.png"))); // NOI18N
        panelBorder7.add(jLabel12);
        jLabel12.setBounds(30, 10, 100, 100);

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel13.setText("Conteo ");
        panelBorder7.add(jLabel13);
        jLabel13.setBounds(40, 120, 70, 16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel3.add(panelBorder7, gridBagConstraints);

        panelBorder1.add(jPanel3);
        jPanel3.setBounds(10, 310, 1280, 200);

        jPanel4.setBackground(new java.awt.Color(217, 217, 217));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar_usuario.jpg"))); // NOI18N
        panelBorder2.add(jLabel2);
        jLabel2.setBounds(30, 0, 100, 110);

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Agregar Usuario");
        panelBorder2.add(jLabel3);
        jLabel3.setBounds(20, 110, 110, 16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel4.add(panelBorder2, gridBagConstraints);

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar_libro.jpg"))); // NOI18N
        panelBorder3.add(jLabel4);
        jLabel4.setBounds(30, 10, 100, 96);

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel7.setText("Agregar Libro");
        panelBorder3.add(jLabel7);
        jLabel7.setBounds(20, 110, 110, 16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel4.add(panelBorder3, gridBagConstraints);

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder4.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bitacora.png"))); // NOI18N
        panelBorder4.add(jLabel6);
        jLabel6.setBounds(30, 10, 100, 100);

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel5.setText("Agregar Libro");
        panelBorder4.add(jLabel5);
        jLabel5.setBounds(20, 110, 110, 16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.weightx = 10.0;
        jPanel4.add(panelBorder4, gridBagConstraints);

        panelBorder1.add(jPanel4);
        jPanel4.setBounds(10, 110, 1280, 200);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.ipadx = 1300;
        gridBagConstraints.ipady = 600;
        getContentPane().add(panelBorder1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_back_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_back_menuActionPerformed
        
    }//GEN-LAST:event_BTN_back_menuActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_back_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private Components.PanelBorder panelBorder1;
    private Components.PanelBorder panelBorder2;
    private Components.PanelBorder panelBorder3;
    private Components.PanelBorder panelBorder4;
    private Components.PanelBorder panelBorder5;
    private Components.PanelBorder panelBorder6;
    private Components.PanelBorder panelBorder7;
    // End of variables declaration//GEN-END:variables
}