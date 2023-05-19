package Ejercicio3.model;

import java.io.*;
import java.net.Socket;

public class AppCliente {

    String host;
    int puerto;
    Socket socketComunicacion;

    PrintWriter flujoSalida;
    BufferedReader flujoEntrada;

    String mensaje;
    String tipoServicio;

    public AppCliente(String host, int puerto, String mensaje, String tipoServicio) {
        this.puerto = puerto;
        this.host = host;
        this.mensaje = mensaje;
        this.tipoServicio = tipoServicio;
    }

    public void iniciarCliente() {

        try
        {
            crearConexion();

            flujoEntrada = new BufferedReader(new InputStreamReader(socketComunicacion.getInputStream()));
            flujoSalida = new PrintWriter(socketComunicacion.getOutputStream(), true);
            flujoSalida.close();
            flujoEntrada.close();

            socketComunicacion.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//Fin de la conexión
    }

    public void crearConexion()throws IOException {
        socketComunicacion = new Socket(host, puerto);
        System.out.println ("conectado");
    }
}
