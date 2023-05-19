package SegundoPunto;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class AppServidor {

    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;

    Socket socketComunicacion;

    PrintWriter flujoSalida;
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

                flujoSalida = new PrintWriter(socketComunicacion.getOutputStream(),true);
                //flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
                entrada = new BufferedReader(new InputStreamReader(socketComunicacion.getInputStream()));

                for (int i = 0; i < 2; i++) {
                    recibirDatosPrimitivos();
                }
                activarServicio();

                //flujoEntrada.close();
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

    private void activarServicio() throws IOException {
        if(tipoServicio.equals("1")){
            verificarPalindromo(mensajeCliente);
        } else if (tipoServicio.equals("2")) {
            contarVocalesConsonantes(mensajeCliente);
        }else {
            System.out.println("opcion no valida");
        }
    }


    private void recibirDatosPrimitivos()throws IOException {

//		flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
        //Se obtiene el flujo entrante desde el cliente
        System.out.println("3");
        if(tipoServicio.equals("") ){
            tipoServicio = entrada.readLine();
            System.out.println(tipoServicio);
        }else{
            mensajeCliente = entrada.readLine();
            System.out.println(mensajeCliente);
        }

    }

    private void contarVocalesConsonantes(String mensajeCliente) {
        String cantidad = "";
        int cantVocales = contarVocales(mensajeCliente);
        int cantConsonante = contarConsonates(mensajeCliente);
        cantidad = "vocales: "+cantVocales +" y consonantes: "+cantConsonante;
        flujoSalida.println(cantidad);
    }

    private int contarConsonates(String mensajeCliente) {
        int cont = 0;

        for (int i = 0; i < mensajeCliente.length(); i++) {
            if(verificarLetra(mensajeCliente.charAt(i))==false){
                cont++;
            }
        }
        return cont;
    }

    private int contarVocales(String mensajeCliente) {
        int cont = 0;

        for (int i = 0; i < mensajeCliente.length(); i++) {
            if(verificarLetra(mensajeCliente.charAt(i))==true){
                cont++;
            }
        }
        return cont;
    }

    private void verificarPalindromo(String mensajeCliente) throws IOException {
        mensajeCliente = quitarEspacio(mensajeCliente);
        String frase = mensajeCliente.toLowerCase();
        System.out.println(frase);
        String nuevaFrase = "";
        for (int i = frase.length()-1; i >=0; i--) {
            nuevaFrase = nuevaFrase +frase.charAt(i);
        }

        if(nuevaFrase.equals(frase)){
            flujoSalida.println("es palindroma");
        }else{
            flujoSalida.println("no es palindroma");
        }
    }

    private static String quitarEspacio(String mensajeCliente) {
        String mensaje = "";

        for (int i = 0; i < mensajeCliente.length(); i++) {
            if(mensajeCliente.charAt(i) != ' '){
                mensaje += mensajeCliente.charAt(i);
            }
        }
        return mensaje;
    }

    private boolean verificarLetra(char letra) {
        if(letra=='a' || letra == 'e'|| letra == 'i' || letra == 'o' || letra=='u'){
            return true;
        }
        return false;
    }

}
