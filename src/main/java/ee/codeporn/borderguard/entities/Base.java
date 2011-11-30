package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.validation.constraints.Size;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Calendar;

@RooJavaBean
@RooToString
@RooEntity
public abstract class Base {
    @Size(max = 32)
    private String avaja;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar avatud;

    @Size(max = 32)
    private String muutja;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar muudetud;

    @Size(max = 32)
    private String sulgeja;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar suletud;
    
    @SuppressWarnings("unused")
	@PrePersist
    private void logSavingData(){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = "system";
    	if(authentication != null) {
    		username = authentication.getName();
    	}
    	Calendar now = Calendar.getInstance();
    	
    	this.avaja = username;
    	this.avatud = now;
    	this.muutja = username;
    	this.muudetud = now;
    	Calendar closedTime = Calendar.getInstance();
    	closedTime.add(Calendar.YEAR, +200);
    	this.suletud = closedTime;
    }
    
}
