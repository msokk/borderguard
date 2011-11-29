package ee.codeporn.borderguard.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Calendar;

@MappedSuperclass
@RooJavaBean
@RooToString
@RooEntity
public abstract class Base {
    @NotNull
    @Size(max = 32)
    private String avaja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar avatud;

    @NotNull
    @Size(max = 32)
    private String muutja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar muudetud;

    @Size(max = 32)
    private String sulgeja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar suletud;
    
    @PrePersist
    private void logSavingData(){
    	Calendar now = Calendar.getInstance();
    	this.avaja = "avaja";
    	this.avatud = now;
    	this.muutja = "avaja";
    	this.muudetud = now;
    	Calendar closedTime = Calendar.getInstance();
    	closedTime.add(Calendar.YEAR, +200);
    	this.suletud = closedTime;
    }
    
}
