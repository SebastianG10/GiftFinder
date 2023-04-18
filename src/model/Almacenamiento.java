package model;

import java.util.ArrayList;

/**
 * Representa un almacenamiento de regalos y proveedores.
 */
public class Almacenamiento {
    private int identificador;
    private String nombre;
    private ArrayList<Regalo> regalos;
    private ArrayList<Proveedor> proveedores;

    /**
     * Constructor de la clase Almacenamiento.
     * @param identificador El identificador del almacenamiento.
     * @param nombre El nombre del almacenamiento.
     */
    public Almacenamiento(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.regalos = new ArrayList<Regalo>();
        this.proveedores = new ArrayList<Proveedor>();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Regalo> getRegalos() {
        return regalos;
    }

    public void setRegalos(ArrayList<Regalo> regalos) {
        this.regalos = regalos;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
