package graphic.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ListeAbonnements extends Application {
    private Stage ListeAbonnementStage = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.ListeAbonnementStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/ListeAbonnements.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("/tools/images/iconefenetre.png"));
        primaryStage.setTitle("Liste des abonnements");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}