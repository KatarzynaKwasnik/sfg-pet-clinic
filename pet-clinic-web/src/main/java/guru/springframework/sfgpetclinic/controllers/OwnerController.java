package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")//TODO można część adresu umieścić tutaj, bo ta część będzie się powtarzać
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    String listOwners() {
        return "owners/index";
    }
}
