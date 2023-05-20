package Ejercicio3.model;

import Ejercicio3.Persistencia.Persistencia;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;

    Universidad universidad;

    Socket socketComunicacion;

    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;
    BufferedReader entrada;
    ObjectInputStream inputStream = null;
    ObjectOutputStream outputStream = null;


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
                inputStream = new ObjectInputStream(socketComunicacion.getInputStream());
                outputStream = new ObjectOutputStream(socketComunicacion.getOutputStream());

                if(universidad==null) {
                    inicializarDatos();
                    Persistencia.guardarRecursoXML(universidad);
                    Persistencia.guardarTrabajoGrados(universidad.getListaTrabajosGrado());
                }

                outputStream.writeObject(this.universidad);

                inputStream.close();
                outputStream.close();
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


    private void inicializarDatos() {
        Universidad universidad = new Universidad("U. del norte");
        this.universidad = universidad;

        //Trabajos de grado
        TrabajoGrado trabajoGrado = new TrabajoGrado();
        trabajoGrado.setTitulo("Fibonacci");
        trabajoGrado.setCodigo("1");
        trabajoGrado.setFecha("19/05/2023");
        trabajoGrado.setDescripcion("La maravillas del fibonacci");

        //Autores
        //autor1
        Autor autor = new Autor();
        autor.setNombre("Juan");
        autor.setApellido("Salazar");
        autor.setCedula("10");
        autor.setPrograma("ingenieria");
        trabajoGrado.getListaAutores().add(autor);
        //autor2
        Autor autor2 = new Autor();
        autor2.setNombre("Jere");
        autor2.setApellido("Urrea");
        autor2.setCedula("11");
        autor2.setPrograma("licenciatura");
        trabajoGrado.getListaAutores().add(autor2);

        universidad.getListaTrabajosGrado().add(trabajoGrado);
        System.out.println("inicializado");
    }
}
