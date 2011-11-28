package ee.codeporn.borderguard.web;

import ee.codeporn.borderguard.entities.Objekt;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "objektid", formBackingObject = Objekt.class)
@RequestMapping("/objektid")
@Controller
public class ObjektController {
}
