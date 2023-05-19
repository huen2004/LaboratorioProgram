package Test;

import java.util.ArrayList;
import java.util.Locale;

public class test {

    public static void main(String[] args) {
//        char letra = ' ';
//        ArrayList<Character> letrasDesechadas = new ArrayList<Character>();
//
//        for (int i = 0; i < 100; i++) {
//            letra = (char) (int)(97+(Math.random()*26));
//            letrasDesechadas.add(letra);
//            //System.out.println(letrasDesechadas.get(i));
//        }
//
//        System.out.println((int)((Math.random()*21))+"");

        prueba();
    }
    
    public static void prueba(){
        String mensajeCliente = "Alliva Ramon y no maravilla";
        mensajeCliente = quitarEspacio(mensajeCliente);
        String frase = mensajeCliente.toLowerCase();
        System.out.println(frase);
        String nuevaFrase = "";
        for (int i = frase.length()-1; i >=0; i--) {
            nuevaFrase = nuevaFrase +frase.charAt(i);
        }
        System.out.println(nuevaFrase);

        if(nuevaFrase.equals(frase)){
            System.out.println("sirvio");
        }else{
            System.out.println("no sirvio");
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
}
