/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ASUS TUF A15
 */
public class Background extends JPanel  {
    private Image imagen;
    
    @Override
    public void paint(Graphics g){
        imagen= new ImageIcon(getClass().getResource("/img/fondo_logint.jpg")).getImage();
        g.drawImage(imagen,0,0,getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);   
    }
    public void BackgroundTrasparent(JButton btn){
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        
    }
    
    
}
