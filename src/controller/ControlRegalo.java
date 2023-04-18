package controller;

import java.io.IOException;
import org.json.JSONObject;
import repository.ILectorJson;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import model.Proveedor;
import model.Regalo;
import model.Almacenamiento;
import resources.ProveedorJSON;
import resources.RegaloJSON;
import service.Filtro;

/**
 Controlador para gestionar la lectura de archivos JSON de proveedores y regalos,
 convertirlos en objetos Proveedor y Regalo, respectivamente, y almacenarlos en un objeto Almacenamiento.
 También permite filtrar la lista de regalos almacenados según la edad y el precio máximo.
 */
public class ControlRegalo {

    /**
     * Lee los archivos JSON de proveedores y regalos y los convierte en objetos Proveedor y Regalo,
     * respectivamente, los cuales son almacenados en un objeto Almacenamiento. Finalmente, se devuelve
     * un ArrayList con los Regalos almacenados.
     * @return un ArrayList con los Regalos almacenados.
     */
    public ArrayList leerArchivos() {
        Almacenamiento almacenamiento = new Almacenamiento(1, "Almacenamiento de Regalos");
        ILectorJson lectorProveedor = new ProveedorJSON();
        ILectorJson lectorRegalo = new RegaloJSON();
        JSONArray jsonRegalos = null;
        JSONArray jsonProveedores  = null;

        try {
            // cargar los datos de proveedores
            JSONObject[] proveedores = lectorProveedor.cargarDatos();
            jsonProveedores = new JSONArray(proveedores);

            // cargar los datos de regalos
            JSONObject[] regalos = lectorRegalo.cargarDatos();
            jsonRegalos = new JSONArray(regalos);

        } catch (IOException e) {
            System.out.println("Error al leer los archivos JSON: " + e.getMessage());
        }



        // Crea los objetos Regalo y Proveedor
        ArrayList<Proveedor> proveedores = crearProveedores(jsonProveedores);
        almacenamiento.setProveedores(proveedores);

        ArrayList<Regalo> regalos = crearRegalos(jsonRegalos, almacenamiento);
        almacenamiento.setRegalos(regalos);

        return almacenamiento.getRegalos();

    }

    /**
     * Crea un ArrayList de objetos Regalo a partir de un JSONArray de objetos JSON.
     * Busca el proveedor correspondiente a cada Regalo en la lista de proveedores del objeto Almacenamiento.
     * @param jsonRegalos el JSONArray de objetos JSON que representa los Regalos.
     * @param almacenamiento el objeto Almacenamiento que contiene la lista de proveedores.
     * @return un ArrayList de objetos Regalo creados.
     */
    private ArrayList<Regalo> crearRegalos(JSONArray jsonRegalos, Almacenamiento almacenamiento) {
        ArrayList<Regalo> regalos = new ArrayList<Regalo>();

        for (int i = 0; i < jsonRegalos.length(); i++) {
            JSONObject jsonRegalo = jsonRegalos.getJSONObject(i);

            String nombre = jsonRegalo.getString("nombre");
            int edadRecomendada = jsonRegalo.getInt("edad");
            double precioBase = jsonRegalo.getDouble("precio");
            String proveedorBuscado = jsonRegalo.getString("proveedor");

            // Buscar el proveedor correspondiente en la lista de proveedores
            Proveedor proveedor = buscarProveedor(proveedorBuscado, almacenamiento.getProveedores());

            Regalo regalo = new Regalo(nombre, edadRecomendada, precioBase, proveedor);
            regalos.add(regalo);
        }

        return regalos;
    }

   /**
    * Crea una lista de objetos Proveedor a partir de un JSONArray de proveedores en formato JSON
    * @param jsonProveedores el JSONArray que contiene los proveedores en formato JSON
    * @return una lista de objetos Proveedor creados a partir del JSONArray de proveedores
    */
    private ArrayList<Proveedor> crearProveedores(JSONArray jsonProveedores) {
        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

        for (int i = 0; i < jsonProveedores.length(); i++) {
            JSONObject jsonProveedor = jsonProveedores.getJSONObject(i);

            String nombre = jsonProveedor.getString("nombre");
            double precioEnvio = jsonProveedor.getDouble("precioEnvio");

            Proveedor proveedor = new Proveedor(nombre, precioEnvio);
            proveedores.add(proveedor);
        }

        return proveedores;
    }

    /**
     * Busca un proveedor por su nombre en una lista de proveedores.
     * @param nombre el nombre del proveedor a buscar
     * @param proveedores la lista de proveedores en la que se buscará el proveedor
     * @return el proveedor que coincide con el nombre buscado, o null si no se encuentra
     */
    private Proveedor buscarProveedor(String nombre, ArrayList<Proveedor> proveedores) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNombre().equals(nombre)) {
                return proveedor;
            }
        }
        return null;
    }

    /**
     * Filtra una lista de regalos por edad y precio máximo y devuelve la lista filtrada.
     * @param edad la edad de los destinatarios de los regalos que se quieren filtrar
     * @param precioMaximo el precio máximo que se está dispuesto a pagar por un regalo
     * @param regalos la lista de regalos que se quiere filtrar
     * @return una lista de regalos que cumple con los criterios de filtrado
     */
    public ArrayList<Regalo> filtrarRegalos(int edad, double precioMaximo, ArrayList regalos) {
        Filtro filtro = new Filtro();

        ArrayList<Regalo> regalosFiltradosEdad = filtro.filtrarRegalosEdad(edad, regalos);

        ArrayList<Regalo> regalosFiltradosActualizados = new ArrayList<>();
        for (Regalo regalo : regalosFiltradosEdad) {
            double precioTotal = calcularPrecioTotal(regalo.getPrecioBase(), regalo.getProveedor().getPrecioEnvio());
            regalo.setPrecioTotal(precioTotal);
            regalosFiltradosActualizados.add(regalo);
        }
        ArrayList<Regalo> regalosFiltradosPrecio = filtro.filtrarRegalosPrecio(precioMaximo, regalosFiltradosActualizados);

        return regalosFiltradosPrecio;
    }


    /**
     * Calcula el precio total de un regalo sumando el precio base y el precio de envío del proveedor.
     * @param precioBase el precio base del regalo
     * @param precioEnvio el precio de envío del proveedor del regalo
     * @return el precio total del regalo
     */
    public double calcularPrecioTotal(double precioBase, double precioEnvio) {
        return precioBase + precioEnvio;
    }

    /**
     * Devuelve una cadena de texto que representa los regalos que se le pasan como parámetro, uno por línea.
     * @param regalos la lista de regalos que se quieren mostrar
     * @return una cadena de texto que representa los regalos que se quieren mostrar
     */
    public String mostrarRegalos(ArrayList<Regalo> regalos){
        String respuesta = "";
        if(regalos.isEmpty()){
            respuesta = "No se tiene productos para esa edad o precio";
        }
        for (Regalo regalo:regalos) {
            respuesta += regalo.toString()+"\n";
        }
        return respuesta;

    }



}
