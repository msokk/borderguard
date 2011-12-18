package ee.codeporn.borderguard.web;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.codeporn.borderguard.entities.Kodakondsus;
import ee.codeporn.borderguard.entities.Seadus;
import ee.codeporn.borderguard.entities.SeadusePunkt;
import ee.codeporn.borderguard.generic.SeadusePunktFilter;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "seadused", formBackingObject = Seadus.class)
@RequestMapping("/seadused")
@Controller
public class SeadusController {
	
	@ModelAttribute(value = "SeadusePunktFilter")
    public SeadusePunktFilter getFilter() {
    	return new SeadusePunktFilter();
    }
	
	  @RequestMapping(method = RequestMethod.GET)
	    public String listSeadused(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        if (page != null || size != null) {
	            int sizeNo = size == null ? 10 : size.intValue();
	            uiModel.addAttribute("seadused", Seadus.findSeadusEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
	            float nrOfPages = (float) Seadus.countSeadused() / sizeNo;
	            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	        } else {
	            uiModel.addAttribute("seadused", Seadus.findAllSeadused());
	        }
	        addDateTimeFormatPatterns(uiModel);
	        return "seadused/list";
	    }
	
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
    	Seadus seadus = Seadus.findSeadus(id);
        uiModel.addAttribute("seadus", seadus);
        uiModel.addAttribute("seadusepunktid", seadus.getSeadusePunktid());
        addDateTimeFormatPatterns(uiModel);
        return "seadused/update";
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("seadus", new Seadus());
        addDateTimeFormatPatterns(uiModel);
        return "seadused/create";
    }
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Seadus seadus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("seadus", seadus);
            addDateTimeFormatPatterns(uiModel);
            return "seadused/create";
        }
        uiModel.asMap().clear();
        seadus.persist();
        return "redirect:/seadused/" + encodeUrlPathSegment(seadus.getId().toString(), httpServletRequest) + "?form";
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET)
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
        return "seadused/history";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Seadus seadus = Seadus.findSeadus(id);
        seadus.close();
        for(SeadusePunkt x : seadus.getSeadusePunktid()){
        	x.close();
        }
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/seadused";
    }
}
