package dao.abonnement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.connexion.Connexion;
import metier.Abonnement_pojo;

import static graphic.controller.AccueilController.daof;

public class MySQLDAOAbonnement implements InterfaceDAOAbonnement {

	private static MySQLDAOAbonnement instance;

	private Connection laconnexion = Connexion.getInstance().creeConnexion();

	private MySQLDAOAbonnement() {
	}

	public static MySQLDAOAbonnement getInstance() {
		if (instance == null) {
			instance = new MySQLDAOAbonnement();
		}
		return instance;
	}

	// execution de la requete
	@Override
	public Abonnement_pojo getById(int id) throws Exception {
		if(id<0)
		{
			throw new IllegalArgumentException("L'id ne peut pas être négatif");
		}
		PreparedStatement requete = laconnexion.prepareStatement("SELECT * FROM Abonnement WHERE id_abonnement=?");
		requete.setInt(1,id);

		ResultSet res = requete.executeQuery();

		while(res.next())
		{
			Abonnement_pojo a = new Abonnement_pojo();
			a.setId_abonnement(res.getInt(1));
			a.setDate_debut(res.getDate(2).toLocalDate());
			a.setDate_fin(res.getDate(3).toLocalDate());
			a.setClient(daof.getClientDao().getById(res.getInt(4)));
			a.setRevue(daof.getRevueDao().getById(res.getInt(5)));

			return a;
		}
		return null;
	}

	@Override
	public List<Abonnement_pojo> getAll() throws Exception {
		List<Abonnement_pojo> listeAbo = new ArrayList<>();

        PreparedStatement requete = laconnexion.prepareStatement("SELECT * FROM Abonnement");
        ResultSet res = requete.executeQuery();

        while(res.next())
        {
            Abonnement_pojo a = new Abonnement_pojo();
			a.setId_abonnement(res.getInt(1));
            a.setDate_debut(res.getDate(2).toLocalDate());//voir si la méthode est bonne   driver vérifier si le nord n'est pas inversé
            a.setDate_fin(res.getDate(3).toLocalDate());
            a.setClient(daof.getClientDao().getById(res.getInt(4)));
            a.setRevue(daof.getRevueDao().getById(res.getInt(5)));

            listeAbo.add(a);

        }
        return listeAbo;
	}

	@Override
	public boolean update(Abonnement_pojo objet) throws SQLException{
        PreparedStatement requete = laconnexion.prepareStatement("UPDATE Abonnement SET date_debut=?,date_fin=?,id_client=?,id_revue=? WHERE id_abonnement=?");

        requete.setDate(1,Date.valueOf(objet.getDate_debut()));
        requete.setDate(2,Date.valueOf(objet.getDate_fin()));
        requete.setInt(3,objet.getClient().getId_client());
        requete.setInt(4,objet.getRevue().getId_revue());
		requete.setInt(5,objet.getId_abonnement());

        int nbLignes= requete.executeUpdate();
        return nbLignes==1;
	}

	@Override
	public boolean create(Abonnement_pojo objet) throws SQLException {
		PreparedStatement requete = laconnexion.prepareStatement("INSERT INTO Abonnement(date_debut,date_fin,id_client,id_revue) VALUES(?,?,?,?)");
		
		requete.setDate(1,Date.valueOf(objet.getDate_debut()));
        requete.setDate(2,Date.valueOf(objet.getDate_fin()));
        requete.setInt(3,objet.getClient().getId_client());
        requete.setInt(4,objet.getRevue().getId_revue());

        int nbLignes= requete.executeUpdate();
        return nbLignes==1;
    }

	@Override
	public boolean delete(Abonnement_pojo objet) throws SQLException{
        PreparedStatement requete = laconnexion.prepareStatement("DELETE FROM Abonnement WHERE id_abonnement=?");

        requete.setInt(1,objet.getId_abonnement());

        int nbLignes= requete.executeUpdate();
        return nbLignes==1;
	}
}