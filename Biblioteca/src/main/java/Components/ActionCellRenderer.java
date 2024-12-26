/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ASUS TUF A15
 */
public class ActionCellRenderer extends JPanel implements TableCellRenderer {
    public ActionCellRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 1, 0));
        JButton viewButton = createIconButton("visto.png");
        setBackground(Color.WHITE);
        setOpaque(true); // Mantiene el fondo del panel
        add(viewButton);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        return this;
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
