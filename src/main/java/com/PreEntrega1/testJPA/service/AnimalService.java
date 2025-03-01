package com.PreEntrega1.testJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PreEntrega1.testJPA.Animal;
import com.PreEntrega1.testJPA.Cabania;
import com.PreEntrega1.testJPA.repository.AnimalRepository;
import com.PreEntrega1.testJPA.repository.CabaniaRepository;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CabaniaRepository cabaniaRepository;

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public String createAnimalWithCabania(Animal animal, Long cabaniaId) throws Exception {
        Cabania cabania = cabaniaRepository.findById(cabaniaId)
                .orElseThrow(() -> new Exception("Cabaña no encontrada"));
        animal.setCabania(cabania);
        animalRepository.save(animal);
        return "Animal Creado con éxito";
    }
}
