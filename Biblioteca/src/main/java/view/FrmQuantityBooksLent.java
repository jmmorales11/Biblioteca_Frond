/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Components.Background;
import Components.PDFExporter;
import Components.ScrollBar;
import Controller.CtrBook;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS TUF A15
 */
public class FrmQuantityBooksLent extends javax.swing.JFrame {

    /**
     * Creates new form FrmQuantityBooksLent
     */
    Background back = new Background();
    CtrBook ctrbook;
    public FrmQuantityBooksLent() {
        setIconImage(new ImageIcon(getClass().getResource("/img/iconof.png")).getImage());
        this.setContentPane(back);
        initComponents();
        this.setExtendedState(FrmMenuOptions.MAXIMIZED_BOTH);
        ctrbook= new CtrBook();
        ctrbook.bookQuantity(tableModel1);
        JSCROLL_book_quantity.getViewport().setBackground(Color.WHITE);
        JSCROLL_book_quantity.setVerticalScrollBar(new ScrollBar());
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
        jLabel2 = new javax.swing.JLabel();
        TXT_book_quantity = new Components.TextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnExportarPDFBook = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        panelBorder2 = new Components.PanelBorder();
        JSCROLL_book_quantity = new javax.swing.JScrollPane();
        tableModel1 = new Components.TableModel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBorder1.setBackground(new java.awt.Color(217, 217, 217));
        panelBorder1.setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 57, 134));
        jLabel1.setText("Gestión Biblioteca Conteo de Prestamos");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        panelBorder1.add(jPanel1);
        jPanel1.setBounds(0, 0, 1300, 100);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setText("Buscar:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(200, 0, 90, 50);

        TXT_book_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_book_quantityActionPerformed(evt);
            }
        });
        TXT_book_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_book_quantityKeyReleased(evt);
            }
        });
        jPanel2.add(TXT_book_quantity);
        TXT_book_quantity.setBounds(320, 0, 660, 50);

        jButton3.setBackground(new java.awt.Color(14, 190, 209));
        jButton3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Libros");
        jButton3.setBorder(null);
        jPanel2.add(jButton3);
        jButton3.setBounds(1030, 10, 70, 30);

        jButton4.setBackground(new java.awt.Color(201, 153, 11));
        jButton4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Usuario");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(1110, 10, 80, 30);

        panelBorder1.add(jPanel2);
        jPanel2.setBounds(0, 100, 1300, 50);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jButton1.setBackground(new java.awt.Color(9, 57, 134));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(30, 0, 95, 44);

        btnExportarPDFBook.setBackground(new java.awt.Color(9, 57, 134));
        btnExportarPDFBook.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnExportarPDFBook.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarPDFBook.setText("Imprimir");
        btnExportarPDFBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarPDFBookActionPerformed(evt);
            }
        });
        jPanel3.add(btnExportarPDFBook);
        btnExportarPDFBook.setBounds(1160, 0, 100, 40);

        panelBorder1.add(jPanel3);
        jPanel3.setBounds(0, 550, 1300, 50);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(null);

        JSCROLL_book_quantity.setBorder(null);
        JSCROLL_book_quantity.setOpaque(false);

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
        JSCROLL_book_quantity.setViewportView(tableModel1);

        panelBorder2.add(JSCROLL_book_quantity);
        JSCROLL_book_quantity.setBounds(10, 10, 980, 330);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1000;
        gridBagConstraints.ipady = 350;
        jPanel4.add(panelBorder2, gridBagConstraints);

        panelBorder1.add(jPanel4);
        jPanel4.setBounds(0, 150, 1300, 400);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1300;
        gridBagConstraints.ipady = 600;
        getContentPane().add(panelBorder1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ctrbook.returnManagementQ(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TXT_book_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_book_quantityKeyReleased
        ctrbook.DataFiltter(TXT_book_quantity);
    }//GEN-LAST:event_TXT_book_quantityKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ctrbook.seeUser(this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnExportarPDFBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPDFBookActionPerformed
        btnExportarPDFBook.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar archivo PDF");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos PDF", "pdf"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".pdf")) {
                    filePath += ".pdf";
                }
                PDFExporter exporter = new PDFExporter();
                try {
                    exporter.exportTableToPDF(tableModel1, filePath,"Reporte de Libros");
                    JOptionPane.showMessageDialog(null, "Datos exportados a PDF exitosamente en: ");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al exportar PDF: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exportación cancelada.");
            }
        }
    });
    }//GEN-LAST:event_btnExportarPDFBookActionPerformed

    private void TXT_book_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_book_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_book_quantityActionPerformed

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
            java.util.logging.Logger.getLogger(FrmQuantityBooksLent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQuantityBooksLent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQuantityBooksLent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQuantityBooksLent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQuantityBooksLent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSCROLL_book_quantity;
    private Components.TextField TXT_book_quantity;
    private javax.swing.JButton btnExportarPDFBook;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private Components.PanelBorder panelBorder1;
    private Components.PanelBorder panelBorder2;
    private Components.TableModel tableModel1;
    // End of variables declaration//GEN-END:variables
}
