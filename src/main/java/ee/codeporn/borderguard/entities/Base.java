package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Size;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Calendar;

@RooJavaBean
@MappedSuperclass
@RooToString
@Transactional
@RooEntity(mappedSuperclass = true)
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
    private void recordSaved(){
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
    	closedTime.set(9999, 12, 31);
    	this.suletud = closedTime;
    }
    
    @PreUpdate
    public void recordModified() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	this.muutja = username;
    	this.muudetud = Calendar.getInstance();
    }

    
    public void close() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	this.sulgeja = username;
    	this.suletud = Calendar.getInstance();
    	this.persist();
    }
    
}
