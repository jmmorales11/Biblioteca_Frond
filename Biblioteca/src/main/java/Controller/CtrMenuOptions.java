/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.FrmAddBook;
import view.FrmAddUser;
import view.FrmMenuOptions;
import view.FrmBook;
import view.FrmLoan;
import view.FrmLogIn;
import view.FrmMenuManagement;
import view.FrmQuantityBooksLent;
import view.FrmReport;
import view.FrmUser;
import view.FrmViewBooks;
import view.FrmViewUser;

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
    
    public void viewUser(){
        FrmViewUser frmviewuser = new FrmViewUser();
        frmMenuManagement.setVisible(false);
        frmviewuser.setVisible(true);
    }
    
    public void addBook(){
        FrmAddBook frmaddbook = new FrmAddBook();
        frmMenuManagement.setVisible(false);
        frmaddbook.setVisible(true);
    }
    
    public void viewBook(){
        FrmViewBooks frmviewbook = new FrmViewBooks();
        frmMenuManagement.setVisible(false);
        frmviewbook.setVisible(true);
    }
    public void viewReport(){
        FrmReport frmreport = new FrmReport();
        frmMenuManagement.setVisible(false);
        frmreport.setVisible(true);
    }
    public void viewQuantity(){
        
        FrmQuantityBooksLent frmQuantity = new FrmQuantityBooksLent();
        frmMenuManagement.setVisible(false);
        frmQuantity.setVisible(true);
    }
    public void closeSession(){
        System.out.println("Holaaaaaaa1111");
        FrmLogIn frmLogIn = new FrmLogIn();
        frmMenu.setVisible(false);
        frmLogIn.setVisible(true);
        System.out.println("Holaaaaaaa");
    }
    
   
}
