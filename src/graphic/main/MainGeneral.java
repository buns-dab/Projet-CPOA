package graphic.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainGeneral extends Application {
    private Stage mainAccueilStage = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainAccueilStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/accueil.fxml"));
        primaryStage.getIcons().add(new Image("/tools/images/iconefenetre.png"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Accueil de l'application");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

    //constructeur
    public MainGeneral()
    {

    }
}
