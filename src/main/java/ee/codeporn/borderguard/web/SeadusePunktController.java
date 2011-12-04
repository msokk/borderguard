package ee.codeporn.borderguard.web;

import ee.codeporn.borderguard.entities.Seadus;
import ee.codeporn.borderguard.entities.SeadusePunkt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RooWebScaffold(path = "seadusepunktid", formBackingObject = SeadusePunkt.class)
@RequestMapping("/seadusepunktid")
@Controller
public class SeadusePunktController {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
    public String delete(@PathVariable("id") Long id) {
        SeadusePunkt.findSeadusePunkt(id).close();
        return "1";
    }
    
    @RequestMapping(value = "/{seadusId}", params = "form", method = RequestMethod.GET)
    public String createForm(@PathVariable("seadusId") Long seadusId, Model uiModel) {
        uiModel.addAttribute("seadusePunkt", new SeadusePunkt());
        uiModel.addAttribute("seadus", Seadus.findSeadus(seadusId));
        addDateTimeFormatPatterns(uiModel);
        return "seadusepunktid/create";
    }
    
}
