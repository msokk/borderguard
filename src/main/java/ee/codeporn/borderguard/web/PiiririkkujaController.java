package ee.codeporn.borderguard.web;

import ee.codeporn.borderguard.entities.Piiririkkuja;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piiririkkujad", formBackingObject = Piiririkkuja.class)
@RequestMapping("/piiririkkujad")
@Controller
public class PiiririkkujaController {
}
