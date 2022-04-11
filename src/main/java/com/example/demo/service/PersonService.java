package com.example.demo.service;

import com.example.demo.dto.Person;
import com.example.demo.model.PersonEntity;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(String firstName, String lastName) {
        Person person = new Person(firstName, lastName, null);
        PersonEntity savedPersonEntity = personRepository.save(person.convertToEntity());
        return new Person(savedPersonEntity);
    }

    public String deletePerson(Integer id) {
        personRepository.deleteById(id);
        return id.toString();
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll().stream().map(Person::new).collect(Collectors.toList());
    }

}
