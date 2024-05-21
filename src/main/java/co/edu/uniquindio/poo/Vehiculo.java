package co.edu.uniquindio.poo;

import java.time.LocalTime;

/**
 * Clase que representa un vehículo.
 */
public class Vehiculo {
    private String nombre;
    private String modelo;
    private int tarifa;
    private LocalTime horaIngreso;
    private LocalTime horaSalida;

    /**
     * Constructor para inicializar un vehículo con nombre de propietario, modelo y tarifa.
     * 
     * @param nombre el nombre del propietario del vehículo.
     * @param modelo el modelo del vehículo.
     * @param tarifa la tarifa del vehículo.
     */
    public Vehiculo(String nombre, String modelo, int tarifa) {
        assert nombre != null && !nombre.isBlank();
        this.nombre = nombre;
        assert modelo != null && !modelo.isBlank();
        this.modelo = modelo;
        assert tarifa >= 0;
        this.tarifa = tarifa;
        this.horaIngreso = null;
        this.horaSalida = null;
    }

    // Métodos getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        assert nombre != null && !nombre.isBlank();
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        assert modelo != null && !modelo.isBlank();
        this.modelo = modelo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        assert tarifa >= 0;
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
                "nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tarifa=" + tarifa +
                ", horaIngreso=" + (horaIngreso != null ? horaIngreso : "N/A") +
                ", horaSalida=" + (horaSalida != null ? horaSalida : "N/A") +
                '}';
    }
}
