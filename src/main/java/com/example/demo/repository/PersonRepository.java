package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PersonEntity;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
