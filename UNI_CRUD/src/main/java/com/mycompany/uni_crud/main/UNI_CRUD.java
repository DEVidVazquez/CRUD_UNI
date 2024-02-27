/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.uni_crud.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mati
 */
public class UNI_CRUD {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            String url = "jdbc:mysql://localhost:3306/bd_institucion";
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);

            // Comprobar si la conexión fue exitosa
            if (connection != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            } else {
                System.out.println("Error al conectar a la base de datos.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo encontrar el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión a la base de datos.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }

    public static void Menu() {
        System.out.println("---------------GESTIÓN DE CARRERAS---------------");
        System.out.println("1. AÑADIR UNA NUEVA CARRERA");
        System.out.println("2. ACTUALIZAR UNA CARRERA EXISTENTE");
        System.out.println("3. VER TODAS LAS CARRERAS EXISTENTES");
        System.out.println("4. VER UNA CARRERA EXISTENTE");
        System.out.println("5. ELIMINAR UNA CARRERA");
        System.out.println("0. SALIR DEL PROGRAMA");
        System.out.println("-------------------------------------------------");
    }
}
