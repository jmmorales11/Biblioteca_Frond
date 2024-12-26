/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author ASUS TUF A15
 */
public class Book {
    
    public String getBook() {
        StringBuilder information = new StringBuilder();

        try {
            URL url = new URL("http://localhost:8080/book");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("Error: " + responseCode);
            } else {
                // Leer los datos
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    information.append(scanner.nextLine());
                }
                scanner.close();
                //System.out.println(information);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return information.toString(); 
    }
    
    public String addBook(String title, String author, String language, String code, String grade, String section, String description, String physical_state, BigDecimal price) {
        try {
            System.out.println("Inicio");
            URL url = new URL("http://localhost:8080/book");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            System.out.println("Inicio 3");

            String jsonInputString = "{\"title\": \"" + title + 
                    "\", \"author\": \"" + author + 
                    "\", \"language\": \"" + language + 
                    "\", \"code\": \"" + code + 
                    "\", \"grade\": \"" + grade + 
                    "\" , \"section\": \"" + section +
                    "\" , \"description\": \"" + description + 
                    "\" , \"physical_state\": \"" + physical_state+ "\"," +
            "\"price\": " +  price.toPlainString()+ // Sin comillas alrededor de precio
        "}";
            System.out.println(jsonInputString);

            // Enviar datos al backend
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

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
    //Mostrar los libros mas leido
    
    public String getBookQuantity() {
        StringBuilder information = new StringBuilder();

        try {
            URL url = new URL("http://localhost:8080/loan/ranking-books");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("Error: " + responseCode);
            } else {
                // Leer los datos
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    information.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(information);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return information.toString(); 
    }
    public String updateBook(int bookId, String title, String author, String language, String code, String grade, String section, String description, String physicalState, BigDecimal precio) {
    try {
        // Establecer la URL para la actualización del libro
        URL url = new URL("http://localhost:8080/book/update/" + bookId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT"); // Cambiar a PUT para la actualización
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");

        String jsonInputString = "{" +
            "\"title\": \"" + title + "\"," +
            "\"author\": \"" + author + "\"," +
            "\"language\": \"" + language + "\"," +
            "\"code\": \"" + code + "\"," +
            "\"grade\": \"" + grade + "\"," +
            "\"section\": \"" + section + "\"," +
            "\"description\": \"" + description + "\"," +
            "\"physical_state\": \"" + physicalState + "\"," +
            "\"price\": " +  precio.toPlainString()+ // Sin comillas alrededor de precio
        "}";


        System.out.println("Datos a enviar: " + jsonInputString);

        // Enviar datos al backend
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Leer la respuesta del backend
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
            return "Actualización exitosa";
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
    public String getPriceBook() {
        StringBuilder information = new StringBuilder();

        try {
            URL url = new URL("http://localhost:8080/book/amount");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("Error: " + responseCode);
            } else {
                // Leer los datos
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    information.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(information);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return information.toString(); 
    }

}
