
package com.ceep.juegos.negocio;

import com.ceep.juegos.datos.AccesoDatos;
import com.ceep.juegos.datos.IAccesoDatos;
import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.AccesoDatosEx;
import com.ceep.juegos.excepciones.EscrituraDatosEx;
import com.ceep.juegos.excepciones.LecturaDatosEx;
import java.util.*;

public class CatalogoJuegos implements IACatalogoJuegos {
    
    private  final IAccesoDatos datos; //Se utiliza para acceder a la capa de datos

    
    
    public CatalogoJuegos() {
        this.datos = new AccesoDatos();
    }


    
    

    @Override
    public void agregarJuego(String titulo, String tipo, double precio, String plataforma, String anio, int cantidad ,String nombreCatalogo) {
       try {
            if (this.datos.existe(nombreCatalogo)) {
                this.datos.escribir(new Juego(titulo, tipo, precio, plataforma, anio, cantidad),nombreCatalogo,true);
            } else {
                System.out.println("Catálogo no inicilizado");
            }
        } catch (EscrituraDatosEx ex) {
            System.out.println("Error al escribir en el catálogo");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarJuego(String nombreCatalogo) {
        List<Juego> juegos = new ArrayList<>();
        
        try{
            juegos = this.datos.listar(nombreCatalogo);
            juegos.forEach(juego ->{
                System.out.println(juego);
            });
        }catch(LecturaDatosEx ex){
            System.out.println("Error leyendo el catalogo");
            ex.printStackTrace(System.out);
        }
            
    }

    @Override
    public void buscarJuego(String nombreCatalogo, String buscar) {
        try{
            System.out.println(this.datos.buscar(nombreCatalogo, buscar));
        }catch(LecturaDatosEx ex){
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogo(String nombreCatalogo) {
        try{
            if (this.datos.existe(nombreCatalogo)) {
                this.datos.borrar(nombreCatalogo);
                this.datos.crear(nombreCatalogo);
                
            }else {
                this.datos.crear(nombreCatalogo);
            }
        }catch(AccesoDatosEx ex){
            ex.printStackTrace(System.out);
            System.out.println("Error al inicializar el catalogo de juegos");
        }
    }
    
    public double maximo(double precio){
        double maximo = 0;
        
        if (precio > maximo) {
            maximo = precio;
            
        }
        
        return maximo;
        
    }
    
}
