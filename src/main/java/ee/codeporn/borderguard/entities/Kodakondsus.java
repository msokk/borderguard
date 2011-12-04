package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;
import ee.codeporn.borderguard.entities.Piiririkkuja;
import javax.persistence.ManyToOne;
import ee.codeporn.borderguard.entities.Riik;

@RooJavaBean
@RooToString
@RooEntity
@RooPlural(value="Kodakondsused")
public class Kodakondsus extends Base {

    private String kommentaar;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar alates;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar kuni;

    @Size(max = 20)
    private String isikukood;

    @ManyToOne
    private Piiririkkuja piiririkkuja;

    @ManyToOne
    private Riik riik;
}
