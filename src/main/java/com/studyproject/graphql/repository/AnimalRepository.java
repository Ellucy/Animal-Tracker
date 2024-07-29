package com.studyproject.graphql.repository;

import com.studyproject.graphql.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
