package dao.factory;

import dao.abonnement.InterfaceDAOAbonnement;
import dao.client.InterfaceDAOClient;
import dao.enumeration.Persistance;
import dao.periodicite.InterfaceDAOPeriodicite;
import dao.revue.InterfaceDAORevue;


public abstract class DAOFactory {
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daoF = null;
		switch (cible) {
		case MYSQL:
			daoF = new MySQLDAOFactory();
			break;
		case LISTE_MEMOIRE:
			daoF = new ListeMemoireDAOFactory();
			break;
		}
		return daoF;
	}

	public abstract InterfaceDAOPeriodicite getPeriodiciteDao();

	public abstract InterfaceDAOClient getClientDao();

	public abstract InterfaceDAORevue getRevueDao() throws Exception;

	public abstract InterfaceDAOAbonnement getAbonnementDao() throws Exception;
}
