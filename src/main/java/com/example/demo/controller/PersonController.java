package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PersonController {

    @PostMapping(value = "/person")
    public ResponseEntity<String> newPerson(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName) {
        String name = firstName + " " + lastName;
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(name);
    }
}
