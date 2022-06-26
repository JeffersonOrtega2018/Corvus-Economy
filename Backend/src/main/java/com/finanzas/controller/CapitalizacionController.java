package com.finanzas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.entities.Capitalizacion;
import com.finanzas.service.CapitalizacionService;

@RestController
@RequestMapping("/capit")
public class CapitalizacionController {
    
    @Autowired
    private CapitalizacionService capitalizacionService;

    public CapitalizacionController(CapitalizacionService capitalizacionService) {
        this.capitalizacionService = capitalizacionService; 
    }

    @GetMapping
    public ResponseEntity<List<Capitalizacion>> findAll() {
        List<Capitalizacion> capitalizacion = capitalizacionService.getAll();
        return new ResponseEntity<>(capitalizacion, HttpStatus.OK);
    }
}
