package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.plural.RooPlural;
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
@RooPlural(value="Riigid")
public class Riik extends Base {
	
	public static Riik build(String iso, String ansi, String comment) {
		Riik tmp = new Riik();
		tmp.isoKood = iso;
		tmp.ansiKood = ansi;
		tmp.kommentaar = comment;
		return tmp;
	}

    @NotNull
    @Size(max = 20)
    private String isoKood;

    private String kommentaar;
    
    @NotNull
    @Size(max = 20)
    private String ansiKood;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "riik")
    private Set<Kodakondsus> kodakondsused = new HashSet<Kodakondsus>();

}
