package graphic.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ChoixIcone extends Application {
    private Stage mainChoixStage = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainChoixStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/Choix.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("/tools/images/iconefenetre.png"));
        primaryStage.setTitle("Choix ");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

    //constructeur
    public ChoixIcone()
    {

    }
}
