package com.ceep.juegos.dominio;

public class Juego {

    private String titulo;
    private String tipo;
    private double precio;
    private String plataforma;
    private String anio;
    private int cantidad;

    //Contructores
    public Juego() {

    }

    public Juego(String titulo, String tipo, double precio, String plataforma, String anio, int cantidad) {
        this();
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.anio = anio;
        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //toString
    @Override
    public String toString() {
        return "titulo= " + titulo + ", tipo= " + tipo
                + ", precio= " + precio + ", plataforma= " + plataforma
                + ", año= " + anio + ", cantidad= " + cantidad + '}';
    }

}
