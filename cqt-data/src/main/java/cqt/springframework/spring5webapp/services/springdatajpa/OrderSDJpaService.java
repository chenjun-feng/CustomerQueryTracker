package cqt.springframework.spring5webapp.services.springdatajpa;

import cqt.springframework.spring5webapp.model.Order;
import cqt.springframework.spring5webapp.repositories.OrderRepository;
import cqt.springframework.spring5webapp.services.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OrderSDJpaService implements OrderService {

    // == fields ==
    private final OrderRepository orderRepository;

    // == constructor ==
    public OrderSDJpaService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // == public methods ==
    @Override
    public Set<Order> findAll() {
        Set<Order> orders = new HashSet<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public Order findById(Long aLong) {
        return orderRepository.findById(aLong).orElse(null) ;
    }

    @Override
    public Order save(Order object) {
        return orderRepository.save(object);
    }

    @Override
    public void delete(Order object) {
        orderRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        orderRepository.deleteById(aLong);
    }
}
