/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Controller.CtrLoan;
import Modelo.Loan;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author ASUS TUF A15
 */
public class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    private JButton editButton;
    private JButton viewButton;
    private JTable table;
    private Runnable refreshCallback;

    public ActionCellEditor(JTable table) {
        this.table = table;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 0));
        viewButton = createIconButton("visto.png");



        viewButton.addActionListener(e -> {
            int row = table.getEditingRow();
            int codigo = Integer.parseInt(table.getValueAt(row, 0).toString());
            String fechaDevolucion = table.getValueAt(row, 7).toString();
           
            Loan lo= new Loan();
            lo.addLoan(codigo, fechaDevolucion);
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            CtrLoan ctrLoan = new CtrLoan();
            ctrLoan.loadLoan(table);
        });
        panel.add(viewButton);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
    private JButton createIconButton(String iconName) {
    JButton button = new JButton(loadIcon(iconName));
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false); 
    button.setBorderPainted(false);  
    button.setFocusPainted(false);
    return button;
}


private Icon loadIcon(String iconName) {
    String path = "/img/" + iconName; 
    return new ImageIcon(getClass().getResource(path));
}
}
