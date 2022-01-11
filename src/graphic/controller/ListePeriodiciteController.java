package graphic.controller;

import graphic.application.ModifierPeriodicite;
import graphic.application.Periodicite;
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
import metier.Periodicite_pojo;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static graphic.controller.AccueilController.daof;
import static graphic.controller.ModifPeriodiciteController.PeriodiciteModif;

public class ListePeriodiciteController implements Initializable {
    @FXML
    private TableColumn<Periodicite_pojo, Integer> ColonneIdPeriodicite;

    @FXML
    private TableColumn<Periodicite_pojo, String> ColonneLibellePeriodicite;

    @FXML
    private TableView<Periodicite_pojo> TableListePeriodicite;

    public ObservableList<Periodicite_pojo> listPeriodicites = FXCollections.observableArrayList(daof.getPeriodiciteDao().getAll()) ;

    //constructeur
    public ListePeriodiciteController() throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColonneIdPeriodicite.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColonneLibellePeriodicite.setCellValueFactory(new PropertyValueFactory<>("libelle"));

        TableListePeriodicite.setItems(listPeriodicites);
    }

    @FXML
    public void AjouterListePeriodicite() throws Exception{
        Periodicite periodicite = new Periodicite();
        periodicite.start(new Stage());

    }

    @FXML
    public void ModifierListePeriodicite()throws Exception {
        try {
            PeriodiciteModif = TableListePeriodicite.getSelectionModel().getSelectedItem();
            ModifierPeriodicite periodicite = new ModifierPeriodicite();
            periodicite.start(new Stage());
        }catch (Exception e)
        {
            //boite de dialogue avec erreur car on a pas selectionne de client dans la liste
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modification listes periodicites");
            alert.setHeaderText("Pour votre information : ");
            alert.setContentText("Vous avez oublie de selectionner une periodicite dans la liste  ");
            alert.showAndWait();
        }

    }

    @FXML
    public void SupprimerListePeriodicite() throws Exception{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression periodicites dans liste");
        alert.setHeaderText("Pour votre information : ");
        alert.setContentText("Voulez-vous vraiment supprimer cette periodicite ?  ");

        Optional<ButtonType> choixBtn = alert.showAndWait();

        if (choixBtn.get() == ButtonType.OK)
        {
            Periodicite_pojo p = TableListePeriodicite.getSelectionModel().getSelectedItem();
            daof.getPeriodiciteDao().delete(p);
            listPeriodicites = FXCollections.observableArrayList(daof.getPeriodiciteDao().getAll());
            TableListePeriodicite.setItems(listPeriodicites);
            TableListePeriodicite.refresh();
        }
        //sinon on ferme la boite de dialogue
        else if (choixBtn.get() == ButtonType.CANCEL)
            alert.close();

    }
}