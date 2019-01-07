package cqt.springframework.spring5webapp.services.springdatajpa;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.repositories.CustomerRepository;
import cqt.springframework.spring5webapp.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CustomerSDJpaService implements CustomerService {

    // == fields ==
    private final CustomerRepository customerRepository;
    //private final OrderRepository orderRepository;
    //private QueryRepository queryRepository;

    // == constructor ==
    public CustomerSDJpaService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        //this.orderRepository = orderRepository;
        //this.queryRepository = queryRepository;
    }

    // == public methods ==
    @Override
    public Customer findByCName(String name) {
        return customerRepository.findByCName(name);
    }

    @Override
    public Set<Customer> findAll() {
        Set<Customer> customers = new HashSet<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer findById(Long aLong) {
        return customerRepository.findById(aLong).orElse(null) ;
    }

    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public void delete(Customer object) {
        customerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        customerRepository.deleteById(aLong);
    }
}
