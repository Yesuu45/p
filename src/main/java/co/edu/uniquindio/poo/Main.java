package co.edu.uniquindio.poo;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalTime;

public class Main {

    private static Parqueadero parqueadero;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al sistema de gestión del parqueadero!");

        int filas = obtenerEntero("Ingrese el número de filas del parqueadero: ");
        int columnas = obtenerEntero("Ingrese el número de columnas del parqueadero: ");
        parqueadero = new Parqueadero(filas, columnas);

        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    registrarEntrada();
                    break;
                case 2:
                    registrarSalida();
                    break;
                case 3:
                    mostrarEstadoParqueadero();
                    break;
                case 4:
                    mostrarRegistros();
                    break;
                case 5:
                    agregarFila();
                    break;
                case 6:
                    agregarColumna();
                    break;
                case 7:
                    System.out.println("Gracias por usar el sistema de gestión del parqueadero. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n----- Menú -----");
        System.out.println("1. Registrar entrada de vehículo");
        System.out.println("2. Registrar salida de vehículo");
        System.out.println("3. Mostrar estado del parqueadero");
        System.out.println("4. Mostrar registros de vehículos");
        System.out.println("5. Agregar fila al parqueadero");
        System.out.println("6. Agregar columna al parqueadero");
        System.out.println("7. Salir");
    }

    private static int obtenerEntero(String mensaje) {
        int valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer de entrada
            }
        }

        return valor;
    }

    private static int obtenerOpcion() {
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            opcion = obtenerEntero("Seleccione una opción: ");
            if (opcion >= 1 && opcion <= 7) {
                entradaValida = true;
            } else {
                System.out.println("Por favor, seleccione una opción válida del menú.");
            }
        }

        return opcion;
    }

    private static void registrarEntrada() {
        System.out.println("\n--- Registro de Entrada ---");
        int fila = obtenerEntero("Ingrese la fila del puesto: ");
        int columna = obtenerEntero("Ingrese la columna del puesto: ");
        String placa = obtenerTexto("Ingrese la placa del vehículo: ");
        String nombrePropietario = obtenerTexto("Ingrese el nombre del propietario del vehículo: ");
        String modelo = obtenerTexto("Ingrese el modelo del vehículo: ");
        double tarifa = obtenerDouble("Ingrese la tarifa del vehículo: ");
        Vehiculo vehiculo = new Vehiculo(placa, nombrePropietario, modelo, (int) tarifa);
        vehiculo.setHoraIngreso(LocalTime.now());
        parqueadero.ocuparPuesto(fila, columna, vehiculo);
        System.out.println("El vehículo ha sido registrado correctamente en el puesto [" + fila + "][" + columna + "].");
    }

    private static void registrarSalida() {
        System.out.println("\n--- Registro de Salida ---");
        int fila = obtenerEntero("Ingrese la fila del puesto a desocupar: ");
        int columna = obtenerEntero("Ingrese la columna del puesto a desocupar: ");
        parqueadero.desocuparPuesto(fila, columna);
        System.out.println("El puesto [" + fila + "][" + columna + "] ha sido desocupado correctamente.");
    }

    private static void mostrarEstadoParqueadero() {
        System.out.println("\n--- Estado del Parqueadero ---");
        parqueadero.mostrarParqueadero();
    }

    private static void mostrarRegistros() {
        System.out.println("\n--- Registros de Vehículos ---");
        parqueadero.mostrarRegistros();
    }

    private static String obtenerTexto(String mensaje) {
        String texto = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim(); // Eliminar espacios en blanco al principio y al final
            if (!texto.isEmpty()) {
                entradaValida = true;
            } else {
                System.out.println("Por favor, ingrese un valor válido.");
            }
        }

        return texto;
    }

    private static void agregarFila() {
        int nuevaFila = obtenerEntero("Ingrese el número de la nueva fila: ");
        parqueadero.agregarFila(nuevaFila);
    }

    private static void agregarColumna() {
        int nuevaColumna = obtenerEntero("Ingrese el número de la nueva columna: ");
        parqueadero.agregarColumna(nuevaColumna);
    }

    private static double obtenerDouble(String mensaje) {
        double valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un valor válido.");
                scanner.next(); // Limpiar el buffer de entrada
            }
        }

        return valor;
    }
}
