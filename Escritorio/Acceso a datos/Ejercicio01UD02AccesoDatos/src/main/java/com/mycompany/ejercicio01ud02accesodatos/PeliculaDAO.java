/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio01ud02accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw2
 */
public class PeliculaDAO implements PeliculasDAORepository{

    private Connection conectar() throws SQLException{
        return Conexion.crearConexion();
    }
    
    @Override
    public Pelicula guardarPelicula(Pelicula p) {
        String instruccion = "INSERT INTO movies (title,director,release_year,genre) VALUES(?,?,?,?)";
        
        try (Connection con = conectar();
                PreparedStatement ps = con.prepareStatement(instruccion, Statement.RETURN_GENERATED_KEYS)){
            
           ps.setString(1, p.getTitulo());
           ps.setString(2, p.getDirector());
           ps.setInt(3, p.getAnioEstreno());
           ps.setString(4, p.getGenero());
           int filaAfectada = ps.executeUpdate();
           ResultSet rs = ps.getGeneratedKeys();
           if (rs.next()){
               p.setId(rs.getInt(1));
           }
            
        } catch (SQLException e){
            System.out.println("Error al conectar con la base de datos"+ e.getMessage());
            return null;
        }
        
        
        return p;
    }

    @Override
    public Pelicula buscarPorId(int id) {
        String instruccion = "Select id,title,director,release_year,genre from movies where id=?";
        Pelicula p = null;
        try (Connection con = conectar();
                PreparedStatement ps = con.prepareStatement(instruccion)){
            
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                
                p = new Pelicula();
                
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("title"));
                p.setAnioEstreno(rs.getInt("release_year"));
                p.setDirector(rs.getString("director")); 
                p.setGenero(rs.getString("genre"));
                
            }
            
        } catch (SQLException e){
            System.out.println("Error en la sentencia select: "+e.getMessage());
        }
        
        return p;
        
    }

    @Override
    public List<Pelicula> listarPeliculas() {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        Pelicula pelicula = null;
        String instruccion = "SELECT id,title,director,release_year,genre from movies";
        
        try (Connection con = conectar();
            
                PreparedStatement ps = con.prepareStatement(instruccion)){
            
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()){
                    
                    pelicula = new Pelicula();
                    
                    pelicula.setId(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnioEstreno(rs.getInt(4));
                    pelicula.setGenero(rs.getString(5));
                    
                    listaPeliculas.add(pelicula);
                }
            
        } catch (SQLException e){
            System.out.println("Error en la sentencia SQL: "+e.getMessage());
        }
        
        return listaPeliculas;
        
    }

    @Override
    public boolean actualizar(Pelicula p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    
    
}
