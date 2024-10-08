/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONObject;
import view.FrmMenuOptions;
import view.FrmPurchaseBook;
import view.FrmUserNew;

/**
 *
 * @author steve
 */
public class CtrUser {

    private User user;
    TableRowSorter<DefaultTableModel> sorter;
    
    private FrmPurchaseBook frmBooks;
    private FrmUserNew frmUserNew;
    private FrmMenuOptions frmMenu;
    
    public CtrUser(FrmUserNew frmUserNew, FrmPurchaseBook frmBooks) {
        this.frmBooks = frmBooks;
        this.frmUserNew = frmUserNew;
        this.user = new User();
    }

    public CtrUser(FrmMenuOptions frmMenu) {
        this.frmMenu = frmMenu;
    }
    

    public CtrUser() {
        this.user = new User();
    }

    // This function will return the users as a list of arrays
    public List<String[]> getUsers() {
        List<String[]> usersList = new ArrayList<>();

        try {
            String jsonString = user.some_user();  // Assuming some_user returns JSON string
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject userObject = usersArray.getJSONObject(i);
                String[] userData = new String[6];  // Array of size 6 for each column

                userData[0] = userObject.optString("code", "N/A");
                userData[1] = userObject.optString("role", "N/A");
                userData[2] = userObject.optString("user_name", "N/A");
                userData[3] = userObject.optString("user_last_name", "N/A");
                userData[4] = userObject.optString("grade", "N/A");
                userData[5] = userObject.optString("mail", "N/A");

                usersList.add(userData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usersList;
    }

    public void loadUsers(JTable JTableUser) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{}, 
                new String[]{"Código", "Tipo de usuario", "Nombre", "Apellido", "Grado", "Correo"} // Nombres de las columnas
        );

        JTableUser.setModel(tableModel);

        CtrUser controller = new CtrUser();
        List<String[]> users = controller.getUsers();

        // Limpia las celdas (en caso que se use la misma tabla pa otra cosa)
        tableModel.setRowCount(0);

        for (String[] userData : users) {
            tableModel.addRow(userData); 
        }
        
        sorter = new TableRowSorter<>(tableModel);
        JTableUser.setRowSorter(sorter);  
    }

    
    //Filtrar busqueda de tabla
    public void DataFiltter(JTextField FiltterTextField){
        try{
            sorter.setRowFilter(RowFilter.regexFilter(FiltterTextField.getText()));
        }catch(Exception e){
            throw new RuntimeException("Error internal");
        }
    }
    
    //obtener la fecha actual
    public void getDate(JTextField DateTextField) {
        LocalDate actualDate = LocalDate.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        String formattedDate = actualDate.format(formatter); 
        DateTextField.setText(formattedDate); 
    }
    
    public void purchaseBook(){
        frmBooks.setVisible(true);
        frmUserNew.setVisible(false);
    }
    public void menu(){
        frmMenu.setVisible(true);
        frmUserNew.setVisible(false);
    }
    
    

}
