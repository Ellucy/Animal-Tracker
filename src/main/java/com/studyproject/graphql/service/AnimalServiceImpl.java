package com.studyproject.graphql.service;

import com.studyproject.graphql.entity.Animal;
import com.studyproject.graphql.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public List<Animal> retrieveAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Optional<Animal> retrieveAnimalById(Long id) {
        return Optional.ofNullable(animalRepository.findById(id).orElse(null));
    }

    @Override
    public List<String> retrieveAnimalBreeds() {
        return (List<String>) animalRepository.findAllBreeds();
    }

    @Override
    public List<String> retrieveAnimalNames() {
        return (List<String>) animalRepository.findAllNames();
    }
}
