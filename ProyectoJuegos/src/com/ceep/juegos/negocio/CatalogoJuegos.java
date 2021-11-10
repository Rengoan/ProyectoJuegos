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

    private final IAccesoDatos datos; //Se utiliza para acceder a la capa de datos

    public CatalogoJuegos() {
        this.datos = new AccesoDatos();
    }

    @Override
    public double CalcularTotalPrecio(String nombreArchivo) throws LecturaDatosEx {

        List<Juego> juegos = new ArrayList<>();
        double total = 0.0;

        try {
            juegos = this.datos.listar(nombreArchivo);

            for (int i = 0; i < juegos.size(); i++) {
                total += juegos.get(i).getPrecio();
            }

        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");

        }
        return total;
    }

    @Override
    public int contadorJuegos(String nombreArchivo) throws LecturaDatosEx {
        List<Juego> juegos = new ArrayList<>();
        int contador = 0;

        try {
            juegos = this.datos.listar(nombreArchivo);

        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");

        }
        return juegos.size();
    }

    @Override
    public double maxPrecioJuego(String nombreArchivo) throws LecturaDatosEx {
        List<Juego> juegos = new ArrayList<>();
        double max = 0.0;

        try {
            juegos = this.datos.listar(nombreArchivo);

            for (int i = 0; i < juegos.size(); i++) {
                if (max < juegos.get(i).getPrecio()) {
                    max = juegos.get(i).getPrecio();
                }
            }

        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");

        }
        return max;
    }

    @Override
    public String inicializarCatalogo(String nombreArchivo) {
        if (this.datos.existe(nombreArchivo)) {
            this.datos.borrar(nombreArchivo);
            
        }
        return "Catalogo inicializado";
    }

    @Override
    public String listarArticulos(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarJuego(String nombreArchivo, Juego juego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String buscarJuego(String nombreArchivo, String titulo) {
        try{
            this.datos.buscar(nombreArchivo, titulo);
        } catch(LecturaDatosEx ex){
            ex.printStackTrace(System.out);
            System.out.println("Excepcion leyendo el archivo");
        }
        return "";
    }

    @Override
    public String borrarCatalogo(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String borrarJuego(String nombreArchivo,String nombreJuego) {
        try{
            this.datos.borrarJuego(nombreArchivo, nombreJuego);
        } catch(AccesoDatosEx ex){
            ex.printStackTrace(System.out);
            System.out.println("Excepcion al borrar un juego");
        }
        return "";
    }

    @Override
    public String listarJuegos(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String mostrarID(String nombreArchivo, int id) {
        List<Juego> juegos = new ArrayList<>();
 
        try {
            juegos = this.datos.listar(nombreArchivo);

            for (int i = 0; i < juegos.size(); i++) {
                if (juegos.get(i).getId() == id) {
                    juegos.get(i).toString();
                    break;
                }
            }

        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);

        }
        return nombreArchivo;
    
    }

}
