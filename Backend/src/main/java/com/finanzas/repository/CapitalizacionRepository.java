package com.finanzas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.Capitalizacion;

@Repository
public interface CapitalizacionRepository extends JpaRepository<Capitalizacion,Long>{
    Optional<Capitalizacion> findByname(String name);
}
