package Components;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 * @author ASUS TUF A15
 */
public class Select<E> extends JComboBox<E> {

    public Select() {
        setUI(new RoundedComboBoxUI()); 
        setBackground(Color.WHITE); 
        setForeground(Color.BLACK); 
        setBorder(new EmptyBorder(5, 10, 5, 10)); 
        setOpaque(false); 
        setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
        
        setEditor(new BasicComboBoxEditor() {
            @Override
            protected JTextField createEditorComponent() {
                JTextField editor = new JTextField();
                editor.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); 
                editor.setBackground(Color.WHITE); 
                editor.setForeground(Color.BLACK); 
                editor.setOpaque(false); 
                return editor;
            }
        });
        setEditable(true); 

       
        setRenderer(new CustomListCellRenderer<>());
        setCustomScroll();
    }
    private void setCustomScroll() {

        JPopupMenu popupMenu = (JPopupMenu) getUI().getAccessibleChild(this, 0);
        if (popupMenu != null) {
            JScrollPane scrollPane = (JScrollPane) popupMenu.getComponent(0);
            scrollPane.setVerticalScrollBar(new ScrollBar()); 
        }
    }

    private static class CustomListCellRenderer<E> extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);


            if (isSelected) {
                label.setBackground(new Color(0, 120, 215)); 
                label.setForeground(Color.WHITE); 
            } else {

                label.setBackground(Color.WHITE);
                label.setForeground(Color.BLACK);
            }

            label.setBorder(new EmptyBorder(5, 10, 5, 10)); 
            return label;
        }
    }


    private static class RoundedComboBoxUI extends BasicComboBoxUI {

        @Override
        protected JButton createArrowButton() {

            JButton button = new JButton("▼");
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setForeground(new Color(9, 57, 134));
            return button;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10, 10);
//            g2.setColor(Color.LIGHT_GRAY);
//            g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 20, 20);

            super.paint(g, c);
        }

        @Override
        protected void installComponents() {
            super.installComponents();
            if (arrowButton != null) {
                arrowButton.setBounds(getArrowButtonBounds());
                comboBox.add(arrowButton);
            }
        }

        private Rectangle getArrowButtonBounds() {
            int width = 20;
            int height = comboBox.getHeight() - 10;
            int x = comboBox.getWidth() - width - 10;
            int y = 5;
            return new Rectangle(x, y, width, height);
        }
    }
}
