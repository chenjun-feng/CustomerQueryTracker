package cqt.springframework.spring5webapp.services;

import cqt.springframework.spring5webapp.model.Employee;

public interface EmployeeService extends CrudService<Employee, Long>{

    Employee findByName(String name);
}
