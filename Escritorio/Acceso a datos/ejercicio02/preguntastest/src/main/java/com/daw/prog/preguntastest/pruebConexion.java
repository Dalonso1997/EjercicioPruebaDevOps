/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.daw.prog.preguntastest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 *
 * @author daw2
 */
public class pruebConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try (Connection con = Conexion.getConexion()){
            
            System.out.println("Conectado con la base de datos");
            
            DatabaseMetaData datos = con.getMetaData();
            
            System.out.println(datos.getUserName());
            System.out.println(datos.getURL());
            System.out.println(datos.getSchemaTerm());
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
