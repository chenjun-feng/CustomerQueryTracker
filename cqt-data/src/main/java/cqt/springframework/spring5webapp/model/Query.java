package cqt.springframework.spring5webapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "q_id")
@Builder
@Entity(name = "queries")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long q_id;
    private boolean q_status;
    private int q_feedback;
    @ManyToOne
    private Type q_type;
    @ManyToOne
    private Customer q_customer;
    @ManyToOne
    private Order q_order;
    @ManyToOne
    private Employee q_employee;

    // == methods ==
    public boolean isNew() {
        return this.q_id == null;
    }
}
