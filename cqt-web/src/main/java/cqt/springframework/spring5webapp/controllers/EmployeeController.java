package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

    // == fields ==
    private EmployeeService employeeService;

    // == constructor ==
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // == request handler ==
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees/index";
    }
}
