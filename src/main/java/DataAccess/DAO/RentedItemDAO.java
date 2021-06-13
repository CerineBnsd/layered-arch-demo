package DataAccess.DAO;

import DataAccess.PersistenceClasses.RentedItem;

import javax.persistence.EntityManager;
import java.util.List;

public class RentedItemDAO extends DataAccessObject implements CrudDAO<RentedItem>{
    public RentedItemDAO(EntityManager e) {
        super(e);
    }

    @Override
    public RentedItem find(Long ID) {
        return null;
    }

    @Override
    public void save(RentedItem entity) {

    }

    @Override
    public void update(RentedItem entity) {

    }

    @Override
    public List<RentedItem> findAll() {
        return null;
    }

    @Override
    public void remove(Long ID) {

    }
}
