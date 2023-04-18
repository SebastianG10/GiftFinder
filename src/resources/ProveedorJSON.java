package resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import repository.ILectorJson;

public class ProveedorJSON implements ILectorJson {
    private String ruta = "C:/Users/USER/Desktop/proveedor.json";


    /**
     * Esta clase representa un proveedor de datos en formato JSON y
     * implementa la interfaz ILectorJson para cargar los datos desde
     * un archivo JSON en disco.
     */
    public ProveedorJSON() {
    }

    public ProveedorJSON(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Carga los datos del proveedor desde un archivo JSON en disco.
     * @return Un arreglo de objetos JSON que representan los datos del proveedor.
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
