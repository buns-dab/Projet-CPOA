package dao.client;

import dao.Interfaces.InterfaceDao;
import metier.Client_pojo;

public interface InterfaceDAOClient extends InterfaceDao<Client_pojo> {
	public Client_pojo getById (int id) throws Exception;

}
