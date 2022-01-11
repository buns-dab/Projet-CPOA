package graphic.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import metier.Abonnement_pojo;
import metier.Client_pojo;
import metier.Revue_pojo;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import static graphic.controller.AccueilController.daof;

public class AjoutAbonnementController implements Initializable {

    @FXML
    private DatePicker datepckDateDebAbonnement;

    @FXML
    private DatePicker datepckDateFinAbonnement;

    @FXML
    private ChoiceBox<Client_pojo> ChoiceBoxClient;

    @FXML
    private ChoiceBox<Revue_pojo> ChoiceBoxRevue;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.ChoiceBoxClient.setItems(FXCollections.observableArrayList(daof.getClientDao().getAll()));
            this.ChoiceBoxRevue.setItems(FXCollections.observableArrayList(daof.getRevueDao().getAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void AjouterAbo() throws Exception
    {
        LocalDate dateDebut = datepckDateDebAbonnement.getValue();
        LocalDate dateFin = datepckDateFinAbonnement.getValue();
        Client_pojo Client = ChoiceBoxClient.getSelectionModel().getSelectedItem();
        Revue_pojo Revue = ChoiceBoxRevue.getSelectionModel().getSelectedItem();

        if((dateDebut == null)||(dateFin == null) ||(Client == null) ||(Revue ==null))
        {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Ajout abonnement");
            alert2.setHeaderText("Pour votre information : ");
            alert2.setContentText("au moins un des champs de saisies est vide ");
            alert2.showAndWait();
        }
        else if((dateDebut != null)&&(dateFin != null) &&(Client != null) &&(Revue !=null))
        {
            if(dateDebut.isAfter(dateFin))
            {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Ajout abonnement");
                alert2.setHeaderText("Pour votre information : ");
                alert2.setContentText("la date de début est supérieur à la date de fin ");
                alert2.showAndWait();
            }
            else
            {
                //boite de dialogue pour confirmer les ajouts
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Ajout abonnement");
                alert.setHeaderText("Pour votre information : ");
                alert.setContentText("Voulez-vous enregistrer vos ajouts ? ");

                Optional<ButtonType> choixBtn = alert.showAndWait();

                if (choixBtn.get() == ButtonType.OK) {
                    Abonnement_pojo a = new Abonnement_pojo(dateDebut,dateFin,Client,Revue);
                    daof.getAbonnementDao().create(a);
                    //nettoyer les champs de saisies quand la saisie est valide
                    datepckDateDebAbonnement.setValue(null);
                    datepckDateFinAbonnement.setValue(null);
                    ChoiceBoxClient.setValue(null);
                    ChoiceBoxRevue.setValue(null);
                }
                //sinon on ferme la boite de dialogue
                else if (choixBtn.get() == ButtonType.CANCEL)
                    alert.close();
            }
        }
    }
}
