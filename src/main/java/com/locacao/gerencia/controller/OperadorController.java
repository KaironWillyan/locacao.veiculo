package com.locacao.gerencia.controller;


import com.locacao.gerencia.entities.Operador;
import com.locacao.gerencia.repositories.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class OperadorController {
    @Autowired
    private OperadorRepository operadorRepository;

    @GetMapping("/operador")
    public List<Operador> GetOperador (){
        return operadorRepository.findAll();
    }

    @GetMapping("/operador/{id}")
    public ResponseEntity<Operador> GetOperadorById(@PathVariable(value = "id") Long id){
        Optional<Operador> operador = operadorRepository.findById(id);
        if (operador.isPresent()) {
            return new ResponseEntity<Operador>(operador.get(), HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Operador não encontrado."
        );
    }

    @PostMapping("/operador")
    public Operador PostOperador(@Validated @RequestBody Operador operador){
        return operadorRepository.save(operador);
    }

    @PutMapping("/operador/{id}")
    public ResponseEntity<Operador> PutOperador(@PathVariable(value = "id") Long id, @Validated @RequestBody Operador newOperador){
        Optional<Operador> oldOperador = operadorRepository.findById(id);
        if (oldOperador.isPresent()){
            Operador operador = oldOperador.get();
            operador.setNome(newOperador.getNome());
            operador.setCpf(newOperador.getCpf());
            operador.setTipo(newOperador.getTipo());
            operador.setEmail(newOperador.getEmail());
            operador.setPassword(newOperador.getPassword());
            operadorRepository.save(operador);
            return new ResponseEntity<Operador>(operador, HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Operador não encontrado."
        );
    }

    @DeleteMapping("/operador")
    public ResponseEntity<Operador> DeleteAllOperador(){
        operadorRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/+operador/{id}")
    public ResponseEntity<Operador> DeleteOperador(@PathVariable(value = "id") Long id){
        Optional<Operador> operador = operadorRepository.findById(id);
        if (operador.isPresent()){
            operadorRepository.delete(operador.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Operador não encontrado"
        );
    }
}
