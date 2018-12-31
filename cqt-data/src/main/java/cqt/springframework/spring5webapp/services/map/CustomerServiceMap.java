package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.services.CrudService;

import java.util.Set;

public class CustomerServiceMap extends AbstractMapService<Customer, Long> implements CrudService<Customer, Long> {

    @Override
    public Set<Customer> findAll() {
        return super.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Customer save(Customer object) {
        return super.save(object.getC_id(), object);
    }

    @Override
    public void delete(Customer object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}