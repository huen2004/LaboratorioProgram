package Ejercicio3.application;

import Ejercicio3.controller.TrabajosGradoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        MostrarVentana();

    }

    public void MostrarVentana (){
        try {
            stage.close();
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/TrabajosGrado.fxml"));
            AnchorPane rootLayout = loader.load();
            TrabajosGradoController controller = loader.getController();
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Uniquindio");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
