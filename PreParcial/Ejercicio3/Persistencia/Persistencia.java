package Ejercicio3.Persistencia;

import Ejercicio3.model.TrabajoGrado;
import Ejercicio3.model.Universidad;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_TRABAJO_GRADOS = "Ejercicio3.RutasArchivoTrabajoGrado.txt";
    public static final String RUTA_ARCHIVO_MODELO_UNIVERSIDAD_BINARIO = "Ejercicio3.Rutas/Model.dat";
    public static final String RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML = "Ejercicio3.Rutas/Encript.xml";
    public static final String RUTA_ARCHIVO_LOG = "Ejercicio3.Rutas/UniversidadLog.txt";

    public static void cargarDatosArchivos(Universidad universidad) throws FileNotFoundException, IOException {

        ArrayList<TrabajoGrado> trabajoGradosCargados = cargarTrabajoGrado();

        if (trabajoGradosCargados.size() > 0)
            universidad.getListaTrabajosGrado().addAll(trabajoGradosCargados);
    }

    public static void guardarTrabajoGrados(ArrayList<TrabajoGrado> listaVendedores) throws IOException {

        String contenido = "";

        for (TrabajoGrado vendedor : listaVendedores) {
            //String datosProducto = obtenerProductos(vendedor);
            contenido += vendedor.toString() +"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_TRABAJO_GRADOS, contenido, false);
    }


//    ----------------------LOADS------------------------

    private static ArrayList<TrabajoGrado> cargarTrabajoGrado() throws IOException {

        ArrayList<TrabajoGrado> trabajoGrados = new ArrayList<TrabajoGrado>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_TRABAJO_GRADOS);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            TrabajoGrado trabajoGrado = new TrabajoGrado();
            trabajoGrado.setTitulo(linea.split("@")[0]);
            trabajoGrados.add(trabajoGrado);
        }
        return trabajoGrados;
    }


    //------------------------SERIALIZACIÓN y XML---------------------------------------------------
    public static Universidad cargarRecursoBinario() {

        Universidad universidad = null;

        try {
            universidad = (Universidad) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return universidad;
    }

    public static void guardarRecursoBinario(Universidad universidad) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_BINARIO, universidad);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Universidad cargarRecursoXML() {

        Universidad universidad = null;

        try {
            universidad = (Universidad) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return universidad;

    }

    public static void guardarRecursoXML(Universidad universidad) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML, universidad);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
