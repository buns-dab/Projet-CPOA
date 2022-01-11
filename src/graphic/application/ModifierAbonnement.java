package graphic.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ModifierAbonnement extends Application {
    private Stage ModifierListeAbonnement = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.ModifierListeAbonnement = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/modifierAbonnement.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("/tools/images/iconefenetre.png"));
        primaryStage.setTitle("Modification des abonnements");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void main(String[] args) {
        launch();
    }

    //constructeur
    public ModifierAbonnement()
    {

    }
}
