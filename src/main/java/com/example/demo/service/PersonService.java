package com.example.demo.service;

import com.example.demo.dto.Person;
import com.example.demo.model.PersonEntity;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        PersonEntity savedPersonEntity = personRepository.save(person.convertToEntity());
        return new Person(savedPersonEntity);
    }
}
