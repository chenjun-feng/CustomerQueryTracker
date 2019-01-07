package cqt.springframework.spring5webapp.services.springdatajpa;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerSDJpaServiceTest {

    public static final String NAME = "Smith";

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerSDJpaService service;

    Customer returnCustomer;

    @BeforeEach
    void setUp() {
        returnCustomer = Customer.builder().c_id(1L).cName(NAME).build();
    }

    @Test
    void findByCName() {
        when(customerRepository.findByCName(any())).thenReturn(returnCustomer);

        Customer smith = service.findByCName(NAME);

        assertEquals(NAME, smith.getCName());
        verify(customerRepository).findByCName(any());
    }

    @Test
    void findAll() {
        Set<Customer> returnCustomerSet = new HashSet<>();
        returnCustomerSet.add(Customer.builder().c_id(1L).build());
        returnCustomerSet.add(Customer.builder().c_id(2L).build());

        when(customerRepository.findAll()).thenReturn(returnCustomerSet);

        Set<Customer> customers = service.findAll();

        assertNotNull(customers);
        assertEquals(2, customers.size());
    }

    @Test
    void findById() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(returnCustomer));

        Customer customer = service.findById(1L);

        assertNotNull(customer);
    }

    @Test
    void findbyIdNotFound() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Customer customer = service.findById(2L);

        assertNull(customer);
    }

    @Test
    void save() {
        Customer customerToSave = Customer.builder().c_id(1L).build();
        when(customerRepository.save(any())).thenReturn(returnCustomer);

        Customer savedCustomer = service.save(customerToSave);
        assertNotNull(savedCustomer);

        verify(customerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnCustomer);

        // defult is 1 time
        verify(customerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(customerRepository).deleteById(anyLong());
    }
}