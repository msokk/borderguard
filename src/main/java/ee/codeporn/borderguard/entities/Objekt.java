package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import ee.codeporn.borderguard.entities.ObjektiLiik;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class Objekt extends Base {

    @NotNull
    @Size(max = 100)
    private String nimetus;

    private String kommentaar;

    @ManyToOne
    private ObjektiLiik objektiLiik;
}
