package com.ceep.juegos.dominio;

import java.util.Date;

public class Juego {
    
    private int id;
    private String titulo;
    private String tipo;
    private double precio;
    private String plataforma;
    private Date anio;
    private static int contador = 0;

    //Contructores
    public Juego() {
        this.id = Juego.contador++;
    }

    public Juego(String titulo, String tipo, double precio, String plataforma, Date anio) {
        this();
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.anio = anio;
    }

    public Juego(int id, String titulo, String tipo, double precio, String plataforma, Date anio) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.anio = anio;
    }
    
    


    //Getter and Setters

    public int getId() {
        return id;
    }

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

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }


    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Juego.contador = contador;
    }

    
    //toString

    @Override
    public String toString() {
        return "Juego{" + "id=" + id + ", titulo=" + titulo +
                ", tipo=" + tipo + ", precio=" + precio + ", plataforma=" + plataforma +
                ", anio=" + anio +'}';
    }
    
    
    
    
}
