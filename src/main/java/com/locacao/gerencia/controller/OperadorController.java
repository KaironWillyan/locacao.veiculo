package com.locacao.gerencia.controller;


import com.locacao.gerencia.entities.Operador;
import com.locacao.gerencia.services.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OperadorController {
    @Autowired
    private OperadorService operadorService;

    @GetMapping("/operador")
    public List<Operador> GetOperador (){
        return operadorService.GetOperador();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operador> GetOperadorById(@PathVariable(value = "id") Long id){
        Operador operador = operadorService.GetOperadorById(id);
        if (operador == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Operador não encontrado."
            );
        }
        return ResponseEntity.ok(operador);
    }

    @PostMapping
    public Operador PostOperador(@Validated @RequestBody Operador operador){
        return operadorService.PostOperador(operador);
    }

    @PutMapping("/operador/{id}")
    public ResponseEntity<Operador> PutOperador(@PathVariable(value = "id") Long id, @Validated @RequestBody Operador newOperador){
        Operador operador = operadorService.PutOperador(id, newOperador);
        if (operador == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Operador não encontrado."
            );
        }
        return ResponseEntity.ok(operador);
    }

    @DeleteMapping("/operador/{id}")
    public Operador DeleteOperador(@PathVariable(value = "id") Long id){
        Operador operador = operadorService.DeleteOperador(id);
        if (operador == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Operador não encontrado"
            );
        }

        return operador;
    }
}
