package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @Mock
    Model model;

    @InjectMocks
    CustomerController customerController;

    Set<Customer> customers;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        customers = new HashSet<>();
        customers.add(Customer.builder().c_id(1L).build());
        customers.add(Customer.builder().c_id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void getCustomers() throws Exception {

        when(customerService.findAll()).thenReturn(customers);

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/index"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }

    @Test
    public void getCustomersByIndex() throws Exception {

        when(customerService.findAll()).thenReturn(customers);

        mockMvc.perform(get("/customers/index.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/index"))
                .andExpect(view().name("customers/index"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }

    @Test
    public void findCustomer() throws Exception{
        mockMvc.perform(get("/customers/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(customerService);
    }

}