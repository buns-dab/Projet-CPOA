package dao.revue;

import dao.Interfaces.InterfaceDao;
import metier.Revue_pojo;

public interface InterfaceDAORevue extends InterfaceDao<Revue_pojo> 
{
    public Revue_pojo getById(int id) throws Exception;
}
