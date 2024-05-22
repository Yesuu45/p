package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private Puesto[][] puestos;
    private List<Registro> registros;

    public Parqueadero(int filas, int columnas) {
        puestos = new Puesto[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
        registros = new ArrayList<>();
    }

    public void ocuparPuesto(int fila, int columna, Vehiculo vehiculo) {
        if (fila >= 0 && fila < puestos.length && columna >= 0 && columna < puestos[0].length) {
            if (!puestos[fila][columna].isOcupado()) {
                puestos[fila][columna].ocupar(vehiculo);
                registros.add(new Registro(vehiculo, LocalTime.now(), null));
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
                puestos[fila][columna].desocupar();
                LocalTime horaSalida = LocalTime.now();
                registros.stream()
                        .filter(registro -> registro.getVehiculo().equals(vehiculo) && registro.getHoraSalida() == null)
                        .findFirst()
                        .ifPresent(registro -> registro.setHoraSalida(horaSalida));
                System.out.println("Puesto [" + fila + "," + columna + "] desocupado.");
                System.out.println("Tarifa: $" + calcularTarifa(vehiculo));
            } else {
                System.out.println("Puesto [" + fila + "," + columna + "] ya está desocupado.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public double calcularTarifa(Vehiculo vehiculo) {
        Registro registro = registros.stream()
                .filter(r -> r.getVehiculo().equals(vehiculo) && r.getHoraSalida() != null)
                .findFirst()
                .orElse(null);

        if (registro != null) {
            Duration duracion = Duration.between(registro.getHoraIngreso(), registro.getHoraSalida());
            long minutos = duracion.toMinutes();
            return vehiculo.getTarifa() * (minutos / 60.0); // Suponiendo tarifa por hora
        }
        return 0;
    }

    public void mostrarParqueadero() {
        System.out.println("\nEstado del Parqueadero:");
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                System.out.print((puestos[i][j].isOcupado() ? "O" : "L") + " ");
            }
            System.out.println();
        }
    }

    public void mostrarRegistros() {
        System.out.println("\nRegistros de Vehículos:");
        for (Registro registro : registros) {
            System.out.println(registro);
        }
    }

    public void agregarFila(int nuevaFila) {
        if (nuevaFila > 0) {
            Puesto[][] nuevoParqueadero = new Puesto[puestos.length + 1][puestos[0].length];
            for (int i = 0; i < puestos.length; i++) {
                for (int j = 0; j < puestos[i].length; j++) {
                    nuevoParqueadero[i][j] = puestos[i][j];
                }
            }
            for (int j = 0; j < puestos[0].length; j++) {
                nuevoParqueadero[nuevoParqueadero.length - 1][j] = new Puesto(nuevaFila, j);
            }
            puestos = nuevoParqueadero;
            System.out.println("Se ha agregado una nueva fila al parqueadero.");
        } else {
            System.out.println("El número de fila debe ser mayor que cero.");
        }
    }

    public void agregarColumna(int nuevaColumna) {
        if (nuevaColumna > 0) {
            Puesto[][] nuevoParqueadero = new Puesto[puestos.length][puestos[0].length + 1];
            for (int i = 0; i < puestos.length; i++) {
                for (int j = 0; j < puestos[i].length; j++) {
                    nuevoParqueadero[i][j] = puestos[i][j];
                }
            }
            for (int i = 0; i < puestos.length; i++) {
                nuevoParqueadero[i][nuevoParqueadero[0].length - 1] = new Puesto(i, nuevaColumna);
            }
            puestos = nuevoParqueadero;
            System.out.println("Se ha agregado una nueva columna al parqueadero.");
        } else {
            System.out.println("El número de columna debe ser mayor que cero.");
        }
    }
}
