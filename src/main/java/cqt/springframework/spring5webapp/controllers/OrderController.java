package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    // == fields ==
    private OrderRepository orderRepository;

    // == constructor ==
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // == request handler ==
    @RequestMapping("/orders")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }
}
