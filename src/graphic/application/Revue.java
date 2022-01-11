package graphic.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Revue extends Application {
    private Stage RevueStage = new Stage();
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.RevueStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/revue.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("/tools/images/iconefenetre.png"));
        primaryStage.setTitle("Ajout d'une revue");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

    //constructeur
    public Revue()
    {

    }
}