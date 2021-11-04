package one.digitalInnovation.personApi.controller;

import one.digitalInnovation.personApi.dto.MessageResponseDTO;
import one.digitalInnovation.personApi.entity.Person;
import one.digitalInnovation.personApi.repository.PersonRepository;
import one.digitalInnovation.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson (@RequestBody Person person){
        return this.personService.createPerson(person);
    }
}
