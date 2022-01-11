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

public class ModifAbonnementController implements Initializable {

    @FXML
    private DatePicker datepckDateDebAbonnement;

    @FXML
    private DatePicker datepckDateFinAbonnement;

    @FXML
    private ChoiceBox<Client_pojo> ChoiceBoxClient;

    @FXML
    private ChoiceBox<Revue_pojo> ChoiceBoxRevue;

    public static Abonnement_pojo AbonnementModif;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datepckDateDebAbonnement.setValue(AbonnementModif.getDate_debut());
        datepckDateFinAbonnement.setValue(AbonnementModif.getDate_fin());

        //mettre la valeur de la périodicité dans la choicebox
        try {
            this.ChoiceBoxClient.setItems(FXCollections.observableArrayList(daof.getClientDao().getAll()));
            ChoiceBoxClient.setValue(AbonnementModif.getClient());//ajout

            this.ChoiceBoxRevue.setItems(FXCollections.observableArrayList(daof.getRevueDao().getAll()));
            ChoiceBoxRevue.setValue(AbonnementModif.getRevue());//ajout
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ModifierAbo() throws Exception {

        LocalDate dateDebut = datepckDateDebAbonnement.getValue();
        LocalDate dateFin = datepckDateFinAbonnement.getValue();
        Client_pojo Client = ChoiceBoxClient.getSelectionModel().getSelectedItem();
        Revue_pojo Revue = ChoiceBoxRevue.getSelectionModel().getSelectedItem();

        if((dateDebut == null)||(dateFin == null) ||(Client == null) ||(Revue ==null))
        {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Ajout abonnement");
            alert2.setHeaderText("Pour votre information : ");
            alert2.setContentText("Au moins un des champs de saisies est vide ");
            alert2.showAndWait();
        }
        else if((dateDebut != null)&&(dateFin != null) &&(Client != null) &&(Revue !=null))
        {
            if(dateDebut.isAfter(dateFin))
            {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Ajout abonnement");
                alert2.setHeaderText("Pour votre information : ");
                alert2.setContentText("La date de debut est superieure a la date de fin");
                alert2.showAndWait();
            }
            else
            {
                //boite de dialogue avec information pour enregistrer les modifications
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Modification abonnements");
                alert.setHeaderText("Pour votre information : ");
                alert.setContentText("Voulez-vous enregistrer vos modifications ? ");

                Optional<ButtonType> choixBtn = alert.showAndWait();

                if (choixBtn.get() == ButtonType.OK)
                {
                    AbonnementModif.setDate_debut(dateDebut);
                    AbonnementModif.setDate_fin(dateFin);
                    AbonnementModif.setClient(Client);
                    AbonnementModif.setRevue(Revue);

                    daof.getAbonnementDao().update(AbonnementModif);
                }
                //sinon on ferme la boite de dialogue
                else if (choixBtn.get() == ButtonType.CANCEL)
                    alert.close();
            }
        }
    }
}