package com.finanzas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.FrecuenciaBono;

@Repository
public interface FrecuenciaBonoRepository extends JpaRepository<FrecuenciaBono,Long>{
    Optional<FrecuenciaBono> findByname(String name);
}
