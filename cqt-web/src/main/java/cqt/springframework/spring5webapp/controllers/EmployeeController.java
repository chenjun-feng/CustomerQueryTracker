package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

    // == fields ==
    private EmployeeRepository employeeRepository;

    // == constructor ==
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // == request handler ==
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees/index";
    }
}
