package ee.codeporn.borderguard.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ee.codeporn.borderguard.entities.Kodakondsus;
import ee.codeporn.borderguard.entities.Piiririkkuja;
import ee.codeporn.borderguard.entities.Riik;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent>{

        @Override
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {
        	if (event.getApplicationContext().getParent() == null) {
        		
        		if(Riik.countRiigid() == 0) {
        			System.out.println("Seeding data!");
        			Riik.build("EST", "233", "Eesti").persist();
        			Riik.build("LVA", "428", "Läti").persist();
        			Riik.build("RUS", "643", "Venemaa").persist();
        			Riik.build("FIN", "246", "Soome").persist();
        			Riik.build("SWE", "752", "Rootsi").persist();
        			Riik.build("LTU", "440", "Leedu").persist();
        		}
        		
        		if (Piiririkkuja.countPiiririkkujad() == 0){
        			Piiririkkuja rikkuja = new Piiririkkuja();
        			rikkuja.setIsikukood("38943456789");
        			rikkuja.setKommentaar("Üritas ületada piiri vale kodakondsusega");
        			rikkuja.setEesnimi("Juku");
        			rikkuja.setPerenimi("Kõikvõimas");
        			rikkuja.setSugu("M");
        			
        			Kodakondsus k = Kodakondsus.build("Est - Rus kodakondus", Riik.findRiik((long)1),"39008292728", Piiririkkuja.findPiiririkkuja((long)1));
        			k.persist();
        			
        			
        			rikkuja.setKodakondsused((Set<Kodakondsus>)k);
        			rikkuja.persist();
        			
        			
        		}
        	}
        }
}