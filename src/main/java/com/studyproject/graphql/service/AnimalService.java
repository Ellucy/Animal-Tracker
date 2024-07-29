package com.studyproject.graphql.service;

import com.studyproject.graphql.entity.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    List<Animal> retrieveAllAnimals();
    Optional<Animal> retrieveAnimalById(Long id);
    List<String> retrieveAnimalBreeds();
    List<String> retrieveAnimalNames();
}
