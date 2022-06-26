package com.finanzas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finanzas.entities.TipoInteres;
import com.finanzas.repository.TipoInteresRepository;

@Service
public class TipoInteresService {
    private TipoInteresRepository tipoInteresRepository;

    public TipoInteresService(TipoInteresRepository repository) {
        this.tipoInteresRepository = repository;
    }
    public List<TipoInteres> getAll(){
        return tipoInteresRepository.findAll();
    }
}
