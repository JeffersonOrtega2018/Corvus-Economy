package com.finanzas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.entities.DatosEntrada;
import com.finanzas.service.DatosEntradaService;

@RestController
@RequestMapping("/entrada")
public class DatosEntradaController {
    
    @Autowired
    private DatosEntradaService datosEntradaService;

    public DatosEntradaController(DatosEntradaService datosEntradaService) {
        this.datosEntradaService = datosEntradaService; 
    }

    @GetMapping("user/{user_id}")
    public ResponseEntity<List<DatosEntrada>> findAllbyuserid(@PathVariable Integer user_id) {
        List<DatosEntrada> datos = datosEntradaService.findAllByUserid(user_id);
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DatosEntrada>> findByid(@PathVariable Long id) {
        Optional<DatosEntrada> datos = datosEntradaService.findByid(id);
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<DatosEntrada> save(@RequestBody  DatosEntrada datos){
        DatosEntrada data = datosEntradaService.save(datos);
        return new ResponseEntity<DatosEntrada>(data, HttpStatus.CREATED);
    }
}
