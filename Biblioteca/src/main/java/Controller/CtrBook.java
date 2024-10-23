/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Book;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONObject;
import view.FrmAddBook;
import view.FrmAddUser;
import view.FrmBook;
import view.FrmMenuManagement;
import view.FrmQuantityBooksLent;
import view.FrmUserBook;
import view.FrmUser;
import view.FrmViewBooks;

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
        this.book = new Book();
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

        
        List<String[]> book = this.getBook();

        // Limpia las celdas (en caso que se use la misma tabla pa otra cosa)
        tableModel.setRowCount(0);

        for (String[] bookData : book) {
            tableModel.addRow(bookData); 
        }
        
        sorter = new TableRowSorter<>(tableModel);
        JTableBook.setRowSorter(sorter);  
    }
    
    //Filtrar busqueda de tabla
    public void DataFiltter(JTextField FiltterTextField){
        try{
            sorter.setRowFilter(RowFilter.regexFilter(FiltterTextField.getText()));
        }catch(Exception e){
            throw new RuntimeException("Error internal");
        }
    }
    
    //Mostrar y editar los libros 
    public List<String[]> getBookInformation() {
        List<String[]> booksList = new ArrayList<>();

        try {
            String jsonString = book.getBook();  // Assuming some_user returns JSON string
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject bookObject = usersArray.getJSONObject(i);
                String[] userData = new String[7];  // Array of size 6 for each column

                userData[0] = bookObject.optString("code", "N/A");
                userData[1] = bookObject.optString("author", "N/A");
                userData[2] = bookObject.optString("grade", "N/A");
                userData[3] = bookObject.optString("title", "N/A");
                userData[4] = bookObject.optString("language", "N/A");
                userData[5] = bookObject.optString("section", "N/A");
                userData[6] = bookObject.optString("description", "N/A");

                

                booksList.add(userData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booksList;
    }

    public void loadBooksInformation(JTable JTableBook) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{}, 
                new String[]{"Código",  "Autor","Grado" ,"Titulo","Idioma", "Sección","Descripcion"} 
        );

        JTableBook.setModel(tableModel);

        
        List<String[]> book = this.getBookInformation();

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
    }
    
    public void addBooks(FrmAddBook frmaddbook) {
        FrmMenuManagement frmenuMana = new FrmMenuManagement();
        String title = frmaddbook.getTitleBook();
        String author = frmaddbook.getAuthor();
        String language = frmaddbook.getLanguage();
        String code = frmaddbook.getCode();
        String grade = frmaddbook.getGrade();
        String section = frmaddbook.getSection();
        String description =frmaddbook.getDescription();
        String physical_state =frmaddbook.getPhysicalstate();
        
       
        // Confirmar si se desea agregar el usuario
        int confirm = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas agregar este usuario?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION
        );

        // Si el usuario confirma
        if (confirm == JOptionPane.YES_OPTION) {
            String resultMessage = book.addBook(title, author, language, code, grade, section, description, physical_state);

            // Mostrar mensaje según el resultado
            if (resultMessage.isEmpty()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Libro agregado con éxito.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
                );
                frmaddbook.setVisible(false);
                frmenuMana.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Error al agregar el libro: " + resultMessage,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Operación cancelada.",
                "Cancelado",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
    
    public void returnManagement(FrmViewBooks frmviewBooks){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
        frmviewBooks.setVisible(false);
        frmMenumana.setVisible(true);
    }
    public void returnManagementQ(FrmQuantityBooksLent frmviewBooksLent){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
        frmviewBooksLent.setVisible(false);
        frmMenumana.setVisible(true);
    }
    
    public void returnManagementA(FrmAddBook frmaddbook){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
         frmaddbook.setVisible(false);
        frmMenumana.setVisible(true);
    }
    
    
}
