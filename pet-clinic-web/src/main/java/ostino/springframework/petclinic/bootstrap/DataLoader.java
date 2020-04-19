package ostino.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ostino.springframework.petclinic.models.Owner;
import ostino.springframework.petclinic.models.Vet;
import ostino.springframework.petclinic.services.OwnerService;
import ostino.springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Scot");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alex");
        vet2.setLastName("Gor");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
