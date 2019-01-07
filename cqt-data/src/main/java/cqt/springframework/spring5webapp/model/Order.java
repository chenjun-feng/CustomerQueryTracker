package cqt.springframework.spring5webapp.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "o_id")
@Builder
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long o_id;
    @Type(type = "date")
    private Date o_date;
    private double o_amount;
    @ManyToOne
    private Customer o_customer;

}

