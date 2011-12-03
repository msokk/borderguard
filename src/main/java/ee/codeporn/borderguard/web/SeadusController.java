package ee.codeporn.borderguard.web;

import javax.validation.Valid;

import ee.codeporn.borderguard.entities.Seadus;
import ee.codeporn.borderguard.generic.SeadusePunktFilter;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "seadused", formBackingObject = Seadus.class)
@RequestMapping("/seadused")
@Controller
public class SeadusController {
	
	@ModelAttribute(value = "SeadusePunktFilter")
    public SeadusePunktFilter getFilter() {
    	return new SeadusePunktFilter();
    }
	
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel, @Valid SeadusePunktFilter filter) {
    	//uiModel.addAttribute("seadused", Seadus.findAllSeadused());
        addDateTimeFormatPatterns(uiModel);
        return "seadused/list";
    }
}
