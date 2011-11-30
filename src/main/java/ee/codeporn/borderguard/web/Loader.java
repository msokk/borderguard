package ee.codeporn.borderguard.web;

import java.util.List;

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
        			Riik eesti = new Riik();
        			eesti.setIsoKood("EST");
        			eesti.setAnsiKood("233");
        			eesti.setKommentaar("Eesti");
        			eesti.persist();
        			
        			List<Riik> k = Riik.findAllRiigid();
        			System.out.println(k.size());
        			System.out.println("Seeding data!");
        		}
        	}
        }
}