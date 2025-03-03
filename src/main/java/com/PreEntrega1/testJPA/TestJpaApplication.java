package com.PreEntrega1.testJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.PreEntrega1.testJPA.service.AnimalService;
import com.PreEntrega1.testJPA.service.CabaniaService;

import java.util.Date;

@SpringBootApplication
public class TestJpaApplication implements CommandLineRunner {
    @Autowired
    private CabaniaService cabaniaService;

    @Autowired
    private AnimalService animalService;

    public static void main(String[] args) {
        SpringApplication.run(TestJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("API REST - Entregable 1");
        Cabania cab1 = new Cabania("Prueba", "Mi PC", "456");
        Cabania cab2 = new Cabania("El establo", "ruta 2", "1256");
        Cabania cab3 = new Cabania("suffolk", "ruta 3", "1256");

        try {
            cabaniaService.saveCabania(cab1);
            cabaniaService.saveCabania(cab2);
            cabaniaService.saveCabania(cab3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Animal animal = new Animal("caballo", "criollo", "macho", new Date(), "2034",
                "caballo de carrera", "marron", cab1, null);
        Animal animal1 = new Animal("obeja", "criolla", "hembra", new Date(), "3042",
                "caballo de carrera", "marron", cab2, null);
        Animal animal2 = new Animal("caballo", "criollo", "hembra", new Date(), "9638",
                "caballo de carrera", "marron", cab3, "2034"); // Cambiar de 2034l a "2034"

        try {
            animalService.saveAnimal(animal);
            animalService.saveAnimal(animal1);
            animalService.saveAnimal(animal2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
