package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.Size;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooEntity
public class Piiririkkuja extends Base {

    @Size(max = 20)
    private String isikukood;

    private String kommentaar;

    @Size(max = 25)
    private String eesnimi;

    @Size(max = 35)
    private String pereNimi;

    @Size(max = 1)
    private String sugu;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar synniaeg;
}
