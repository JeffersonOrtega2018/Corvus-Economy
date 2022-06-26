package com.finanzas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.entities.TipoAnho;
import com.finanzas.service.TipoAnhoService;


@RestController
@RequestMapping("/anho")
public class TipoAnhoController {
    
    @Autowired
    private TipoAnhoService tipoAnhoService;

    public TipoAnhoController(TipoAnhoService tipoAnhoService) {
        this.tipoAnhoService = tipoAnhoService; 
    }

    @GetMapping
    public ResponseEntity<List<TipoAnho>> findAll() {
        List<TipoAnho> tanho = tipoAnhoService.getAll();
        return new ResponseEntity<>(tanho, HttpStatus.OK);
    }
}