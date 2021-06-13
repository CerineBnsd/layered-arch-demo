package DataAccess.DAO;

import DataAccess.PersistenceClasses.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDAO extends DataAccessObject implements CrudDAO<Customer>{
    public CustomerDAO(EntityManager e) {
        super(e);
    }

    @Override
    public Customer find(Long ID) {
        return null;
    }

    @Override
    public void save(Customer entity) {

    }

    @Override
    public void update(Customer entity) {

    }

    @Override
    public List<Customer> findAll(){
        startTransaction();
        List<Customer> customers = entityManager.createNamedQuery("findAllCustomer", Customer.class).getResultList();
        endTransaction();
        return customers;
    }

    @Override
    public void remove(Long ID) {

    }
}
