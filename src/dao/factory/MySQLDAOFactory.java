package dao.factory;

import dao.abonnement.InterfaceDAOAbonnement;
import dao.abonnement.MySQLDAOAbonnement;
import dao.client.InterfaceDAOClient;
import dao.client.MySQLDAOClient;
import dao.periodicite.InterfaceDAOPeriodicite;
import dao.periodicite.MySQLDAOPeriodicite;
import dao.revue.InterfaceDAORevue;
import dao.revue.MySQLDAORevue;

public class MySQLDAOFactory extends DAOFactory 
{
	@Override
	public InterfaceDAOPeriodicite getPeriodiciteDao() {
		return MySQLDAOPeriodicite.getInstance();
	}
	
	@Override
	public InterfaceDAOClient getClientDao() {
		return MySQLDAOClient.getInstance();
	}
	
	@Override
	public InterfaceDAORevue getRevueDao() {
		return MySQLDAORevue.getInstance();
	}
	
	@Override
	public InterfaceDAOAbonnement getAbonnementDao() {
		return MySQLDAOAbonnement.getInstance();
	}
}
