package dao.periodicite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.connexion.Connexion;

import metier.Periodicite_pojo;

public class MySQLDAOPeriodicite implements InterfaceDAOPeriodicite {

	private static MySQLDAOPeriodicite instance;
	private Connection laconnexion = Connexion.getInstance().creeConnexion();


	public static MySQLDAOPeriodicite getInstance() {
		if (instance == null) {
			instance = new MySQLDAOPeriodicite();
		}
		return instance;
	}

	private MySQLDAOPeriodicite() {
	}

	@Override
	public Periodicite_pojo getById(int id) throws SQLException {
		if(id<0)
		{
			throw new IllegalArgumentException("L'id ne peut pas être négatif");
		}
			PreparedStatement requete = laconnexion.prepareStatement("SELECT * FROM Periodicite WHERE id_periodicite=?");
			requete.setInt(1,id);
			ResultSet res = requete.executeQuery();
			if (res.next()) {
				Periodicite_pojo p1 = new Periodicite_pojo(res.getInt(1), res.getString(2) );
				return p1;
			}
		return null;
	}

	@Override
	public List<Periodicite_pojo> getAll() throws SQLException{
		List<Periodicite_pojo> listePeriodicite = new ArrayList<>();

			PreparedStatement requete = laconnexion.prepareStatement("SELECT * FROM Periodicite");
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				Periodicite_pojo p = new Periodicite_pojo(res.getInt(1), res.getString(2) );
				listePeriodicite.add(p);
			}

		return listePeriodicite;
		}

	@Override
	public boolean update(Periodicite_pojo objet) throws SQLException {
			PreparedStatement requete = laconnexion.prepareStatement("UPDATE Periodicite SET libelle =? where id_periodicite=?");

			requete.setString(1,objet.getLibelle());
			requete.setInt(2,objet.getId());
			int nbLignes = requete.executeUpdate();

		return nbLignes==1;
	}

	@Override
	public boolean create(Periodicite_pojo objet) throws SQLException {
			PreparedStatement requete = laconnexion.prepareStatement("INSERT INTO Periodicite(libelle) VALUES(?) ",Statement.RETURN_GENERATED_KEYS);

			requete.setString(1,objet.getLibelle());
			int nbLignes = requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();
			if (res.next()) {
				objet.setId(res.getInt(1));
			}
		return nbLignes==1;
	}

	@Override
	public boolean delete(Periodicite_pojo objet) throws SQLException {
			PreparedStatement requete = laconnexion.prepareStatement("DELETE FROM Periodicite WHERE id_periodicite=?");
			requete.setInt(1,objet.getId());
			int nbLignes = requete.executeUpdate();

		return nbLignes==1;
	}
}