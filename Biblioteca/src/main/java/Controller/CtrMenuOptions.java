/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.FrmMenuOptions;
import view.FrmBook;
import view.FrmUser;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrMenuOptions {
    private FrmMenuOptions frmMenu;

    public CtrMenuOptions(FrmMenuOptions frmMenu) {
        this.frmMenu = frmMenu;
    }
    
    public void purchaseUser(){
        FrmUser frmUserNew = new FrmUser() ;
        frmMenu.setVisible(false);
        frmUserNew.setVisible(true);
    }
}
