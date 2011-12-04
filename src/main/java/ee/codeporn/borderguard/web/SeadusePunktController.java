package ee.codeporn.borderguard.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.codeporn.borderguard.entities.Seadus;
import ee.codeporn.borderguard.entities.SeadusePunkt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid SeadusePunkt seadusePunkt, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("seadusePunkt", seadusePunkt);
            addDateTimeFormatPatterns(uiModel);
            return "seadusepunktid/update";
        }
        uiModel.asMap().clear();
        seadusePunkt.merge();
        return "redirect:/seadused/" + encodeUrlPathSegment(seadusePunkt.getSeadus().getId().toString(), httpServletRequest) + "?form";
    }
    
    @RequestMapping(value = "/{id}/{seadusId}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, @PathVariable("seadusId") Long seadusId, Model uiModel) {
        uiModel.addAttribute("seadusePunkt", SeadusePunkt.findSeadusePunkt(id));
        uiModel.addAttribute("seadusId", seadusId);
        
        addDateTimeFormatPatterns(uiModel);
        return "seadusepunktid/update";
    }
    
    @RequestMapping(value = "/{seadusId}", params = "form", method = RequestMethod.GET)
    public String createForm(@PathVariable("seadusId") Long seadusId, Model uiModel) {

        uiModel.addAttribute("seadusePunkt", new SeadusePunkt());
        uiModel.addAttribute("seadusId", seadusId);
        addDateTimeFormatPatterns(uiModel);
        return "seadusepunktid/create";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid SeadusePunkt seadusePunkt, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
        	System.out.println(bindingResult.getAllErrors().toString());
            uiModel.addAttribute("seadusePunkt", seadusePunkt);
            addDateTimeFormatPatterns(uiModel);
            return "seadusepunktid/create";
        }
        uiModel.asMap().clear();
        seadusePunkt.persist();
        return "redirect:/seadused/" + encodeUrlPathSegment(seadusePunkt.getSeadus().getId().toString(), httpServletRequest) + "?form";
    }
}
