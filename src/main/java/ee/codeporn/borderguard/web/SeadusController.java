package ee.codeporn.borderguard.web;

import java.util.Calendar;

import javax.validation.Valid;

import ee.codeporn.borderguard.entities.Seadus;
import ee.codeporn.borderguard.entities.SeadusePunkt;
import ee.codeporn.borderguard.generic.SeadusePunktFilter;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "seadused", formBackingObject = Seadus.class, update = false)
@RequestMapping("/seadused")
@Controller
public class SeadusController {
	
	@ModelAttribute(value = "SeadusePunktFilter")
    public SeadusePunktFilter getFilter() {
    	return new SeadusePunktFilter();
    }
	
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("seadus", new Seadus());
        addDateTimeFormatPatterns(uiModel);
        return "seadused/create";
    }
	
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel, @Valid SeadusePunktFilter filter) {
    	uiModel.addAttribute("seadused", Seadus.findAllSeadused());
    	
    	if(filter.getAlates() == null) {
    		Calendar cal = Calendar.getInstance();
    		cal.add(Calendar.YEAR, -2);
    		filter.setAlates(cal);
    	}
    	
    	if(filter.getKuni() == null) {
    		Calendar cal = Calendar.getInstance();
    		cal.add(Calendar.YEAR, +2);
    		filter.setKuni(cal);
    	}
    	
    	if(filter.getValitudSeadus() != null) {
    		uiModel.addAttribute("seadusepunktid", filter.getValitudSeadus().getPunktid(filter.getAlates(), filter.getKuni()));
    	} else {
    		uiModel.addAttribute("seadusepunktid", SeadusePunkt.getAllPunktid(filter.getAlates(), filter.getKuni()));
    	}
    	
    	uiModel.addAttribute("SeadusePunktFilter", filter);

    	
        addDateTimeFormatPatterns(uiModel);
        return "seadused/list";
    }
}
