package one.digitalInnovation.personApi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import one.digitalInnovation.personApi.dto.MessageResponseDTO;
import one.digitalInnovation.personApi.dto.request.PersonDTO;
import one.digitalInnovation.personApi.entity.Person;
import one.digitalInnovation.personApi.mapper.PersonMapper;
import one.digitalInnovation.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = this.personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }


}
