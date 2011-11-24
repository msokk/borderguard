package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooEntity
public class ObjektiLiik extends Base {

    @NotNull
    @Size(max = 100)
    private String nimetus;

    private String kommentaar;

    @Size(max = 18)
    private String kood;
}
