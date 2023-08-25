package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;
    Long petId = 1l;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(petId);

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(petId));

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Pet newPet = Pet.builder().id(2l).build();
        Pet savedPet = petMapService.save(newPet);

        assertEquals(2l, savedPet.getId());
    }

    @Test
    void saveNoId() {
        Pet newPet = Pet.builder().build();
        Pet savedPet = petMapService.save(newPet);

        assertNotNull(savedPet.getId());
    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(petId);

        assertEquals(petId, null);
    }
}