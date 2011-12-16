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
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "piiririkkujad", formBackingObject = Piiririkkuja.class)
@RequestMapping("/piiririkkujad")
@Controller
public class PiiririkkujaController {

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		Piiririkkuja rikkuja = Piiririkkuja.findPiiririkkuja(id);
        uiModel.addAttribute("piiririkkuja", rikkuja);
        uiModel.addAttribute("kodakondsused", rikkuja.getKodakondsused());
        uiModel.addAttribute("genders", new String[] {"M", "N"});
        addDateTimeFormatPatterns(uiModel);
        return "piiririkkujad/update";
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Piiririkkuja piiririkkuja, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piiririkkuja", piiririkkuja);
            addDateTimeFormatPatterns(uiModel);
//            System.out.println(bindingResult.getAllErrors().toString());
//            sysout is not good in production code :)
            return "piiririkkujad/update";
        }
        uiModel.asMap().clear();
        piiririkkuja.merge();
        return "redirect:/piiririkkujad/" + encodeUrlPathSegment(piiririkkuja.getId().toString(), httpServletRequest);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Piiririkkuja piiririkkuja, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piiririkkuja", piiririkkuja);
            addDateTimeFormatPatterns(uiModel);
            return "piiririkkujad/create";
        }
        uiModel.asMap().clear();
        piiririkkuja.persist();
        return "redirect:/piiririkkujad/" + encodeUrlPathSegment(piiririkkuja.getId().toString(), httpServletRequest) + "?form";
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Piiririkkuja rikkuja = Piiririkkuja.findPiiririkkuja(id);
        rikkuja.close();
        for(Kodakondsus x : rikkuja.getKodakondsused()){
        	x.close();
        }
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/piiririkkujad";
    }
}
