/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.FrmAddUser;
import view.FrmMenuOptions;
import view.FrmBook;
import view.FrmLoan;
import view.FrmMenuManagement;
import view.FrmUser;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrMenuOptions {
    private FrmMenuOptions frmMenu;
    
    private FrmMenuManagement frmMenuManagement; 

    public CtrMenuOptions(FrmMenuOptions frmMenu) {
        this.frmMenu = frmMenu;
    }

    public CtrMenuOptions(FrmMenuManagement frmMenuManagement) {
        this.frmMenuManagement = frmMenuManagement;
    }
    
    public void purchaseUser(){
        FrmUser frmUserNew = new FrmUser() ;
        frmMenu.setVisible(false);
        frmUserNew.setVisible(true);
    }
    public void menuManagement(){
        FrmMenuManagement frmMenuManagement = new FrmMenuManagement() ;
        frmMenu.setVisible(false);
        frmMenuManagement.setVisible(true);
    }
    public void loan(){
        FrmLoan frmLoan= new FrmLoan() ;
        frmMenu.setVisible(false);
        frmLoan.setVisible(true);
    }
    public void backmenuManagement(){
        FrmMenuOptions frmMenu= new FrmMenuOptions();
        frmMenu.setVisible(true);
        frmMenuManagement.setVisible(false);
    }
    
    public void addUser(){
        FrmAddUser frmadduser = new FrmAddUser();
        frmMenuManagement.setVisible(false);
        frmadduser.setVisible(true);
    }
}
