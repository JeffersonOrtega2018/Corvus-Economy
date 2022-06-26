package com.finanzas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.TipoAnho;

@Repository
public interface TipoAnhoRepository extends JpaRepository<TipoAnho,Long>{
    Optional<TipoAnho> findByname(String name);
}
