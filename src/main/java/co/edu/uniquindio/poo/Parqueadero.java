package co.edu.uniquindio.poo;

import java.time.LocalTime;
import java.time.Duration;

public class Parqueadero {
    private Puesto[][] puestos;

    public Parqueadero(int filas, int columnas) {
        puestos = new Puesto[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

    public void ocuparPuesto(int fila, int columna, Vehiculo vehiculo) {
        if (fila >= 0 && fila < puestos.length && columna >= 0 && columna < puestos[0].length) {
            if (!puestos[fila][columna].isOcupado()) {
                puestos[fila][columna].ocupar(vehiculo);
                System.out.println("Puesto [" + fila + "," + columna + "] ocupado por " + vehiculo.getPlaca());
            } else {
                System.out.println("Puesto [" + fila + "," + columna + "] ya está ocupado.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public void desocuparPuesto(int fila, int columna) {
        if (fila >= 0 && fila < puestos.length && columna >= 0 && columna < puestos[0].length) {
            if (puestos[fila][columna].isOcupado()) {
                Vehiculo vehiculo = puestos[fila][columna].getVehiculo();
                vehiculo.setHoraSalida(LocalTime.now());
                double tarifa = calcularTarifa(vehiculo);
                puestos[fila][columna].desocupar();
                System.out.println("Puesto [" + fila + "," + columna + "] desocupado. Tarifa a pagar: " + tarifa);
            } else {
                System.out.println("Puesto [" + fila + "," + columna + "] ya está desocupado.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public double calcularTarifa(Vehiculo vehiculo) {
        Duration duration = Duration.between(vehiculo.getHoraIngreso(), vehiculo.getHoraSalida());
        long minutos = duration.toMinutes();
        return (minutos / 60.0) * vehiculo.getTarifa();
    }

    public void mostrarParqueadero() {
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                System.out.print((puestos[i][j].isOcupado() ? "O" : "L") + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero(3, 3);
        parqueadero.mostrarParqueadero();

        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota", 2.5, LocalTime.now(), "John Doe");
        parqueadero.ocuparPuesto(1, 1, vehiculo1);
        parqueadero.mostrarParqueadero();

        // Simular un tiempo de estancia
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parqueadero.desocuparPuesto(1, 1);
        parqueadero.mostrarParqueadero();
    }
}
