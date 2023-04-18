package service;

import model.Regalo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene métodos para filtrar una lista de regalos por edad y precio.
 */
public class Filtro {

    /**
     * Filtra una lista de regalos por edad recomendada.
     *
     * @param edad la edad recomendada para los regalos a filtrar.
     * @param regalos la lista de regalos a filtrar.
     * @return una lista de regalos filtrada por la edad recomendada.
     */
    public ArrayList<Regalo> filtrarRegalosEdad(int edad, ArrayList<Regalo> regalos) {
        ArrayList<Regalo> regalosFiltrados = new ArrayList<>();
        for (Regalo regalo : regalos) {
            if (regalo.getEdadRecomendada() == edad) {
                regalosFiltrados.add(regalo);
            }
        }
        return regalosFiltrados;
    }

    /**
     * Filtra una lista de regalos por precio máximo.
     *
     * @param precioMaximo el precio máximo para los regalos a filtrar.
     * @param regalos la lista de regalos a filtrar.
     * @return una lista de regalos filtrada por el precio máximo.
     */
    public ArrayList<Regalo> filtrarRegalosPrecio(double precioMaximo, List<Regalo> regalos) {
        ArrayList<Regalo> regalosFiltrados = new ArrayList<>();
        for (Regalo regalo : regalos) {
            if (regalo.getPrecioBase() < precioMaximo) {
                regalosFiltrados.add(regalo);
            }
        }
        return regalosFiltrados;
    }
}
