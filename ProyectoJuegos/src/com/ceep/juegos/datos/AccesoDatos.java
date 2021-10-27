package com.ceep.juegos.datos;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.AccesoDatosEx;
import com.ceep.juegos.excepciones.EscrituraDatosEx;
import com.ceep.juegos.excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos implements IAccesoDatos {
    
    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

   
    @Override
    public List<Juego> listar(String nombreArchivo  ) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        List<Juego> juegos = new ArrayList<>();
        
        try {
            // entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // nos devuelve una línea de nuestro archivo
            var lectura = entrada.readLine();
            while(lectura != null){ // hasta null
                // Creamos un objeto de Juego con cada línea del archivo
                // Añado cada juego a mi listado de juegos
                juegos.add(new Juego(lectura, lectura, 0, lectura, lectura, 0));
                // Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            entrada.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        }
        return juegos;
    }
    

    @Override
   public void escribir(Juego juegos, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(juegos);
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepción al escribir en el archivo");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String titulo) throws LecturaDatosEx {
       var archivo = new File(nombreArchivo);
        int cont = 1;
        String mensaje = "";
        try {
            // entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // nos devuelve una línea de nuestro archivo
            var lectura = entrada.readLine();
            while(lectura != null){ // 
                if (lectura.equalsIgnoreCase(titulo)){
                    mensaje = "El juego " + titulo + " se encuentra en la "
                            + "línea " + cont + " del catálogo de juegos";
                    break;
                }
                lectura = entrada.readLine();
                cont++;
            }
            if (lectura == null) 
                mensaje = "El juego " + titulo + " no está "
                    + "en el catálogo de juegos.";
            
            entrada.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        }
        return mensaje;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }




    
}
