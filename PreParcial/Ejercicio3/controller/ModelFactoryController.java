package Ejercicio3.controller;

import Ejercicio3.model.Universidad;
import Ejercicio3.application.MainCliente;
import Ejercicio3.Persistencia.Persistencia;

public class ModelFactoryController {

    Universidad universidad;
    MainCliente main;
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
        this.universidad= Persistencai;
        if(universidad==null) {
            inicializarDatos();

        }

    }

    private void inicializarDatos() {
    }
}
