
package dao.abonnement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import metier.Abonnement_pojo;

import static graphic.controller.AccueilController.daof;

public class ListeMemoireAbonnementDAO implements InterfaceDAOAbonnement {

	private static ListeMemoireAbonnementDAO instance;

	private List<Abonnement_pojo> donnees;

	public static ListeMemoireAbonnementDAO getInstance() throws Exception {

		if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}

		return instance;
	}

	private ListeMemoireAbonnementDAO() throws Exception {

		this.donnees = new ArrayList<Abonnement_pojo>();

		this.donnees.add(new Abonnement_pojo(1,LocalDate.of(2020,9,12),LocalDate.of(2021,12,25),daof.getClientDao().getById(1),daof.getRevueDao().getById(1)));
		this.donnees.add(new Abonnement_pojo(2,LocalDate.of(2020,9,12),LocalDate.of(2021,9,25),daof.getClientDao().getById(1),daof.getRevueDao().getById(1)));
	}

	@Override
	public boolean create(Abonnement_pojo objet) {

		objet.setId_abonnement(3);
		// Ne fonctionne que si l'objet metier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_abonnement(objet.getId_abonnement() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(Abonnement_pojo objet) {

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
	public boolean delete(Abonnement_pojo objet) {

		Abonnement_pojo supprime;

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
	public Abonnement_pojo getById(int id) {
		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(new Abonnement_pojo());
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Abonnement_pojo> getAll() {
		return (ArrayList<Abonnement_pojo>) this.donnees;
	}
}