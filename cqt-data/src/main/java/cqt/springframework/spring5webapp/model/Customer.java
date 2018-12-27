package cqt.springframework.spring5webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "c_id")
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long c_id;
    private String c_name;
    private String c_password;
    private String c_email;
    private boolean c_status;
    @OneToMany(mappedBy = "o_customer")
    private List<Order> c_orders;
    @OneToMany(mappedBy = "q_customer")
    private List<Query> c_queries;

}

