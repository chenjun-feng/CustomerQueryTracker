package cqt.springframework.spring5webapp.services;

import cqt.springframework.spring5webapp.model.Department;
import cqt.springframework.spring5webapp.model.Employee;

import java.util.List;

public interface EmployeeService extends CrudService<Employee, Long>{

    Employee findByEName(String name);

    List<Employee> findAllByDepartment(Department department);

    Employee selectLowestWorkloadEmployee(Department department);
}
