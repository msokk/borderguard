package ee.codeporn.borderguard.web;

import ee.codeporn.borderguard.entities.SeadusePunkt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "seadusepunktid", formBackingObject = SeadusePunkt.class)
@RequestMapping("/seadusepunktid")
@Controller
public class SeadusePunktController {
}
