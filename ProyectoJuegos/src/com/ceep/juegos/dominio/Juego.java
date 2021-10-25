
package com.ceep.juegos.dominio;


public class Juego {
    
    private String titulo;
    private String tipo;
    private double precio;
    private String plataforma;
    private String anio;
    
    //Contructores

    public Juego() {
    }

    public Juego(String titulo, String tipo, double precio, String plataforma, String anio) {
        this.tipo = tipo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.anio = anio;
    }
    
    //Getter and Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    
    
    
}
