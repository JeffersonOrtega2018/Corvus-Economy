package com.finanzas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.TipoInteres;

@Repository
public interface TipoInteresRepository extends JpaRepository<TipoInteres,Long> {
    Optional<TipoInteres> findByname(String name);
}
