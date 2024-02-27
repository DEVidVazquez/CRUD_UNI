package com.mycompany.uni_crud.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarreraDAO {
    
    private Connection connection;
    
    public CarreraDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarCarrera(Carrera carrera) throws SQLException {
        String query = "INSERT INTO Carrera (id, nombre) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, carrera.getId());
            statement.setString(2, carrera.getNombre());
            statement.executeUpdate();
        }
    }

    public void actualizarCarrera(Carrera carrera) throws SQLException {
        String query = "UPDATE Carrera SET nombre = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, carrera.getNombre());
            statement.setInt(2, carrera.getId());
            statement.executeUpdate();
        }
    }

    public Carrera obtenerCarrera(int id) throws SQLException {
        String query = "SELECT * FROM Carrera WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Carrera(resultSet.getInt("id"), resultSet.getString("nombre"));
                }
            }
        }
        return null;
    }

    public Carrera obtenerCarreraPorNombre(String nombre) throws SQLException {
        String query = "SELECT * FROM Carrera WHERE nombre = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombre);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Carrera(resultSet.getInt("id"), resultSet.getString("nombre"));
                }
            }
        }
        return null;
    }

    public void eliminarCarrera(int id) throws SQLException {
        String query = "DELETE FROM Carrera WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<Carrera> obtenerTodasLasCarreras() throws SQLException {
        List<Carrera> carreras = new ArrayList<>();
        String query = "SELECT * FROM Carrera";
        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Carrera carrera = new Carrera(resultSet.getInt("id"), resultSet.getString("nombre"));
                carreras.add(carrera);
            }
        }
        return carreras;
    }

}
