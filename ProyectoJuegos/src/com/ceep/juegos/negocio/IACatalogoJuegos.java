package com.ceep.juegos.negocio;

import com.ceep.juegos.excepciones.LecturaDatosEx;

public interface IACatalogoJuegos {
    
    
    double CalcularTotalPrecio(String nombreArchivo) throws LecturaDatosEx;
    
    int contadorJuegos(String nombreArchivo)throws LecturaDatosEx;
    
    double maxPrecioJuego(String nombreArchivo)throws LecturaDatosEx;
}
