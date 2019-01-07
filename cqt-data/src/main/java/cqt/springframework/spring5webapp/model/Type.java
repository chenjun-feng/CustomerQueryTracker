package cqt.springframework.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "t_id")
@Builder
@Entity(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long t_id;
    private String t_name;
    private String department;
    @OneToMany(mappedBy = "q_type")
    private Set<Query> t_queries = new HashSet<>();

}
