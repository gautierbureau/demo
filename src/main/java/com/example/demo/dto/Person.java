package com.example.demo.dto;

import com.example.demo.model.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String firstName;

    private String lastName;

    // private Address address;

    public PersonEntity convertToEntity() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(this.firstName);
        personEntity.setLastName(this.firstName);
        return personEntity;
    }

    public Person(PersonEntity personEntity) {
        firstName = personEntity.getFirstName();
        lastName = personEntity.getLastName();
    }
}
