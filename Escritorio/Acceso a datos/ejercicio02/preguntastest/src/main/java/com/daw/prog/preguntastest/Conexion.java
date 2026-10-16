/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.prog.preguntastest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author daw2
 */
public class Conexion {

    private static final String FICHERO = "/db.properties";
    
    private static final Properties prop = cargarPropiedades();
    
    private static final String URL = obligatoria(prop, "db.url");
    private static final String USUARIO = obligatoria(prop, "db.user");
    private static final String PASSWORD = obligatoria(prop, "db.password");
    
    

    private Conexion() {

    }

    public static Connection getConexion() throws SQLException {

        return DriverManager.getConnection(URL, USUARIO, PASSWORD);

    }
    
    
    private static Properties cargarPropiedades(){
        
        
        Properties prop = new Properties();
        
        try (InputStream in = Conexion.class.getResourceAsStream(FICHERO)){
            
            if (in ==  null){
                throw new IllegalStateException("No se encuentra "+FICHERO+" en src/main/resources.");
            }
            
            prop.load(new InputStreamReader(in, StandardCharsets.UTF_8));
            
            
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return prop;
    }
    
    private static String obligatoria(Properties prop,String clave){
        
        String valor = prop.getProperty(clave);
        
        if (valor == null || valor.isBlank()){
            throw new IllegalStateException("Falta la propiedad");
        } 
        
        return valor.trim();
        
    }
    
    
}
