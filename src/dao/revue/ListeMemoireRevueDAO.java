package dao.revue;

import java.util.ArrayList;
import java.util.List;
import metier.Revue_pojo;

import static graphic.controller.AccueilController.daof;

public class ListeMemoireRevueDAO implements InterfaceDAORevue {

	private static ListeMemoireRevueDAO instance;

	private List<Revue_pojo> donnees;

	public static ListeMemoireRevueDAO getInstance() throws Exception {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO() throws Exception {

		this.donnees = new ArrayList<Revue_pojo>();


		this.donnees.add(new Revue_pojo( 1,"paris match", "attrayant", 5, "horrible", daof.getPeriodiciteDao().getById(1)));
		this.donnees.add(new Revue_pojo( 2,"tesst", "affreux", 50, "joli", daof.getPeriodiciteDao().getById(1)));
	}

	@Override
	public boolean create(Revue_pojo objet) {
		objet.setId_revue(3);
		// Ne fonctionne que si l'objet m�tier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_revue(objet.getId_revue() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(Revue_pojo objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {

			this.donnees.set(idx, objet);
		}

		return true;
	}

	@Override
	public boolean delete(Revue_pojo objet) {

		Revue_pojo supprime;

		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}

		return objet.equals(supprime);
	}

	@Override
	public Revue_pojo getById(int id) throws Exception {
		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(new Revue_pojo( id,"paris match", "attrayant", 5, "horrible", daof.getPeriodiciteDao().getById(1)));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Revue_pojo> getAll() {
		return (ArrayList<Revue_pojo>) this.donnees;
	}
}
