/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ejercicio01ud02accesodatos;

import java.util.List;

/**
 *
 * @author daw2
 */
public interface PeliculasDAORepository {
    
    Pelicula guardarPelicula(Pelicula p);
    
    Pelicula buscarPorId(int id);
    
    List<Pelicula> listarPeliculas();
    
    boolean actualizar(Pelicula p);
    
    boolean eliminar(int id);
}
