package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import ee.codeporn.borderguard.entities.Piiririkkuja;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
public class Objekt extends Base {

    @NotNull
    @Size(max = 100)
    private String nimetus;

    private String kommentaar;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Piiririkkuja> piiririkkujad = new HashSet<Piiririkkuja>();
}
