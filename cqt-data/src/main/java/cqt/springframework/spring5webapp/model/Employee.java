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
@EqualsAndHashCode(of = "e_id")
@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long e_id;
    private String e_name;
    private String e_password;
    private String e_email;
    private String department;
    private String e_role;
    private int e_workload;
    @OneToMany(mappedBy = "q_employee")
    private List<Query> e_queries;

}
