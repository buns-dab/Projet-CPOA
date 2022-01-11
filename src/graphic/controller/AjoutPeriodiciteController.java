package graphic.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import metier.Periodicite_pojo;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static graphic.controller.AccueilController.daof;

public class AjoutPeriodiciteController  implements Initializable {

    @FXML
    private TextField txt_periodicite;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void CreerPeriodicite() throws Exception {
        String periodicite = txt_periodicite.getText().trim();

        if(periodicite.equals(""))
        {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Ajout periodicite");
            alert2.setHeaderText("Pour votre information : ");
            alert2.setContentText("Vous n'avez pas saisie tous les champs  ");
            alert2.showAndWait();
        }
        else if(!periodicite.equals(""))
        {
            //boite de dialogue avec information
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ajout periodiicte");
            alert.setHeaderText("Pour votre information : ");
            alert.setContentText("Voulez-vous enregistrer vos ajouts ? ");

            Optional<ButtonType> choixBtn = alert.showAndWait();


            if (choixBtn.get() == ButtonType.OK) {
                Periodicite_pojo p = new Periodicite_pojo(periodicite);
                daof.getPeriodiciteDao().create(p);
                txt_periodicite.setText("");
            }

            else if (choixBtn.get() == ButtonType.CANCEL)
                alert.close();
        }
        }
}