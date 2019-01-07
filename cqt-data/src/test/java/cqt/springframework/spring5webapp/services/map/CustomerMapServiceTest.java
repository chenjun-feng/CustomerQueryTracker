package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapServiceTest {

    CustomerMapService customerMapService;
    final Long customerId = 1L;
    final String customerName = "Smith";

    @BeforeEach
    void setUp() {
        customerMapService = new CustomerMapService();
        customerMapService.save(Customer.builder().c_id(customerId).cName(customerName).build());
    }

    @Test
    void findAll() {
        Set<Customer> customerSet = customerMapService.findAll();

        assertEquals(1, customerSet.size());
    }

    @Test
    void findById() {
        Customer customer = customerMapService.findById(customerId);

        assertEquals(customerId, customer.getC_id());
    }

    @Test
    void save() {
        Long id = 2L;
        Customer customer2 = Customer.builder().c_id(id).build();
        Customer savedCustomer = customerMapService.save(customer2);

        assertEquals(id, savedCustomer.getC_id());
    }

    @Test
    void delete() {
        customerMapService.delete(customerMapService.findById(customerId));

        assertEquals(0, customerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        customerMapService.deleteById(customerId);

        assertEquals(0, customerMapService.findAll().size());
    }

    @Test
    void findByCName() {
        Customer smith = customerMapService.findByCName(customerName);

        assertNotNull(smith);
        assertEquals(customerId, smith.getC_id());
    }

    @Test
    void findByCNameNotFound() {
        Customer foo = customerMapService.findByCName("foo");

        assertNull(foo);
    }
}