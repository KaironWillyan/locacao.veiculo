package com.locacao.gerencia.controller;

import com.locacao.gerencia.entities.Locar;
import com.locacao.gerencia.services.LocarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class LocarController {
    @Autowired
    private LocarService locarService;

    @GetMapping("/locar")
    public List<Locar> GetLocar (){
        return locarService.getLocar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locar> GetLocarById(@PathVariable(value = "id") Long id){
        Locar locacao = locarService.getLocarById(id);
        if (locacao == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Locar não encontrado."
            );
        }
            return ResponseEntity.ok(locacao);
    }

    @PostMapping
    public Locar PostLocar(@Validated @RequestBody Locar locacao){
        return locarService.postLocar(locacao);
    }

    @PutMapping("/locar/{id}")
    public ResponseEntity<Locar> PutLocar(@PathVariable(value = "id") Long id, @Validated @RequestBody Locar newLocar){
       Locar locar = locarService.putLocar(id, newLocar);
       if (locar == null) {
           throw new ResponseStatusException(
                   HttpStatus.NOT_FOUND, "Locacao não encontrado."
           );
       }
       return ResponseEntity.ok(locar);
    }

    @DeleteMapping("/locar/{id}")
    public Locar DeleteLocar(@PathVariable(value = "id") Long id){
       Locar locar = locarService.deleteLocar(id);
        if (locar == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Locar não encontrado"
            );
        }

        return locar;
    }
}
