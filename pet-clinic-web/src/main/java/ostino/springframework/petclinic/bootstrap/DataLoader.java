package ostino.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ostino.springframework.petclinic.models.Owner;
import ostino.springframework.petclinic.models.Vet;
import ostino.springframework.petclinic.services.OwnerService;
import ostino.springframework.petclinic.services.VetService;
import ostino.springframework.petclinic.services.map.OwnerServiceMap;
import ostino.springframework.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Scot");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Sam");
        vet.setLastName("Axe");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Alex");
        vet2.setLastName("Gor");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
