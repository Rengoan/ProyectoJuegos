package com.ceep.juegos.negocio;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.LecturaDatosEx;

public interface IACatalogoJuegos {
    
    //Pre-condicion: No existe el fichero
    //Post-condicion: Crear un nuevo recurso
    String inicializarCatalogo(String nombreArchivo);
    
    String listarJuegos(String nombreArchivo);
    
    void agregarJuego(String nombreArchivo, Juego juego);
    
    String buscarJuego(String nombreArchivo, String titulo);
    
    double CalcularTotalPrecio(String nombreArchivo) throws LecturaDatosEx;
    
    int contadorJuegos(String nombreArchivo)throws LecturaDatosEx;
    
    double maxPrecioJuego(String nombreArchivo)throws LecturaDatosEx;
    
    String borrarCatalogo(String nombreArchivo);
    
    String borrarJuego(String nombreArchivo,String nombreJuego);
    
    String mostrarID(String nombreArchivo,int id);
    
}
