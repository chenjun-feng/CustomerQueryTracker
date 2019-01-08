package cqt.springframework.spring5webapp.repositories;

import cqt.springframework.spring5webapp.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByCName(String name);

    List<Customer> findAllByCNameLike(String name);
}
