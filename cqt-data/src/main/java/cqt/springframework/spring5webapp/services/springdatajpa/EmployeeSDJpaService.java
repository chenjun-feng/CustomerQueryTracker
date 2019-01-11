package cqt.springframework.spring5webapp.services.springdatajpa;

import cqt.springframework.spring5webapp.model.Department;
import cqt.springframework.spring5webapp.model.Employee;
import cqt.springframework.spring5webapp.repositories.EmployeeRepository;
import cqt.springframework.spring5webapp.services.EmployeeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class EmployeeSDJpaService implements EmployeeService {

    // == fields ==
    private final EmployeeRepository employeeRepository;

    // == constructor ==
    public EmployeeSDJpaService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // == public methods ==

    @Override
    public Employee findByEName(String name) {
        return employeeRepository.findByEName(name);
    }

    @Override
    public List<Employee> findAllByDepartment(Department department) {
        return employeeRepository.findAllByDepartment(department);
    }

    // find the employee of given department with lowest workload
    public Employee selectLowestWorkloadEmployee(Department department) {
        List<Employee> employees = findAllByDepartment(department);
        int minWorkload = Integer.MAX_VALUE;
        Employee selectedEmp = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getE_workload() <= minWorkload) {
                minWorkload = employee.getE_workload();
                selectedEmp = employee;
            }
        }

        return selectedEmp;
    }

    @Override
    public Set<Employee> findAll() {
        Set<Employee> employees = new HashSet<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public Employee findById(Long aLong) {
        return employeeRepository.findById(aLong).orElse(null) ;
    }

    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public void delete(Employee object) {
        employeeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        employeeRepository.deleteById(aLong);
    }
}
