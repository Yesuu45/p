package co.edu.uniquindio.poo;

public class Puesto {
    private int fila;
    private int columna;
    private Vehiculo vehiculo;

    public Puesto(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.vehiculo = null; // Inicialmente no hay vehículo en el puesto
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public boolean isOcupado() {
        return vehiculo != null;
    }

    public void ocupar(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void desocupar() {
        this.vehiculo = null;
    }

    @Override
    public String toString() {
        return "Puesto{" +
                "fila=" + fila +
                ", columna=" + columna +
                ", vehiculo=" + (vehiculo != null ? vehiculo.toString() : "Libre") +
                '}';
    }
}
