package ee.codeporn.borderguard.web;

import ee.codeporn.borderguard.entities.Piiririkkuja;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "piiririkkujad", formBackingObject = Piiririkkuja.class)
@RequestMapping("/piiririkkujad")
@Controller
public class PiiririkkujaController {

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		Piiririkkuja rikkuja = Piiririkkuja.findPiiririkkuja(id);
        uiModel.addAttribute("piiririkkuja", rikkuja);
        uiModel.addAttribute("kodakondsused", rikkuja.getKodakondsused());
        System.out.println(rikkuja.getKodakondsused().toString());
        addDateTimeFormatPatterns(uiModel);
        return "piiririkkujad/update";
    }
}
