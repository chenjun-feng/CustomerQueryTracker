package cqt.springframework.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "c_id")
@Builder
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long c_id;
    @Column(name = "c_name")
    private String cName;
    private String c_password;
    private String c_email;
    private boolean c_status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "o_customer")
    private Set<Order> c_orders = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "q_customer")
    private Set<Query> c_queries = new HashSet<>();

    // == methods ==
    public boolean isNew() {
        return this.c_id == null;
    }

}

