// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.codeporn.borderguard.entities;

import ee.codeporn.borderguard.entities.SeadusePunkt;
import java.lang.String;
import java.util.Calendar;
import java.util.Set;

privileged aspect Seadus_Roo_JavaBean {
    
    public String Seadus.getKood() {
        return this.kood;
    }
    
    public void Seadus.setKood(String kood) {
        this.kood = kood;
    }
    
    public String Seadus.getNimetus() {
        return this.nimetus;
    }
    
    public void Seadus.setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }
    
    public String Seadus.getKommentaar() {
        return this.kommentaar;
    }
    
    public void Seadus.setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }
    
    public Calendar Seadus.getKehtivAlates() {
        return this.kehtivAlates;
    }
    
    public void Seadus.setKehtivAlates(Calendar kehtivAlates) {
        this.kehtivAlates = kehtivAlates;
    }
    
    public Calendar Seadus.getKehtivKuni() {
        return this.kehtivKuni;
    }
    
    public void Seadus.setKehtivKuni(Calendar kehtivKuni) {
        this.kehtivKuni = kehtivKuni;
    }
    
    public void Seadus.setSeadusePunktid(Set<SeadusePunkt> seadusePunktid) {
        this.seadusePunktid = seadusePunktid;
    }
    
}
