package com.ceep.juegos.principal;

import com.ceep.juegos.negocio.CatalogoJuegos;
import com.ceep.juegos.negocio.IACatalogoJuegos;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        
        var opcion =-1;
        var nombreJuego ="";
        var lectura = new Scanner(System.in);
        var nombreCatalogo = "Game.txt";
        IACatalogoJuegos catalogo = new CatalogoJuegos();
        
        while (opcion != 0) {
            System.out.println("Elige una de las opciones: \n"
                    + "1.- Iniciar catálogo de juegos. \n"
                    + "2.- Agregar juego. \n"
                    + "3.- Listar juegos. \n"
                    + "4.- Buscar juegos. \n"
                    + "5.- Calcular total precio. \n"
                    + "6.- Borrar juego. \n"
                    + "7.- Mayor numero de juegos. \n"
                    + "0.- Salir \n");
            // Leemos la opción del la consola
            opcion = Integer.parseInt(lectura.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogo(nombreCatalogo);
                    System.out.println("Catalogo iniciado...");
                    break;
                    
                case 2:
//                    catalogo.agregarJuego(nombreJuego,);
                    
                case 3:
                    catalogo.listarJuego(nombreCatalogo);
            }
            
            
        
        }
    }
}
