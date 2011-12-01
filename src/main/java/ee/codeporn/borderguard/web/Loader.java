package ee.codeporn.borderguard.web;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        		}
        	}
        }
}