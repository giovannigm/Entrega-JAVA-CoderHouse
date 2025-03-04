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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.Map;

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

    @PostMapping("/create/{cabaniaId}")
    // API: http://localhost:8080/Animal/create/1
    // body: {
    // "ingreso": "2025-03-04T00:06:29.990+00:00",
    // "activo": true,
    // "color": "gris",
    // "especie": "obeja",
    // "sexo": "hembraaaa",
    // "descripcion": "Una vaca marrón",
    // "raza": "Holstein",
    // "caravana": "125446",
    // "numero_carabana_madre": null,
    // "comentarioBaja": null
    // }
    public ResponseEntity<String> createAnimal(@RequestBody Animal animal, @PathVariable Long cabaniaId) {
        try {
            String createdAnimal = animalService.createAnimalWithCabania(animal, cabaniaId);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/update/{numeroCaravana}")
    // API: http://localhost:8080/Animal/update/9638
    // body: {
    // "comentarioBaja": "Animal muerto en cañada",
    // "activo": true
    // }
    public ResponseEntity<String> updateAnimal(@PathVariable String numeroCaravana,
            @RequestBody Map<String, Object> body) {
        try {
            String comentarioBaja = (String) body.get("comentarioBaja");
            boolean activo = (boolean) body.get("activo");
            String result = animalService.updateAnimal(numeroCaravana, comentarioBaja, activo);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    
}