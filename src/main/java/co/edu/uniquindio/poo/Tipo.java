package co.edu.uniquindio.poo;

/**
 * Enumeración que representa los tipos de motos y sus velocidades máximas.
 */
public enum Tipo {
    HIBRIDA(180.0),
    CLASICA(150.0);

    private final double velocidadMaxima;

    /**
     * Constructor para inicializar la velocidad máxima de cada tipo de moto.
     * @param velocidadMaxima la velocidad máxima del tipo de moto.
     */
    private Tipo(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Obtiene la velocidad máxima del tipo de moto.
     * @return la velocidad máxima.
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Devuelve una representación en forma de cadena del tipo de moto.
     * @return una cadena que describe el tipo de moto y su velocidad máxima.
     */
    @Override
    public String toString() {
        switch (this) {
            case HIBRIDA:
                return "Moto híbrida (Velocidad máxima: " + velocidadMaxima + " km/h)";
            case CLASICA:
                return "Moto clásica (Velocidad máxima: " + velocidadMaxima + " km/h)";
            default:
                throw new IllegalArgumentException("Tipo de moto desconocido: " + this);
        }
    }
}
