package guru.springframework.sfgpetclinic.services.springDatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Long ownerId = 1l;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findAll() {
        Set<Owner> ownersData = Set.of(Owner.builder().id(ownerId).build());
        when(ownerRepository.findAll()).thenReturn(ownersData);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner ownerData = Owner.builder().id(ownerId).build();
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(ownerData));

        Owner owner = ownerSDJpaService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        Owner ownerData = Owner.builder().id(ownerId).build();
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findById(ownerId);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerData = Owner.builder().build();
        when(ownerRepository.save(any())).thenReturn(ownerData);

        Owner owner = ownerRepository.save(ownerData);

        assertNull(owner.getId());
        verify(ownerRepository).save(any()); //weryfikuje czy pojawiła się interakcja z Mock
    }

    @Test
    void delete() {
        Owner ownerData = Owner.builder().id(ownerId).build();
        ownerRepository.delete(ownerData);
        verify(ownerRepository, times(1)).delete(any());//sprawdzamy czy się wykonała, bo delete jest void i trudno inaczej to zweryfikować
    }

    @Test
    void deleteById() {
        ownerRepository.deleteById(ownerId);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        String lastName = "smith";
        Owner ownerData = Owner.builder().id(ownerId).lastName(lastName).build();
        when(ownerRepository.findAllByLastName(any())).thenReturn(ownerData);

        Owner owner = ownerRepository.findAllByLastName(lastName);

        assertEquals(lastName, owner.getLastName());
        verify(ownerRepository, times(1)).findAllByLastName(any());
    }
}