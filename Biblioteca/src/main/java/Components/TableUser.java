/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import Components.TableHeader;

/**
 *
 * @author ASUS TUF A15
 */

public class TableUser extends JTable {

    
    public TableUser(){
        setShowHorizontalLines(true);
        setGridColor(new Color(230,230,230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setRowSelectionAllowed(true);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer (){
           @Override
           public Component getTableCellRendererComponent( JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1 ){
               TableHeader header  = new TableHeader(o+"");

                   header.setHorizontalAlignment(JLabel.CENTER);
               
               return header;
           } 
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int i, int i1) {
                
                   Component com = super.getTableCellRendererComponent(table, o, bln1, bln1, i, i1);
                   com.setBackground(Color.WHITE);
                    if (bln) {
                        com.setBackground(new Color(184, 207, 229)); // Color por defecto de selección
                    }
                    setBorder(noFocusBorder);
                    return com;
                
            }
              
        });
    }

    void setSelectionModel(int SINGLE_SELECTION) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        // Evitar que cualquier celda sea editable
        return false;
    }
    
}
