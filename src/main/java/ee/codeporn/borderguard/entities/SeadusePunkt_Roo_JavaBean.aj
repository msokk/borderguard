// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.codeporn.borderguard.entities;

import ee.codeporn.borderguard.entities.Seadus;
import ee.codeporn.borderguard.entities.SeadusePunkt;
import java.lang.String;
import java.util.Calendar;
import java.util.Set;

privileged aspect SeadusePunkt_Roo_JavaBean {
    
    public String SeadusePunkt.getParagrahv() {
        return this.paragrahv;
    }
    
    public void SeadusePunkt.setParagrahv(String paragrahv) {
        this.paragrahv = paragrahv;
    }
    
    public String SeadusePunkt.getPais() {
        return this.pais;
    }
    
    public void SeadusePunkt.setPais(String pais) {
        this.pais = pais;
    }
    
    public String SeadusePunkt.getTekst() {
        return this.tekst;
    }
    
    public void SeadusePunkt.setTekst(String tekst) {
        this.tekst = tekst;
    }
    
    public String SeadusePunkt.getKommentaar() {
        return this.kommentaar;
    }
    
    public void SeadusePunkt.setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }
    
    public Calendar SeadusePunkt.getKehtivAlates() {
        return this.kehtivAlates;
    }
    
    public void SeadusePunkt.setKehtivAlates(Calendar kehtivAlates) {
        this.kehtivAlates = kehtivAlates;
    }
    
    public Calendar SeadusePunkt.getKehtivKuni() {
        return this.kehtivKuni;
    }
    
    public void SeadusePunkt.setKehtivKuni(Calendar kehtivKuni) {
        this.kehtivKuni = kehtivKuni;
    }
    
    public Seadus SeadusePunkt.getSeadus() {
        return this.seadus;
    }
    
    public void SeadusePunkt.setSeadus(Seadus seadus) {
        this.seadus = seadus;
    }
    
    public SeadusePunkt SeadusePunkt.getSeadusePunkt() {
        return this.seadusePunkt;
    }
    
    public void SeadusePunkt.setSeadusePunkt(SeadusePunkt seadusePunkt) {
        this.seadusePunkt = seadusePunkt;
    }
    
    public void SeadusePunkt.setSeadusePunktid(Set<SeadusePunkt> seadusePunktid) {
        this.seadusePunktid = seadusePunktid;
    }
    
}
