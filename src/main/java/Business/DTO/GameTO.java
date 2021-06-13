package Business.DTO;

public class GameTO extends StockItemTO{
    private String platform;
    public GameTO() {
    }

    public GameTO(Long id, String title, Double rentalPrice, String platform) {
        super(id, title, rentalPrice);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() +'\''+
                ", rentalPrice='" + getRentalPrice() +'\''+
                ", platform='" +getPlatform() + '\''+
                '}';
    }
}
