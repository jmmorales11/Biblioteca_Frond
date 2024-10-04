/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.User;
import java.awt.event.ActionEvent;
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
    
    public void input(){
        String username = frmlogin.getUser();
        String password = frmlogin.getPassword();
        
        boolean result = user.login(username, password);
        if(result == true){
            frmlogin.setVisible(false);
            frmMenu.setVisible(true);
        }else{
            frmlogin.setVisible(true);
        }
    }
      
    
    
}
