package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.model.Customer;
import cqt.springframework.spring5webapp.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void findCustomer() throws Exception{
        mockMvc.perform(get("/customers/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/findCustomer"))
                .andExpect(model().attributeExists("customer"));

        verifyZeroInteractions(customerService);
    }

    @Test
    public void initCreationForm() throws Exception {
        mockMvc.perform(get("/customers/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/createOrUpdateCustomerForm"))
                .andExpect(model().attributeExists("customer"));
    }

    @Test
    public void processCreationForm() throws Exception {
        when(customerService.save(ArgumentMatchers.any())).thenReturn(Customer.builder().c_id(1L).build());

        mockMvc.perform(post("/customers/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customers/1"))
                .andExpect(model().attributeExists("customer"));

        verify(customerService).save(ArgumentMatchers.any());
    }

    @Test
    public void initUpdateCustomerForm() throws Exception {
        when(customerService.findById(anyLong())).thenReturn(Customer.builder().c_id(1L).build());

        mockMvc.perform(get("/customers/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/createOrUpdateCustomerForm"))
                .andExpect(model().attributeExists("customer"));

        verifyZeroInteractions(customerService);
    }

    @Test
    public void processUpdateCustomerForm() throws Exception {
        when(customerService.save(ArgumentMatchers.any())).thenReturn(Customer.builder().c_id(1L).build());

        mockMvc.perform(post("/customers/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customers/1"))
                .andExpect(model().attributeExists("customer"));

        verify(customerService).save(ArgumentMatchers.any());
    }


    @Test
    public void processFindFormReturnMany() throws Exception{
        when(customerService.findAllByCNameLike(anyString()))
                .thenReturn(Arrays.asList(Customer.builder().c_id(1L).build(),
                        Customer.builder().c_id(2L).build()));

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/customerList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    public void processFindFormReturnOne() throws Exception{
        when(customerService.findAllByCNameLike(anyString())).thenReturn(Arrays.asList(Customer.builder().c_id(1L).build()));

        mockMvc.perform(get("/customers"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customers/1"));
    }

    @Test
    public void displayCustomer() throws Exception {

        when(customerService.findById(any())).thenReturn(Customer.builder().c_id(1L).build());

        mockMvc.perform(get("/customers/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/customerDetails"))
                .andExpect(model().attribute("customer", hasProperty("c_id", is(1L))));
    }



}