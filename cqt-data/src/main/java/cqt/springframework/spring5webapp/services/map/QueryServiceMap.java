package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Query;
import cqt.springframework.spring5webapp.services.CrudService;

import java.util.Set;

public class QueryServiceMap extends AbstractMapService<Query, Long> implements CrudService<Query, Long> {

    @Override
    public Set<Query> findAll() {
        return super.findAll();
    }

    @Override
    public Query findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Query save(Query object) {
        return super.save(object.getQ_id(), object);
    }

    @Override
    public void delete(Query object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
