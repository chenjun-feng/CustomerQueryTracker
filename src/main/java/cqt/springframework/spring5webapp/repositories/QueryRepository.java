package cqt.springframework.spring5webapp.repositories;

import cqt.springframework.spring5webapp.model.Query;
import org.springframework.data.repository.CrudRepository;

public interface QueryRepository extends CrudRepository<Query, Long> {
}
