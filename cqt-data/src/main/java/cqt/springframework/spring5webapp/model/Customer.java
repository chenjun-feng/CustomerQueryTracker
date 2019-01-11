package cqt.springframework.spring5webapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "c_id")
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

    @Builder
    public Customer(Long c_id, String cName, String c_password, String c_email, boolean c_status, Set<Order> c_orders, Set<Query> c_queries) {
        this.c_id = c_id;
        this.cName = cName;
        this.c_password = c_password;
        this.c_email = c_email;
        this.c_status = c_status;
        this.c_orders = c_orders;
        if (c_orders != null) this.c_orders = c_orders;
        if (c_queries != null) this.c_queries = c_queries;
    }

    // == methods ==
    public boolean isNew() {
        return this.c_id == null;
    }

    // Return the Query with the given order id, or null if none found for this customer
    public Query getQuery(Order order) {
        return getQuery(order, false);
    }

    // Return the Query with the given order id, or null if none found for this customer
    public Query getQuery(Order order, boolean ignoreNew) {
        for (Query query : c_queries) {
            if (!ignoreNew || !query.isNew()) {
                Order compOrder = query.getQ_order();
                if (compOrder.equals(order)) return query;
            }
        }

        return null;
    }
}


