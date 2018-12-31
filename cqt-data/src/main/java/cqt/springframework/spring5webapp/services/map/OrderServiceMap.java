package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Order;
import cqt.springframework.spring5webapp.services.CrudService;

import java.util.Set;

public class OrderServiceMap extends AbstractMapService<Order, Long> implements CrudService<Order, Long> {

    @Override
    public Set<Order> findAll() {
        return super.findAll();
    }

    @Override
    public Order findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Order save(Order object) {
        return super.save(object.getO_id(), object);
    }

    @Override
    public void delete(Order object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
