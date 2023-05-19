package PrimerPunto;

public class P1 extends Thread{
    private Buffer buffer;

    public P1( Buffer buffer )
    {
        // Mantiene una copia propia del objeto compartido
        this.buffer = buffer;
    }

    public void run() {
        char letra = ' ';
        while (buffer.isCompletado()== false){
            letra = (char) (int)(97+(Math.random()*26));
            if(verificarVocacal(letra)){
                buffer.lanzar( letra );
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

    private boolean verificarVocacal(char letra) {
        if(letra=='a' || letra == 'e'|| letra == 'i' || letra == 'o' || letra=='u'){
            return true;
        }
        return false;
    }
}
