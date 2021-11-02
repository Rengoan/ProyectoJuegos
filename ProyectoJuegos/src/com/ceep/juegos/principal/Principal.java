package com.ceep.juegos.principal;

import com.ceep.juegos.negocio.CatalogoJuegos;
import com.ceep.juegos.negocio.IACatalogoJuegos;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        var opcion = -1;
        var nombreJuego = "";
        var tipoJuego = "";
        double precio = 0;
        var plataforma = "";
        var anio = "";
        int cantidad = 0;
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

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogo(nombreCatalogo);
                    System.out.println("Catalogo iniciado...");
                    break;

                case 2:
                    System.out.println("Introduce el titulo del juego a agregar: ");
                    nombreJuego = lectura.nextLine();
                    System.out.println("Introduce el tipo juego a agregar: ");
                    tipoJuego = lectura.nextLine();
                    System.out.println("Introduce el precio del juego a agregar: ");
                    precio = lectura.nextDouble();
                    System.out.println("Introduce la plataforma del juego a agregar: ");
                    plataforma = lectura.next();
                    System.out.println("Introduce el año del juego a agregar: ");
                    anio = lectura.next();
                    System.out.println("Introduce la cantidad del juego a agregar: ");
                    cantidad = lectura.nextInt();
                    catalogo.agregarJuego(nombreJuego, tipoJuego, precio, plataforma, anio, cantidad, nombreCatalogo);
                    System.out.println("Se ha agregado el juego " + nombreJuego + " al " + nombreCatalogo);

                case 3:
                    catalogo.listarJuego(nombreCatalogo);

                    break;
                case 0:
                    System.out.println("Adios y hasta pronto!!! :(");
                    break;
                default:
                    System.out.println("Opción desconocida.");
            }

        }
    }
}
