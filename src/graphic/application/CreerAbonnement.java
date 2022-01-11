package graphic.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CreerAbonnement extends Application {
    private Stage mainAboStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainAboStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/abonnement.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("/tools/images/iconefenetre.png"));
        primaryStage.setTitle("Ajout d'un abonnement");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

    //constructeur
    public CreerAbonnement()
    {

    }
}
