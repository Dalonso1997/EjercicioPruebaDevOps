/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio01ud02accesodatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author daw2
 */
public class Conexion {

    private static Connection conn = null;
    private static String usuario;
    private static String contrasena;
    private static String url;

    private static void leerProperties() {

        try (FileInputStream fis = new FileInputStream("src/main/resources/db.properties")) {

            Properties prop = new Properties();
            prop.load(fis);
            url = prop.getProperty("db.url");
            usuario = prop.getProperty("db.user");
            contrasena = prop.getProperty("db.password");

        } catch (FileNotFoundException e) {
            System.out.println("Error fichero no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static Connection crearConexion() {

        leerProperties();
        if (conn == null) {
            try {
                conn =  DriverManager.getConnection(url, usuario, contrasena);
            } catch (SQLException e) {
                System.out.println("Error en la conexion: " + e.getMessage());
            }
        }
        return conn;
    }
    

   
    
    
}
