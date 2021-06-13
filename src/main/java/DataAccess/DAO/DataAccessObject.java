package DataAccess.DAO;

import DataAccess.PersistenceClasses.SuperEntity;

import javax.persistence.EntityManager;

public class DataAccessObject {

    protected EntityManager entityManager;
    public DataAccessObject(EntityManager e){
        entityManager = e;
    }
    protected void startTransaction(){
        entityManager.getTransaction().begin();
    }
    protected void endTransaction(){
        entityManager.getTransaction().commit();
    }
    //Used to save any entity in the database
    public void saveEntity(SuperEntity entity) {
        startTransaction();
        entityManager.persist(entity);
        endTransaction();
    }

}
