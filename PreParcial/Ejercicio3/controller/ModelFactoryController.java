package Ejercicio3.controller;

import Ejercicio3.model.*;
import Ejercicio3.application.MainCliente;

public class ModelFactoryController {

    MainCliente mainCliente;
    Universidad universidad;


    AppCliente appCliente = new AppCliente("localhost",8081);

    /**
     * singleton holder
     */
    public static class SingletonHolder {
        public final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    /**
     * get del singleton
     * @return
     */
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    /**
     * constructor de model factory controller
     */
    public ModelFactoryController() {

        System.out.println("Iniciando cliente\n");
        appCliente.iniciarCliente();
        this.universidad = appCliente.getUniversidad();

    }


}
