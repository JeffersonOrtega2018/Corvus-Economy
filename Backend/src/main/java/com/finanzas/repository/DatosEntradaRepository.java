package com.finanzas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.DatosEntrada;

@Repository
public interface DatosEntradaRepository extends JpaRepository<DatosEntrada,Long> {
    String query_datos_entrada = "select * from datos_entrada u "
    + "where u.user_id = user_id";
    @Query(value = query_datos_entrada, nativeQuery = true)
    List<DatosEntrada> findAllByUser_id(@Param("user_id") Integer user_id);

}
