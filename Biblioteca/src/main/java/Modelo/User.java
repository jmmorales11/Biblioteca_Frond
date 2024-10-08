/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

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
                System.out.println(information);
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

    public boolean login(String user, String password) {
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
            if (responseCode != 200) {
                throw new RuntimeException("Error: " + responseCode);
            } else {
                StringBuilder response = new StringBuilder();
                Scanner scanner = new Scanner(connection.getInputStream());
                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();

                // Mostrar la respuesta
                System.out.println(response.toString());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
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
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return information.toString(); 
    }

}
