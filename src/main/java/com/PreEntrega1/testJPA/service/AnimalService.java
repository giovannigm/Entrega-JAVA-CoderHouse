package com.PreEntrega1.testJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PreEntrega1.testJPA.Animal;
import com.PreEntrega1.testJPA.repository.AnimalRepository;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

}
