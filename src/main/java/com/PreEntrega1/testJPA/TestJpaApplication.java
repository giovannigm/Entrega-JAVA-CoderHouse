package com.PreEntrega1.testJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.PreEntrega1.testJPA.service.AnimalService;
import com.PreEntrega1.testJPA.service.CabaniaService;

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
        System.out.println("Primera Pre-Entrega 1");
        Cabania cab1 = new Cabania("El desafio", "ruta 1", "1256");
        Cabania cab2 = new Cabania("El establo", "ruta 2", "1256");
        Cabania cab3 = new Cabania("suffolk", "ruta 3", "1256");

        try {
            cabaniaService.saveCabania(cab1);
            cabaniaService.saveCabania(cab2);
            cabaniaService.saveCabania(cab3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Animal animal = new Animal("caballo", "criollo", "macho", 5, "123456",
        "caballo de carrera", "marron", cab1);
        Animal animal1 = new Animal("obeja", "criolla", "hembra", 2, "123456",
        "caballo de carrera", "marron", cab2);
        Animal animal2 = new Animal("caballo", "criollo", "hembra", 5, "123456",
        "caballo de carrera", "marron", cab3);

        try {
            animalService.saveAnimal(animal);
            animalService.saveAnimal(animal1);
            animalService.saveAnimal(animal2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
