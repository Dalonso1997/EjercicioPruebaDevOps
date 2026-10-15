/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio01ud02accesodatos;

import java.util.Objects;

/**
 *
 * @author daw2
 */
public class Pelicula {
    
    private Integer id;
    private String titulo;
    private String director;
    private Integer anioEstreno;
    private String genero;
    
    public Pelicula(){
        
    }
    
    public Pelicula(Integer id, String titulo, String director, Integer anioEstreno, String genero){
        this.id = id;
        setTitulo(titulo);
        setDirector(director);
        this.anioEstreno = anioEstreno;
        setGenero(genero);
    }
    
    public Pelicula(String titulo, String director, Integer anioEstreno, String genero){
        setTitulo(titulo);
        setDirector(director);
        this.anioEstreno = anioEstreno;
        setGenero(genero);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null | titulo.isBlank()){
            throw new IllegalArgumentException("El titulo no es obligatorio");
        }
        if (titulo.length() > 150){
            throw new IllegalArgumentException("EL titulo no puede superar los 150 caracteres");
        }
        
        this.titulo = titulo;
        
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if(director != null && director.length() > 100){
            throw new IllegalArgumentException("El nombre no puede superar los 100 caracteres.");
        }
        this.director = director;
    }

    public Integer getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero != null | genero.length() > 25){
            throw new IllegalArgumentException("El nombre no puede superar los 25 caracteres");
        }
        
        this.genero = genero;
    }
    
    @Override
    public boolean equals(Object o){
        
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula otra = (Pelicula) o;
        return id != null && id.equals(otra.id);
        
    }
    
    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }
    
    
}
