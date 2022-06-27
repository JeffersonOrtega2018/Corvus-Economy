package com.finanzas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda,Long>{
    Optional<Moneda> findByname(String name);
}