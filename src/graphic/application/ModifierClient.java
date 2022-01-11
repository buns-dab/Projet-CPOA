package graphic.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ModifierClient extends Application {
    private Stage ModifierListeClient = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.ModifierListeClient = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/modifierClient.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("/tools/images/iconefenetre.png"));
        primaryStage.setTitle("Modification des clients");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
        public static void main(String[] args) {
            launch();
        }

    //constructeur
    public ModifierClient()
    {

    }

    public void hide()
    {
        ModifierListeClient.hide();
    }
}
