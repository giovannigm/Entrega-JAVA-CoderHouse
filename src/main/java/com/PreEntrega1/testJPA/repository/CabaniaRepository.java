package com.PreEntrega1.testJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PreEntrega1.testJPA.Cabania;

public interface CabaniaRepository extends JpaRepository<Cabania, Long> {
    boolean existsByNombre(String nombre);
}
