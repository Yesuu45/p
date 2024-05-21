package co.edu.uniquindio.poo;

/**
 * Clase que representa un carro, extendiendo la clase Vehiculo.
 */
public class Carro extends Vehiculo {
    private int numeroPuertas;
    private boolean esAutomatico;

    /**
     * Constructor de la clase Carro.
     *
     * @param nombrePropietario el nombre del propietario del carro.
     * @param modelo el modelo del carro.
     * @param tarifa la tarifa del carro.
     * @param numeroPuertas el número de puertas del carro.
     * @param esAutomatico indica si el carro es automático.
     */
    public Carro(String nombrePropietario, String modelo, int tarifa, int numeroPuertas, boolean esAutomatico) {
        super(nombrePropietario, modelo, tarifa);
        this.numeroPuertas = numeroPuertas;
        this.esAutomatico = esAutomatico;
    }

    /**
     * Obtiene el número de puertas del carro.
     *
     * @return el número de puertas.
     */
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    /**
     * Establece el número de puertas del carro.
     *
     * @param numeroPuertas el nuevo número de puertas.
     */
    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    /**
     * Indica si el carro es automático.
     *
     * @return true si es automático, false si es manual.
     */
    public boolean isEsAutomatico() {
        return esAutomatico;
    }

    /**
     * Establece si el carro es automático.
     *
     * @param esAutomatico true si es automático, false si es manual.
     */
    public void setEsAutomatico(boolean esAutomatico) {
        this.esAutomatico = esAutomatico;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNúmero de puertas: " + numeroPuertas + "\nEs automático: " + (esAutomatico ? "Sí" : "No");
    }
}
