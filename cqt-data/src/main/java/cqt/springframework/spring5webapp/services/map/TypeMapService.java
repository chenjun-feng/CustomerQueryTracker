package cqt.springframework.spring5webapp.services.map;

import cqt.springframework.spring5webapp.model.Type;
import cqt.springframework.spring5webapp.services.TypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class TypeMapService extends AbstractMapService<Type, Long> implements TypeService {

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
