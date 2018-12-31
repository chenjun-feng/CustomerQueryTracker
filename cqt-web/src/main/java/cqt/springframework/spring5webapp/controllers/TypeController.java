package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.repositories.TypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/types")
@Controller
public class TypeController {

    // == fields ==
    private TypeRepository typeRepository;

    // == constructor ==
    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    // == request handler ==
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getTypes(Model model) {
        model.addAttribute("types", typeRepository.findAll());
        return "types/index";
    }
}
