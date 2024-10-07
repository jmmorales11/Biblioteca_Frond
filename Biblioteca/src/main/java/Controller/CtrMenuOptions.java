/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.FrmMenuOptions;
import view.FrmPurchaseBook;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrMenuOptions {
    private FrmMenuOptions frmMenu;
    private FrmPurchaseBook frmPurchaseBook;

    public CtrMenuOptions(FrmMenuOptions frmMenu, FrmPurchaseBook frmPurchaseBook) {
        this.frmMenu = frmMenu;
        this.frmPurchaseBook = frmPurchaseBook;
    }
    
    
    
    public void purchaseBook(){
        frmMenu.setVisible(false);
        frmPurchaseBook.setVisible(true);
    }
}
