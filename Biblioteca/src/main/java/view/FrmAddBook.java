/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Components.Background;

/**
 *
 * @author ASUS TUF A15
 */
public class FrmAddBook extends javax.swing.JFrame {

    /**
     * Creates new form FrmAddBook
     */
    Background back = new Background();
    public FrmAddBook() {
        this.setContentPane(back);
        initComponents();
        this.setExtendedState(FrmMenuOptions.MAXIMIZED_BOTH);
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
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textField1 = new Components.TextField();
        textField2 = new Components.TextField();
        textField4 = new Components.TextField();
        textField5 = new Components.TextField();
        textField6 = new Components.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea2 = new Components.TextArea();
        select1 = new Components.Select();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBorder1.setBackground(new java.awt.Color(217, 217, 217));
        panelBorder1.setLayout(null);

        jPanel1.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(9, 57, 134));
        jLabel8.setText("Gestion Biblioteca Libros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(359, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panelBorder1.add(jPanel1);
        jPanel1.setBounds(0, 0, 1300, 100);

        jPanel2.setLayout(null);

        textField1.setText("textField1");
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });
        jPanel2.add(textField1);
        textField1.setBounds(170, 35, 450, 55);

        textField2.setText("textField2");
        jPanel2.add(textField2);
        textField2.setBounds(697, 35, 450, 55);

        textField4.setText("textField4");
        jPanel2.add(textField4);
        textField4.setBounds(697, 108, 450, 52);

        textField5.setText("textField5");
        jPanel2.add(textField5);
        textField5.setBounds(170, 184, 450, 53);

        textField6.setText("textField6");
        jPanel2.add(textField6);
        textField6.setBounds(697, 184, 450, 53);

        jLabel1.setText("Codigo");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(178, 13, 69, 16);

        jLabel2.setText("Grado");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(176, 91, 73, 16);

        jLabel3.setText("Idioma");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(176, 162, 57, 16);

        jLabel4.setText("Descripcion");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(176, 249, 80, 16);

        jLabel5.setText("Autor");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(705, 13, 68, 16);

        jLabel6.setText("Titulo de la Obra");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(703, 91, 140, 16);

        jLabel7.setText("Seccion");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(703, 162, 57, 16);

        jScrollPane2.setBorder(null);

        textArea2.setColumns(20);
        textArea2.setRows(5);
        jScrollPane2.setViewportView(textArea2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(170, 277, 977, 116);
        jPanel2.add(select1);
        select1.setBounds(170, 110, 450, 50);

        panelBorder1.add(jPanel2);
        jPanel2.setBounds(0, 100, 1300, 450);

        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelBorder1.add(jPanel3);
        jPanel3.setBounds(0, 550, 1300, 50);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1300;
        gridBagConstraints.ipady = 600;
        getContentPane().add(panelBorder1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private Components.PanelBorder panelBorder1;
    private Components.Select select1;
    private Components.TextArea textArea2;
    private Components.TextField textField1;
    private Components.TextField textField2;
    private Components.TextField textField4;
    private Components.TextField textField5;
    private Components.TextField textField6;
    // End of variables declaration//GEN-END:variables
}
