package dao.periodicite;

import dao.Interfaces.InterfaceDao;
import metier.Periodicite_pojo;

public interface InterfaceDAOPeriodicite extends InterfaceDao<Periodicite_pojo> {

		public Periodicite_pojo getById(int id) throws Exception;
}

