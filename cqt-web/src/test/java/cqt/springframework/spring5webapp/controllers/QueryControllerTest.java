package cqt.springframework.spring5webapp.controllers;

import cqt.springframework.spring5webapp.model.*;
import cqt.springframework.spring5webapp.services.*;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class QueryControllerTest {

    @Mock
    QueryService queryService;
    @Mock
    CustomerService customerService;
    @Mock
    EmployeeService employeeService;
    @Mock
    OrderService orderService;
    @Mock
    TypeService typeService;

    @Mock
    Model model;

    @InjectMocks
    QueryController queryController;

    MockMvc mockMvc;

    Customer customer;
    Order order;
    Employee employee;
    Set<Type> types;

    @BeforeEach
    void setUp() {
        customer = Customer.builder().c_id(1L).build();
        order = Order.builder().o_id(1L).build();
        employee = Employee.builder().e_id(1L).build();

        types = new HashSet<>();
        types.add(Type.builder().t_id(1L).t_name("defect").build());
        types.add(Type.builder().t_id(2L).t_name("wrong size").build());

        mockMvc = MockMvcBuilders.standaloneSetup(queryController).build();
    }

    @Test
    void initCreationQueryForm() throws Exception {
        when(customerService.findById(anyLong())).thenReturn(customer);
        when(typeService.findAll()).thenReturn(types);

        mockMvc.perform(get("/customers/1/queries/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("query"))
                .andExpect(model().attributeExists("customer"))
                .andExpect(view().name("queries/createOrUpdateQueryForm"));
    }

    @Test
    void processCreationQueryForm() throws Exception {
        when(customerService.findById(anyLong())).thenReturn(customer);
        when(typeService.findAll()).thenReturn(types);

        mockMvc.perform(post("/customers/1/queries/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customers/1"));

        verify(queryService).save(any());
    }

    @Test
    void initUpdateQueryForm() throws Exception {
        when(customerService.findById(anyLong())).thenReturn(customer);
        when(typeService.findAll()).thenReturn(types);
        when(queryService.findById(anyLong())).thenReturn(Query.builder().q_id(2L).build());

        mockMvc.perform(get("/customers/1/queries/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("query"))
                .andExpect(model().attributeExists("customer"))
                .andExpect(view().name("queries/createOrUpdateQueryForm"));
    }

    @Test
    void processUpdateQueryForm() throws Exception {
        when(customerService.findById(anyLong())).thenReturn(customer);
        when(typeService.findAll()).thenReturn(types);

        mockMvc.perform(post("/customers/1/queries/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customers/1"));

        verify(queryService).save(any());
    }


}