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

    // Verificar si la respuesta contiene un error
    if (responseMessage.startsWith("Error:")) {
        // Mostrar el mensaje de error en un cuadro de diálogo de advertencia
        String displayMessage = responseMessage.replaceFirst("Error:", "").trim();
        JOptionPane.showMessageDialog(frmlogin, displayMessage, "Advertencia", JOptionPane.WARNING_MESSAGE);
    } else {
        // Mostrar el mensaje de éxito e ir al menú
        JOptionPane.showMessageDialog(frmlogin, responseMessage, "Información", JOptionPane.INFORMATION_MESSAGE);
        frmlogin.setVisible(false); // Ocultar la ventana de login
        frmMenu.setVisible(true);   // Mostrar la siguiente página
    }
}


    

   
}
