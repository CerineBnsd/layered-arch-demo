package Business;

import Business.DTO.CustomerTO;
import Business.DTO.FilmTO;
import Business.DTO.GameTO;
import Business.DTO.TransferObject;

import java.util.List;

public interface Queries {
    public List<FilmTO> searchByActor(String actor);
    public TransferObject checkItemAvailability();
    public List<TransferObject> getCustomerLocations();
    public List<TransferObject> getCustomerLateArticles();
    public List<CustomerTO> getAllCustomers();
    public List<GameTO> getAllGames();
    public List<FilmTO> getAllFilms();
    public List<TransferObject> getAllRentedItems();

}
