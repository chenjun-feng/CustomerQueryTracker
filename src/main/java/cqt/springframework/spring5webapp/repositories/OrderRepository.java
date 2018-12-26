package cqt.springframework.spring5webapp.repositories;

import cqt.springframework.spring5webapp.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
