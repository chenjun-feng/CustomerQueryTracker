package cqt.springframework.spring5webapp.repositories;

import cqt.springframework.spring5webapp.model.Department;
import cqt.springframework.spring5webapp.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByEName(String name);

    List<Employee> findAllByDepartment(Department department);
}
