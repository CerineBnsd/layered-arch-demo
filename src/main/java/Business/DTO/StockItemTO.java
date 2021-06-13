package Business.DTO;

public class StockItemTO implements TransferObject{
    private Long id;
    private String title;
    private Double rentalPrice;

    public StockItemTO(){

    }
    public StockItemTO(Long id, String title, Double rentalPrice) {
        this.id = id;
        this.title = title;
        this.rentalPrice = rentalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
}
