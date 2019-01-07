package cqt.springframework.spring5webapp.services.springdatajpa;

import cqt.springframework.spring5webapp.model.Type;
import cqt.springframework.spring5webapp.repositories.TypeRepository;
import cqt.springframework.spring5webapp.services.TypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class TypeSDJpaService implements TypeService {

    // == fields ==
    private final TypeRepository typeRepository;

    // == constructor ==
    public TypeSDJpaService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    // == public methods ==
    @Override
    public Set<Type> findAll() {
        Set<Type> types = new HashSet<>();
        typeRepository.findAll().forEach(types::add);
        return types;
    }

    @Override
    public Type findById(Long aLong) {
        return typeRepository.findById(aLong).orElse(null) ;
    }

    @Override
    public Type save(Type object) {
        return typeRepository.save(object);
    }

    @Override
    public void delete(Type object) {
        typeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        typeRepository.deleteById(aLong);
    }
}
