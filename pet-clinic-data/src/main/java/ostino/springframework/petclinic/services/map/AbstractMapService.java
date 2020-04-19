package ostino.springframework.petclinic.services.map;

import ostino.springframework.petclinic.models.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        T savedObject = null;
        if (object != null) {
            if (object.getId() == null) {
                object.setId(nextId());
            }
            savedObject = map.put(object.getId(), object);
        } else {
            throw new IllegalArgumentException("Failed to save entity. Object is null");
        }
        return savedObject;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public Map<Long, T> getMap() {
        return Collections.unmodifiableMap(map);
    }

    private Long nextId() {
        return map.keySet().isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }
}
