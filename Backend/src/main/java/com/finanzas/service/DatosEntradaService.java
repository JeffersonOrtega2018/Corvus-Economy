package com.finanzas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.entities.DatosEntrada;
import com.finanzas.repository.DatosEntradaRepository;

@Service
public class DatosEntradaService {
    
    @Autowired
    DatosEntradaRepository datosEntradaRepository;
    
    
    public List<DatosEntrada> findAllByUserid(Integer user_id){
        return datosEntradaRepository.findAllByUser_id(user_id);
    }

    public Optional<DatosEntrada> findByid(Long id){
        return datosEntradaRepository.findById(id);
    }

    public DatosEntrada save(DatosEntrada datos){
        return datosEntradaRepository.save(datos);
    }
}