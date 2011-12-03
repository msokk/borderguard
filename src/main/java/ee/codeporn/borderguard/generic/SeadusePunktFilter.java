package ee.codeporn.borderguard.generic;

import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;

import ee.codeporn.borderguard.entities.Seadus;

public class SeadusePunktFilter {
    @DateTimeFormat(style = "M-")
	private Calendar alates;

    @DateTimeFormat(style = "M-")
	private Calendar kuni;
	
	private Seadus valitudSeadus;

	public Calendar getAlates() {
		return alates;
	}

	public void setAlates(Calendar alates) {
		this.alates = alates;
	}

	public Calendar getKuni() {
		return kuni;
	}

	public void setKuni(Calendar kuni) {
		this.kuni = kuni;
	}

	public Seadus getValitudSeadus() {
		return valitudSeadus;
	}

	public void setValitudSeadus(Seadus valitudSeadus) {
		this.valitudSeadus = valitudSeadus;
	}
	
}
