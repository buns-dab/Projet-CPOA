package dao.client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.connexion.Connexion;

import metier.Client_pojo;

public class MySQLDAOClient implements InterfaceDAOClient {

	private static MySQLDAOClient instance;

	private Connection laconnexion = Connexion.getInstance().creeConnexion();

	public MySQLDAOClient() {}

	public static MySQLDAOClient getInstance() {
		if (instance == null) {
			instance = new MySQLDAOClient();
		}
		return instance;
	}

	@Override
	public Client_pojo getById(int id) throws SQLException{
		if(id<0)
		{
			throw new IllegalArgumentException("L'id ne peut pas être négatif");
		}
			PreparedStatement requete = laconnexion.prepareStatement("SELECT * FROM Client WHERE id_client=?");
			requete.setInt(1,id);

			ResultSet res = requete.executeQuery();

			while(res.next())
			{
				Client_pojo c = new Client_pojo();
				c.setId_client(res.getInt(1));
				c.setNom(res.getString(2));
				c.setPrenom(res.getString(3));
				c.setNo_rue(res.getString(4));
				c.setVoie(res.getString(5));
				c.setCode_postal(res.getString(6));
				c.setVille(res.getString(7));
				c.setPays(res.getString(8));

				return c;
			}
		return null;
	}

	@Override
	public List<Client_pojo> getAll() throws SQLException {//ajout de arrayList
		List<Client_pojo> listeClient = new ArrayList<>();

			PreparedStatement requete = laconnexion.prepareStatement("SELECT * FROM Client");
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				Client_pojo c = new Client_pojo();
				c.setId_client(res.getInt(1));
				c.setNom(res.getString(2));
				c.setPrenom(res.getString(3));
				c.setNo_rue(res.getString(4));
				c.setVoie(res.getString(5));
				c.setCode_postal(res.getString(6));
				c.setVille(res.getString(7));
				c.setPays(res.getString(8));

				listeClient.add(c);
			}
		return listeClient;
	}

	@Override
	public boolean update(Client_pojo objet) throws SQLException{
			PreparedStatement requete = this.laconnexion.prepareStatement("UPDATE Client SET nom =?,prenom =?,no_rue =?,voie =?,code_postal =?,ville =?, pays =? where id_client=?");

			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, objet.getNo_rue());
			requete.setString(4, objet.getVoie());
			requete.setString(5, objet.getCode_postal());
			requete.setString(6,objet.getVille());
			requete.setString(7, objet.getPays());
			requete.setInt(8,objet.getId_client());

			int nbLignes = requete.executeUpdate();

		return nbLignes==1;
	}

	@Override
	public boolean create(Client_pojo objet) throws SQLException{
			PreparedStatement requete = this.laconnexion.prepareStatement(" INSERT INTO Client (nom,prenom,no_rue,voie,code_postal,ville,pays)  VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, objet.getNo_rue());
			requete.setString(4, objet.getVoie());
			requete.setString(5, objet.getCode_postal());
			requete.setString(6,objet.getVille());
			requete.setString(7, objet.getPays());

			int nbLignes = requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();

			if (res.next()) {
				objet.setId_client(res.getInt(1));
			}

		return nbLignes==1;
	}

	@Override
	public boolean delete(Client_pojo objet) throws SQLException {

			PreparedStatement requete = laconnexion.prepareStatement("DELETE FROM Client WHERE id_client=?");
			requete.setInt(1,objet.getId_client());
			int nbLignes = requete.executeUpdate();

		return nbLignes==1;
	}
}
