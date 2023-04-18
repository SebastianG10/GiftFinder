package repository;

import java.io.IOException;
import org.json.JSONObject;

/**
 * Esta interfaz define el comportamiento de un lector de archivos JSON.
 */
public interface ILectorJson {
    /**
     * Carga los datos de un archivo JSON y los devuelve como un arreglo de objetos JSON.
     *
     * @return Un arreglo de objetos JSON que representan los datos cargados del archivo.
     * @throws IOException Si ocurre un error al leer el archivo JSON.
     */
    public JSONObject[] cargarDatos() throws IOException;
}
