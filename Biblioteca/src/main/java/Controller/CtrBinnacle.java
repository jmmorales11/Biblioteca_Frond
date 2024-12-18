/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Components.ActiveStatusRenderer;
import Modelo.Binnacle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONObject;
import view.FrmMenuManagement;
import view.FrmReport;

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
                userData[12] = bookObject.optString("confirm_devolution", "N/A");
                

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
        JTableBook.getColumnModel().getColumn(12).setCellRenderer(new ActiveStatusRenderer());
        
        TableColumn activoColumn = JTableBook.getColumnModel().getColumn(12);
        activoColumn.setCellRenderer(new ActiveStatusRenderer());
        activoColumn.setPreferredWidth(75);  
        activoColumn.setMaxWidth(75);        
        activoColumn.setMinWidth(75);   
        
        
    }
    
    //Filtrar busqueda de tabla
    public void DataFiltter(JTextField FiltterTextField) {
        try {
            // Filtro que ignora mayúsculas y minúsculas usando (?i)
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + FiltterTextField.getText()));
        } catch (Exception e) {
            throw new RuntimeException("Error interno en el filtrado");
        }
    }

    
    public void returnMenuManagement(FrmReport frmreport){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
        frmreport.setVisible(false);
        frmMenumana.setVisible(true);
    }
    
}
