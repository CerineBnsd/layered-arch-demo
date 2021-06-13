package DataAccess.PersistenceClasses;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("G")
@NamedQueries({
        @NamedQuery(name="findAllGame", query="select g from Game g"),
})
public class Game extends StockItem{
    private String platform;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
