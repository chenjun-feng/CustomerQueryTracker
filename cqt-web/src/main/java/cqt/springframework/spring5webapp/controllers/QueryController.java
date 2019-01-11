package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.model.Order;
import cqt.springframework.spring5webapp.model.Query;
import cqt.springframework.spring5webapp.model.Type;
import cqt.springframework.spring5webapp.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

//@RequestMapping("/queries")
@Controller
@RequestMapping("/customers/{customerId}")
public class QueryController {

    // == fields ==
    private static final String VIEWS_QUERY_CREATE_OR_UPDATE_FORM = "queries/createOrUpdateQueryForm";
    private QueryService queryService;
    private CustomerService customerService;
    private EmployeeService employeeService;
    private OrderService orderService;
    private TypeService typeService;

    // == constructor ==
    public QueryController(QueryService queryService, CustomerService customerService, EmployeeService employeeService, OrderService orderService, TypeService typeService) {
        this.queryService = queryService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.orderService = orderService;
        this.typeService = typeService;
    }

    // == request handler ==
//    @RequestMapping({"", "/", "/index", "/index.html"})
//    public String getQueries(Model model) {
//        model.addAttribute("queries", queryService.findAll());
//        return "queries/index";
//    }

    @ModelAttribute("types")
    public Collection<Type> queryTypes() {
        return typeService.findAll();
    }

    @ModelAttribute("customer")
    public Customer findCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.findById(customerId);
    }

    @ModelAttribute("orders")
    public Collection<Order> queryOrders(@PathVariable("customerId") Long customerId) {
        return customerService.findById(customerId).getC_orders();
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("c_id");
    }

    @GetMapping("/queries/new")
    public String initCreationQueryForm(Customer customer, Model model) {
        Query query = new Query();
        query.setQ_customer(customer);
        model.addAttribute("query", query);
        model.addAttribute("customer", customer);
        return VIEWS_QUERY_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/queries/new")
    public String processCreationQueryForm(Customer customer, @Valid Query query, BindingResult result, ModelMap model) {
        if (query.isNew() && customer.getQuery(query.getQ_order(), true) != null) {
            result.rejectValue("q_order", "duplicate", "already exists");
        }
        if (customer.getC_orders().isEmpty()) {
            //model.put("customer", customer);
            return "redirect:/customers/" + customer.getC_id();
        }
        query.setQ_customer(customer);
        if (result.hasErrors()) {
            model.put("query", query);
            return VIEWS_QUERY_CREATE_OR_UPDATE_FORM;
        } else {
            query.setQ_employee(employeeService.selectLowestWorkloadEmployee(query.getQ_type().getDepartment()));
            queryService.save(query);
            return "redirect:/customers/" + customer.getC_id();
        }
    }

    @GetMapping("/queries/{queryId}/edit")
    public String initUpdateQueryForm(@PathVariable("queryId") Long queryId, Model model) {
        model.addAttribute("query", queryService.findById(queryId));
        return VIEWS_QUERY_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/queries/{queryId}/edit")
    public String processUpdateQueryForm(@Valid Query query, BindingResult result, Customer customer, Model model) {
        if (result.hasErrors()) {
            query.setQ_customer(customer);
            model.addAttribute("query", query);
            return VIEWS_QUERY_CREATE_OR_UPDATE_FORM;
        } else {
            customer.getC_queries().add(query);
            queryService.save(query);
            return "redirect:/customers/" + customer.getC_id();
        }
    }




}
