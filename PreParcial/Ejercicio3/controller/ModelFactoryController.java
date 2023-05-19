package Ejercicio3.controller;

import Ejercicio3.model.Autor;
import Ejercicio3.model.TrabajoGrado;
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
        this.universidad= Persistencia.cargarRecursoXML();
        if(universidad==null) {
            inicializarDatos();

        }

    }

    private void inicializarDatos() {
        Universidad universidad = new Universidad("U. del norte");
        this.universidad = universidad;

        //Trabajos de grado
        TrabajoGrado trabajoGrado = new TrabajoGrado();
        trabajoGrado.setTitulo("Fibonacci");
        trabajoGrado.setCodigo("1");
        trabajoGrado.setFecha("19/05/2023");
        trabajoGrado.setDescripcion("La maravillas del fibonacci");

        //Autores
        //autor1
        Autor autor = new Autor();
        autor.setNombre("Juan");
        autor.setApellido("Salazar");
        autor.setCedula("10");
        autor.setPrograma("ingenieria");
        trabajoGrado.getListaAutores().add(autor);
        //autor2
        Autor autor2 = new Autor();
        autor2.setNombre("Jere");
        autor2.setApellido("Urrea");
        autor2.setCedula("11");
        autor2.setPrograma("licenciatura");
        trabajoGrado.getListaAutores().add(autor2);

        universidad.getListaTrabajosGrado().add(trabajoGrado);
        System.out.println("inicializado");
    }
}
