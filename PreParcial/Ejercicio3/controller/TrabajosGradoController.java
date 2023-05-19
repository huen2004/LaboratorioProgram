package Ejercicio3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TrabajosGradoController {

    @FXML
    private TableColumn<?, ?> apellidoAutor;

    @FXML
    private TableView<?> autoresTable;

    @FXML
    private TableColumn<?, ?> cedulaAutor;

    @FXML
    private TableColumn<?, ?> codigoTrabajo;

    @FXML
    private TableColumn<?, ?> descripcionTrabajo;

    @FXML
    private TableColumn<?, ?> fechaTrabajo;

    @FXML
    private TableColumn<?, ?> nombreAutor;

    @FXML
    private Button pedirServicio;

    @FXML
    private TableColumn<?, ?> programaAutor;

    @FXML
    private TableView<?> tableTrabajos;

    @FXML
    private TableColumn<?, ?> tituloProfesionalAutor;

    @FXML
    private TableColumn<?, ?> tituloTrabajo;

    @FXML
    void pedirServicioAction(ActionEvent event) {

    }
}
