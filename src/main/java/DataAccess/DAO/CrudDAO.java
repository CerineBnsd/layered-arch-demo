package DataAccess.DAO;

import DataAccess.PersistenceClasses.SuperEntity;

import java.util.List;

public interface CrudDAO<T extends SuperEntity>{
    public T find(Long ID);
    public void save(T entity);
    public void update(T entity);
    public List<T> findAll();
    public void remove(Long ID);
}
