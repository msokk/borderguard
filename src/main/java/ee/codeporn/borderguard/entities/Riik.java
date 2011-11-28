package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import ee.codeporn.borderguard.entities.Kodakondsus;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
public class Riik extends Base {

    @NotNull
    @Size(max = 20)
    private String isoKood;

    private String kommentaar;
    
    @NotNull
    @Size(max = 20)
    private String ansiKood;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Kodakondsus> kodakonsused = new HashSet<Kodakondsus>();
}
