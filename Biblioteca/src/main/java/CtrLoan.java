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

    // Editor de celda personalizado con RSDateChooser para la columna de fecha de devolución
    class DateChooserEditor extends AbstractCellEditor implements TableCellEditor {
        private RSDateChooser dateChooser = new RSDateChooser();

        @Override
        public Object getCellEditorValue() {
            return dateFormat.format(dateChooser.getDatoFecha());  // Devuelve la fecha seleccionada
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value != null && value instanceof String) {
                try {
                    dateChooser.setDatoFecha(dateFormat.parse((String) value));  // Setea la fecha inicial
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return dateChooser;
        }
    }
}
