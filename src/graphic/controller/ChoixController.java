package graphic.controller;

import graphic.application.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChoixController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    @FXML
    public void ClicAbonnementAccueil() throws Exception {
       ListeAbonnements abonnement = new ListeAbonnements();
        abonnement.start(new Stage());
    }

    @FXML
    public void ClicClientAccueil() throws Exception {
        ListeClients client = new ListeClients();
        client.start(new Stage());
    }

    @FXML
    void ClicRevueAccueil() throws Exception {
        ListeRevues revue = new ListeRevues();
        revue.start(new Stage());
    }

    @FXML
    public void ClicPeriodiciteAccueil() throws Exception {
       ListePeriodicite periodicite = new ListePeriodicite();
       periodicite.start(new Stage());
    }
}