package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/customers")
@Slf4j
@Controller
public class CustomerController {

    // == fields ==
    private static final String VIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM = "customers/createOrUpdateCustomerForm";

    private final CustomerService customerService;

    // == constructor ==
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("c_id");
    }

    // == request handlers ==
//    @RequestMapping({"", "/", "/index", "/index.html"})
//    public String getCustomers(Model model) {
//        model.addAttribute("customers", customerService.findAll());
//        return "customers/index";
//    }

    @RequestMapping("/find")
    public String findCustomers(Model model) {
        model.addAttribute("customer", Customer.builder().build());
        return "customers/findCustomer";
    }

    @GetMapping
    public String processFindForm(Customer customer, BindingResult result, Model model) {
        // allow parameterless GET request for /customers to return all records
        if(customer.getCName() == null) {
            customer.setCName(""); // empty string signifies the broadest search
        }

        // find customers by name
        List<Customer> results = customerService.findAllByCNameLike("%" + customer.getCName() + "%");

        if(results.isEmpty()) {
            // no customer found
            result.rejectValue("cName", "notFound" ,"not found");
            return "customers/findCustomer";
        } else if (results.size() == 1) {
            // 1 customer found
            customer = results.get(0);
            return "redirect:/customers/" + customer.getC_id();
        } else {
            // multiple customers found
            model.addAttribute("selections", results);
            return "customers/customerList";
        }
    }

    @GetMapping("/{customerId}")
    public ModelAndView showCustomers(@PathVariable("customerId") Long customerId) {
        ModelAndView mav = new ModelAndView("customers/customerDetails");
        mav.addObject(customerService.findById(customerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("customer", Customer.builder().build());
        return VIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM;
        } else {
            Customer savedCustomer = customerService.save(customer);
            return "redirect:/customers/" + savedCustomer.getC_id();
        }
    }

    @GetMapping("/{customerId}/edit")
    public String initUpdateCustomerForm(@PathVariable("customerId") Long customerId, Model model) {
        model.addAttribute(customerService.findById(customerId));
        return VIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{customerId}/edit")
    public String processUpdateCustomerForm(@Valid Customer customer, BindingResult result, @PathVariable("customerId") Long customerId) {
        if (result.hasErrors()) {
            return VIEWS_CUSTOMER_CREATE_OR_UPDATE_FORM;
        } else {
            customer.setC_id(customerId);
            Customer savedCustomer = customerService.save(customer);
            return "redirect:/customers/" + savedCustomer.getC_id();
        }
    }
}
