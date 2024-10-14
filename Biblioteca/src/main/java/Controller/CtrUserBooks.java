/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.UserBook;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import view.FrmPurchaseBook;
import view.FrmUserBook;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrUserBooks {
    private UserBook userbook;
    TableRowSorter<DefaultTableModel> sorter;
    
    public CtrUserBooks(UserBook userbook) {
        this.userbook = new UserBook();
    }
    
    public UserBook getUserBook(){
        return userbook;
    }
    
    // Método para establecer los datos del usuario
    public void selectUserDate(String name, String lastName, String mail) {
        userbook.setUserName(name);
        userbook.setUserLastName(lastName);
        userbook.setUserMail(mail);
    }

    
    
    public void selectUser(JTable jtable){
        int rowSelected= jtable.getSelectedRow();
        
        if(rowSelected>=0){
            String Datos[]= new String[7];
            Datos[0]= jtable.getValueAt(rowSelected,0).toString();
            Datos[1]= jtable.getValueAt(rowSelected,1).toString();
            Datos[2]= jtable.getValueAt(rowSelected,2).toString();
            Datos[3]= jtable.getValueAt(rowSelected,3).toString();
            Datos[4]= jtable.getValueAt(rowSelected,4).toString();
            Datos[5]= jtable.getValueAt(rowSelected,5).toString();
            Datos[6]= jtable.getValueAt(rowSelected,6).toString();
            System.out.println("Datos"+Datos[3]+Datos[4]);
            this.selectUserDate(Datos[3], Datos[4], Datos[6]);
        }
        
    }
    
    public void cargar(JTable jTable){
        this.userbook.selectBooksFromTable(jTable);
    }
    // Función para cargar los libros seleccionados en la tabla de destino
    public void loadSelectedBooksTableInto(JTable jTable) {
        // Obtener los libros seleccionados desde la clase controladora
        System.out.println("CONTROLADOR------------");
        List<String[]> selectedBooksList = userbook.getSelectedBooksList();

        // Modelo de la tabla
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{}, 
                new String[]{"Códigoaa", "Libroaa", "Autor", "Descripción"}  // Nombres de las columnas
        );

        // Establecer el modelo en la tabla
        jTable.setModel(tableModel);

        
        // Agregar los datos de los libros seleccionados al modelo de la tabla
        for (String[] bookData : selectedBooksList) {
            tableModel.addRow(bookData);
        }
        
        // Opcional: Añadir un sorter para ordenar las filas
         sorter= new TableRowSorter<>(tableModel);
        jTable.setRowSorter(sorter);
        
        
        
        
        

        
        System.out.println("CONTROLADORA");
        for (String[] book : selectedBooksList) {
            System.out.println("Libro seleccionado:");
            for (String detail : book) {
                System.out.println(detail);
            }
            System.out.println("-----------------------");
        }
        
    }


    
    public void mostrar(FrmUserBook frmuserbook){
        UserBook userbook= this.getUserBook();
        String userName= userbook.getUserName();
        String lastName= userbook.getUserLastName();
        String mail= userbook.getUserMail();
        frmuserbook.setNameUser(userName);
        frmuserbook.setLastNameUser(lastName);
        frmuserbook.setMailUser(mail);
    }
    public void backpurchaseBook(CtrUserBooks ctrUserBooks, FrmUserBook frmuserbook){
        FrmPurchaseBook frmBooks= new FrmPurchaseBook(ctrUserBooks);
        frmBooks.setVisible(true);
        frmuserbook.setVisible(false);
    }
}
