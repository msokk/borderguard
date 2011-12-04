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
import ee.codeporn.borderguard.entities.SeadusePunkt;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
@RooPlural(value="Seadused")
public class Seadus extends Base {

    @NotNull
    @Size(max = 20)
    private String kood;

    @NotNull
    @Size(max = 20)
    private String nimetus;

    private String kommentaar;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar kehtivAlates;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar kehtivKuni;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seadus")
    private Set<SeadusePunkt> seadusePunktid = new HashSet<SeadusePunkt>();
    

    @SuppressWarnings("unchecked")
	public List<SeadusePunkt> getPunktid(Calendar alates, Calendar kuni) {
    	Query query = entityManager().createQuery("from SeadusePunkt as p where p.seadus = ?1 and p.kehtivAlates > ?2 and p.kehtivKuni < ?3", SeadusePunkt.class);
    	query.setParameter(1, this);
    	query.setParameter(2, alates);
        query.setParameter(3, kuni);
		return query.getResultList();
    }
    
    public static long countSeadused() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Seadus o WHERE o.sulgeja IS NULL", Long.class).getSingleResult();
    }
    
    public static List<Seadus> findAllSeadused() {
        return entityManager().createQuery("SELECT o FROM Seadus o WHERE o.sulgeja IS NULL", Seadus.class).getResultList();
    }
    
    public static List<Seadus> findSeadusEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Seadus o WHERE o.sulgeja IS NULL", Seadus.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<SeadusePunkt> getSeadusePunktid() {
    	Query query = entityManager().createQuery("FROM SeadusePunkt AS s WHERE s.seadus = ?1 AND s.sulgeja IS NULL", SeadusePunkt.class);
    	query.setParameter(1, this);
    	return query.getResultList();
    }
}
