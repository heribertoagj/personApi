package one.digitalInnovation.personApi.utils;

import one.digitalInnovation.personApi.dto.request.PersonDTO;
import one.digitalInnovation.personApi.entity.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);
    public static final int LIST_SIZE = 3;


    public static List<PersonDTO> listFakePersonDTO(){
        List<PersonDTO> listFakePersonDTO = new ArrayList<>();
        for (int i=0; i < LIST_SIZE; i++)
        listFakePersonDTO.add(PersonDTO.builder()
                .id(PERSON_ID + i)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build());

        return listFakePersonDTO;
    }

    public static List<Person> listFakePerson(){
        List<Person> listFakePerson = new ArrayList<>();
        for (int i=0; i < LIST_SIZE; i++)
        listFakePerson.add(
                Person.builder()
                        .id(PERSON_ID + i)
                        .firstName(FIRST_NAME)
                        .lastName(LAST_NAME)
                        .cpf(CPF_NUMBER)
                        .birthDate(BIRTH_DATE)
                        .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                        .build());


        return listFakePerson;
    }

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}