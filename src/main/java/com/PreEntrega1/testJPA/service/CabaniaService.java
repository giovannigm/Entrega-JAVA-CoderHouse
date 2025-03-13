package com.PreEntrega1.testJPA.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PreEntrega1.testJPA.repository.CabaniaRepository;
import com.PreEntrega1.testJPA.Cabania;
import com.PreEntrega1.testJPA.dto.CabaniaDTO;

@Service
public class CabaniaService {
    @Autowired
    private CabaniaRepository cabaniaRepository;

    public void saveCabania(Cabania cabania) throws Exception {
        if (cabaniaRepository.existsByNombre(cabania.getNombre())) {
            throw new Exception("Ya existe una Cabania con el mismo nombre.");
        }
        cabaniaRepository.save(cabania);
    }

    public List<Cabania> findAll() {
        return cabaniaRepository.findAll();
    }

    public List<CabaniaDTO> listarCabania() {
        List<Cabania> cabanias = findAll();
        return cabanias.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private CabaniaDTO convertToDTO(Cabania cabania) {
        CabaniaDTO cabaniaDTO = new CabaniaDTO();
        cabaniaDTO.setId(cabania.getId());
        cabaniaDTO.setNombre(cabania.getNombre());
        cabaniaDTO.setUbicacion(cabania.getUbicacion());
        cabaniaDTO.setTelefono(cabania.getTelefono());
        return cabaniaDTO;
    }
}
