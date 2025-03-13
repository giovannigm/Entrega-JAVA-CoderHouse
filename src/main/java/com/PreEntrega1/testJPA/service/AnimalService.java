package com.PreEntrega1.testJPA.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PreEntrega1.testJPA.Animal;
import com.PreEntrega1.testJPA.Cabania;
import com.PreEntrega1.testJPA.dto.AnimalDTO;
import com.PreEntrega1.testJPA.dto.CabaniaDTO;
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
                    .filter(Animal::isActivo)
                    .orElseThrow(() -> new Exception(
                            "No existe una madre con ese número de caravana o la madre no está activa"));
            if (!"hembra".equalsIgnoreCase(madre.getSexo())) {
                throw new Exception("El número de caravana proporcionado pertenece a un macho");
            }
        }

        animal.setCabania(cabania);
        animalRepository.save(animal);
        return "Animal Creado con éxito";
    }

    public String updateAnimal(String numeroCaravana, String comentarioBaja, boolean activo) throws Exception {
        Animal animal = animalRepository.findByCaravana(numeroCaravana)
                .orElseThrow(() -> new Exception("Animal no encontrado"));

        if (animal.isActivo() == activo) {
            if (activo) {
                throw new Exception("El animal ya está activo");
            } else {
                throw new Exception("El animal ya está dado de baja");
            }
        }

        if (activo) {
            animal.setComentarioBaja(null);
        } else {
            animal.setComentarioBaja(comentarioBaja);
        }

        animal.setActivo(activo);
        animalRepository.save(animal);
        return "Animal actualizado con éxito";
    }

    public void deleteAnimalByCaravana(String numeroCaravana) throws Exception {
        Animal animal = animalRepository.findByCaravana(numeroCaravana)
                .orElseThrow(() -> new Exception("Animal no encontrado"));
        animalRepository.delete(animal);
    }

    public List<AnimalDTO> listarAnimales() {
        List<Animal> animales = findAll();
        return animales.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private AnimalDTO convertToDTO(Animal animal) {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setIngreso(animal.getIngreso());
        animalDTO.setActivo(animal.isActivo());
        animalDTO.setColor(animal.getColor());
        animalDTO.setEspecie(animal.getEspecie());
        animalDTO.setSexo(animal.getSexo());
        animalDTO.setDescripcion(animal.getDescripcion());
        animalDTO.setRaza(animal.getRaza());
        animalDTO.setCaravana(animal.getCaravana());
        animalDTO.setNumero_carabana_madre(animal.getNumero_carabana_madre());
        animalDTO.setComentarioBaja(animal.getComentarioBaja());
        animalDTO.setCabania(convertToCabaniaDTO(animal.getCabania()));
        return animalDTO;
    }

    private CabaniaDTO convertToCabaniaDTO(Cabania cabania) {
        CabaniaDTO cabaniaDTO = new CabaniaDTO();
        cabaniaDTO.setId(cabania.getId());
        cabaniaDTO.setNombre(cabania.getNombre());
        cabaniaDTO.setUbicacion(cabania.getUbicacion());
        cabaniaDTO.setTelefono(cabania.getTelefono());
        return cabaniaDTO;
    }
}
