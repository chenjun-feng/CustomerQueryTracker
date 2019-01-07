package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class CustomerMapService extends AbstractMapService<Customer, Long> implements CustomerService {

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

    @Override
    public Customer findByCName(String name) {
        return this.findAll()
                .stream()
                .filter(customer -> customer.getCName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}