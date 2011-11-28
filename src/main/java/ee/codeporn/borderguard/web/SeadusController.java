package ee.codeporn.borderguard.web;

import ee.codeporn.borderguard.entities.Seadus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "seadused", formBackingObject = Seadus.class)
@RequestMapping("/seadused")
@Controller
public class SeadusController {
}
