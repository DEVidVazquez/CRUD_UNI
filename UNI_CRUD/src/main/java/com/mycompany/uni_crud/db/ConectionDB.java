/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uni_crud.db;

import java.sql.*;

/**
 *
 * @author Mati
 */
public class ConectionDB {

    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/bd_institucion";
    public static final String user = "root";
    public static final String pass = "1234";

    public static Connection Conexion() {
        Connection connection = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            connection = DriverManager.getConnection(url, user, pass);

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
        }

        return connection;
    }

    public static void CerrarConexion(Connection conex) {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }

}
