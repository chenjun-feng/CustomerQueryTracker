package cqt.springframework.spring5webapp.services;

import cqt.springframework.spring5webapp.model.Customer;

import java.util.List;

public interface CustomerService extends CrudService<Customer, Long> {

    Customer findByCName(String name);

    List<Customer> findAllByCNameLike(String name);
}
