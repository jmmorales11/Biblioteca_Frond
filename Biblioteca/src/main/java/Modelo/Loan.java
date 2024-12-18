/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author ASUS TUF A15
 */
public class Loan {
    public String some_loan() {
        StringBuilder information = new StringBuilder();

        try {
            URL url = new URL("http://localhost:8080/loan/some-data");
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
                
                System.out.println("Información obtenida de la base de datos: " + information.toString());
        
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return information.toString(); 
    }
    
    
    public String addLoan(int code,String date) {
        try {
            System.out.println("Inicio");
            URL url = new URL("http://localhost:8080/loan/returned-book/"+code);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            System.out.println("Inicio 3");

            String jsonInputString = "{\"date_of_devolution\": \"" + date+"\"}";
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
