/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Components.ButtonEditor;
import Components.ButtonRenderer;
import Components.CenteredCellRenderer;
import Modelo.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import view.FrmAddUser;
import view.FrmMenuOptions;
import view.FrmBook;
import view.FrmMenuManagement;
import view.FrmUserBook;
import view.FrmUser;
import view.FrmViewUser;

/**
 *
 * @author steve
 */
public class CtrUser {

    private User user;
    TableRowSorter<DefaultTableModel> sorter;
    private FrmUser frmUserNew;

    public CtrUser(FrmUser frmUserNew) {
        this.frmUserNew = frmUserNew;
        
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
                String[] userData = new String[7];  // Array of size 6 for each column
                userData[0] = userObject.optString("id_user", "N/A");
                userData[1] = userObject.optString("code", "N/A");
                userData[2] = userObject.optString("role", "N/A");
                userData[3] = userObject.optString("user_name", "N/A");
                userData[4] = userObject.optString("user_last_name", "N/A");
                userData[5] = userObject.optString("grade", "N/A");
                userData[6] = userObject.optString("mail", "N/A");

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
                new String[]{"ID","Código", "Tipo de usuario", "Nombre", "Apellido", "Grado", "Correo"} // Nombres de las columnas
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
    //Agregar Usuario
    
    public void addUser(FrmAddUser frmaddUser) {
        FrmMenuManagement frmenuMana = new FrmMenuManagement();
        String code = frmaddUser.getCodeUser();
        String name = frmaddUser.getName();
        String lastName = frmaddUser.getLastName();
        String grade = frmaddUser.getGrade();
        String mail = frmaddUser.getEmail();
        String typeUser = frmaddUser.getTypeUser();
        // Confirmar si se desea agregar el usuario
        int confirm = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas agregar este usuario?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION
        );

        // Si el usuario confirma
        if (confirm == JOptionPane.YES_OPTION) {
            String resultMessage = user.addUser(code, typeUser, name, lastName, mail, grade);

            // Mostrar mensaje según el resultado
            if (resultMessage.isEmpty()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Usuario agregado con éxito.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
                );
                frmaddUser.setVisible(false);
                frmenuMana.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Error al agregar el usuario: " + resultMessage,
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

    
    
    
    public void mostrarDatos(FrmUserBook frmuserbook){
        frmuserbook.setName("");
        frmuserbook.setLastNameUser(" ");
        frmuserbook.setMailUser("");
    }
            
    public void purchaseBook(CtrUserBooks ctrUserBooks){
        FrmBook frmBooks= new FrmBook(ctrUserBooks);
        frmBooks.setVisible(true);
        frmUserNew.setVisible(false);
    }
    public void menu(){
        FrmMenuOptions frmMenu= new FrmMenuOptions();
        frmMenu.setVisible(true);
        frmUserNew.setVisible(false);
    }
    public void axilarAddUser(){
        FrmAddUser frmAddUser= new FrmAddUser();
        frmAddUser.setVisible(true);
        frmUserNew.setVisible(false);
    }
    
    public void returnManagement(FrmAddUser frmadduser){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
        frmadduser.setVisible(false);
        frmMenumana.setVisible(true);
    }
    
    public void returnManagementview(FrmViewUser frmviewuser){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
        frmviewuser.setVisible(false);
        frmMenumana.setVisible(true);
    }
    
    
}
