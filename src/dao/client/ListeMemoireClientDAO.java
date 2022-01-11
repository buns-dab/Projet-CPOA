package dao.client;

import java.util.ArrayList;

import metier.Client_pojo;

public class ListeMemoireClientDAO implements InterfaceDAOClient {

	private static ListeMemoireClientDAO instance;

	private ArrayList<Client_pojo> donnees;

	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return instance;
	}

	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<>();

		this.donnees.add(new Client_pojo(1,"dupont","thierry","8","rue du palais","31000","Toulouse","France"));
		this.donnees.add(new Client_pojo(2,"wagner","charles","1","impasse du puit","35000","Rennes","France"));
	}

	@Override
	public boolean create(Client_pojo objet) {

		objet.setId_client(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_client(objet.getId_client() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(Client_pojo objet) {

		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {

			this.donnees.set(idx, objet);
		}

		return true;
	}

	@Override
	public boolean delete(Client_pojo objet) {

		Client_pojo supprime;

		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}

		return objet.equals(supprime);
	}

	@Override
	public Client_pojo getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Client_pojo(id,"ernesto","francesco","5","impasse du chalet","88000","epinal","france"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Client_pojo> getAll() {
		return this.donnees;
	}
}


