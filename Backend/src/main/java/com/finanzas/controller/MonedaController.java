package com.finanzas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.entities.Moneda;
import com.finanzas.service.MonedaService;

@RestController
@RequestMapping("/moneda")
public class MonedaController {
    
    @Autowired
    private MonedaService monedaService;

    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService; 
    }

    @GetMapping
    public ResponseEntity<List<Moneda>> findAll() {
        List<Moneda> interes = monedaService.getAll();
        return new ResponseEntity<>(interes, HttpStatus.OK);
    }
}
