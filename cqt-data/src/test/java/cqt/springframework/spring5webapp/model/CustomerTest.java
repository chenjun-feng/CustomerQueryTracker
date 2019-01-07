package cqt.springframework.spring5webapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void getC_id() {
        Long idValue = 4L;

        customer.setC_id(idValue);

        assertEquals(idValue, customer.getC_id());
    }

    @Test
    public void getCName() {
    }

    @Test
    public void getC_password() {
    }
}