package com.finanzas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finanzas.entities.Capitalizacion;
import com.finanzas.repository.CapitalizacionRepository;

@Service
public class CapitalizacionService {
    private CapitalizacionRepository capitalizacionRepository;

    public CapitalizacionService(CapitalizacionRepository repository) {
        this.capitalizacionRepository = repository;
    }
    public List<Capitalizacion> getAll(){
        return capitalizacionRepository.findAll();
    }
}
