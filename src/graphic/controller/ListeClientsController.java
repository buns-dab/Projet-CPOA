package graphic.controller;

import dao.client.Adresse;
import graphic.application.CreerClient;
import graphic.application.ModifierClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import metier.Client_pojo;

import static graphic.controller.AccueilController.daof;
import static graphic.controller.ModifClientController.cltModif;

public class ListeClientsController implements Initializable {

    @FXML
    private TableView<Client_pojo> TableListeClient;

    @FXML
    private TableColumn<Client_pojo, String> ColonneCodePostalClient;

    @FXML
    private TableColumn<Client_pojo, Integer> ColonneIdClient;

    @FXML
    private TableColumn<Client_pojo, String> ColonneNoRueClient;

    @FXML
    private TableColumn<Client_pojo, String> ColonneNomClient;

    @FXML
    private TableColumn<Client_pojo, String> ColonnePaysClient;

    @FXML
    private TableColumn<Client_pojo, String> ColonnePrenomClient;

    @FXML
    private TableColumn<Client_pojo, String> ColonneVilleClient;

    @FXML
    private TableColumn<Client_pojo, String> ColonneVoieClient;

    //recuperer tous les clients
    public ObservableList<Client_pojo> listClients = FXCollections.observableArrayList(daof.getClientDao().getAll()) ;

    //constructeur
    public ListeClientsController() throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColonneIdClient.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        ColonneNomClient.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColonnePrenomClient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ColonneNoRueClient.setCellValueFactory(new PropertyValueFactory<>("no_rue"));
        ColonneVoieClient.setCellValueFactory(new PropertyValueFactory<>("voie"));
        ColonneCodePostalClient.setCellValueFactory(new PropertyValueFactory<>("code_postal"));
        ColonneVilleClient.setCellValueFactory(new PropertyValueFactory<>("ville"));
        ColonnePaysClient.setCellValueFactory(new PropertyValueFactory<>("pays"));

        TableListeClient.setItems(listClients);

       }

    @FXML
    public void btnCSV() throws IOException {
        FileChooser parcourirFichiers = new FileChooser();
        File selectedFile = parcourirFichiers.showOpenDialog(null);
        if (selectedFile != null) { // si on choisit un fichier , on fait la methode

            BufferedReader reader = new BufferedReader(new FileReader(selectedFile.getAbsolutePath())); // recupère le chemin du dossier
            String line ="";
            try {
                while((line =reader.readLine()) != null) {
                    String[] row = line.split(",");
                    Client_pojo client = new Client_pojo(Integer.parseInt(row[0]),row[1],row[2],row[3],Adresse.normalizeVoie(row[4]),Adresse.normalizeCodePst(row[5]),Adresse.normalizeVille(row[6]), Adresse.normalizePays(row[7]) );
                    daof.getClientDao().create(client);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                TableListeClient.refresh();
                reader.close();
            }
        }
    }

    //action sur le bouton creer client
    @FXML
     public void AjoutListeClients() throws Exception{
        CreerClient client = new CreerClient();
        client.start(new Stage());
    }

    //action sur le bouton modifier client
    @FXML

    public void ModifierListeClients() throws Exception{
        try {
            cltModif = TableListeClient.getSelectionModel().getSelectedItem();
            ModifierClient client = new ModifierClient();
            client.start(new Stage());

        }catch (Exception e)
        {
            //boite de dialogue avec erreur car on a pas selectionne de client dans la liste
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modification listes clients");
            alert.setHeaderText("Pour votre information : ");
            alert.setContentText("Vous avez oublie de selectionner un client dans la liste  ");
            alert.showAndWait();
        }
    }

    //action sur le bouton supprimer client
    @FXML
    public void SupprimerClientListe() throws Exception{
        //boite de dialogue avec confirmation pour confirmer la suppression du client
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression clients dans liste");
        alert.setHeaderText("Pour votre information : ");
        alert.setContentText("Voulez-vous vraiment supprimer ce client ?  ");

        Optional<ButtonType> choixBtn = alert.showAndWait();
        //si ok alors on supprime le client
        if (choixBtn.get() == ButtonType.OK)
        {
            Client_pojo cl = TableListeClient.getSelectionModel().getSelectedItem();
            daof.getClientDao().delete(cl);
            listClients = FXCollections.observableArrayList(daof.getClientDao().getAll());
            TableListeClient.setItems(listClients);
            TableListeClient.refresh();
        }
        //sinon on ferme la boite de dialogue
        else if (choixBtn.get() == ButtonType.CANCEL)
            alert.close();
    }
}