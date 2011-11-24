package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooEntity
public class IntsidendiLiik extends Base {

    @Size(max = 18)
    private String kood;

    @Size(max = 60)
    private String nimetus;

    private String kommentaar;
}
