package ee.codeporn.borderguard.web;

import ee.codeporn.borderguard.entities.Kodakondsus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "kodakondsused", formBackingObject = Kodakondsus.class)
@RequestMapping("/kodakondsused")
@Controller
public class KodakondsusController {
}
