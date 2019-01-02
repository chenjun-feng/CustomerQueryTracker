package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/orders")
@Controller
public class OrderController {

    // == fields ==
    private OrderService orderService;

    // == constructor ==
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // == request handler ==
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders/index";
    }
}
