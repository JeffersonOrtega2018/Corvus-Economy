package com.finanzas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finanzas.entities.TipoAnho;
import com.finanzas.repository.TipoAnhoRepository;

@Service
public class TipoAnhoService {
    private TipoAnhoRepository tipoanhoRepository;

    public TipoAnhoService(TipoAnhoRepository repository) {
        this.tipoanhoRepository = repository;
    }
    public List<TipoAnho> getAll(){
        return tipoanhoRepository.findAll();
    }
}
