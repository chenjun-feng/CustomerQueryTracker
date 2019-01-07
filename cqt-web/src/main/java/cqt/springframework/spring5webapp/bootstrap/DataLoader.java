package cqt.springframework.spring5webapp.bootstrap;

import cqt.springframework.spring5webapp.model.*;
import cqt.springframework.spring5webapp.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    // == fields ==
    private final CustomerService customerService;
    private final OrderService orderService;
    private final TypeService typeService;
    private final EmployeeService employeeService;
    private final QueryService queryService;

    // == constructor ==
    public DataLoader(CustomerService customerService, OrderService orderService, TypeService typeService, EmployeeService employeeService, QueryService queryService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.typeService = typeService;
        this.employeeService = employeeService;
        this.queryService = queryService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = customerService.findAll().size();
        if (count == 0) loadData();
    }

    private void loadData() {
        Customer c1 = new Customer();
        //c1.setC_id(111L);
        //Customer.builder().cName("Chen").c_password("chen123").c_email("chen@cogent.com").c_status(true);
        c1.setCName("Chen");
        c1.setC_password("chen123");
        c1.setC_email("chen@cogent.com");
        c1.setC_status(true);
        customerService.save(c1);

        Customer c2 = new Customer();
        //c2.setC_id(222L);
        c2.setCName("Sunit");
        c2.setC_password("sunit123");
        c2.setC_email("sunit@cogent.com");
        c2.setC_status(true);
        customerService.save(c2);

        System.out.println("Loaded Customers......");

        Order o1 = new Order();
        //o1.setO_id(3L);
        o1.setO_date(Date.valueOf("2018-01-01"));
        o1.setO_amount(1.11);
        o1.setO_customer(c1);
        orderService.save(o1);

        Order o2 = new Order();
        //o2.setO_id(4L);
        o2.setO_date(Date.valueOf("2018-01-02"));
        o2.setO_amount(1.12);
        o2.setO_customer(c1);
        orderService.save(o2);

        System.out.println("Loaded Orders......");

        Type t1 = new Type();
        //t1.setT_id(5L);
        t1.setT_name("Defect Product");
        t1.setDepartment("Customer Service Department");
        typeService.save(t1);

        System.out.println("Loaded Query Types......");

        Employee e1 = new Employee();
        //e1.setE_id(6L);
        e1.setEName("John");
        e1.setE_password("john123");
        e1.setE_email("john@amazon.com");
        e1.setDepartment(Department.CUSTOMER_SERVICE_DEPARTMENT);
        e1.setE_role("staff");
        e1.setE_workload(1);
        employeeService.save(e1);

        System.out.println("Loaded Employees......");

        Query q1 = new Query();
        //q1.setQ_id(7L);
        q1.setQ_status(true);
        q1.setQ_feedback(-1);
        q1.setQ_type(t1);
        q1.setQ_customer(c1);
        q1.setQ_order(o1);
        q1.setQ_employee(e1);
        queryService.save(q1);

        System.out.println("Loaded Queries......");
    }
}
