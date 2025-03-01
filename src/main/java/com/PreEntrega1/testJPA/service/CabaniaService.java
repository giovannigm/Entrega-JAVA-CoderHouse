package com.PreEntrega1.testJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PreEntrega1.testJPA.repository.CabaniaRepository;
import com.PreEntrega1.testJPA.Cabania;

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

}
