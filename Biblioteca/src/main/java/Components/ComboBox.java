package Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ComboBox<T> extends JComboBox<T> {

    private int round = 10;
    private Color shadowColor = new Color(170, 170, 170);
    private BufferedImage imageShadow;
    private final Insets shadowSize = new Insets(2, 5, 8, 5);

    public ComboBox() {
        setUI(new ComboBoxUI());
        setOpaque(false);
        setForeground(new Color(80, 80, 80));
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(10, 12, 15, 12));
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth() - (shadowSize.left + shadowSize.right);
        double height = getHeight() - (shadowSize.top + shadowSize.bottom);
        double x = shadowSize.left;
        double y = shadowSize.top;

        // Create Shadow Image
        if (imageShadow != null) {
            g2.drawImage(imageShadow, 0, 0, null);
        }

        // Create Background Color
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, round, round));
        g2.fill(area);
        g2.dispose();
        
        super.paintComponent(grphcs);
    }

    private class ComboBoxUI extends BasicComboBoxUI {

        // Override this method to remove background or not paint background
        protected void paintBackground(Graphics g) {
            // No background painting
        }
        
        @Override
        public void paint(Graphics g, JComponent c) {
            super.paint(g, c);
            paintComponent(g);
        }

        @Override
        public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
            // You can customize the painting of the current value if needed
            super.paintCurrentValue(g, bounds, hasFocus);
        }
    }
}
