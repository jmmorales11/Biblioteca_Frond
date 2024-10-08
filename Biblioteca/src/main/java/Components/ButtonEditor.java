/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ButtonEditor extends DefaultCellEditor {
    ButtonPanel buttonPanel;
    private int row;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        buttonPanel = new ButtonPanel();

        // Acción del botón "Editar"
        buttonPanel.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                JOptionPane.showMessageDialog(buttonPanel, "Editando fila " + (row + 1));
            }
        });

        // Acción del botón "Entregar"
        buttonPanel.btnReturned.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                JOptionPane.showMessageDialog(buttonPanel, "Libro entregado en la fila " + (row + 1));
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;  // Almacena la fila
        return buttonPanel;
    }

    @Override
    public Object getCellEditorValue() {
        return null; // No es necesario devolver un valor
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
