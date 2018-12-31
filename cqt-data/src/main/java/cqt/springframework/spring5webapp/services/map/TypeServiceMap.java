package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Type;
import cqt.springframework.spring5webapp.services.CrudService;

import java.util.Set;

public class TypeServiceMap extends AbstractMapService<Type, Long> implements CrudService<Type, Long> {

    @Override
    public Set<Type> findAll() {
        return super.findAll();
    }

    @Override
    public Type findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Type save(Type object) {
        return super.save(object.getT_id(), object);
    }

    @Override
    public void delete(Type object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}