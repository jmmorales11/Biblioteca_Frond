/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author ASUS TUF A15
 */
public class User {

    public User() {
    }

    public void connectiondb() {

        try {
            URL url = new URL("http://localhost:8080/user");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            //Pedir
            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("Error" + responseCode);
            } else {
                //Leer datos
                StringBuilder information = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    information.append(scanner.nextLine());
                }
                scanner.close();

                //Mostrar la informacion ontenida
                //System.out.println(information);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String some_user() {
        StringBuilder information = new StringBuilder();

        try {
            URL url = new URL("http://localhost:8080/user/some-data");
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
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return information.toString(); 
    }
    
    

    public String login(String user, String password) {
    try {
        URL url = new URL("http://localhost:8080/user/login");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");

        String jsonInputString = "{\"code\": \"" + user + "\", \"password\": \"" + password + "\"}";
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int responseCode = connection.getResponseCode();
        StringBuilder response = new StringBuilder();
        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
        }

        if (responseCode != 200) {
            return "Error: " + response.toString();
        }

        return response.toString(); // Devuelve el mensaje del servidor

    } catch (Exception e) {
        e.printStackTrace();
        return "Error al conectar con el servidor.";
    }
}


    
    

    
    public String addUser(String code, String typeUser, String name, String lastName, String mail, String grade) {
        try {
            System.out.println("Inicio");
            URL url = new URL("http://localhost:8080/user/without-password");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            System.out.println("Inicio 3");

            String jsonInputString = "{\"user_name\": \"" + name + 
                    "\", \"user_last_name\": \"" + lastName + 
                    "\", \"mail\": \"" + mail + 
                    "\", \"role\": \"" + typeUser + 
                    "\", \"grade\": \"" + grade + 
                    "\" , \"code\": \"" + code + "\"}";
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

    public String updateUser(int userId, String userName, String userLastName, String mail, String role, String grade, String code) {
    try {
        // Establecer la URL para la actualización
        URL url = new URL("http://localhost:8080/user/update/" + userId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");  // Cambiar a PUT para actualización
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");

        // Crear el cuerpo JSON con los nuevos datos del usuario
        String jsonInputString = "{" +
            "\"user_name\": \"" + userName + "\"," +
            "\"user_last_name\": \"" + userLastName + "\"," +
            "\"mail\": \"" + mail + "\"," +
            "\"role\": \"" + role + "\"," +
            "\"grade\": \"" + grade + "\"," +
            "\"code\": \"" + code + "\"" +
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
    //contar usuarios 
    public String  userQuantity() {
        
        StringBuilder information = new StringBuilder();

        try {
            URL url = new URL("http://localhost:8080/loan/ranking-users");
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
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return information.toString(); 
    }
}
