package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.services.QueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/queries")
@Controller
public class QueryController {

    // == fields ==
    private QueryService queryService;

    // == constructor ==


    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    // == request handler ==
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getQueries(Model model) {
        model.addAttribute("queries", queryService.findAll());
        return "queries/index";
    }
}
