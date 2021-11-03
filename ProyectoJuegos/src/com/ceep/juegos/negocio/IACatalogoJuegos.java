package com.ceep.juegos.negocio;

public interface IACatalogoJuegos {
    
    // Agrega una Película al catálogo
    void agregarJuego(String titulo, String tipo, double precio, String plataforma, String anio, int cantidad , String nombreCatalogo);
    
    // Mostrar todas los juegos del catálogo
    void listarJuego(String nombreCatalogo);
    
    // Busca el juego "Buscar" en nuestro catálogo
    void buscarJuego(String nombreCatalogo, String buscar);
    
    // Nos inicia nuestro catálogo
    void iniciarCatalogo(String nombreCatalogo);
    
    double maximo(double precio);
}
