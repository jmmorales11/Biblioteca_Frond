/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS TUF A15
 */
import Components.ActionCellEditor;
import Components.ActionCellRenderer;
import Modelo.Loan;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rojeru_san.componentes.RSDateChooser;
import view.FrmLoan;
import view.FrmMenuOptions;

public class CtrLoan {
    private Loan loan;
    private TableRowSorter<DefaultTableModel> sorter;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Cambia el formato según tu base de datos

    public CtrLoan() {
        this.loan = new Loan();
    }

    // Retornar una lista de préstamos en formato String
    public List<String[]> getLoan() {
        List<String[]> loanList = new ArrayList<>();

        try {
            String jsonString = loan.some_loan();
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject userObject = usersArray.getJSONObject(i);
                String[] loanData = new String[8];
                loanData[0] = userObject.optString("id_loan", "N/A");
                loanData[1] = userObject.optString("codeUser", "N/A");
                loanData[2] = userObject.optString("user_name", "N/A");
                loanData[3] = userObject.optString("user_last_name", "N/A");
                loanData[4] = userObject.optString("codeBook", "N/A");
                loanData[5] = userObject.optString("title", "N/A");
                loanData[6] = userObject.optString("acquisition_date", "N/A");
                loanData[7] = userObject.optString("date_of_devolution", "N/A");

                loanList.add(loanData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return loanList;
    }

    // Método para cargar la tabla con el editor RSDateChooser en la columna "Devolución"
    public void loadLoan(JTable JTableLoan) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"", "Cédula", "Nombre", "Apellido", "Código", "Libro", "Adquisición", "Devolución", "Acciones"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7;  // Solo la columna de "Devolución" es editable
            }
        };

        JTableLoan.setModel(tableModel);

        List<String[]> loan = this.getLoan();
        tableModel.setRowCount(0);

        for (String[] loanData : loan) {
            Object[] rowData = new Object[loanData.length + 1]; 
            System.arraycopy(loanData, 0, rowData, 0, loanData.length);
            rowData[loanData.length] = "";  // Columna "Acciones"
            tableModel.addRow(rowData);
        }
        TableColumn codigoColumn = JTableLoan.getColumnModel().getColumn(0);
        codigoColumn.setMinWidth(0);
        codigoColumn.setMaxWidth(0);
        codigoColumn.setPreferredWidth(0);
        codigoColumn.setResizable(false);
        // Asigna el renderer y el editor a la columna de devoluciones
        JTableLoan.getColumnModel().getColumn(7).setCellEditor(new DateChooserEditor());
        JTableLoan.getColumnModel().getColumn(8).setCellRenderer(new ActionCellRenderer());
        JTableLoan.getColumnModel().getColumn(8).setCellEditor(new ActionCellEditor(JTableLoan));

        sorter = new TableRowSorter<>(tableModel);
        JTableLoan.setRowSorter(sorter);
    }

    public void DataFiltter(JTextField FiltterTextField) {
        try {
            sorter.setRowFilter(RowFilter.regexFilter(FiltterTextField.getText()));
        } catch (Exception e) {
            throw new RuntimeException("Error interno");
        }
    }

    public void backmenu(FrmLoan frmloan) {
        FrmMenuOptions frmMenu = new FrmMenuOptions();
        frmMenu.setVisible(true);
        frmloan.setVisible(false);
    }

class DateChooserEditor extends AbstractCellEditor implements TableCellEditor {
    private RSDateChooser dateChooser = new RSDateChooser();
    private int editingRow; // Variable para almacenar la fila en edición

    public DateChooserEditor() {
        // Agrega un listener para detectar cambios y detener la edición automáticamente
        dateChooser.addPropertyChangeListener("datoFecha", evt -> {
            if (evt.getNewValue() != null) {
                stopCellEditing(); // Termina la edición cuando se selecciona una fecha
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        // Obtiene la fecha seleccionada y formateada
        String selectedDate = dateFormat.format(dateChooser.getDatoFecha());

        // Actualiza el modelo de la tabla con la fecha seleccionada
        JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, dateChooser);
        if (table != null) {
            table.setValueAt(selectedDate, editingRow, 7); // Actualiza la fecha en la columna de devolución
        }

        return selectedDate;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.editingRow = row; // Guarda la fila en edición para actualizar el valor después

        // Configura la fecha inicial en el editor si ya tiene un valor
        if (value != null && value instanceof String) {
            try {
                dateChooser.setDatoFecha(dateFormat.parse((String) value));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            dateChooser.setDatoFecha(null); // Limpia la fecha si no hay un valor inicial
        }

        // Asegura que el editor se muestre correctamente
        return dateChooser;
    }

    @Override
    public boolean stopCellEditing() {
        // Aquí se asegura de que la edición se detenga correctamente
        String selectedDate = dateFormat.format(dateChooser.getDatoFecha());
        JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, dateChooser);
        if (table != null) {
            table.setValueAt(selectedDate, editingRow, 7); // Actualiza la celda con la fecha seleccionada
        }

        return super.stopCellEditing(); // Llama al método padre para completar la edición
    }
}

}
