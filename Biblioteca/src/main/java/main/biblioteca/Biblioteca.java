/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.biblioteca;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.FrmLogIn;



/**
 *
 * @author ASUS TUF A15
 */
public class Biblioteca {



    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        FrmLogIn login= new FrmLogIn();
        // Hacer visible la ventana
        login.setVisible(true);
    }
}
