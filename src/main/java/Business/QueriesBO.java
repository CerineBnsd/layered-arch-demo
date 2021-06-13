package Business;

import DataAccess.DAO.CustomerDAO;
import DataAccess.DAO.RentedItemDAO;
import DataAccess.DAO.StockItemDAO;
import Business.DTO.CustomerTO;
import Business.DTO.FilmTO;
import Business.DTO.GameTO;
import Business.DTO.TransferObject;
import DataAccess.PersistenceClasses.Customer;
import DataAccess.PersistenceClasses.Film;
import DataAccess.PersistenceClasses.Game;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class QueriesBO implements Queries{

    private String databaseName;
    private CustomerDAO customerDAO;
    private RentedItemDAO rentedItemDAO;
    private StockItemDAO stockItemDAO;

    public QueriesBO(String databaseName, EntityManager e){
        this.databaseName = databaseName;
        customerDAO = new CustomerDAO(e);
        rentedItemDAO = new RentedItemDAO(e);
        stockItemDAO = new StockItemDAO(e);
    }
    @Override
    public List<FilmTO> searchByActor(String actor) {
        List<Film> films = stockItemDAO.findFilmByActor(actor);
        ArrayList<FilmTO> filmTOS = new ArrayList<>();
        for(int i=0;i<films.size();i++){
            filmTOS.add(i,new FilmTO(
                    films.get(i).getItemId(),
                    films.get(i).getTitle(),
                    films.get(i).getRentalPrice(),
                    films.get(i).getActor()
            ));
        }
        return filmTOS;

    }

    @Override
    public List<CustomerTO> getAllCustomers() {
        List<Customer> customers = customerDAO.findAll();
        ArrayList<CustomerTO> customerTOS = new ArrayList<>();
        for(int i=0;i<customers.size();i++){
            customerTOS.add(i,new CustomerTO(
                    customers.get(i).getId(),
                    customers.get(i).getFirstName(),
                    customers.get(i).getLastName(),
                    customers.get(i).getAccountBalance()
            ));
        }
        return customerTOS;

    }

    @Override
    public List<GameTO> getAllGames() {

        List<Game> games = stockItemDAO.findAllGames();
        ArrayList<GameTO> gamesTOS = new ArrayList<>();
        for(int i=0;i<games.size();i++){
            gamesTOS.add(i,new GameTO(
                    games.get(i).getItemId(),
                    games.get(i).getTitle(),
                    games.get(i).getRentalPrice(),
                    games.get(i).getPlatform()
            ));
        }
        return gamesTOS;
    }

    @Override
    public List<FilmTO> getAllFilms() {
        List<Film> films = stockItemDAO.findAllFilms();
        ArrayList<FilmTO> filmTOS = new ArrayList<>();
        for(int i=0;i<films.size();i++){
            filmTOS.add(i,new FilmTO(
                    films.get(i).getItemId(),
                    films.get(i).getTitle(),
                    films.get(i).getRentalPrice(),
                    films.get(i).getActor()
            ));
        }
        return filmTOS;
    }

    @Override
    public List<TransferObject> getAllRentedItems() {
        return null;
    }

    @Override
    public TransferObject checkItemAvailability() {
        return null;
    }

    @Override
    public List<TransferObject> getCustomerLocations() {
        return null;
    }

    @Override
    public List<TransferObject> getCustomerLateArticles() {
        return null;
    }


}
