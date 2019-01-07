package cqt.springframework.spring5webapp.services.springdatajpa;

import cqt.springframework.spring5webapp.model.Query;
import cqt.springframework.spring5webapp.repositories.QueryRepository;
import cqt.springframework.spring5webapp.services.QueryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class QuerySDJpaService implements QueryService {

    // == fields ==
    private final QueryRepository queryRepository;

    // == constructor ==
    public QuerySDJpaService(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    // == public methods ==
    @Override
    public Set<Query> findAll() {
        Set<Query> queries = new HashSet<>();
        queryRepository.findAll().forEach(queries::add);
        return queries;
    }

    @Override
    public Query findById(Long aLong) {
        return queryRepository.findById(aLong).orElse(null);
    }

    @Override
    public Query save(Query object) {
        return queryRepository.save(object);
    }

    @Override
    public void delete(Query object) {
        queryRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        queryRepository.deleteById(aLong);
    }
}
