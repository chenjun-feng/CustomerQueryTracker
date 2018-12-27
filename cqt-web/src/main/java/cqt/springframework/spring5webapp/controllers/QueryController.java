package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.repositories.QueryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QueryController {

    // == fields ==
    private QueryRepository queryRepository;

    // == constructor ==
    public QueryController(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    // == request handler ==
    @RequestMapping("/queries")
    public String getQueries(Model model) {
        model.addAttribute("queries", queryRepository.findAll());
        return "queries";
    }
}
