package ee.codeporn.borderguard.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.codeporn.borderguard.entities.Kodakondsus;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RooWebScaffold(path = "kodakondsused", formBackingObject = Kodakondsus.class)
@RequestMapping("/kodakondsused")
@Controller
public class KodakondsusController {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
    public String delete(@PathVariable("id") Long id) {
        Kodakondsus.findKodakondsus(id).close();
        return "1";
    }
	
	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("kodakondsus", Kodakondsus.findKodakondsus(id));
        addDateTimeFormatPatterns(uiModel);
        
        return "kodakondsused/update";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Kodakondsus kodakondsus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("kodakondsus", kodakondsus);
            addDateTimeFormatPatterns(uiModel);
            return "kodakondsused/create";
        }
        uiModel.asMap().clear();
        kodakondsus.persist();
        return "redirect:/piiririkkujad/" + encodeUrlPathSegment(kodakondsus.getPiiririkkuja().getId().toString(), httpServletRequest) + "?form";
    }
	
}
