package cqt.springframework.spring5webapp.repositories;

import cqt.springframework.spring5webapp.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
