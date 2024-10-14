/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author ASUS TUF A15
 */
public class UserBook {
    private String userName;
    private String userLastName;
    private String userMail;
    private List<String[]> selectedBooks;
    public UserBook() {
        this.selectedBooks = new ArrayList<>();
    }

    // Getters y Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public List<String[]> getSelectedBooksList() {
        return selectedBooks;
    }

    public void selectBooksFromTable(JTable jTable) {
        selectedBooks.clear();  // Limpiar la lista antes de agregar nuevos datos

        // Obtener las filas seleccionadas
        int[] selectedRows = jTable.getSelectedRows();

        if (selectedRows.length > 0) {
            // Iterar sobre las filas seleccionadas
            for (int i = 0; i < selectedRows.length; i++) {
                int selectedRow = selectedRows[i];
                String[] bookData = new String[4];  // Cambiar según el número de columnas

                // Obtener los valores de las columnas de la fila seleccionada
                bookData[0] = jTable.getValueAt(selectedRow, 0).toString();  // Código
                bookData[1] = jTable.getValueAt(selectedRow, 1).toString();  // Libro
                bookData[2] = jTable.getValueAt(selectedRow, 2).toString();  // Autor
                bookData[3] = jTable.getValueAt(selectedRow, 3).toString();  // Descripción

                // Agregar los datos a la lista
                selectedBooks.add(bookData);
                System.out.println(bookData[0]+bookData[1]+bookData[2]+bookData[3]);
            }
        }
    }

    
}
