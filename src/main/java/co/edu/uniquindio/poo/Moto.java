package co.edu.uniquindio.poo;

/**
 * Clase que representa una moto, extendiendo la clase Vehiculo e implementando la interfaz IMoto.
 */
public class Moto extends Vehiculo implements IMoto {
    private Tipo tipo;

    /**
     * Constructor para inicializar una moto con su nombre de propietario, modelo, tarifa y tipo.
     * 
     * @param nombre el nombre del propietario de la moto.
     * @param modelo el modelo de la moto.
     * @param tarifa la tarifa de la moto.
     * @param tipo el tipo de la moto.
     */
    public Moto(String nombre, String modelo, int tarifa, Tipo tipo) {
        super(nombre, modelo, tarifa);
        this.tipo = tipo;
    }

    /**
     * Obtiene el tipo de la moto.
     * 
     * @return el tipo de la moto.
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la moto.
     * 
     * @param tipo el nuevo tipo de la moto.
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la velocidad máxima de la moto según su tipo.
     * 
     * @return la velocidad máxima de la moto.
     */
    @Override
    public double getVelocidadMaxima() {
        return tipo.getVelocidadMaxima();
    }

    /**
     * Devuelve una representación en forma de cadena de la moto.
     * 
     * @return una cadena que describe la moto.
     */
    @Override
    public String toString() {
        return super.toString() + "\nTipo: " + tipo;
    }
}

