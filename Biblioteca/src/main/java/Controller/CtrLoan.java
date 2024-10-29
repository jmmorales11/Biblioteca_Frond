/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Components.ActionCellEditor;
import Components.ActionCellRenderer;
import Components.ButtonEditor;
import Components.ButtonRenderer;
import Components.CenteredCellRenderer;
import Modelo.Loan;
import Modelo.User;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import view.FrmLoan;
import view.FrmMenuOptions;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrLoan {
    private Loan loan;
    TableRowSorter<DefaultTableModel> sorter;

    public CtrLoan() {
        this.loan = new Loan();
    }
    
    
    // Retornar una lista de prestamos en formato String 
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
    

    
public void loadLoan(JTable JTableLoan) {
    DefaultTableModel tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"","Cédula", "Nombre", "Apellido", "Código", "Libro", "Adquisición", "Devolución", "Acciones"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 7;  
        }
    };

    JTableLoan.setModel(tableModel);

    List<String[]> loan = this.getLoan();
    tableModel.setRowCount(0);


    for (String[] loanData : loan) {
        Object[] rowData = new Object[loanData.length + 1]; 
        System.arraycopy(loanData, 0, rowData, 0, loanData.length);
        rowData[loanData.length] = "";  // Columna "Acciones".
        tableModel.addRow(rowData);
    }

    JTableLoan.getColumnModel().getColumn(8).setCellRenderer(new ActionCellRenderer());
    JTableLoan.getColumnModel().getColumn(8).setCellEditor(new ActionCellEditor(JTableLoan));

    sorter = new TableRowSorter<>(tableModel);
    JTableLoan.setRowSorter(sorter);
    }

    public void DataFiltter(JTextField FiltterTextField){
        try{
            sorter.setRowFilter(RowFilter.regexFilter(FiltterTextField.getText()));
        }catch(Exception e){
            throw new RuntimeException("Error internal");
        }
    }
    
    
    public void backmenu(FrmLoan frmloan){
        FrmMenuOptions frmMenu = new FrmMenuOptions() ;
        frmMenu.setVisible(true);
        frmloan.setVisible(false);
    }
    
    
}

