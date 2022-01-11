package graphic.controller;

import graphic.application.ModifierRevue;
import graphic.application.Revue;
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
import metier.Revue_pojo;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static graphic.controller.AccueilController.daof;
import static graphic.controller.ModifRevueController.RevueModif;

public class ListeRevueController implements Initializable {
    @FXML
    TableView<Revue_pojo> TableListeRevues;

    @FXML
    private TableColumn<Revue_pojo, String> ColonneDescription;

    @FXML
    private TableColumn<Periodicite_pojo, String> ColonnePeriodicite;

    @FXML
    private TableColumn<Revue_pojo, Integer> ColonneIdRevue;

    @FXML
    private TableColumn<Revue_pojo, Float> ColonneTarif;

    @FXML
    private TableColumn<Revue_pojo, String> ColonneTitre;

    @FXML
    private TableColumn<Revue_pojo, String> ColonneVisuel;


    public ObservableList<Revue_pojo> listRevues = FXCollections.observableArrayList(daof.getRevueDao().getAll()) ;

    //constructeur
    public ListeRevueController() throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColonneIdRevue.setCellValueFactory(new PropertyValueFactory<>("id_revue"));
        ColonneTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        ColonneDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        ColonneTarif.setCellValueFactory(new PropertyValueFactory<>("tarif_numero"));
        ColonneVisuel.setCellValueFactory(new PropertyValueFactory<>("visuel"));
        ColonnePeriodicite.setCellValueFactory(new PropertyValueFactory<>("periodicite"));

        TableListeRevues.setItems(listRevues);
    }

    //action sur le bouton creer revue
    @FXML
    public void AjoutListeRevue() throws Exception{
        Revue revue = new Revue();
        revue.start(new Stage());
    }

    @FXML
    public void ModifierListeRevue() throws Exception{
        try {
            RevueModif = TableListeRevues.getSelectionModel().getSelectedItem();
            ModifierRevue revue = new ModifierRevue();
            revue.start(new Stage());
        }catch(Exception e)
        {
            //boite de dialogue avec erreur car on a pas selectionne de revue dans la liste
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modification listes revues");
            alert.setHeaderText("Pour votre information : ");
            alert.setContentText("Vous avez oublie de selectionner une revue dans la liste  ");
            alert.showAndWait();
        }
    }

    //action sur le bouton supprimer revue
    @FXML
    public void SupprimerListeRevue() throws Exception{
        //boite de dialogue avec confirmation pour confirmer la suppression de la revue
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression revues dans liste");
        alert.setHeaderText("Pour votre information : ");
        alert.setContentText("Voulez-vous vraiment supprimer cette revue ?  ");

        Optional<ButtonType> choixBtn = alert.showAndWait();

        if (choixBtn.get() == ButtonType.OK)
        {
            Revue_pojo r = TableListeRevues.getSelectionModel().getSelectedItem();
            daof.getRevueDao().delete(r);
            listRevues = FXCollections.observableArrayList(daof.getRevueDao().getAll());
            TableListeRevues.setItems(listRevues);
            TableListeRevues.refresh();
        }
        //sinon on ferme la boite de dialogue
        else if (choixBtn.get() == ButtonType.CANCEL)
            alert.close();
    }
}