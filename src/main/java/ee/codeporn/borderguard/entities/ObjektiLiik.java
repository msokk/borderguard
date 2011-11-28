package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import ee.codeporn.borderguard.entities.Objekt;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
public class ObjektiLiik extends Base {

    @NotNull
    @Size(max = 20)
    private String kood;

    private String kommentaar;

    @Size(max = 100)
    private String nimetus;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Objekt> objektid = new HashSet<Objekt>();
}
