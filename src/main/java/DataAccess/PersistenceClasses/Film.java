package DataAccess.PersistenceClasses;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("F")
@NamedQueries({
        @NamedQuery(name="findAllFilm", query="select f from Film f"),
        @NamedQuery(name="findByActor", query="select f from Film f where f.actor = :actor"),
})
public class Film extends StockItem{
    private String actor;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
