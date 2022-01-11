package graphic.controller;

import dao.enumeration.Persistance;
import dao.factory.DAOFactory;
import graphic.application.ChoixIcone;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;

import java.util.ResourceBundle;

public class AccueilController implements Initializable {

    public static DAOFactory daof;
    private static AccueilController instance;
    protected ChoixIcone choix = new ChoixIcone();

    public static AccueilController getInstance() {
        if (instance == null) {
            instance = new AccueilController();
        }
        return instance;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //cas où on se trouve dans LISTE MEMOIRE
    @FXML
    public void ChoixLISTEMEMOIRE() throws Exception {
        daof = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        choix.start(new Stage());
    }

    //choix du cas où on se trouve dans MYSQL
    @FXML
    public void ChoixMYSQL() throws Exception{
        daof = DAOFactory.getDAOFactory(Persistance.MYSQL);
        choix.start(new Stage());
    }

    public DAOFactory getDaof() {
        return daof;
    }


}