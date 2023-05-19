package PrimerPunto;

public class P2 extends Thread{

    private Buffer buffer;

    public P2( Buffer buffer )
    {
        // Mantiene una copia propia del objeto compartido
        this.buffer = buffer;
    }

    public void run() {
        char letra = ' ';
        while (buffer.isCompletado()== false){
            letra = (char) (int)(97+(Math.random()*26));
            if(verificarConsonantes(letra)){
                buffer.lanzar( letra );
                // Imprime un registro con lo añadido
                //System.out.println( "Lanzado "+letra+" a la tuberia." );
                // Espera un poco antes de añadir más letras
            }
            try
            {
                sleep(  500  );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);;
            }
        }
    }

    private boolean verificarConsonantes(char letra) {
        if(letra=='a' || letra == 'e'|| letra == 'i' || letra == 'o' || letra=='u'){
            return false;
        }
        return true;
    }
}
