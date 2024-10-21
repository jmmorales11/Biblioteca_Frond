/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Binnacle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrBinnacle {
    private Binnacle binnacle;
    TableRowSorter<DefaultTableModel> sorter;
    public CtrBinnacle() {
        this.binnacle = new Binnacle();
    }
    public List<String[]> getReport() {
        List<String[]> booksList = new ArrayList<>();

        try {
            String jsonString = binnacle.getReport();  // Assuming some_user returns JSON string
            JSONArray usersArray = new JSONArray(jsonString);
            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject bookObject = usersArray.getJSONObject(i);
                String[] userData = new String[13];  // Array of size 6 for each column

                userData[0] = bookObject.optString("codeBook", "N/A");
                userData[1] = bookObject.optString("author", "N/A");
                userData[2] = bookObject.optString("grade", "N/A");
                userData[3] = bookObject.optString("title", "N/A");
                userData[4] = bookObject.optString("language", "N/A");
                userData[5] = bookObject.optString("section", "N/A");
                userData[6] = bookObject.optString("user_name", "N/A");
                userData[7] = bookObject.optString("user_last_name", "N/A");
                userData[8] = bookObject.optString("mail", "N/A");
                userData[9] = bookObject.optString("role", "N/A");
                userData[10] = bookObject.optString("acquisition_date", "N/A");
                userData[11] = bookObject.optString("date_of_devolution", "N/A");
                userData[12] = bookObject.optString("status", "N/A");
                

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
                new String[]{"Código", "Autor", "Grado", "Titulo","Idioma","Seccion","Nombre", "Apellido","Correo","Rol","Fecha de adquisicion", "Fecha devolucion","Estado"} // Nombres de las columnas
        );

        JTableBook.setModel(tableModel);

        
        List<String[]> report = this.getReport();

        // Limpia las celdas (en caso que se use la misma tabla pa otra cosa)
        tableModel.setRowCount(0);

        for (String[] bookData : report) {
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

    
}
