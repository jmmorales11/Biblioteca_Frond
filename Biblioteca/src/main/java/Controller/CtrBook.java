/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Book;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONObject;
import view.FrmBook;
import view.FrmUserBook;
import view.FrmUser;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrBook {
    
    private Book book;
    TableRowSorter<DefaultTableModel> sorter;

    private FrmBook frmBooks;


    public CtrBook(FrmBook frmBooks) {
        this.frmBooks = frmBooks;
    }
    
    public CtrBook() {
        this.book = new Book();
    }

    
    
    public List<String[]> getBook() {
        List<String[]> booksList = new ArrayList<>();

        try {
            String jsonString = book.getBook();  // Assuming some_user returns JSON string
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject bookObject = usersArray.getJSONObject(i);
                String[] userData = new String[5];  // Array of size 6 for each column

                userData[0] = bookObject.optString("code", "N/A");
                userData[1] = bookObject.optString("title", "N/A");
                userData[2] = bookObject.optString("author", "N/A");
                userData[3] = bookObject.optString("description", "N/A");
                userData[4] = bookObject.optString("status", "N/A");
                

                booksList.add(userData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booksList;
    }
    
    public void loadBooks(JTable JTableBook) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{}, 
                new String[]{"Código", "Libro", "Autor", "Descripcion", "Activo"} // Nombres de las columnas
        );

        JTableBook.setModel(tableModel);

        CtrBook controller = new CtrBook();
        List<String[]> book = controller.getBook();

        // Limpia las celdas (en caso que se use la misma tabla pa otra cosa)
        tableModel.setRowCount(0);

        for (String[] bookData : book) {
            tableModel.addRow(bookData); 
        }
        
        sorter = new TableRowSorter<>(tableModel);
        JTableBook.setRowSorter(sorter);  
    }
    
    

    
    
    
    public void backUser(){
        FrmUser frmUserNew= new FrmUser ();
        frmBooks.setVisible(false);
        frmUserNew.setVisible(true);
    }
    public void nextUserBook(CtrUserBooks ctrUserBooks){
        FrmUserBook frmUserBook= new FrmUserBook(ctrUserBooks);
        
        frmBooks.setVisible(false);
        frmUserBook.setVisible(true);
//        DefaultTableModel modelo1 = new DefaultTableModel() ;
//        frmUserBook.getJTableBook().setModel(modelo1);

        
    }
}
