package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customers")
@Controller
public class CustomerController {

    // == fields ==
    private CustomerRepository customerRepository;

    // == constructor ==
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // == request handlers ==
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/index"; // return a view
    }
}
