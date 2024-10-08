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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONException;
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

    // Retornar una lista de usuarios en formato String 
    public List<String[]> getUsers() {
        List<String[]> usersList = new ArrayList<>();

        try {
            String jsonString = user.some_user();
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject userObject = usersArray.getJSONObject(i);
                String[] userData = new String[6];

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

    // Retornar una lista de prestamos en formato String 
    public List<String[]> getLoan() {
        List<String[]> loanList = new ArrayList<>();

        try {
            String jsonString = user.some_loan();
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject userObject = usersArray.getJSONObject(i);
                String[] loanData = new String[7];

                loanData[0] = userObject.optString("codeUser", "N/A");
                loanData[1] = userObject.optString("user_name", "N/A");
                loanData[2] = userObject.optString("user_last_name", "N/A");
                loanData[3] = userObject.optString("codeBook", "N/A");
                loanData[4] = userObject.optString("title", "N/A");
                loanData[5] = userObject.optString("acquisition_date", "N/A");
                loanData[6] = userObject.optString("date_of_devolution", "N/A");

                loanList.add(loanData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return loanList;
    }

    //Carga la lista de usuarios en una tabla
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

    //carga la lista de prestamos en una tabla
    public void loadLoan(JTable JTableLoan) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Cédula", "Nombre", "Apellido", "Código", "Libro", "Fecha de adquisición", "Fecha de devolución", "Acciones"}
        );

        JTableLoan.setModel(tableModel);

        CtrUser controller = new CtrUser();
        List<String[]> loan = controller.getLoan();

        // Limpia las celdas (en caso que se use la misma tabla pa otra cosa)
        tableModel.setRowCount(0);

        // Carga los datos y añade el panel de acciones
        for (String[] loanData : loan) {
            Object[] rowData = new Object[loanData.length + 1]; // +1 para los botones
            System.arraycopy(loanData, 0, rowData, 0, loanData.length); // Copia los datos del préstamo
            rowData[loanData.length] = ""; // La celda de "Acciones" no necesita datos, solo los botones
            tableModel.addRow(rowData);
        }

        // Configura el renderizador y editor para la columna de acciones
        JTableLoan.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        JTableLoan.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));

        //Manejamos los anchos de las columnas
        TableColumn accionesColumn = JTableLoan.getColumnModel().getColumn(7);
        TableColumn fechaDevolucionColumn = JTableLoan.getColumnModel().getColumn(6);
        TableColumn fechaAdquisicionColumn = JTableLoan.getColumnModel().getColumn(5);
        
        accionesColumn.setPreferredWidth(200);
        accionesColumn.setMinWidth(200);
        accionesColumn.setMaxWidth(200);
        
        fechaDevolucionColumn.setPreferredWidth(150);
        
        
        fechaAdquisicionColumn.setPreferredWidth(150);
        

        // Aplicar renderizador centrado para las columnas
        CenteredCellRenderer centeredRenderer = new CenteredCellRenderer();
        for (int i = 0; i < JTableLoan.getColumnCount() - 1; i++) { // -1 para no aplicar en la columna de "Acciones"
            JTableLoan.getColumnModel().getColumn(i).setCellRenderer(centeredRenderer);
        }

        sorter = new TableRowSorter<>(tableModel);
        JTableLoan.setRowSorter(sorter);
    }

    //Filtrar busqueda de tabla
    public void DataFiltter(JTextField FiltterTextField) {
        try {
            sorter.setRowFilter(RowFilter.regexFilter(FiltterTextField.getText()));
        } catch (Exception e) {
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

    public void purchaseBook() {
        frmBooks.setVisible(true);
        frmUserNew.setVisible(false);
    }

    public void menu() {
        frmMenu.setVisible(true);
        frmUserNew.setVisible(false);
    }
}
