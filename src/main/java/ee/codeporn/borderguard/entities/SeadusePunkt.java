package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
public class SeadusePunkt extends Base {

    private String paragrahv;

    private String pais;

    private String tekst;

    private String kommentaar;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar kehtiv_alates;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar kehtiv_kuni;

    @ManyToOne
    private SeadusePunkt seadusePunkt;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<SeadusePunkt> seadusePunktid = new HashSet<SeadusePunkt>();
}
