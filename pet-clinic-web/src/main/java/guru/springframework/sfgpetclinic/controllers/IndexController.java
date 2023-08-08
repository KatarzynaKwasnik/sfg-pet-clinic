package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//TODO Wszystkie komponenty muszą być w tym samym pakiecie co klasa main!!!!!!!!
public class IndexController {

    @RequestMapping({"/", "", "/index", "/index.html"})
    public String index() {

        return "index";
    }

    @RequestMapping({ "/oups"})
    String oupsHandler() {
        return "notImplemented";
    }
}
