package cqt.springframework.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "e_id")
@Builder
@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long e_id;
    @Column(name = "e_name")
    private String eName;
    private String e_password;
    private String e_email;
    @Enumerated(value = EnumType.STRING)
    private Department department;
    private String e_role;
    private int e_workload;
    @OneToMany(mappedBy = "q_employee")
    private Set<Query> e_queries = new HashSet<>();

}
