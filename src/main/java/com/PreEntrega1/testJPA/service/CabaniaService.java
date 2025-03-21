package com.PreEntrega1.testJPA.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PreEntrega1.testJPA.repository.CabaniaRepository;
import com.PreEntrega1.testJPA.Cabania;
import com.PreEntrega1.testJPA.dto.CabaniaCreateDTO;
import com.PreEntrega1.testJPA.dto.CabaniaDTO;

@Service
public class CabaniaService {
    @Autowired
    private CabaniaRepository cabaniaRepository;

    public void saveCabaniaDTO(CabaniaCreateDTO CabaniaCreateDTO) throws Exception {
        if (cabaniaRepository.existsByNombre(CabaniaCreateDTO.getNombre())) {
            throw new Exception("Ya existe una Cabania con el nombre " + CabaniaCreateDTO.getNombre());
        }
        Cabania cabania = convertToEntity(CabaniaCreateDTO);
        cabaniaRepository.save(cabania);
    }

    public void saveCabania(Cabania cabania) throws Exception {
        if (cabaniaRepository.existsByNombre(cabania.getNombre())) {
            throw new Exception("Ya existe una Cabania con el nombre " + cabania.getNombre());
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

    private Cabania convertToEntity(CabaniaCreateDTO cabaniaCreateDTO) {
        Cabania cabania = new Cabania();
        cabania.setNombre(cabaniaCreateDTO.getNombre());
        cabania.setUbicacion(cabaniaCreateDTO.getUbicacion());
        cabania.setTelefono(cabaniaCreateDTO.getTelefono());
        return cabania;
    }
}
