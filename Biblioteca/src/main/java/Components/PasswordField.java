package Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTextFieldUI;

public class PasswordField extends JPasswordField {

    private int round = 10; // Radio de las esquinas redondeadas
    private Color shadowColor = new Color(170, 170, 170); // Color de la sombra
    private BufferedImage imageShadow; // Imagen de la sombra
    private final Insets shadowSize = new Insets(2, 5, 8, 5); // Tamaño de la sombra

    public PasswordField() {
        setUI(new TextUI()); // Cambiar UI para personalización
        setOpaque(false); // Hacer que el fondo sea transparente
        setForeground(new Color(80, 80, 80)); // Color del texto
        setSelectedTextColor(new Color(255, 255, 255)); // Color del texto seleccionado
        setSelectionColor(new Color(133, 209, 255)); // Color del fondo de selección
        setBorder(new EmptyBorder(10, 12, 15, 12)); // Márgenes internos
        setBackground(new Color(255, 255, 255)); // Color de fondo blanco
        setEchoChar('•'); // Mostrar puntos en lugar de texto ingresado
    }

    // Método para generar la sombra
    private void generateShadow() {
        // Esperar a que el componente tenga un tamaño válido
        if (getWidth() > 0 && getHeight() > 0) {
            int width = getWidth() - (shadowSize.left + shadowSize.right);
            int height = getHeight() - (shadowSize.top + shadowSize.bottom);
            imageShadow = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = imageShadow.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(shadowColor);
            g2d.fillRoundRect(0, 0, width, height, round, round);
            g2d.dispose();
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        // Dejar que JPasswordField maneje la pintura del texto y de los puntos
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja la sombra
        g2.drawImage(imageShadow, 0, 0, null);

        // Dibuja el fondo con esquinas redondeadas
        double width = getWidth() - (shadowSize.left + shadowSize.right);
        double height = getHeight() - (shadowSize.top + shadowSize.bottom);
        double x = shadowSize.left;
        double y = shadowSize.top;
        
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, round, round));
        g2.fill(area);

        g2.dispose();

        // Deja que el JPasswordField maneje la pintura del texto y puntos
        super.paintComponent(grphcs);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        generateShadow(); // Regenerar la sombra al cambiar el tamaño
    }

    // Métodos para configurar el radio de las esquinas redondeadas
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        generateShadow(); // Regenerar sombra con el nuevo radio
        repaint();
    }

    // Métodos para configurar el color de la sombra
    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        generateShadow(); // Regenerar sombra con el nuevo color
        repaint();
    }

    private class TextUI extends BasicTextFieldUI {
        // No sobrescribir paintBackground, dejar que el sistema maneje el fondo del componente.
    }
}
