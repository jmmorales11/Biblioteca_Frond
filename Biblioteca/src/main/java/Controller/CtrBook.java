/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Components.ActionCellRenderer;
import Components.ActiveStatusRenderer;
import Components.CircularLabel;
import Modelo.Book;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONObject;
import view.FrmAddBook;
import view.FrmAddUser;
import view.FrmBook;
import view.FrmMenuManagement;
import view.FrmQuantityBooksLent;
import view.FrmQuantityUser;
import view.FrmUserBook;
import view.FrmUser;
import view.FrmViewBooks;

/**
 *
 * @author ASUS TUF A15
 */
public class CtrBook {
    
    private Book book;
    TableRowSorter<DefaultTableModel> sorter;

    private FrmBook frmBooks;


    public CtrBook(FrmBook frmBooks) {
        this.frmBooks = frmBooks;
        this.book = new Book();
    }
    
    public CtrBook() {
        this.book = new Book();
    }

    
    
    public List<String[]> getBook() {
        List<String[]> booksList = new ArrayList<>();

        try {
            String jsonString = book.getBook();  // Assuming some_user returns JSON string
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject bookObject = usersArray.getJSONObject(i);
                String[] userData = new String[6];  // Array of size 6 for each column
                userData[0] = bookObject.optString("id_book", "N/A");
                userData[1] = bookObject.optString("code", "N/A");
                userData[2] = bookObject.optString("title", "N/A");
                userData[3] = bookObject.optString("author", "N/A");
                userData[4] = bookObject.optString("description", "N/A");
                userData[5] = bookObject.optString("status" );
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
                new String[]{"id","Código", "Libro", "Autor", "Descripción","Estado" } // Nombres de las columnas
        );

        JTableBook.setModel(tableModel);

        
        List<String[]> book = this.getBook();

        // Limpia las celdas (en caso que se use la misma tabla pa otra cosa)
        tableModel.setRowCount(0);

        for (String[] bookData : book) {
            tableModel.addRow(bookData); 
        }
        
        sorter = new TableRowSorter<>(tableModel);
        JTableBook.setRowSorter(sorter);  

        
        TableColumn codigoColumn = JTableBook.getColumnModel().getColumn(0);
        codigoColumn.setMinWidth(0);
        codigoColumn.setMaxWidth(0);
        codigoColumn.setPreferredWidth(0);
        codigoColumn.setResizable(false);
        
        JTableBook.getColumnModel().getColumn(5).setCellRenderer(new ActiveStatusRenderer());
        TableColumn activoColumn = JTableBook.getColumnModel().getColumn(5);
        activoColumn.setCellRenderer(new ActiveStatusRenderer());
        activoColumn.setPreferredWidth(75);  
        activoColumn.setMaxWidth(75);        
        activoColumn.setMinWidth(75);   
        JTableBook.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JTableBook.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                int[] selectedRows = JTableBook.getSelectedRows();
                for (int row : selectedRows) {
                    boolean isActive = Boolean.parseBoolean(
                            JTableBook.getValueAt(row, 5).toString()
                    );
                    if (!isActive) {
                        // Si la fila no está activa, se elimina de la selección
                        JTableBook.removeRowSelectionInterval(row, row);
                    }
                }
            }
        }
    });
    }
      
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////77
    public List<String[]> getBookEdit() {
        List<String[]> booksList = new ArrayList<>();

        try {
            String jsonString = book.getBook();  // Assuming some_user returns JSON string
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject bookObject = usersArray.getJSONObject(i);
                String[] userData = new String[9];  // Array of size 6 for each column
                userData[0] = bookObject.optString("id_book", "N/A");
                userData[1] = bookObject.optString("title", "N/A");
                userData[2] = bookObject.optString("author", "N/A");
                userData[3] = bookObject.optString("language", "N/A");
                userData[4] = bookObject.optString("code", "N/A");
                userData[5] = bookObject.optString("grade", "N/A");
                userData[6] = bookObject.optString("section", "N/A");
                userData[7] = bookObject.optString("physical_state", "N/A");
                userData[8] = bookObject.optString("description", "N/A");
                
                
                
                
                booksList.add(userData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booksList;
    }
    
    
    public void loadBooksEdit(JTable JTableBook, FrmViewBooks frmviewbook) {
    DefaultTableModel tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Título", "Autor", "Idioma", "Código", "Grado", "Sección", "Estado Físico","Descripción", "Acciones"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Permite editar todas las columnas excepto la columna de "Acciones"
            return column >= 1 && column <= 8;
        }
    };

    JTableBook.setModel(tableModel);

    CtrBook controller = new CtrBook();
    List<String[]> books = controller.getBookEdit();

    // Limpia las filas en caso de reutilizar la tabla
    tableModel.setRowCount(0);

    for (String[] bookData : books) {
        Object[] rowData = new Object[bookData.length + 1];
        System.arraycopy(bookData, 0, rowData, 0, bookData.length);
        rowData[bookData.length] = ""; // Columna "Acciones"
        tableModel.addRow(rowData);
    }

    sorter = new TableRowSorter<>(tableModel);
    JTableBook.setRowSorter(sorter);

    TableColumn idColumn = JTableBook.getColumnModel().getColumn(0);
    idColumn.setMinWidth(0);
    idColumn.setMaxWidth(0);
    idColumn.setPreferredWidth(0);
    idColumn.setResizable(false);

    // Asignar renderer y editor a la columna de acciones
    JTableBook.getColumnModel().getColumn(9).setCellRenderer(new ActionCellRenderer());
    JTableBook.getColumnModel().getColumn(9).setCellEditor(new ActionCellEditor(JTableBook, frmviewbook));
}
public class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    private JButton viewButton;
    private JTable table;
    private FrmViewBooks frmviewbook;

    public ActionCellEditor(JTable table, FrmViewBooks frmviewbook) {
        this.table = table;
        this.frmviewbook = frmviewbook;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 0));
        viewButton = createIconButton("visto.png");

        viewButton.addActionListener(e -> {
            int row = table.getEditingRow();

            // Extraer datos de la fila actual
            int id = Integer.parseInt(table.getValueAt(row, 0).toString());
            String titulo = table.getValueAt(row, 1).toString();
            String autor = table.getValueAt(row, 2).toString();
            String idioma = table.getValueAt(row, 3).toString();
            String codigo = table.getValueAt(row, 4).toString();
            String grado = table.getValueAt(row, 5).toString();
            String seccion = table.getValueAt(row, 6).toString();
            String estadoFisico = table.getValueAt(row, 7).toString();
            String descrpcion = table.getValueAt(row, 8).toString();
            

            // Mostrar datos y confirmar la actualización
            int confirm = JOptionPane.showConfirmDialog(
                    table,
                    "Datos actuales:\n" +
                            "Título: " + titulo + "\n" +
                            "Autor: " + autor + "\n" +
                            "Idioma: " + idioma + "\n" +
                            "Código: " + codigo + "\n" +
                            "Grado: " + grado + "\n" +
                            "Sección: " + seccion + "\n" +
                            "Descripción: " + descrpcion + "\n" +
                            "Estado Físico: " + estadoFisico + "\n\n" +
                            "¿Desea actualizar estos datos?",
                    "Confirmación de Actualización",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Lógica para actualizar el libro
                CtrBook controller = new CtrBook();
                book.updateBook(id, titulo, autor,idioma , codigo, grado, seccion, descrpcion, estadoFisico);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(
                        table,
                        "Datos actualizados exitosamente.",
                        "Actualización Exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );

                // Recargar la tabla
                loadBooksEdit(table, frmviewbook);
            } else {
                // Recargar la tabla y mostrar mensaje de cancelación
                loadBooksEdit(table, frmviewbook);
                JOptionPane.showMessageDialog(
                        table,
                        "Actualización cancelada.",
                        "Cancelado",
                        JOptionPane.WARNING_MESSAGE
                );
            }

            // Detener la edición para evitar problemas visuales
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
    public void DataFiltter(JTextField FiltterTextField) {
        try {
            // Filtro que ignora mayúsculas y minúsculas usando (?i)
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + FiltterTextField.getText()));
        } catch (Exception e) {
            throw new RuntimeException("Error interno en el filtrado");
        }
    }

    
    //Mostrar y editar los libros 
    public List<String[]> getBookInformation() {
        List<String[]> booksList = new ArrayList<>();

        try {
            String jsonString = book.getBook();  // Assuming some_user returns JSON string
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject bookObject = usersArray.getJSONObject(i);
                String[] userData = new String[7];  // Array of size 6 for each column

                userData[0] = bookObject.optString("code", "N/A");
                userData[1] = bookObject.optString("author", "N/A");
                userData[2] = bookObject.optString("grade", "N/A");
                userData[3] = bookObject.optString("title", "N/A");
                userData[4] = bookObject.optString("language", "N/A");
                userData[5] = bookObject.optString("section", "N/A");
                userData[6] = bookObject.optString("description", "N/A");
                
                booksList.add(userData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booksList;
    }

    public void loadBooksInformation(JTable JTableBook) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{}, 
                new String[]{"Código",  "Autor","Grado" ,"Titulo","Idioma", "Sección","Descripción"} 
        );

        JTableBook.setModel(tableModel);

        
        List<String[]> book = this.getBookInformation();

        // Limpia las celdas (en caso que se use la misma tabla pa otra cosa)
        tableModel.setRowCount(0);

        for (String[] bookData : book) {
            tableModel.addRow(bookData); 
        }
        
        sorter = new TableRowSorter<>(tableModel);
        JTableBook.setRowSorter(sorter);  
    }
    
    //mostrar la cantidad de los libros mas leidos 
    public List<String[]> getBookQuantity() {
        List<String[]> booksList = new ArrayList<>();

        try {
            String jsonString = book.getBookQuantity();  // Assuming some_user returns JSON string
            JSONArray usersArray = new JSONArray(jsonString);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject bookObject = usersArray.getJSONObject(i);
                String[] userData = new String[6];  // Array of size 6 for each column
                userData[0] = bookObject.optString("title", "N/A");
                userData[1] = bookObject.optString("author", "N/A");
                userData[2] = bookObject.optString("description", "N/A");
                userData[3] = bookObject.optString("language", "N/A");
                userData[4] = bookObject.optString("grade", "N/A");
                userData[5] = bookObject.optString("loan_count","N/A" );
                booksList.add(userData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booksList;
    }
    public void bookQuantity(JTable JTableBook) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{}, 
                new String[]{"Titulo","Autor","Descripción" ,"Idioma","Grade", "Cantidad"} 
        );

        JTableBook.setModel(tableModel);

        
        List<String[]> book = this.getBookQuantity();

        // Limpia las celdas (en caso que se use la misma tabla pa otra cosa)
        tableModel.setRowCount(0);

        for (String[] bookData : book) {
            tableModel.addRow(bookData); 
        }
        
        sorter = new TableRowSorter<>(tableModel);
        JTableBook.setRowSorter(sorter);  
    }
    
    public void backUser(){
        FrmUser frmUserNew= new FrmUser ();
        frmBooks.setVisible(false);
        frmUserNew.setVisible(true);
    }
    public void nextUserBook(CtrUserBooks ctrUserBooks){
        FrmUserBook frmUserBook= new FrmUserBook(ctrUserBooks);
        
        frmBooks.setVisible(false);
        frmUserBook.setVisible(true); 
    }
    
    public void addBooks(FrmAddBook frmaddbook) {
        FrmMenuManagement frmenuMana = new FrmMenuManagement();
        String title = frmaddbook.getTitleBook();
        String author = frmaddbook.getAuthor();
        String language = frmaddbook.getLanguage();
        String code = frmaddbook.getCode();
        String grade = frmaddbook.getGrade();
        String section = frmaddbook.getSection();
        String description =frmaddbook.getDescription();
        String physical_state =frmaddbook.getPhysicalstate();
        
       
        // Confirmar si se desea agregar el usuario
        int confirm = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas agregar este usuario?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION
        );

        // Si el usuario confirma
        if (confirm == JOptionPane.YES_OPTION) {
            String resultMessage = book.addBook(title, author, language, code, grade, section, description, physical_state);

            // Mostrar mensaje según el resultado
            if (resultMessage.isEmpty()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Libro agregado con éxito.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
                );
                frmaddbook.setVisible(false);
                frmenuMana.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Error al agregar el libro: " + resultMessage,
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
    
    public void returnManagement(FrmViewBooks frmviewBooks){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
        frmviewBooks.setVisible(false);
        frmMenumana.setVisible(true);
    }
    public void returnManagementQ(FrmQuantityBooksLent frmviewBooksLent){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
        frmviewBooksLent.setVisible(false);
        frmMenumana.setVisible(true);
    }
    
    public void returnManagementA(FrmAddBook frmaddbook){
        FrmMenuManagement frmMenumana = new FrmMenuManagement();
         frmaddbook.setVisible(false);
        frmMenumana.setVisible(true);
    }
    
    public void seeUser(FrmQuantityBooksLent frmaddbook){
        FrmQuantityUser frmQuantityUser = new FrmQuantityUser();
         frmaddbook.setVisible(false);
        frmQuantityUser.setVisible(true);
    }
    
}
