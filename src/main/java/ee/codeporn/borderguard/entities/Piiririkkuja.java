package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Set;
import ee.codeporn.borderguard.entities.Kodakondsus;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
@RooPlural(value="Piiririkkujad")
public class Piiririkkuja extends Base {

    @Size(max = 20)
    private String isikukood;

    private String kommentaar;

    @NotNull
    @Size(max = 25)
    private String eesnimi;

    @NotNull
    @Size(max = 35)
    private String perenimi;

    @NotNull
    @Size(max = 1)
    private String sugu;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar synniaeg;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piiririkkuja")
    private Set<Kodakondsus> kodakondsused = new HashSet<Kodakondsus>();
    
    @SuppressWarnings("unchecked")
	public List<Kodakondsus> getKodakondsused() {
    	Query query = entityManager().createQuery("FROM Kodakondsus AS k WHERE k.piiririkkuja = ?1 AND k.sulgeja IS NULL", Kodakondsus.class);
    	query.setParameter(1, this);
    	return query.getResultList();
    }
    
    public static long countPiiririkkujad() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Piiririkkuja o WHERE o.sulgeja IS NULL", Long.class).getSingleResult();
    }
    
    public static List<Piiririkkuja> findAllPiiririkkujad() {
        return entityManager().createQuery("SELECT o FROM Piiririkkuja o WHERE o.sulgeja IS NULL", Piiririkkuja.class).getResultList();
    }

    
    public static List<Piiririkkuja> findPiiririkkujaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Piiririkkuja o WHERE o.sulgeja IS NULL", Piiririkkuja.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
}
