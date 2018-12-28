package cqt.springframework.spring5webapp.services;

import cqt.springframework.spring5webapp.model.Customer;

public interface CustomerService extends CrudService<Customer, Long> {

    Customer findByName(String name);
}
