package com.PreEntrega1.testJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PreEntrega1.testJPA.Animal;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // Animal findAnimalByCaravana(String caravana);
    boolean existsByCaravana(String numeroCaravana);
    Optional<Animal> findByCaravana(String numeroCaravana);
}
