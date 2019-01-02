package cqt.springframework.spring5webapp.bootstrap;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.model.Order;
import cqt.springframework.spring5webapp.services.CustomerService;
import cqt.springframework.spring5webapp.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataLoader implements CommandLineRunner {

    // == fields ==
    private final CustomerService customerService;
    private final OrderService orderService;

    // == constructor ==
    public DataLoader(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer c1 = new Customer();
        c1.setC_id(1L);
        c1.setC_name("Chen");
        c1.setC_password("chen123");
        c1.setC_email("chen@cogent.com");
        c1.setC_status(true);

        customerService.save(c1);

        Customer c2 = new Customer();
        c2.setC_id(2L);
        c2.setC_name("Sunit");
        c2.setC_password("sunit123");
        c2.setC_email("sunit@cogent.com");
        c2.setC_status(true);

        customerService.save(c2);

        System.out.println("Loaded Customers......");

        Order o1 = new Order();
        o1.setO_id(11L);
        o1.setO_date(Date.valueOf("2018-01-01"));
        o1.setO_amount(1.11);
        o1.setO_customer(c1);

        orderService.save(o1);

        Order o2 = new Order();
        o2.setO_id(22L);
        o2.setO_date(Date.valueOf("2018-01-02"));
        o2.setO_amount(1.12);
        o2.setO_customer(c1);

        orderService.save(o2);

        System.out.println("Loaded Orders......");

    }
}
