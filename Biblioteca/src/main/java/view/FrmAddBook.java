/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Components.Background;
import Components.ScrollBar;
import Controller.CtrBook;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS TUF A15
 */
public class FrmAddBook extends javax.swing.JFrame {

    /**
     * Creates new form FrmAddBook
     */
    Background back = new Background();
    CtrBook ctrbook;
    public FrmAddBook() {
        setIconImage(new ImageIcon(getClass().getResource("/img/iconof.png")).getImage());
        this.setContentPane(back);
        initComponents();
        this.setExtendedState(FrmMenuOptions.MAXIMIZED_BOTH);
        jScroll_TextArea_Book.setVerticalScrollBar(new ScrollBar());
        ctrbook= new CtrBook();
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
        TXT_code = new Components.TextField();
        TXT_author = new Components.TextField();
        TXT_price = new Components.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScroll_TextArea_Book = new javax.swing.JScrollPane();
        TA_description = new Components.TextArea();
        SLC_grade = new Components.Select();
        SLC_section = new Components.Select();
        SLC_language = new Components.Select();
        TXT_physicalState = new Components.TextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TXT_title = new Components.TextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        BTN_addBook = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBorder1.setBackground(new java.awt.Color(217, 217, 217));
        panelBorder1.setLayout(null);

        jPanel1.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(9, 57, 134));
        jLabel8.setText("Gestión de Biblioteca");

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

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        TXT_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_codeActionPerformed(evt);
            }
        });
        jPanel2.add(TXT_code);
        TXT_code.setBounds(160, 30, 450, 55);
        jPanel2.add(TXT_author);
        TXT_author.setBounds(690, 30, 450, 55);

        TXT_price.setText("0");
        TXT_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_priceActionPerformed(evt);
            }
        });
        jPanel2.add(TXT_price);
        TXT_price.setBounds(690, 180, 450, 52);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("Código");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(170, 10, 69, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setText("Grado");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(170, 90, 73, 16);

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Idioma");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(170, 160, 57, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setText("Descripción");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(170, 310, 80, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel5.setText("Autor");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(700, 10, 68, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel6.setText("Título de la Obra");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(700, 90, 140, 16);

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel7.setText("Precio");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(700, 160, 57, 16);

        jScroll_TextArea_Book.setBackground(new java.awt.Color(255, 255, 255));
        jScroll_TextArea_Book.setBorder(null);
        jScroll_TextArea_Book.setOpaque(false);

        TA_description.setColumns(20);
        TA_description.setRows(5);
        jScroll_TextArea_Book.setViewportView(TA_description);

        jPanel2.add(jScroll_TextArea_Book);
        jScroll_TextArea_Book.setBounds(167, 330, 980, 116);

        SLC_grade.setBorder(null);
        SLC_grade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SECUNDARIA", "PRIMARIA", "DOCENTES", "PREESCOLAR", "TEACHING GUIDE", "NINGUNA" }));
        jPanel2.add(SLC_grade);
        SLC_grade.setBounds(165, 110, 440, 45);

        SLC_section.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AG", "CP", "D", "DOCENTE", "FE", "FG", "FLL", "FR", "FT", "GF", "GR", "I", "INV", "LG", "LL", "R", "S", "SR", "TC", "NINGUNA" }));
        jPanel2.add(SLC_section);
        SLC_section.setBounds(695, 250, 440, 45);

        SLC_language.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ESPAÑOL", "CIENCIAS", "ÁLGEBRA", "ESPAÑOL- INGLES", "FÍSICA", "INGLÉS", "MATEMÁTICAS", "" }));
        SLC_language.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SLC_languageActionPerformed(evt);
            }
        });
        jPanel2.add(SLC_language);
        SLC_language.setBounds(165, 180, 440, 45);
        jPanel2.add(TXT_physicalState);
        TXT_physicalState.setBounds(160, 250, 450, 55);

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel9.setText("Estado Físico");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(170, 230, 120, 16);

        jLabel10.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel10.setText("Sección");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(700, 230, 57, 16);
        jPanel2.add(TXT_title);
        TXT_title.setBounds(690, 110, 450, 52);

        panelBorder1.add(jPanel2);
        jPanel2.setBounds(0, 100, 1300, 450);

        jPanel3.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(9, 57, 134));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BTN_addBook.setBackground(new java.awt.Color(9, 57, 134));
        BTN_addBook.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        BTN_addBook.setForeground(new java.awt.Color(255, 255, 255));
        BTN_addBook.setText("Agregar");
        BTN_addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_addBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1060, Short.MAX_VALUE)
                .addComponent(BTN_addBook)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(BTN_addBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelBorder1.add(jPanel3);
        jPanel3.setBounds(0, 550, 1300, 50);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1300;
        gridBagConstraints.ipady = 600;
        getContentPane().add(panelBorder1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_codeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ctrbook.returnManagementA(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTN_addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addBookActionPerformed
        ctrbook.addBooks(this);
    }//GEN-LAST:event_BTN_addBookActionPerformed

    private void SLC_languageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SLC_languageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SLC_languageActionPerformed

    private void TXT_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_priceActionPerformed
    //Get y Set
    public String getGrade() {
        return SLC_grade.getSelectedItem().toString();
    }
    
    public String  getLanguage() {
        return SLC_language.getSelectedItem().toString();
    }
    
    public String getSection() {
        return SLC_section.getSelectedItem().toString();
    }
    public String getDescription() {
        return TA_description.getText();
    }
    
    public String getAuthor() {
        return TXT_author.getText();
    }
    
    public String getCode() {
        return TXT_code.getText();
    }
    public String getTitleBook() {
        return TXT_title.getText();
    }
    
    public String getTXTprice(){
        return TXT_price.getText();
    }
    
    public String getPhysicalstate() {
        return TXT_physicalState.getText();
    }
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
    private javax.swing.JButton BTN_addBook;
    private Components.Select SLC_grade;
    private Components.Select SLC_language;
    private Components.Select SLC_section;
    private Components.TextArea TA_description;
    private Components.TextField TXT_author;
    private Components.TextField TXT_code;
    private Components.TextField TXT_physicalState;
    private Components.TextField TXT_price;
    private Components.TextField TXT_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScroll_TextArea_Book;
    private Components.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
