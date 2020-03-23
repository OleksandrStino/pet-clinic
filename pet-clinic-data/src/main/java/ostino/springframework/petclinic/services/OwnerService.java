package ostino.springframework.petclinic.services;

import ostino.springframework.petclinic.models.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Set<Owner> findByLastName(String lastName);

}
