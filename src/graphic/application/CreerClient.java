package graphic.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CreerClient  extends Application {
    private Stage mainClientStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainClientStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/client.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("/tools/images/iconefenetre.png"));
        primaryStage.setTitle("Ajout d'un client");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

    //constructeur
    public CreerClient()
    {

    }

    public void hide()
    {
        mainClientStage.hide();
    }
}
