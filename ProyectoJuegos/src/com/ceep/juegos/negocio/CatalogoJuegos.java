
package com.ceep.juegos.negocio;

import com.ceep.juegos.datos.AccesoDatos;
import com.ceep.juegos.datos.IAccesoDatos;
import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.AccesoDatosEx;
import com.ceep.juegos.excepciones.EscrituraDatosEx;
import com.ceep.juegos.excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CatalogoJuegos implements IACatalogoJuegos {
    
    private  final IAccesoDatos datos; //Se utiliza para acceder a la capa de datos

    
    
    public CatalogoJuegos() {
        this.datos = new AccesoDatos();
    }


    @Override
    public double CalcularTotalPrecio(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
//        Juego juegoN = null;
         double total = 0.0;
        String[] juego = new String[5]; //(id, Titulo,tipo,precio,plataforma,anio,cantidad)
//        List<Juego> juegos = new ArrayList<>();

        try {

            BufferedReader entrada = new BufferedReader(new FileReader(archivo));// entrada es el descriptor de lectura
            String lectura = entrada.readLine();// nos devuelve una línea de nuestro archivo
            //Lectura = "id";"titulo";"tipo";"precio";"plataforma";"anio";
            while ((lectura = entrada.readLine()) != null) { // hasta null
                juego = lectura.split(";"); //Lectura = "id";"titulo";"tipo";"precio";"plataforma";"anio";"cantidad";
                total += Double.parseDouble(juego[3]);
                // Creamos un objeto de Juego con cada línea del archivo
                // Añado cada juego a mi listado de juegos
//                juegoN = new Juego(Integer.parseInt(juego[0]), juego[1],
//                        juego[2], Double.parseDouble(juego[3]),
//                        juego[4], formatoFecha.parse(juego[5]));
//                juegos.add(juegoN);
                // Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } 
        return total;
    }

    @Override
    public int contadorJuegos(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
//        Juego juegoN = null;
         int total = 0;
//        String[] juego = new String[5]; //(id, Titulo,tipo,precio,plataforma,anio,cantidad)
//        List<Juego> juegos = new ArrayList<>();

        try {

            BufferedReader entrada = new BufferedReader(new FileReader(archivo));// entrada es el descriptor de lectura
            String lectura = entrada.readLine();// nos devuelve una línea de nuestro archivo
            //Lectura = "id";"titulo";"tipo";"precio";"plataforma";"anio";
            while ((lectura = entrada.readLine()) != null) { // hasta null
//                juego = lectura.split(";"); //Lectura = "id";"titulo";"tipo";"precio";"plataforma";"anio";"cantidad";
                total += 1;
                // Creamos un objeto de Juego con cada línea del archivo
                // Añado cada juego a mi listado de juegos
//                juegoN = new Juego(Integer.parseInt(juego[0]), juego[1],
//                        juego[2], Double.parseDouble(juego[3]),
//                        juego[4], formatoFecha.parse(juego[5]));
//                juegos.add(juegoN);
                // Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } 
        return total;
    }

    @Override
    public double maxPrecioJuego(String nombreArchivo)throws LecturaDatosEx {
         File archivo = new File(nombreArchivo);
//        Juego juegoN = null;
         double max = 0.0;
        String[] juego = new String[5]; //(id, Titulo,tipo,precio,plataforma,anio,cantidad)
//        List<Juego> juegos = new ArrayList<>();

        try {

            BufferedReader entrada = new BufferedReader(new FileReader(archivo));// entrada es el descriptor de lectura
            String lectura= null;
            //Lectura = "id";"titulo";"tipo";"precio";"plataforma";"anio";
            while ((lectura = entrada.readLine()) != null) { // hasta null
                juego = lectura.split(";"); //Lectura = "id";"titulo";"tipo";"precio";"plataforma";"anio";"cantidad";
                // Creamos un objeto de Juego con cada línea del archivo
                // Añado cada juego a mi listado de juegos
                if (Double.parseDouble(juego[3]) >max) {
                    max = Double.parseDouble(juego[3]);
                    
                }
//                juegoN = new Juego(Integer.parseInt(juego[0]), juego[1],
//                        juego[2], Double.parseDouble(juego[3]),
//                        juego[4], formatoFecha.parse(juego[5]));
//                juegos.add(juegoN);
                // Avanzamos en la lectura
//                lectura = entrada.readLine();
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } 
        return max;
    }
    
}
