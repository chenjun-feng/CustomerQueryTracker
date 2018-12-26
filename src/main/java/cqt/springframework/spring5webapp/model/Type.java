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
@EqualsAndHashCode(of = "t_id")
@Entity(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long t_id;
    private String t_name;
    private String department;
    @OneToMany(mappedBy = "q_type")
    private List<Query> t_queries;

}
