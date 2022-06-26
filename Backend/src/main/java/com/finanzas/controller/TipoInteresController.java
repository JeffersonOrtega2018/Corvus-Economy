package com.finanzas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.entities.TipoInteres;
import com.finanzas.service.TipoInteresService;


@RestController
@RequestMapping("/interes")
public class TipoInteresController {
    
    @Autowired
    private TipoInteresService tipoInteresService;

    public TipoInteresController(TipoInteresService tipoInteresService) {
        this.tipoInteresService = tipoInteresService; 
    }

    @GetMapping
    public ResponseEntity<List<TipoInteres>> findAll() {
        List<TipoInteres> interes = tipoInteresService.getAll();
        return new ResponseEntity<>(interes, HttpStatus.OK);
    }
}