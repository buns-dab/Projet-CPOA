package dao.factory;

import dao.abonnement.InterfaceDAOAbonnement;
import dao.abonnement.ListeMemoireAbonnementDAO;
import dao.client.InterfaceDAOClient;
import dao.client.ListeMemoireClientDAO;
import dao.periodicite.InterfaceDAOPeriodicite;
import dao.periodicite.ListeMemoirePeriodiciteDAO;
import dao.revue.InterfaceDAORevue;
import dao.revue.ListeMemoireRevueDAO;


public class ListeMemoireDAOFactory extends DAOFactory
{
	public ListeMemoireDAOFactory()
	{

	}

	@Override
	public InterfaceDAOPeriodicite getPeriodiciteDao() {
		return ListeMemoirePeriodiciteDAO.getInstance();
	}
	
	@Override
	public InterfaceDAOClient getClientDao() {
		return ListeMemoireClientDAO.getInstance();
	}
	
	@Override
	public InterfaceDAORevue getRevueDao() throws Exception {
		return ListeMemoireRevueDAO.getInstance();
	}
	
	@Override
	public InterfaceDAOAbonnement getAbonnementDao() throws Exception {
		return ListeMemoireAbonnementDAO.getInstance();
	}
}
	
	

