package com.studyproject.graphql.mutator;

import com.studyproject.graphql.entity.Animal;
import com.studyproject.graphql.exception.AnimalNotFoundException;
import com.studyproject.graphql.exception.BreedNotFoundException;
import com.studyproject.graphql.repository.AnimalRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final AnimalRepository animalRepository;

    public Animal newAnimal(String name, String breed, String gender) {
        Animal animal = new Animal();
        animal.setName(name);
        animal.setBreed(breed);
        animal.setGender(gender);
        animalRepository.save(animal);
        return animal;
    }

    public boolean deleteAnimal(Long id) {
        animalRepository.deleteById(id);
        return true;
    }

    public boolean deleteAnimalByBreed(String breed) {
        boolean deleted = false;
        Iterable<Animal> allAnimals = animalRepository.findAll();

        for (Animal d:allAnimals) {
            if (d.getBreed().equals(breed)) {
                animalRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public Animal updateAnimalName(String newName, Long id) {
        Optional<Animal> optionalLocation =
                animalRepository.findById(id);

        if (optionalLocation.isPresent()) {
            Animal animal = optionalLocation.get();
            animal.setName(newName);
            animalRepository.save(animal);
            return animal;
        } else {
            throw new AnimalNotFoundException("Animal Not Found", id);
        }
    }
}
