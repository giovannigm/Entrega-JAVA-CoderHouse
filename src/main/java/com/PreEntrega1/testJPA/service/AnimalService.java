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
        if (!animal.isActivo()) {
            throw new Exception("No se puede crear un animal que no esté activo");
        }

        Cabania cabania = cabaniaRepository.findById(cabaniaId)
                .orElseThrow(() -> new Exception("Cabaña no encontrada"));
        
        if (animalRepository.existsByCaravana(animal.getCaravana())) {
            throw new Exception("Ya existe un animal con el número de caravana proporcionado");
        }

        if (animal.getNumero_carabana_madre() != null) {
            Animal madre = animalRepository.findByCaravana(animal.getNumero_carabana_madre())
                    .orElseThrow(() -> new Exception("No existe un animal con el número de caravana de la madre proporcionado"));
            if (!"hembra".equalsIgnoreCase(madre.getSexo())) {
                throw new Exception("El número de caravana proporcionado pertenece a un macho");
            }
        }

        animal.setCabania(cabania);
        animalRepository.save(animal);
        return "Animal Creado con éxito";
    }

    public String deleteAnimal(String numeroCaravana, String comentarioBaja) throws Exception {
        Animal animal = animalRepository.findByCaravana(numeroCaravana)
                .orElseThrow(() -> new Exception("Animal no encontrado"));
        
        if (!animal.isActivo()) {
            throw new Exception("El animal ya está dado de baja");
        }

        animal.setComentarioBaja(comentarioBaja);
        animal.setActivo(false);
        animalRepository.save(animal);
        return "Animal dado de baja con éxito";
    }
}
