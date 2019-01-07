package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customers")
@Slf4j
@Controller
public class CustomerController {

    // == fields ==
    private final CustomerService customerService;

    // == constructor ==
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // == request handlers ==
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers/index";
    }

    @RequestMapping("/find")
    public String findCustomers() {
        return "notimplemented";
    }
}
