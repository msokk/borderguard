package ee.codeporn.borderguard.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.codeporn.borderguard.entities.Kodakondsus;
import ee.codeporn.borderguard.entities.Piiririkkuja;

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
	
    @RequestMapping(value = "/{id}/{piiririkkujaId}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, @PathVariable("piiririkkujaId") Long piiririkkujaId, Model uiModel) {
        uiModel.addAttribute("kodakondsus", Kodakondsus.findKodakondsus(id));
        uiModel.addAttribute("piiririkkuja", Piiririkkuja.findPiiririkkuja(piiririkkujaId));

        addDateTimeFormatPatterns(uiModel);
        return "kodakondsused/update";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Kodakondsus kodakondsus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("kodakondsus", kodakondsus);
            addDateTimeFormatPatterns(uiModel);
            return "kodakondsused/update";
        }
        uiModel.asMap().clear();
        kodakondsus.merge();
        return "redirect:/piiririkkujad/" + encodeUrlPathSegment(kodakondsus.getPiiririkkuja().getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{piiririkkujaId}", params = "form", method = RequestMethod.GET)
    public String createForm(@PathVariable("piiririkkujaId") Long piiririkkujaId, Model uiModel) {
        uiModel.addAttribute("kodakondsus", new Kodakondsus());
        uiModel.addAttribute("piiririkkuja", Piiririkkuja.findPiiririkkuja(piiririkkujaId));
        addDateTimeFormatPatterns(uiModel);
        return "kodakondsused/create";
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        uiModel.addAttribute("kodakondsus", new Kodakondsus());;
        addDateTimeFormatPatterns(uiModel);
        return "kodakondsused/create";
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
        return "redirect:/piiririkkujad/" + encodeUrlPathSegment(kodakondsus.getPiiririkkuja().getId().toString(), httpServletRequest);
    }
	
}
