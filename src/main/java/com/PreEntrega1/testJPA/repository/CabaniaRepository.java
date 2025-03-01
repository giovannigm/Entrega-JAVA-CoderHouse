package com.PreEntrega1.testJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PreEntrega1.testJPA.Cabania;

@Repository
public interface CabaniaRepository extends JpaRepository<Cabania, Long> {
    boolean existsByNombre(String nombre);
}
