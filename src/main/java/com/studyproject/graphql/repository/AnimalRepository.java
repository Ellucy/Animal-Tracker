package com.studyproject.graphql.repository;

import com.studyproject.graphql.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT DISTINCT a.breed FROM Animal a")
    List<String> findAllBreeds();

    @Query("SELECT a.name FROM Animal a")
    List<String> findAllNames();
}
