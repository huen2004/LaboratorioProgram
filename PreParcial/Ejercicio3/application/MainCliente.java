package Ejercicio3.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainCliente extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception{
        this.stage=stage;
        mostrarAlgo();
    }

    private void mostrarVentana() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCliente.class.getResource("Ejercicio3/views/Hola.fxml"));
            AnchorPane rootLayout = loader.load();
            //TrabajosGradoController controller = loader.getController();
            //controller.setMain(this);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Ventana");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarAlgo(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation((MainCliente.class.getResource("Ejercicio3/views/Hola.fxml")));
            AnchorPane rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}