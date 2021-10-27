package com.ceep.juegos.datos;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.AccesoDatosEx;
import com.ceep.juegos.excepciones.EscrituraDatosEx;
import com.ceep.juegos.excepciones.LecturaDatosEx;
import java.util.List;


public interface IAccesoDatos {
    
    
    
    
    // Comprueba si el fichero existe 
    boolean existe(String nombreArchivo);
    
    // Lista todas los juegos contenidos en el archivo nombreArchivo
    List<Juego> listar(String nombreArchivo) throws LecturaDatosEx;
    
    // Escribe un nuevo juego en el archivo nombreArchivo
    // con el parámetro anexar podemos indicar si queremos agregar el juego o
    // sobreescribir
    void escribir(Juego juego, String nombreArchivo, boolean anexar) 
            throws EscrituraDatosEx;
    
    // Busca la expresión de buscar en el archivo y nos muestra un mensaje en
    // caso de que lo encuentro o no
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    // Crea el archivo
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    // Borra el archivo
    void borrar(String nombreArchivo);
    

    
    
    
}
