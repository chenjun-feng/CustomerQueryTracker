package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Query;
import cqt.springframework.spring5webapp.services.QueryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class QueryMapService extends AbstractMapService<Query, Long> implements QueryService {

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
