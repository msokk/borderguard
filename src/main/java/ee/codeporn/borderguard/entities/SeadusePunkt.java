package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Calendar;

import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
@RooPlural(value="SeadusePunktid")
public class SeadusePunkt extends Base {

    private String paragrahv;

    private String pais;

    private String tekst;

    private String kommentaar;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar kehtivAlates;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar kehtivKuni;
    
    @ManyToOne
    private Seadus seadus;

    @ManyToOne
    private SeadusePunkt seadusePunkt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seadusePunkt")
    private Set<SeadusePunkt> seadusePunktid = new HashSet<SeadusePunkt>();
    
    @SuppressWarnings({ "unchecked" })
    public static List<SeadusePunkt> getAllPunktid(Calendar alates, Calendar kuni) {
    	Query query = entityManager().createQuery("from SeadusePunkt as p where p.kehtivAlates > ?1 and p.kehtivKuni < ?2 and p.sulgeja IS NULL", SeadusePunkt.class);
    	query.setParameter(1, alates);
        query.setParameter(2, kuni);
		return query.getResultList();
    }
}
