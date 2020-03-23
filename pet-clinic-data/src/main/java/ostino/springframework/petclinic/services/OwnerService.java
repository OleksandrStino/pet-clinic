package ostino.springframework.petclinic.services;

import ostino.springframework.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
