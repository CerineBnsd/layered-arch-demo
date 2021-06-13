package Business;

import DataAccess.DAO.CustomerDAO;
import DataAccess.DAO.RentedItemDAO;
import DataAccess.DAO.StockItemDAO;
import Business.DTO.*;
import DataAccess.PersistenceClasses.Customer;
import DataAccess.PersistenceClasses.Film;
import DataAccess.PersistenceClasses.Game;

import javax.persistence.EntityManager;

public class TransactionsBO implements Transactions{
    private String databaseName;
    private CustomerDAO customerDAO;
    private RentedItemDAO rentedItemDAO;
    private StockItemDAO stockItemDAO;
    private Queries queriesBO ;
    public TransactionsBO(EntityManager e, Queries queriesBO){
        this.queriesBO = queriesBO;
        customerDAO = new CustomerDAO(e);
        rentedItemDAO = new RentedItemDAO(e);
        stockItemDAO = new StockItemDAO(e);
    }

    @Override
    public void addNewCustomer(TransferObject object) {
        CustomerTO customer = (CustomerTO)object;
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setAccountBalance(customer.getAccountBalance());
        customerDAO.saveEntity(newCustomer);
    }

    @Override
    public void addNewFilm(TransferObject object) {
        FilmTO film = (FilmTO) object;
        Film newFilm = new Film();
        newFilm.setActor(film.getActor());
        newFilm.setRentalPrice(film.getRentalPrice());
        newFilm.setTitle(film.getTitle());
        stockItemDAO.saveEntity(newFilm);
    }

    @Override
    public void addNewGame(TransferObject object) {
        GameTO game = (GameTO) object;
        Game newGame = new Game();
        newGame.setPlatform(game.getPlatform());
        newGame.setRentalPrice(game.getRentalPrice());
        newGame.setTitle(game.getTitle());
        stockItemDAO.saveEntity(newGame);
    }

    @Override
    public void rentItem(TransferObject object) {
    }

    @Override
    public void returnItem(TransferObject object) {
    }

    @Override
    public void addPenalty(TransferObject object) {
    }
}
