package com.finanzas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finanzas.entities.FrecuenciaBono;
import com.finanzas.repository.FrecuenciaBonoRepository;



@Service
public class FrecuenciaBonoService {
    private FrecuenciaBonoRepository frecuenciaBonorepository;

    public FrecuenciaBonoService(FrecuenciaBonoRepository repository) {
        this.frecuenciaBonorepository = repository;
    }
    public List<FrecuenciaBono> getAll(){
        return frecuenciaBonorepository.findAll();
    }
}
