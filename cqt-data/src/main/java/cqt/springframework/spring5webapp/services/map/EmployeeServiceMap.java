package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Employee;
import cqt.springframework.spring5webapp.services.CrudService;

import java.util.Set;

public class EmployeeServiceMap extends AbstractMapService<Employee, Long> implements CrudService<Employee, Long> {

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
}
