package PrimerPunto;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        P1 productor = new P1(buffer);
        P2 productor1 = new P2(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        productor.start();
        productor1.start();
        consumidor.start();
    }
}
