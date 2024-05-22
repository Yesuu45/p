package co.edu.uniquindio.poo;

import java.time.LocalTime;

public class Registro {
    private Vehiculo vehiculo;
    private LocalTime horaIngreso;
    private LocalTime horaSalida;

    public Registro(Vehiculo vehiculo, LocalTime horaIngreso, LocalTime horaSalida) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }
        if (horaIngreso == null) {
            throw new IllegalArgumentException("La hora de ingreso no puede ser nula.");
        }
        
        this.vehiculo = vehiculo;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida; // Puede ser nula al momento de creación
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }
        this.vehiculo = vehiculo;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        if (horaIngreso == null) {
            throw new IllegalArgumentException("La hora de ingreso no puede ser nula.");
        }
        this.horaIngreso = horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida; // Puede ser nula si el vehículo aún no ha salido
    }

    @Override
    public String toString() {
        return "Registro{" +
                "vehiculo=" + vehiculo +
                ", horaIngreso=" + horaIngreso +
                ", horaSalida=" + (horaSalida != null ? horaSalida : "N/A") +
                '}';
    }
}
