package com.finanzas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finanzas.entities.Moneda;
import com.finanzas.repository.MonedaRepository;



@Service
public class MonedaService {
    private MonedaRepository monedarepository;

    public MonedaService(MonedaRepository repository) {
        this.monedarepository = repository;
    }
    public List<Moneda> getAll(){
        return monedarepository.findAll();
    }
}
