package Ejercicio3.model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;

    Socket socketComunicacion;

    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;
    BufferedReader entrada;
    String mensajeCliente;
    String tipoServicio = "";

    public AppServidor() {
    }

    public void iniciarServidor() {


        try {
            // Se crea un socket servidor atendiendo a un determinado puerto.
            server = new ServerSocket(puerto);

            while(true)
            {
                System.out.println ("Esperando cliente");
                socketComunicacion = server.accept();

                //Se envian datos al cliente

                flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());
                flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
                entrada = new BufferedReader(new InputStreamReader(socketComunicacion.getInputStream()));

                flujoEntrada.close();
                flujoSalida.close();

                // Se cierra el socket con el cliente.
                // La llamada anterior a setSoLinger() hará
                // que estos cierres esperen a que el cliente retire los datos.
                socketComunicacion.close();

                // Se cierra el socket encargado de aceptar clientes. Ya no
                // queremos más.
                //		            server.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
