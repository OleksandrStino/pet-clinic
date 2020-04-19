package ostino.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import ostino.springframework.petclinic.models.Owner;
import ostino.springframework.petclinic.services.OwnerService;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return getMap().entrySet()
                .stream()
                .filter(entry -> entry.getValue().getLastName().equals(lastName))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
