package com.studyproject.graphql.web;

import com.studyproject.graphql.entity.Animal;
import com.studyproject.graphql.service.AnimalService;
import com.studyproject.graphql.service.AnimalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalServiceImpl animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animals = animalService.retrieveAllAnimals();
        return ResponseEntity.ok(animals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        Optional<Animal> animalOptional = animalService.retrieveAnimalById(id);
        return animalOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/breed")
    public ResponseEntity<List<String>> getAnimalBreeds() {
        List<String> list = animalService.retrieveAnimalBreeds();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<String>> getAnimalNames() {
        List<String> list = animalService.retrieveAnimalNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}
