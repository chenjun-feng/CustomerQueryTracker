package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Department;
import cqt.springframework.spring5webapp.model.Employee;
import cqt.springframework.spring5webapp.services.EmployeeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class EmployeeMapService extends AbstractMapService<Employee, Long> implements EmployeeService {

    @Override
    public Set<Employee> findAll() {
        return super.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Employee save(Employee object) {
        return super.save(object.getE_id(), object);
    }

    @Override
    public void delete(Employee object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Employee findByEName(String name) {
        return null;
    }

    @Override
    public List<Employee> findAllByDepartment(Department department) {
        return null;
    }

    @Override
    public Employee selectLowestWorkloadEmployee(Department department) {
        return null;
    }
}
