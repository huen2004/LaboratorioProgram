package Ejercicio3.controller;

import Ejercicio3.model.*;
import Ejercicio3.application.MainCliente;
import Ejercicio3.Persistencia.Persistencia;

public class ModelFactoryController {

    MainCliente main;
    Universidad universidad;

    AppServidor appServidor = new AppServidor();

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
        appServidor.iniciarServidor();
        this.universidad = appServidor.getUniversidad();

    }


}
