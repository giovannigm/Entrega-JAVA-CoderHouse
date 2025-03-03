package com.PreEntrega1.testJPA.Controller;

import java.util.List;
import com.PreEntrega1.testJPA.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;

import com.PreEntrega1.testJPA.service.AnimalService;

@RestController
@RequestMapping("/Animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/all")
    // API: http://localhost:8080/Animal/all
    public List<Animal> getAllAnimals() {
        return animalService.findAll();
    }

    @PostMapping("/create")
    // API: http://localhost:8080/Animal/create?cabaniaId=1
    // Params: cabaniaId=1
    // body: {
    // "edad": 5,
    // "color": "marrón",
    // "especie": "vaca",
    // "sexo": "hembra",
    // "descripcion": "Una vaca marrón",
    // "raza": "Holstein",
    // "caravana": "12546",
    // "numero_carabana_madre": 3042
    // }
    public ResponseEntity<String> createAnimal(@RequestBody Animal animal, @RequestParam Long cabaniaId) {
        try {
            String createdAnimal = animalService.createAnimalWithCabania(animal, cabaniaId);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}