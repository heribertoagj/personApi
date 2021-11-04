package one.digitalInnovation.personApi.service;

import one.digitalInnovation.personApi.dto.MessageResponseDTO;
import one.digitalInnovation.personApi.dto.request.PersonDTO;
import one.digitalInnovation.personApi.entity.Person;
import one.digitalInnovation.personApi.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static one.digitalInnovation.personApi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    @Test
    void testGivenPersonDTOThenReturnPersonAllList() {
        List<PersonDTO> expectedListPerson = listFakePersonDTO();
        List<Person> allPerson = listFakePerson();

        when(personRepository.findAll()).thenReturn(allPerson);
        List<PersonDTO> allPersonDTO = personService.listAll();

        for (int i=0; i < allPersonDTO.size(); i++){
            assertEquals(allPersonDTO.get(i).getId(), expectedListPerson.get(i).getId());
        }
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
