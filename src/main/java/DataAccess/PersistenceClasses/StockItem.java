package DataAccess.PersistenceClasses;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="item_type")
public class StockItem extends SuperEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long itemId;
    private String title;
    private Double rentalPrice;

    public StockItem() {
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

    public void setItemId(Long id) {
        this.itemId = id;
    }

    public Long getItemId() {
        return itemId;
    }
}
