/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Components.TableHeader;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS TUF A15
 */
public class Table extends JTable {
    public Table(){
        setShowHorizontalLines(true);
        setGridColor(new Color(230,230,230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        setRowSelectionAllowed(true);
        
        
        
        
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer (){
           @Override
           public Component getTableCellRendererComponent( JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1 ){
               TableHeader header  = new TableHeader(o+"");
               if (i1==4){
                   header.setHorizontalAlignment(JLabel.RIGHT);
               }else{
                   header.setHorizontalAlignment(JLabel.CENTER);
               }
               return header;
           } 
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int i, int i1) {
                if(i1 != 4){
                   Component com = super.getTableCellRendererComponent(table, o, bln1, bln1, i, i1);
                   com.setBackground(Color.white);
                   if (bln) {
                        com.setBackground(new Color(184, 207, 229)); // Color por defecto de selección
                    }
                    setBorder(noFocusBorder);
                    return com;
                }else{
                    JLabel label = new JLabel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            g.setColor(Color.GREEN);
                            // Dibujar un círculo verde
                            g.fillOval(getWidth() - 20, getHeight() / 2 - 10, 15, 15);
                        }
                    };
                    label.setHorizontalAlignment(SwingConstants.RIGHT); // Alinear a la derecha
                    label.setBackground(Color.white); // Color de fondo blanco
                    label.setOpaque(true); 
                    return label;
                }
            }
              
        });
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        // Evitar que cualquier celda sea editable
        return false;
    }
    
}
