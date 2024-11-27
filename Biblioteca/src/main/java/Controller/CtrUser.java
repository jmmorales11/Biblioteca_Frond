/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Components.ActiveStatusRenderer;
import Components.ButtonEditor;
import Components.ButtonRenderer;
import Components.CenteredCellRenderer;
import Modelo.User;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
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

    // Clase principal para cargar usuarios en la tabla
public void loadUsers(JTable JTableUser) {
    DefaultTableModel tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Código", "Tipo de usuario", "Nombre", "Apellido", "Grado", "Correo", "Acciones User"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Permite editar todas las columnas excepto la columna de "Acciones User"
            return column >= 1 && column <= 6;
        }
    };

    JTableUser.setModel(tableModel);

    CtrUser controller = new CtrUser();
    List<String[]> users = controller.getUsers();

    // Limpia las filas en caso de reutilizar la tabla
    tableModel.setRowCount(0);

    for (String[] userData : users) {
        Object[] rowData = new Object[userData.length + 1];
        System.arraycopy(userData, 0, rowData, 0, userData.length);
        rowData[userData.length] = ""; // Columna "Acciones User"
        tableModel.addRow(rowData);
    }

    sorter = new TableRowSorter<>(tableModel);
    JTableUser.setRowSorter(sorter);

    TableColumn idColumn = JTableUser.getColumnModel().getColumn(0);
    idColumn.setMinWidth(0);
    idColumn.setMaxWidth(0);
    idColumn.setPreferredWidth(0);
    idColumn.setResizable(false);

    // Asignar renderer y editor a la columna de acciones
    JTableUser.getColumnModel().getColumn(7).setCellRenderer(new ActionCellRenderer());
    JTableUser.getColumnModel().getColumn(7).setCellEditor(new ActionCellEditor(JTableUser));
}

// Renderer para mostrar el ícono de "visto" en la columna de acciones
public class ActionCellRenderer extends JPanel implements TableCellRenderer {
    public ActionCellRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 1, 0));
        JButton viewButton = createIconButton("visto.png");
        add(viewButton);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Configurar el color de fondo
        if (isSelected) {
            setBackground(table.getSelectionBackground()); // Fondo al seleccionar
        } else {
            setBackground(java.awt.Color.WHITE); // Fondo blanco
        }
        return this;
    }

    private JButton createIconButton(String iconName) {
        JButton button = new JButton(loadIcon(iconName));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    private Icon loadIcon(String iconName) {
        String path = "/img/" + iconName;
        return new ImageIcon(getClass().getResource(path));
    }
}

// Editor para manejar la acción del botón en la columna de acciones
public class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    private JButton viewButton;
    private JTable table;

    public ActionCellEditor(JTable table) {
        this.table = table;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 0));
        viewButton = createIconButton("visto.png");

        viewButton.addActionListener(e -> {
            int row = table.getEditingRow();
            // Extraer datos de la fila actual
            String codigo = table.getValueAt(row, 1).toString();
            String tipoUsuario = table.getValueAt(row, 2).toString();
            String nombre = table.getValueAt(row, 3).toString();
            String apellido = table.getValueAt(row, 4).toString();
            String grado = table.getValueAt(row, 5).toString();
            String correo = table.getValueAt(row, 6).toString();

            // Mostrar datos en un cuadro de diálogo para validación
            JOptionPane.showMessageDialog(
                    table,
                    "Datos actualizados:\n" +
                            "Código: " + codigo + "\n" +
                            "Tipo de Usuario: " + tipoUsuario + "\n" +
                            "Nombre: " + nombre + "\n" +
                            "Apellido: " + apellido + "\n" +
                            "Grado: " + grado + "\n" +
                            "Correo: " + correo,
                    "Validación de Cambios",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
        });

        panel.add(viewButton);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    private JButton createIconButton(String iconName) {
        JButton button = new JButton(loadIcon(iconName));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    private Icon loadIcon(String iconName) {
        String path = "/img/" + iconName;
        return new ImageIcon(getClass().getResource(path));
    }
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
