/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.User;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import view.FrmLogIn;
import view.FrmMenuOptions;

/**
 *
 * @author ASUS TUF A15
 */
public class Ctrlogin {
    private User user;
    private FrmLogIn frmlogin;
    private FrmMenuOptions frmMenu;
    
    public Ctrlogin(User user, FrmLogIn frmlogin, FrmMenuOptions frmMenu) {
        this.user = user;
        this.frmlogin = frmlogin;
        this.frmMenu = frmMenu;
    }
    
    public Ctrlogin(User user, FrmLogIn frmlogin) {
        this.user = user;
        this.frmlogin = frmlogin;
    }
    
    public void input() {
    String username = frmlogin.getUser();
    String password = frmlogin.getPassword();

    String responseMessage = user.login(username, password);

    if (responseMessage.startsWith("Error:") || responseMessage.equals("Error al conectar con el servidor.")) {
        // Mostrar ventana de advertencia si hay un error
        JOptionPane.showMessageDialog(frmlogin, responseMessage, "Advertencia", JOptionPane.WARNING_MESSAGE);
        // No redirigir a la siguiente pantalla
    } else {
        // Mostrar mensaje de éxito y redirigir al menú principal
        JOptionPane.showMessageDialog(frmlogin, responseMessage, "Información", JOptionPane.INFORMATION_MESSAGE);
        frmlogin.setVisible(false);
        frmMenu.setVisible(true);
    }
}
    
    


      
    
    
}
