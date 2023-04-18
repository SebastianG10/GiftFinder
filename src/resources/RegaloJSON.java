package resources;

import org.json.JSONArray;
import org.json.JSONObject;
import repository.ILectorJson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Clase que implementa la interfaz ILectorJson y permite cargar datos desde un archivo JSON de regalos.
 */
public class RegaloJSON implements ILectorJson {
    private String ruta = "C:/Users/USER/Desktop/regalos.json";

    public RegaloJSON() {
    }

    public RegaloJSON(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Carga los datos desde el archivo JSON y los retorna en forma de un arreglo de objetos JSON.
     * @return Un arreglo de objetos JSON con los datos del archivo.
     * @throws IOException Si ocurre un error al leer el archivo JSON.
     */
    public JSONObject[] cargarDatos() throws IOException {
        File archivo = new File(ruta);
        String contenido = new String(Files.readAllBytes(archivo.toPath()));
        JSONArray arregloJson = new JSONArray(contenido);
        JSONObject[] objetosJson = new JSONObject[arregloJson.length()];

        for (int i = 0; i < arregloJson.length(); i++) {
            objetosJson[i] = arregloJson.getJSONObject(i);
        }

        return objetosJson;
    }
}