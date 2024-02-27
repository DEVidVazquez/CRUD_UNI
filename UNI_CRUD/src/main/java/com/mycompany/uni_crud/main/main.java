/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uni_crud.main;

import com.mycompany.uni_crud.db.ConectionDB;
import com.mycompany.uni_crud.modelo.*;
import java.sql.*;
import java.util.*;
import com.mycompany.uni_crud.modelo.Carrera.*;
import com.mycompany.uni_crud.modelo.CarreraDAO.*;
import com.mycompany.uni_crud.main.UNI_CRUD.*;


/**
 *
 * @author Mati
 */
public class main {

    public static void main(String[] args){
        int selector, contador = 1;
        String name;
        Scanner sc = new Scanner(System.in);
        Connection conexion = ConectionDB.Conexion();
        do {
            UNI_CRUD.Menu();
            selector = sc.nextInt();
            switch (selector) {

                case 1:
                    System.out.println("Introduce el nombre de la carrera");
                    name = sc.nextLine();
                    Carrera cr1 = new Carrera(contador, name);
                    //CarreraDAO.agregarCarrera(cr1);
                    contador++;
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la carrera");
                    name = sc.nextLine();
                    Carrera cr2 = new Carrera(contador, name);
                    //CarreraDAO.actualizarCarrera(cr2);
                    contador++;
                    break;
                case 3:
                    //CarreraDAO.obtenerTodasLasCarreras();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la carrera");
                    name = sc.nextLine();
                    Carrera cr3 = new Carrera(contador, name);
                    //CarreraDAO.obtenerCarreraPorNombre(cr3.getNombre());
                    contador++;
                    break;
                case 5:
                    System.out.println("Introduce el nombre de la carrera");
                    name = sc.nextLine();
                    Carrera cr4 = new Carrera(contador, name);
                    Carrera.eliminarCarrera(cr4.getId());
                    contador++;
                    break;
                default:

                    break;

            }
        } while (selector != 0);

        sc.close();
        ConectionDB.CerrarConexion(conexion);
    }

}
