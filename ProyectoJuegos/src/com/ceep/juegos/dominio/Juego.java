
package com.ceep.juegos.dominio;


public class Juego {
    
    private String titulo;
    private String tipo;
    private double precio;
    private String plataforma;
    private String anio;
    private double precioActual;
    private double total;
    private double diferencia;
    private int cantidad;
    
    //Contructores

    public Juego() {
        
    }

    public Juego(String titulo, String tipo, double precio, String plataforma, String anio, double precioActual, double total, double diferencia, int cantidad) {
        this();
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.anio = anio;
        this.precioActual = precioActual;
        this.total = precioActual * cantidad;
        this.diferencia = precio - precioActual;
        this.cantidad = cantidad;
       
    }

    public Juego(String lectura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(double diferencia) {
        this.diferencia = diferencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
    
    
}
