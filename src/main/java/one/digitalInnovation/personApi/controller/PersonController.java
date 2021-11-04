package one.digitalInnovation.personApi.controller;

import one.digitalInnovation.personApi.dto.MessageResponseDTO;
import one.digitalInnovation.personApi.dto.request.PersonDTO;
import one.digitalInnovation.personApi.exception.PersonNotFoundException;
import one.digitalInnovation.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson (@RequestBody  @Valid PersonDTO personDTO){
        return this.personService.createPerson(personDTO);
    }


    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable  Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
}
