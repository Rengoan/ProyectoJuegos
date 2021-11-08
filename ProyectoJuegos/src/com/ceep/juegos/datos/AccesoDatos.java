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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Juego> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        Juego juegoN = null;
        String[] juego = new String[5]; //(id, Titulo,tipo,precio,plataforma,anio,cantidad)
        List<Juego> juegos = new ArrayList<>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try {

            BufferedReader entrada = new BufferedReader(new FileReader(archivo));// entrada es el descriptor de lectura
            String lectura = entrada.readLine();// nos devuelve una línea de nuestro archivo
            //Lectura = "id";"titulo";"tipo";"precio";"plataforma";"anio";
            while ((lectura = entrada.readLine()) != null) { // hasta null
                juego = lectura.split(";"); //Lectura = "id";"titulo";"tipo";"precio";"plataforma";"anio";"cantidad";
                // Creamos un objeto de Juego con cada línea del archivo
                // Añado cada juego a mi listado de juegos
                juegoN = new Juego(Integer.parseInt(juego[0]), juego[1],
                        juego[2], Double.parseDouble(juego[3]),
                        juego[4], formatoFecha.parse(juego[5]));
                juegos.add(juegoN);
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
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
        return juegos;
    }

    @Override
    public void escribir(Juego juegos, String nombreArchivo) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); //Para agregar una nueva linea
            //Formato de cada linea del fichero es: id;titulo,tipo;precio;plataforma;anio;
            String game = juegos.getId() + ";" + juegos.getTitulo() + ";"
                    + juegos.getTipo() + ";" + juegos.getPrecio() + ";"
                    + juegos.getPlataforma() + ";" + juegos.getAnio() + ";";
            salida.println(game);
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepción al escribir en el archivo");
        }
    }

    //1. Busqueda en todos los campos
    //2. Busqueda especificando el campo por el que se quiere buscar
    //3. Busquedas que contengan el termino
    @Override
    //Busqueda simple
    public int buscar(String nombreArchivo, String titulo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String[] juego = new String[5];
        int cont = 1;
        try {
            // entrada es el descriptor de lectura
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            // nos devuelve una línea de nuestro archivo
            String lectura = entrada.readLine();
            while (lectura != null) {
                juego = lectura.split(";");
                if (titulo.equalsIgnoreCase(juego[1])) { //id;titulo,tipo;precio
                    //;plataforma;anio; Ya que vamos a buscar por titulo es la posicion 1 del array
                    break;
                }
                cont++;
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando los juegos");
        }
        return cont;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear el archivo");
        }
    }

    @Override
    public String borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        String msg = "";
        if (existe(nombreArchivo)) {
            archivo.delete();
            msg = "Archivo borrado con exito";
        } else {
            msg = "No se ha podido borrar el archivo ya que no existe";
        }
        return msg;
    }

    @Override
    public void borrarJuego(String nombreArchivo, String titulo) throws AccesoDatosEx {
        File archivoOri = new File(nombreArchivo);
        File archivoBackup = new File("temp.txt");

        String[] juego = new String[5];

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivoOri));
            PrintWriter salida = new PrintWriter(new FileWriter(archivoBackup));
            String lectura = null;

            while ((lectura = entrada.readLine()) != null) {
                juego = lectura.split(";");
                if (juego[1] != titulo) {
                    salida.println(juego);

                }
            }
            entrada.close();
            salida.close();

            if (existe(nombreArchivo)) {
                borrar(nombreArchivo);
            }

            archivoBackup.renameTo(archivoOri);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
