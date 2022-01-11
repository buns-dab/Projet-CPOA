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

public class ModifPeriodiciteController implements Initializable {

    @FXML
    private TextField txt_periodicite;

    public static Periodicite_pojo PeriodiciteModif;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_periodicite.setText(PeriodiciteModif.getLibelle());

    }

    @FXML
    public void ModifierPeriodicite() throws Exception {
        String periodicite = txt_periodicite.getText().trim();

        if (periodicite.equals("")) {
            //boite de dialogue avec information
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Modification periodicites");
            alert2.setHeaderText("Pour votre information : ");
            alert2.setContentText("Vous n'avez pas rempli tous les champs de saisies ");
            alert2.showAndWait();
        }
        else if (!periodicite.equals("")) {
            //boite de dialogue avec information
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Modification periodicites");
            alert.setHeaderText("Pour votre information : ");
            alert.setContentText("Voulez-vous enregistrer vos modifications ? ");

            Optional<ButtonType> choixBtn = alert.showAndWait();

            //si ok alors on modifie le client
            if (choixBtn.get() == ButtonType.OK) {
                PeriodiciteModif.setLibelle(periodicite);
                daof.getPeriodiciteDao().update(PeriodiciteModif);
            }
            //sinon on ferme la boite de dialogue
            else if (choixBtn.get() == ButtonType.CANCEL)
                alert.close();
        }
    }
}
