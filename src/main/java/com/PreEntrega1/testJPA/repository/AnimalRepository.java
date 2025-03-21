package com.PreEntrega1.testJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PreEntrega1.testJPA.Animal;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    boolean existsByCaravana(int numeroCaravana); // Cambiado de String a int
    Optional<Animal> findByCaravana(int numeroCaravana); // Cambiado de String a int
}
