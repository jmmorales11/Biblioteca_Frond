/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Components.Background;
import Controller.CtrBinnacle;
import java.awt.Color;

/**
 *
 * @author ASUS TUF A15
 */
public class FrmReport extends javax.swing.JFrame {

    /**
     * Creates new form FrmReport
     */
    Background back = new Background();
    CtrBinnacle ctrbinnacle;
    public FrmReport() {
        this.setContentPane(back);
        initComponents();
        this.setExtendedState(FrmMenuOptions.MAXIMIZED_BOTH);
        JSCROLL_Report.getViewport().setBackground(Color.WHITE);
        ctrbinnacle=  new CtrBinnacle();
        ctrbinnacle.loadBooks(tableModel1);
        
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
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Regresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        textField1 = new Components.TextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panelBorder2 = new Components.PanelBorder();
        JSCROLL_Report = new javax.swing.JScrollPane();
        tableModel1 = new Components.TableModel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBorder1.setBackground(new java.awt.Color(217, 217, 217));
        panelBorder1.setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(9, 57, 134));
        jLabel4.setText("Sistema de Biblioteca");
        jPanel1.add(jLabel4, new java.awt.GridBagConstraints());

        panelBorder1.add(jPanel1);
        jPanel1.setBounds(0, 0, 1300, 100);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        Regresar.setBackground(new java.awt.Color(9, 57, 134));
        Regresar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        jPanel2.add(Regresar);
        Regresar.setBounds(48, 6, 86, 38);

        panelBorder1.add(jPanel2);
        jPanel2.setBounds(0, 550, 1300, 50);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        textField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField1KeyReleased(evt);
            }
        });
        jPanel3.add(textField1);
        textField1.setBounds(300, 0, 770, 50);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("Buscar:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(230, 0, 63, 50);

        panelBorder1.add(jPanel3);
        jPanel3.setBounds(0, 100, 1300, 50);

        jPanel4.setOpaque(false);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(null);

        JSCROLL_Report.setBorder(null);
        JSCROLL_Report.setOpaque(false);

        tableModel1.setModel(new javax.swing.table.DefaultTableModel(
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
        JSCROLL_Report.setViewportView(tableModel1);

        panelBorder2.add(JSCROLL_Report);
        JSCROLL_Report.setBounds(10, 0, 1180, 350);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelBorder1.add(jPanel4);
        jPanel4.setBounds(0, 150, 1300, 400);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1300;
        gridBagConstraints.ipady = 600;
        getContentPane().add(panelBorder1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegresarActionPerformed

    private void textField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField1KeyReleased
        ctrbinnacle.DataFiltter(textField1);
    }//GEN-LAST:event_textField1KeyReleased

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
            java.util.logging.Logger.getLogger(FrmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSCROLL_Report;
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private Components.PanelBorder panelBorder1;
    private Components.PanelBorder panelBorder2;
    private Components.TableModel tableModel1;
    private Components.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
