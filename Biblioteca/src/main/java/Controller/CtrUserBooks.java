/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.UserBook;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import view.FrmBook;
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
    public void selectUserDate(int id_user ,String name, String lastName, String mail) {
        userbook.setId_user(id_user);
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
            this.selectUserDate(Integer.parseInt(Datos[0]),Datos[3], Datos[4], Datos[6]);
        }
        
    }
    
    public void cargar(JTable jTable){
        this.userbook.selectBooksFromTable(jTable);
    }
    // Función para cargar los libros seleccionados en la tabla de destino
    public List<String[]> loadSelectedBooksTableInto(JTable jTable) {
        // Obtener los libros seleccionados desde la clase controladora
        List<String[]> selectedBooksList = userbook.getSelectedBooksList();

        // Modelo de la tabla
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{}, 
                new String[]{"ID","Código", "Libro", "Autor", "Descripción"}  // Nombres de las columnas
        );

        jTable.setModel(tableModel);
        for (String[] bookData : selectedBooksList) {
            tableModel.addRow(bookData);
        }
         sorter= new TableRowSorter<>(tableModel);
        jTable.setRowSorter(sorter);
        TableColumn codigoColumn = jTable.getColumnModel().getColumn(0);
        codigoColumn.setMinWidth(0);
        codigoColumn.setMaxWidth(0);
        codigoColumn.setPreferredWidth(0);
        codigoColumn.setResizable(false);
        return selectedBooksList;
    }

    public void insertloan(FrmUserBook frmUserbook){
        List<String[]> selectedBooksList = userbook.getSelectedBooksList();
        int id=this.getUserBook().getId_user();
        String date= frmUserbook.getDate();
        String datetime=frmUserbook.getDateDelivery();
        System.out.println("Id User"+id);
        for (String[] book : selectedBooksList) {
            // Imprimir solo el valor de la posición [0]
            System.out.println("Libro seleccionado: " + book[0]+" "+id+" "+date+ " "+datetime);
            this.getUserBook().addLoan(Integer.parseInt(book[0]), id, date, datetime);
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
        FrmBook frmBooks= new FrmBook(ctrUserBooks);
        frmBooks.setVisible(true);
        frmuserbook.setVisible(false);
    }
    //obtener la fecha actual
    public void getDate(JTextField DateTextField) {
        LocalDateTime actualDate = LocalDateTime.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss"); 
        String formattedDate = actualDate.format(formatter); 
        DateTextField.setText(formattedDate); 
    }
    
    public void getDateDelivery(JTextField DateTextField) {
        LocalDateTime actualDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = actualDateTime.plusDays(7);

        DayOfWeek dayOfWeek = futureDateTime.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY) {
            futureDateTime = futureDateTime.plusDays(2);  // Sumar 2 días si es sábado
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            futureDateTime = futureDateTime.plusDays(1);  // Sumar 1 día si es domingo
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = futureDateTime.format(formatter);
        DateTextField.setText(formattedDate);
    }
}
