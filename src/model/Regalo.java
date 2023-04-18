package model;

/**
 * La clase Regalo representa un regalo con su nombre, edad recomendada, precio base, proveedor y precio total.
 */
public class Regalo {
    private String nombre;
    private int edadRecomendada;
    private double precioBase;
    private Proveedor proveedor;
    private double precioTotal;

    /**
     * Constructor de la clase Regalo.
     *
     * @param nombre El nombre del regalo.
     * @param edadRecomendada La edad recomendada para el regalo.
     * @param precioBase El precio base del regalo.
     * @param proveedor El proveedor del regalo.
     */
    public Regalo(String nombre, int edadRecomendada, double precioBase, Proveedor proveedor) {
        this.nombre = nombre;
        this.edadRecomendada = edadRecomendada;
        this.precioBase = precioBase;
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Regalo{" +
                "nombre='" + nombre + '\'' +
                ", edadRecomendada=" + edadRecomendada +
                ", precioBase=" + precioBase +
                ", proveedor=" + proveedor +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
