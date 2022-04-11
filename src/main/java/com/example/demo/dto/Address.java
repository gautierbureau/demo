package com.example.demo.dto;

// import com.example.demo.dto.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String number;

    private String street;

    private String city;

    private String country;

    private Integer zipCode;

    // private List<Person> persons;
}
