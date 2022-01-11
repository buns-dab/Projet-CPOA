package dao.periodicite;

import java.util.ArrayList;

import metier.Periodicite_pojo;

public class ListeMemoirePeriodiciteDAO implements InterfaceDAOPeriodicite {

	private static ListeMemoirePeriodiciteDAO instance;

	private ArrayList<Periodicite_pojo> donnees;//ajout de array

	public static ListeMemoirePeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoirePeriodiciteDAO();
		}

		return instance;
	}

	private ListeMemoirePeriodiciteDAO() {

		this.donnees = new ArrayList<Periodicite_pojo>();

		this.donnees.add(new Periodicite_pojo(1,"Mensuel"));
		this.donnees.add(new Periodicite_pojo(2,"Quotidien"));
	}

	@Override
	public boolean create(Periodicite_pojo objet) {

		objet.setId(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(Periodicite_pojo objet) {

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
	public boolean delete(Periodicite_pojo objet) {

		Periodicite_pojo supprime;

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
	public Periodicite_pojo getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Periodicite_pojo(id,"test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Periodicite_pojo> getAll() {
		return this.donnees;
	}
}