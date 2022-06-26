package com.finanzas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.DatosSalida;

@Repository
public interface DatosSalidaRepository extends JpaRepository<DatosSalida,Long>  {
    
}
