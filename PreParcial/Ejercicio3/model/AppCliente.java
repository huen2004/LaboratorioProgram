package Ejercicio3.model;

import java.io.*;
import java.net.Socket;

public class AppCliente {

    String host;
    int puerto;
    Socket socketComunicacion;

    private Universidad universidad;
    PrintWriter flujoSalida;
    BufferedReader flujoEntrada;

    ObjectInputStream inputStream = null;
    ObjectOutputStream outputStream = null;


    public AppCliente(String host, int puerto) {
        this.puerto = puerto;
        this.host = host;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void iniciarCliente() {

        try
        {
            crearConexion();

            flujoEntrada = new BufferedReader(new InputStreamReader(socketComunicacion.getInputStream()));
            flujoSalida = new PrintWriter(socketComunicacion.getOutputStream(), true);
            inputStream = new ObjectInputStream(socketComunicacion.getInputStream());
            outputStream = new ObjectOutputStream(socketComunicacion.getOutputStream());

            this.universidad = (Universidad)inputStream.readObject();

            outputStream.close();
            inputStream.close();
            flujoSalida.close();
            flujoEntrada.close();

            socketComunicacion.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//Fin de la conexión
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearConexion()throws IOException {
        socketComunicacion = new Socket(host, puerto);
        System.out.println ("conectado");
    }
}
