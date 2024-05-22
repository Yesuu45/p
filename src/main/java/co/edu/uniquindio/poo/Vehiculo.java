package co.edu.uniquindio.poo;

import java.time.LocalTime;

/**
 * Clase que representa un vehículo.
 */
public class Vehiculo {
    // Atributos
    private String placa;
    private String nombre;
    private String modelo;
    private int tarifa;
    private LocalTime horaIngreso;
    private LocalTime horaSalida;

    // Constructor
    public Vehiculo(String placa, String nombre, String modelo, int tarifa) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("La placa no puede ser nula o vacía.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío.");
        }
        if (tarifa < 0) {
            throw new IllegalArgumentException("La tarifa no puede ser negativa.");
        }

        this.placa = placa;
        this.nombre = nombre;
        this.modelo = modelo;
        this.tarifa = tarifa;
    }

    // Métodos getter y setter
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("La placa no puede ser nula o vacía.");
        }
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío.");
        }
        this.modelo = modelo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        if (tarifa < 0) {
            throw new IllegalArgumentException("La tarifa no puede ser negativa.");
        }
        this.tarifa = tarifa;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tarifa=" + tarifa +
                ", horaIngreso=" + (horaIngreso != null ? horaIngreso : "N/A") +
                ", horaSalida=" + (horaSalida != null ? horaSalida : "N/A") +
                '}';
    }
}
