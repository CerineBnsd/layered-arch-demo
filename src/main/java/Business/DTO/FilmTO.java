package Business.DTO;

public class FilmTO extends StockItemTO{


    private String actor;

    public FilmTO() {
    }

    public FilmTO(Long id, String title, Double rentalPrice, String actor) {
        super(id, title, rentalPrice);
        this.actor = actor;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() +'\''+
                ", rentalPrice='" + getRentalPrice() +'\''+
                ", actor='" +getActor() + '\''+
                '}';
    }
}
