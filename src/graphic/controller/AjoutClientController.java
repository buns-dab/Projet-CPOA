package graphic.controller;

import dao.client.Adresse;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import metier.Client_pojo;

import static graphic.controller.AccueilController.daof;

public class AjoutClientController implements Initializable {

    @FXML
    private TextField txt_cdepst;

    @FXML
    private TextField txt_noRue;

    @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_pays;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_ville;

    @FXML
    private TextField txt_voie;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    //action sur le bouton creer client
    public void btnAjoutClient() throws Exception
    {
        String nom = txt_nom.getText().trim();
        String prenom = txt_prenom.getText().trim();
        String rue = txt_noRue.getText().trim();
        String voie = txt_voie.getText().trim();
        String cdepst = txt_cdepst.getText().trim();
        String ville = txt_ville.getText().trim();
        String pays = txt_pays.getText().trim();

        if ((nom.equals("")) || (prenom.equals("")) || (rue.equals("")) || (voie.equals("")) || (cdepst.equals("")) || (ville.equals("")) || (pays.equals("")))
        {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Ajout clients");
            alert2.setHeaderText("Pour votre information : ");
            alert2.setContentText("Vous n'avez pas saisie tous les champs  ");
            alert2.showAndWait();
        }
        else if ((!nom.equals("")) && (!prenom.equals("")) && (!rue.equals("")) && (!voie.equals("")) && (!cdepst.equals("")) && (!ville.equals("")) && (!pays.equals("")))
        {
                voie = Adresse.normalizeVoie(voie);
                cdepst = Adresse.normalizeCodePst(cdepst);
                ville = Adresse.normalizeVille(ville);
                pays = Adresse.normalizePays(pays);

                //si tous les champs sont saisis on demande si l'utilisateur veut ajouter le client
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Ajout clients");
                alert.setHeaderText("Pour votre information : ");
                alert.setContentText("Voulez-vous enregistrer vos ajouts ? ");

                Optional<ButtonType> choixBtn = alert.showAndWait();

                //si ok alors on ajoute le client
                if (choixBtn.get() == ButtonType.OK) {
                    Client_pojo cl = new Client_pojo(nom, prenom, rue, voie, cdepst, ville, pays);
                    daof.getClientDao().create(cl);

                    txt_nom.setText("");
                    txt_prenom.setText("");
                    txt_noRue.setText("");
                    txt_voie.setText("");
                    txt_cdepst.setText("");
                    txt_ville.setText("");
                    txt_pays.setText("");
                }
                //sinon on ferme la boite de dialogue
                else if (choixBtn.get() == ButtonType.CANCEL)
                    alert.close();

        }
    }
}