package graphic.controller;

import graphic.application.CreerAbonnement;
import graphic.application.ModifierAbonnement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metier.Abonnement_pojo;
import metier.Revue_pojo;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import static graphic.controller.AccueilController.daof;
import static graphic.controller.ModifAbonnementController.AbonnementModif;

public class ListeAbonnementsController implements Initializable {
    @FXML
    private TableView<Abonnement_pojo> TableListeAbonnements;

    @FXML
    private TableColumn<Abonnement_pojo, LocalDate> ColonneDateDebutAbonnement;

    @FXML
    private TableColumn<Abonnement_pojo, LocalDate> ColonneDateFinAbonnement;

    @FXML
    private TableColumn<Abonnement_pojo, Integer> ColonneIdAbonnement;

    @FXML
    private TableColumn<Revue_pojo, String> ColonneClientAbonnement;

    @FXML
    private TableColumn<Revue_pojo, String> ColonneRevueAbonnement;


    public ObservableList<Abonnement_pojo> listAbonnement = FXCollections.observableArrayList(daof.getAbonnementDao().getAll()) ;

    //constructeur
    public ListeAbonnementsController() throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColonneIdAbonnement.setCellValueFactory(new PropertyValueFactory<>("id_abonnement"));
        ColonneDateDebutAbonnement.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        ColonneDateFinAbonnement.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        ColonneClientAbonnement.setCellValueFactory(new PropertyValueFactory<>("client"));
        ColonneRevueAbonnement.setCellValueFactory(new PropertyValueFactory<>("revue"));

        TableListeAbonnements.setItems(listAbonnement);

    }

    //action sur le bouton creer abonnement
    @FXML
    public void AjouterAbonnement() throws Exception{
        CreerAbonnement abonnement = new CreerAbonnement();
        abonnement.start(new Stage());
    }

    //action sur le bouton modifier abonnement
    @FXML
    public void ModifierAbonnement() throws Exception{
        try {
            AbonnementModif = TableListeAbonnements.getSelectionModel().getSelectedItem();
            ModifierAbonnement abonnement = new ModifierAbonnement();
            abonnement.start(new Stage());
        }catch(Exception e)
        {
            //boite de dialogue avec erreur car on a pas selectionne de revue dans la liste
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modification listes abonnements");
            alert.setHeaderText("Pour votre information : ");
            alert.setContentText("Vous avez oublie de selectionner un abonnement dans la liste  ");
            alert.showAndWait();
        }
    }

    //action sur le bouton supprimer abonnement
    @FXML
    public void SupprimerAbonnement() throws Exception{
        //boite de dialogue avec confirmation pour confirmer la suppression de la revue
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression abonnement dans liste");
        alert.setHeaderText("Pour votre information : ");
        alert.setContentText("Voulez-vous vraiment supprimer cet abonnement ?  ");

        Optional<ButtonType> choixBtn = alert.showAndWait();

        if (choixBtn.get() == ButtonType.OK)
        {
        Abonnement_pojo a = TableListeAbonnements.getSelectionModel().getSelectedItem();
        daof.getAbonnementDao().delete(a);
        listAbonnement = FXCollections.observableArrayList(daof.getAbonnementDao().getAll());
        TableListeAbonnements.setItems(listAbonnement);
        TableListeAbonnements.refresh();
        }
        //sinon on ferme la boite de dialogue
        else if (choixBtn.get() == ButtonType.CANCEL)
            alert.close();
    }
}
