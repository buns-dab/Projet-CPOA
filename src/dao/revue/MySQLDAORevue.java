package dao.revue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import metier.Revue_pojo;
import dao.connexion.Connexion;

import static graphic.controller.AccueilController.daof;

public class MySQLDAORevue implements InterfaceDAORevue {

	private static MySQLDAORevue instance;

	private Connection laconnexion = Connexion.getInstance().creeConnexion();


	private MySQLDAORevue() {
	}

	public static MySQLDAORevue getInstance() {
		if (instance == null) {
			instance = new MySQLDAORevue();
		}
		return instance;
	}

	@Override
	public Revue_pojo getById(int id) throws Exception {
		if(id<0)
		{
			throw new IllegalArgumentException("L'id ne peut pas être négatif");
		}
			PreparedStatement requete = laconnexion.prepareStatement("SELECT * FROM Revue WHERE id_revue=?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
			if (res.next()) {
				Revue_pojo r = new Revue_pojo();
				r.setId_revue(res.getInt(1));
				r.setTitre(res.getString(2));
				r.setDescription(res.getString(3));
				r.setTarif_numero(res.getFloat(4));
				r.setVisuel(res.getString(5));
				r.setPeriodicite(daof.getPeriodiciteDao().getById(res.getInt(6)));

				return r;
			}
		return null;
	}

	@Override
	public List<Revue_pojo> getAll() throws Exception {
		List<Revue_pojo> listeRevue = new ArrayList<>();

			PreparedStatement requete = laconnexion.prepareStatement("SELECT * FROM Revue");
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				Revue_pojo r = new Revue_pojo();
				r.setId_revue(res.getInt(1));
				r.setTitre(res.getString(2));
				r.setDescription(res.getString(3));
				r.setTarif_numero(res.getFloat(4));
				r.setVisuel(res.getString(5));
				r.setPeriodicite(daof.getPeriodiciteDao().getById(res.getInt(6)));

				listeRevue.add(r);
			}

		return listeRevue;
	}

	@Override
	public boolean update(Revue_pojo objet) throws SQLException {

			PreparedStatement requete = laconnexion.prepareStatement("UPDATE Revue SET titre =?,description=?,tarif_numero=?,visuel=?,id_periodicite=? WHERE id_revue=?");

			requete.setString(1, objet.getTitre());
			requete.setString(2, objet.getDescription());
			requete.setFloat(3, objet.getTarif_numero());
			requete.setString(4, objet.getVisuel());
			requete.setInt(5, objet.getPeriodicite().getId());
			requete.setInt(6, objet.getId_revue());

			int nbLignes = requete.executeUpdate();

		return nbLignes==1;
	}

	@Override
	public boolean create(Revue_pojo objet) throws SQLException{

			PreparedStatement requete = laconnexion.prepareStatement("INSERT INTO Revue (titre,description,tarif_numero,visuel,id_periodicite) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, objet.getTitre());
			requete.setString(2, objet.getDescription());
			requete.setFloat(3, objet.getTarif_numero());
			requete.setString(4, objet.getVisuel());
			requete.setInt(5, objet.getPeriodicite().getId());

			int nbLignes = requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();
			if (res.next()) {
				objet.setId_revue(res.getInt(1));
			}

		return nbLignes==1;
	}

	@Override
	public boolean delete(Revue_pojo objet) throws SQLException {
			PreparedStatement requete = laconnexion.prepareStatement("DELETE FROM Revue WHERE id_revue=?");
			requete.setInt(1,objet.getId_revue());

			int nbLignes = requete.executeUpdate();

			return nbLignes==1;
		}
}
