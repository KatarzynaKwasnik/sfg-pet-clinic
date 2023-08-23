package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Long ownerId = 1l;

    @BeforeEach
    void setUp() {//PetTypeMapService, PetMapService normelnie trzeba byłoby zamockować,
        // ale implementacje są proste i odnoszą się do mapy, więc można ich użyć
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName("Kowalski").build());//
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2l;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoExistingId() {
        Owner owner2 = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        String lastName = "Kowalski";
        Owner owner = ownerMapService.findByLastName(lastName);

        assertEquals((lastName), owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        String lastName = "foo";
        Owner owner = ownerMapService.findByLastName(lastName);

        assertNull(owner);
    }
}