package com.example.demo.controller;

import com.example.demo.dto.Person;
import com.example.demo.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Person server")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "/person")
    @Operation(summary = "Create a person with its first name and last name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The new person"),
            @ApiResponse(responseCode = "404", description = "Person not found")})
    public ResponseEntity<Person> newPerson(@RequestParam("first_name") String firstName,
                                            @RequestParam("last_name") String lastName) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(personService.create(firstName, lastName));
    }

    @DeleteMapping(value = "/person/{id}")
    @Operation(summary = "Delete a person")
    @ApiResponse(responseCode = "200", description = "Person deleted")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(
                personService.deletePerson(id));
    }

    @GetMapping(value = "/")
    @Operation(summary = "Get all persons")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "The list of persons")})
    public ResponseEntity<List<Person>> getPersonList() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(personService.getAllPersons());
    }
}
