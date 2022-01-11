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

public class ModifRevueController implements Initializable {

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

    public static Revue_pojo RevueModif;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_titre.setText(RevueModif.getTitre());
        txt_description.setText(RevueModif.getDescription());
        txt_tarif.setText(String.valueOf(RevueModif.getTarif_numero()));
        txt_visuel.setText(RevueModif.getVisuel());
        //mettre la valeur de la périodicité dans la choicebox
        try {
            this.ChoiceBoxPeriodiciteRevue.setItems(FXCollections.observableArrayList(daof.getPeriodiciteDao().getAll()));
            ChoiceBoxPeriodiciteRevue.setValue(RevueModif.getPeriodicite());//ajout
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //action sur le bouton creer revue
    public void btnModifierRevue() throws Exception {
        String titre = txt_titre.getText().trim();
        String description = txt_description.getText().trim();
        String visuel = txt_visuel.getText().trim();
        Periodicite_pojo Periodicite = ChoiceBoxPeriodiciteRevue.getSelectionModel().getSelectedItem();

        if(titre.equals("") ||(description.equals("")) || (visuel.equals("")) ||(Periodicite==null) ) //gérer le cas ou la choicebox est vide
        {
            //boite de dialogue qui indique qu'au moins un des champs de saisies est vide
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Ajout revue");
            alert2.setHeaderText("Pour votre information : ");
            alert2.setContentText("Vous n'avez pas saisie tous les champs  ");
            alert2.showAndWait();
        }
        else if(!titre.equals("") ||(!description.equals("")) || (!visuel.equals("")) &&(Periodicite==null)) //gérer le cas où la choicebox est vide
        {
            try{
                Float tarif =  Float.parseFloat(txt_tarif.getText().trim());
                //boite de dialogue avec information pour enregistrer les modifications
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Modification revues");
                alert.setHeaderText("Pour votre information : ");
                alert.setContentText("Voulez-vous enregistrer vos modifications ? ");

                Optional<ButtonType> choixBtn = alert.showAndWait();

                if (choixBtn.get() == ButtonType.OK)
                {
                    RevueModif.setTitre(titre);
                    RevueModif.setDescription(description);
                    RevueModif.setTarif_numero(Float.parseFloat(txt_tarif.getText()));
                    RevueModif.setVisuel(visuel);
                    RevueModif.setPeriodicite(Periodicite);

                    daof.getRevueDao().update(RevueModif);
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
                alert2.setContentText("Entrez un nombre pour le tarif ! ");
                alert2.showAndWait();
            }

        }
    }
}