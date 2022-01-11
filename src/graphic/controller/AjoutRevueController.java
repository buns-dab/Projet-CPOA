package graphic.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import metier.Periodicite_pojo;
import metier.Revue_pojo;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static graphic.controller.AccueilController.daof;

public class AjoutRevueController implements Initializable {
    @FXML
    private ChoiceBox<Periodicite_pojo> ChoiceBoxPeriodiciteRevue;

    @FXML
    private TextArea txt_description;

    @FXML
    private TextField txt_tarif;

    @FXML
    private TextField txt_titre;

    @FXML
    private TextField txt_visuel;


    //compléter la combobox
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.ChoiceBoxPeriodiciteRevue.setItems(FXCollections.observableArrayList(daof.getPeriodiciteDao().getAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //action sur le bouton creer revue
    public void BtnAjoutRevue() throws Exception
    {
        String titre = txt_titre.getText().trim();
        String description = txt_description.getText().trim();
        String visuel = txt_visuel.getText().trim();
        Periodicite_pojo Periodicite = ChoiceBoxPeriodiciteRevue.getSelectionModel().getSelectedItem();

        if(titre.equals("") ||(description.equals("")) || (visuel.equals("")) ) //gérer le cas ou la choicebox est vide
        {
            //boite de dialogue qui indique qu'au moins un des champs de saisies est vide
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Ajout revue");
            alert2.setHeaderText("Pour votre information : ");
            alert2.setContentText("Vous n'avez pas saisie tous les champs  ");
            alert2.showAndWait();
        }
        else if(!titre.equals("") ||(!description.equals("")) || (!visuel.equals(""))) //gérer le cas où la choicebox est vide
        {
            try{
                Float tarif =  Float.parseFloat(txt_tarif.getText().trim());
                //boite de dialogue pour confirmer les ajouts
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Ajout revue");
                alert.setHeaderText("Pour votre information : ");
                alert.setContentText("Voulez-vous enregistrer vos ajouts ? ");

                Optional<ButtonType> choixBtn = alert.showAndWait();

                if (choixBtn.get() == ButtonType.OK) {
                    Revue_pojo r = new Revue_pojo(titre,description,tarif,visuel,Periodicite);
                    txt_titre.setText("");
                    txt_description.setText("");
                    txt_tarif.setText("");
                    txt_visuel.setText("");
                    ChoiceBoxPeriodiciteRevue.setValue(null);
                    daof.getRevueDao().create(r);
                }
                //sinon on ferme la boite de dialogue
                else if (choixBtn.get() == ButtonType.CANCEL)
                    alert.close();
            }catch (NumberFormatException n)
            {
                //boite de dialogue avec information car il faut entrer des chiffres pour le tarif
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Ajout revues");
                alert2.setHeaderText("Pour votre information : ");
                alert2.setContentText("Entrez un nombre pour le tarif !! ");
                alert2.showAndWait();
            }

        }
    }
}

        /*String titre = txt_titre.getText().trim();
        String description = txt_description.getText().trim();


        try{
            Float tarif =  Float.parseFloat(txt_tarif.getText().trim());
            String visuel = txt_visuel.getText().trim();
            Periodicite_pojo Periodicite = ChoiceBoxPeriodiciteRevue.getSelectionModel().getSelectedItem();

            if((!titre.equals("")) && (!description.equals(""))  && (!tarif.equals("")) && (!visuel.equals(""))) //gérer le cas ou la choicebox est vide
            {
                //boite de dialogue pour confirmer les ajouts
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Ajout revue");
                alert.setHeaderText("Pour votre information : ");
                alert.setContentText("Voulez-vous enregistrer vos ajouts ? ");

                Optional<ButtonType> choixBtn = alert.showAndWait();

                //si ok alors on creer le client
                if (choixBtn.get() == ButtonType.OK) {
                    Revue_pojo r = new Revue_pojo(titre,description,tarif,visuel,Periodicite);
                    txt_titre.setText("");
                    txt_description.setText("");
                    txt_tarif.setText("");
                    txt_visuel.setText("");
                    ChoiceBoxPeriodiciteRevue.setValue(null);
                    daof.getRevueDao().create(r);
                }
                //sinon on ferme la boite de dialogue
                else if (choixBtn.get() == ButtonType.CANCEL)
                    alert.close();
            }
            else {
                //boite de dialogue qui indique qu'au moins un des champs de saisies est vide
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Ajout revue");
                alert2.setHeaderText("Pour votre information : ");
                alert2.setContentText("Vous n'avez pas saisie tous les champs  ");
                alert2.showAndWait();
            }
        }catch (NumberFormatException n)
        {
            //boite de dialogue avec information car il faut entrer des chiffres pour le tarif
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Ajout revues");
            alert2.setHeaderText("Pour votre information : ");
            alert2.setContentText("Entrez un nombre pour le tarif !! ");
            alert2.showAndWait();
        }*/
