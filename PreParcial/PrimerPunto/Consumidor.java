package PrimerPunto;

import java.util.ArrayList;

public class Consumidor extends Thread{
    private Buffer buffer;

    private String palabra = "parangaricutirimiguaro";
    private char[] palabraEncontrada = new char[palabra.length()];
    private ArrayList<Character> letrasDesechadas = new ArrayList<Character>();

    public Consumidor( Buffer buffer )
    {
        // Mantiene una copia propia del objeto compartido
        this.buffer = buffer;
    }

    public void run() {
        char letra;
        int i =0;
        // Consume 10 letras de la tubería

        while (i<palabra.length()){
            letra = buffer.recoger();

            if(letra == palabra.charAt(i)){
                palabraEncontrada[i] = letra;
                System.out.println("encontrada "+palabraEncontrada[i]);
                i++;
            }else{
                letrasDesechadas.add(letra);
                System.out.println("desechada "+letra);
            }
            // Espera un poco antes de coger más letras
            try
            {
                sleep( (int)(Math.random() * 1200 ) );
            }
            catch( InterruptedException e )
            {

            }
        }
        if(i>= palabra.length()){
            buffer.setCompletado(true);
        }
    }

}
