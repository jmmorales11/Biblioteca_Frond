/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTable;
import org.json.JSONObject;

/**
 *
 * @author ASUS TUF A15
 */
public class UserBook {

    
    private int id_user;
    private String userName;
    private String userLastName;
    private String userMail;
    private List<String[]> selectedBooks;
    public UserBook() {
        this.selectedBooks = new ArrayList<>();
    }

    // Getters y Setters
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public List<String[]> getSelectedBooksList() {
        return selectedBooks;
    }

    public void selectBooksFromTable(JTable jTable) {
        selectedBooks.clear();  // Limpiar la lista antes de agregar nuevos datos

        // Obtener las filas seleccionadas
        int[] selectedRows = jTable.getSelectedRows();

        if (selectedRows.length > 0) {
            // Iterar sobre las filas seleccionadas
            for (int i = 0; i < selectedRows.length; i++) {
                int selectedRow = selectedRows[i];
                String[] bookData = new String[5];  // Cambiar según el número de columnas

                // Obtener los valores de las columnas de la fila seleccionada
                bookData[0] = jTable.getValueAt(selectedRow, 0).toString();
                bookData[1] = jTable.getValueAt(selectedRow, 1).toString();  // Código
                bookData[2] = jTable.getValueAt(selectedRow, 2).toString();  // Libro
                bookData[3] = jTable.getValueAt(selectedRow, 3).toString();  // Autor
                bookData[4] = jTable.getValueAt(selectedRow, 4).toString();  // Descripción

                // Agregar los datos a la lista
                selectedBooks.add(bookData);
            }
        }
    }
    
    public String addLoan(int bookId, int userId,String acquisitionDate, String dateOfDevolution) {
        try {
            System.out.println("Inicio");
            URL url = new URL("http://localhost:8080/loan");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            System.out.println("Inicio 3");

            String jsonInputString = "{" +
                "\"acquisition_date\": \"" + acquisitionDate + "\"," +
                "\"date_of_devolution\": \"" + dateOfDevolution + "\"," +
                "\"book\": {\"id_book\": " + bookId + "}," +
                "\"user\": {\"id_user\": " + userId + "}" +
            "}";
            System.out.println(jsonInputString);

            // Enviar datos al backend
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode);

            if (responseCode == 200) {
                // Leer la respuesta exitosa
                StringBuilder response = new StringBuilder();
                try (Scanner scanner = new Scanner(connection.getInputStream())) {
                    while (scanner.hasNext()) {
                        response.append(scanner.nextLine());
                    }
                }
                System.out.println("Respuesta: " + response.toString());
                return ""; 
            } else {
                // Leer la respuesta de error como JSON
                StringBuilder errorResponse = new StringBuilder();
                try (Scanner scanner = new Scanner(connection.getErrorStream())) {
                    while (scanner.hasNext()) {
                        errorResponse.append(scanner.nextLine());
                    }
                }
                
                JSONObject json = new JSONObject(errorResponse.toString());
                String errorMessage = json.getString("message");
                System.err.println("Error del backend: " + errorMessage); 
                return errorMessage; 
            }
        } catch (Exception e) {
            return "Ocurrió un error inesperado: " + e.getMessage();
        }
    }

    

    
}
