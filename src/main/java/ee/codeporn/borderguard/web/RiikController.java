package ee.codeporn.borderguard.web;

import ee.codeporn.borderguard.entities.Riik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "riigid", formBackingObject = Riik.class)
@RequestMapping("/riigid")
@Controller
public class RiikController {
}
