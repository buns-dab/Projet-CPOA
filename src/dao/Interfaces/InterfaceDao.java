package dao.Interfaces;

import java.util.List;

public interface InterfaceDao<T> {

	public abstract T getById(int id) throws Exception;

	public abstract List<T> getAll() throws Exception;

	public abstract boolean update(T objet) throws Exception;

	public abstract boolean create(T objet) throws Exception;

	public abstract boolean delete(T objet) throws Exception;

}
