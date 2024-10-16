package Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTextAreaUI;

/**
 * TextArea personalizado con diseño redondeado y sombra.
 * @author ASUS TUF A15
 */
public class TextArea extends JTextArea {

    private int round = 10;
    private BufferedImage imageShadow;
    private final Insets shadowSize = new Insets(2, 5, 8, 5);

    public TextArea() {
        setUI(new CustomTextAreaUI());
        setOpaque(false);
        setForeground(new Color(80, 80, 80));
        setSelectedTextColor(new Color(255, 255, 255));
        setSelectionColor(new Color(133, 209, 255));
        setBorder(new EmptyBorder(10, 12, 15, 12));
        setBackground(new Color(255, 255, 255));
        setLineWrap(true); // Permitir salto de línea automático.
        setWrapStyleWord(true); // Ajustar líneas por palabra completa.
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
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



        // Dibujar el fondo con bordes redondeados.
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, round, round));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
    }

    // Clase interna para personalizar la UI del JTextArea.
    private class CustomTextAreaUI extends BasicTextAreaUI {
        @Override
        protected void paintBackground(Graphics grphcs) {
            // No dibujar el fondo predeterminado.
        }
    }

    /**
     * Método estático para crear un JScrollPane con el TextArea.
     */
    public static JScrollPane createScrollPane(TextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(
            textArea, 
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // Mostrar scroll vertical cuando sea necesario.
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER   // No permitir scroll horizontal.
        );
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null); // Eliminar borde del JScrollPane.
        return scrollPane;
    }
}
