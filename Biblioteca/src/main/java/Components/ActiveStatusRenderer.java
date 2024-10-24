/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ASUS TUF A15
 */
public class ActiveStatusRenderer extends JPanel implements TableCellRenderer {
        public ActiveStatusRenderer() {
            setOpaque(false); 
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, 
                                                       int row, int column) {
            boolean isActive = Boolean.parseBoolean(value.toString());
            Color color = isActive ? Color.GREEN : Color.RED;

            return new CircularLabel(color); 
        }
    }