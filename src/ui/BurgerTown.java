package ui;

import java.util.Scanner;

/**
 * Descripción: La clase BurgerTown proporciona un sistema para registrar las
 * ventas diarias de diferentes platos.
 */
public class BurgerTown {

    public static Scanner in;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {
        inicializarGlobales();
        menu();
        in.close();
    }

    /**
     * Descripción: Inicializa cualquier variable que sea global.
     * Pre: El Scanner debe estar declarado.
     * Pos: El Scanner está inicializado.
     */
    public static void inicializarGlobales() {
        in = new Scanner(System.in);
    }

    /**
     * Descripción: En este metodo se muestra el menú principal y maneja la entrada
     * del usuario para varias funcionalidades.
     * Pre: El Scanner debe estar inicializado.
     * Pre: Los arreglos precios y unidades ya deben estar inicializados.
     * Pos: El programa mostrara la informacion al usuario segun la opcion elegida.
     */
    public static void menu() {
        System.out.println("¡Bienvenido a BurgerTown!");

        establecerCantidadVendida();

        boolean salir = false;

        do {
            System.out.println("\nMenu principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada plato vendido en el dia");
            System.out.println("2. Calcular el número total de platos vendidos en el dia");
            System.out.println("3. Calcular el precio promedio de los platos vendidos en el dia");
            System.out.println("4. Calcular las ventas totales (ingresos) del dia");
            System.out.println("5. Consultar el número de platos que excedieron un límite mínimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nIngrese la opción a ejecutar");
            int opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    verificarDatosInicializados();
                    System.out.println("\nEl total de platos vendidos en el día fue: " + calcularTotalPlatosVendidos());
                    break;
                case 3:
                    verificarDatosInicializados();
                    System.out.println(
                            "\nEl precio promedio de los platos vendidos en el día fue: " + calcularPrecioPromedio());
                    break;
                case 4:
                    verificarDatosInicializados();
                    System.out.println("\nLas ventas totales (ingresos) del día fueron: " + calcularVentasTotales());
                    break;
                case 5:
                    verificarDatosInicializados();
                    System.out.println("\nIngrese el límite mínimo de ventas a analizar");
                    double limite = in.nextDouble();
                    System.out.println("\nDe " + precios.length + " referencias vendidas en el día, "
                            + consultarPlatosSobreLimite(limite) + " se superó el límite mínimo de ventas de "
                            + limite);
                    break;
                case 6:
                    System.out.println("\n¡Gracias por utilizar nuestros servicios!");
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpción inválida, por favor intente nuevamente.");
                    break;
            }
        } 
        while (!salir);
    }

    /**
     * Descripción: En este metodo se solicita al usuario la cantidad de platos
     * distintos vendidos en el día e inicializa los arrays para almacenar precios y
     * cantidades.
     * Pre: El Scanner debe estar inicializado.
     * Pre: Los arrays de precios y unidades ya deben estar declarados.
     * Pos: Se inicializan los arrays precios y unidades.
     */
    public static void establecerCantidadVendida() {
        System.out.println("\nIngresa la cantidad de platos distintos vendidos en el día: ");
        int platos = in.nextInt();

        double precios[] = new double[platos];
        int unidades[] = new int[platos];
    }

    /**
     * Descripción: En este metodo se pregunta al usuario el precio y la cantidad de
     * cada plato vendido y almacena los datos en los arrays.
     * Pre: Se deben inicializar los arrays precios y unidades.
     * Pos: Los arrays tomaran valores de precio y cantidad
     */
    public static void solicitarDatos() {
        for (int i = 0; i < precios.length; i++) {
            System.out.println("\nIngresa el precio del plato " + (i + 1) + ": ");
            precios[i] = in.nextDouble();

            System.out.println("Ingresa la cantidad de platos " + (i + 1) + ": ");
            unidades[i] = in.nextInt();
        }
    }

    /**
     * Descripcion:El metodo calcula el total de platos vendidos en el dia.
     * pre: El Scanner debera leer la cantidad que ingrese el usuario.
     * Pos: Indica el numero total de platos vendidos en el dia.
     * 
     * @return El numero total de platos vendidos en el dia.
     */
    public static int calcularTotalPlatosVendidos() {
        int total = 0;
        for (int unidad : unidades) {
            total = total + unidad;
        }
        return total;
    }

  
    public static double calcularPrecioPromedio() {
        double totalPrecio = 0;
        for (int i = 0; i < precios.length; i++) {
            totalPrecio = totalPrecio + precios[i];
        }
        return precios.length > 0 ? totalPrecio / precios.length : 0;
    }

    public static double calcularVentasTotales() {
        double totalVentas = 0;
        for (int i = 0; i < precios.length; i++) {
            totalVentas = totalVentas + precios[i] * unidades[i];
        }
        return totalVentas;
    }

    public static int consultarPlatosSobreLimite(double limite) {
        int count = 0;
        for (int i = 0; i < precios.length; i++) {
            if (precios[i] * unidades[i] > limite) {
                count++;
            }
        }
        return count;
    }

    /**
     * Descripción: Verifica si los arreglos de datos precios y unidades están
     * inicializados y lanza un error si no están inicializados.
     */

    public static void verificarDatosInicializados() {
        if (precios == null && unidades == null) {
            System.out.println("¡Primero debes ingresar la cantidad de platos vendidos (Opción 1)!");
        }
    }
}