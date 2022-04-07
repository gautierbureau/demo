package com.example.demo.controller;

import com.example.demo.dto.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Person server")
@AllArgsConstructor
public class PersonController {

    @PostMapping(value = "/person")
    @Operation(summary = "Create a person with its first name and last name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The new person"),
            @ApiResponse(responseCode = "404", description = "Person not found")})
    public ResponseEntity<Person> newPerson(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new Person(1, firstName, lastName));
    }
}
