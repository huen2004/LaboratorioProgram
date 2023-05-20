package SegundoPunto;

import java.io.*;
import java.net.ServerSocket;
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
            pedirServicio(mensaje, tipoServicio);
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

    public void pedirServicio(String mensaje, String i) {
        try {
            enviarTipoServicio(i);
            enviarFraseMensaje(mensaje);
            System.out.println(flujoEntrada.readLine());
            System.out.println("confirmo");
        }catch (IOException e){

        }
    }

    private void enviarFraseMensaje(String mensaje) throws IOException {
        System.out.println("2");
        flujoSalida.println(mensaje);
    }

    private void enviarTipoServicio(String i) throws IOException {
        System.out.println("1");
        flujoSalida.println(i);
    }

}
