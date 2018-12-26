package cqt.springframework.spring5webapp.repositories;

import cqt.springframework.spring5webapp.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
