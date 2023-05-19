package SegundoPunto;

import java.io.IOException;

public class MainCliente {
    public static void main(String[] args){

        AppCliente appCliente = new AppCliente("localhost",8081,"alliva ramon y no maravilla","2");
        System.out.println("Iniciando cliente\n");
        appCliente.iniciarCliente();
    }
}
