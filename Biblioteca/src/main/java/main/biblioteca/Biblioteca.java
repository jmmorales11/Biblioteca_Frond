/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.biblioteca;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.LogIn;


/**
 *
 * @author ASUS TUF A15
 */
public class Biblioteca {



    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        LogIn loginWindow = new LogIn();
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 999);
        // Hacer visible la ventana
        loginWindow.setVisible(true);
    }
}
