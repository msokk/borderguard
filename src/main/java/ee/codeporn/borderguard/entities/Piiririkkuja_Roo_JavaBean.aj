// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.codeporn.borderguard.entities;

import ee.codeporn.borderguard.entities.Kodakondsus;
import java.lang.String;
import java.util.Calendar;
import java.util.Set;

privileged aspect Piiririkkuja_Roo_JavaBean {
    
    public String Piiririkkuja.getIsikukood() {
        return this.isikukood;
    }
    
    public void Piiririkkuja.setIsikukood(String isikukood) {
        this.isikukood = isikukood;
    }
    
    public String Piiririkkuja.getKommentaar() {
        return this.kommentaar;
    }
    
    public void Piiririkkuja.setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }
    
    public String Piiririkkuja.getEesnimi() {
        return this.eesnimi;
    }
    
    public void Piiririkkuja.setEesnimi(String eesnimi) {
        this.eesnimi = eesnimi;
    }
    
    public String Piiririkkuja.getPerenimi() {
        return this.perenimi;
    }
    
    public void Piiririkkuja.setPerenimi(String perenimi) {
        this.perenimi = perenimi;
    }
    
    public String Piiririkkuja.getSugu() {
        return this.sugu;
    }
    
    public void Piiririkkuja.setSugu(String sugu) {
        this.sugu = sugu;
    }
    
    public Calendar Piiririkkuja.getSynniaeg() {
        return this.synniaeg;
    }
    
    public void Piiririkkuja.setSynniaeg(Calendar synniaeg) {
        this.synniaeg = synniaeg;
    }
    
    public void Piiririkkuja.setKodakondsused(Set<Kodakondsus> kodakondsused) {
        this.kodakondsused = kodakondsused;
    }
    
}
