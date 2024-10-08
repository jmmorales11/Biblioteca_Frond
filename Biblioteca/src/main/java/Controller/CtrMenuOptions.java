/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.FrmMenuOptions;
import view.FrmPurchaseBook;
import view.FrmUserNew;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrMenuOptions {
    private FrmMenuOptions frmMenu;
    private FrmUserNew frmUserNew;

    public CtrMenuOptions(FrmMenuOptions frmMenu,FrmUserNew frmUserNew) {
        this.frmMenu = frmMenu;
        this.frmUserNew = frmUserNew;
    }
    
    
    
    public void purchaseUser(){
        frmMenu.setVisible(false);
        frmUserNew.setVisible(true);
    }
}
