package cqt.springframework.spring5webapp.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate o_date;
    private double o_amount;
    @ManyToOne
    private Customer o_customer;

    @Override
    public String toString() {
        //return "" + o_id;
        return "ID: " + o_id + " , Date: " + o_date + " , Amount: $" + o_amount;
    }
}

