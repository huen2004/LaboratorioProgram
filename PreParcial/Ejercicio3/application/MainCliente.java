package Ejercicio3.application;


import Ejercicio3.model.AppCliente;

public class MainCliente {

    public static void main(String[] args) {
        AppCliente appCliente = new AppCliente("localhost",8081);
        System.out.println("Iniciando cliente\n");
        appCliente.iniciarCliente();
    }

}