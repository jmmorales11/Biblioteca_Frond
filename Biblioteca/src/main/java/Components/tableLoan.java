/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import view.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS TUF A15
 */
public class tableLoan extends JTable {
    public tableLoan(){
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
                   // Configurar colores de fondo y texto
                    if (bln) { // Si la celda está seleccionada
                        com.setBackground(new Color(184, 207, 229)); // Fondo azul claro
                        com.setForeground(Color.BLACK); // Texto en negro
                    } else { // Si la celda no está seleccionada
                        com.setBackground(Color.WHITE); // Fondo blanco
                        com.setForeground(Color.BLACK); // Texto en negro
                    }

                    // Configuración adicional para evitar bordes molestos
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
    // Lista de columnas que deben estar bloqueadas
    int[] columnasBloqueadas = {0, 1, 2, 3, 4, 5, 6, 7}; // Bloquea estas columnas
    
    // Comprueba si la columna actual está en la lista de columnas bloqueadas
    for (int col : columnasBloqueadas) {
        if (column == col) {
            return false; // Bloquea esta columna
        }
    }
    
    // Si no está en la lista de columnas bloqueadas, permite la edición
    return true;
}
   
}