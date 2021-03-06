package cqt.springframework.spring5webapp.bootstrap;

import cqt.springframework.spring5webapp.model.*;
import cqt.springframework.spring5webapp.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.time.LocalDate;

//@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    // == fields ==
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;
    private OrderRepository orderRepository;
    private QueryRepository queryRepository;
    private TypeRepository typeRepository;

    // == constructor ==
    public DevBootStrap(CustomerRepository customerRepository, EmployeeRepository employeeRepository, OrderRepository orderRepository, QueryRepository queryRepository, TypeRepository typeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.orderRepository = orderRepository;
        this.queryRepository = queryRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Customer c1 = new Customer();
        c1.setCName("Chen");
        c1.setC_password("chen123");
        c1.setC_email("chen@cogent.com");
        c1.setC_status(true);

        Customer c2 = new Customer();
        c2.setCName("Sunit");
        c2.setC_password("sunit123");
        c2.setC_email("sunit@cogent.com");
        c2.setC_status(true);

        Order o1 = new Order();
        o1.setO_date(LocalDate.now());
        o1.setO_amount(1.11);
        o1.setO_customer(c1);

        Order o2 = new Order();
        o2.setO_date(LocalDate.now());
        o2.setO_amount(1.12);
        o2.setO_customer(c1);

        Type t1 = new Type();
        t1.setT_name("Defect Product");
        t1.setDepartment(Department.CUSTOMER_SERVICE_DEPARTMENT);

        Employee e1 = new Employee();
        e1.setEName("John");
        e1.setE_password("john123");
        e1.setE_email("john@amazon.com");
        e1.setDepartment(Department.CUSTOMER_SERVICE_DEPARTMENT);
        e1.setE_role("staff");
        e1.setE_workload(1);

        Query q1 = new Query();
        q1.setQ_status(true);
        q1.setQ_feedback(-1);
        q1.setQ_type(t1);
        q1.setQ_customer(c1);
        q1.setQ_order(o1);
        q1.setQ_employee(e1);

        customerRepository.save(c1);
        customerRepository.save(c2);
        orderRepository.save(o1);
        orderRepository.save(o2);
        typeRepository.save(t1);
        employeeRepository.save(e1);
        queryRepository.save(q1);
    }
}

