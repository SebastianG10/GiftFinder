package model;

/**
 * Representa un proveedor que suministra regalos y tiene un precio de envío.
 */
public class Proveedor {
    private String nombre;
    private double precioEnvio;

    /**
     * Constructor de la clase Proveedor
     * @param nombre Nombre del proveedor
     * @param precioEnvio Precio del envío del proveedor
     */
    public Proveedor(String nombre, double precioEnvio) {
        this.nombre = nombre;
        this.precioEnvio = precioEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }
}
