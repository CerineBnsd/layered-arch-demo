package DataAccess.DAO;

import DataAccess.PersistenceClasses.Film;
import DataAccess.PersistenceClasses.Game;
import DataAccess.PersistenceClasses.StockItem;

import javax.persistence.EntityManager;
import java.util.List;

public class StockItemDAO extends DataAccessObject implements CrudDAO<StockItem>{
    public StockItemDAO(EntityManager e) {
        super(e);
    }

    public List<Game> findAllGames(){
        startTransaction();
        List<Game> games =  entityManager.createNamedQuery("findAllGame", Game.class).getResultList();
        endTransaction();
        return games;
    }
    public List<Film> findAllFilms(){
        startTransaction();
        List<Film> films = entityManager.createNamedQuery("findAllFilm", Film.class).getResultList();
        endTransaction();
        return films;
    }
    public List<Film> findFilmByActor(String actor){
        startTransaction();
        List<Film> films =  entityManager.createNamedQuery("findByActor", Film.class).setParameter("actor",actor).getResultList();
        endTransaction();
        return films;
    }

    @Override
    public StockItem find(Long ID) {
        return null;
    }

    @Override
    public void save(StockItem entity) {

    }

    @Override
    public void update(StockItem entity) {

    }

    @Override
    public List<StockItem> findAll() {
        return null;
    }

    @Override
    public void remove(Long ID) {

    }
}
