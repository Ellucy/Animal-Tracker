package com.studyproject.graphql.resolver;

import com.studyproject.graphql.entity.Animal;
import com.studyproject.graphql.exception.AnimalNotFoundException;
import com.studyproject.graphql.repository.AnimalRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final AnimalRepository animalRepository;

    public Iterable<Animal> findAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal findAnimalById(Long id) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            return optionalAnimal.get();
        } else {
            throw new AnimalNotFoundException("Animal Not Found", id);
        }
    }
}

//    public List<String> findAnimalBreeds() {
//        return (List<String>) animalRepository.findAllBreeds();
//    }
//
//    public List<String> findAnimalNames() {
//        return (List<String>) animalRepository.findAllNames();
//    }
// }
