package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.services.CustomerService;
import cqt.springframework.spring5webapp.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    // == fields ==
    private OrderService orderService;
    private CustomerService customerService;

    // == constructor ==
    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    // == model attributes ==
    @ModelAttribute("customer")
    public Customer findCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.findById(customerId);
    }

    // == request handler ==
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders/index";
    }
}
