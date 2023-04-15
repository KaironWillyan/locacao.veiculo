package com.locacao.gerencia.controller;

import com.locacao.gerencia.entities.Locar;
import com.locacao.gerencia.repositories.LocarRepository;
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
    private LocarRepository locarRepository;

    @GetMapping("/locar")
    public List<Locar> GetLocar (){
        return locarRepository.findAll();
    }

    @GetMapping("/locar/{id}")
    public ResponseEntity<Locar> GetLocarById(@PathVariable(value = "id") Long id){
        Optional<Locar> locacao = locarRepository.findById(id);
        if (locacao.isPresent()) {
            return new ResponseEntity<Locar>(locacao.get(), HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Locar não encontrado."
        );
    }

    @PostMapping("/locar")
    public Locar PostLocar(@Validated @RequestBody Locar locacao){
        return locarRepository.save(locacao);
    }

    @PutMapping("/locar/{id}")
    public ResponseEntity<Locar> PutLocar(@PathVariable(value = "id") Long id, @Validated @RequestBody Locar newLocar){
        Optional<Locar> oldLocar = locarRepository.findById(id);
        if (oldLocar.isPresent()){
            Locar locacao = oldLocar.get();
            locacao.setFuncionario(newLocar.getFuncionario());
            locacao.setOperador(newLocar.getOperador());
            locacao.setVeiculo(newLocar.getVeiculo());
            locacao.setDt_locacao(newLocar.getDt_locacao());
            locacao.setDt_entrega(newLocar.getDt_entrega());
            locacao.setKm_locacao(newLocar.getKm_locacao());
            locacao.setKm_entrega(newLocar.getKm_entrega());
            locarRepository.save(locacao);
            return new ResponseEntity<Locar>(locacao, HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Locacao não encontrado."
        );
    }

    @DeleteMapping("/locar")
    public ResponseEntity<Locar> DeleteAllLocar(){
        locarRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/locar/{id}")
    public ResponseEntity<Locar> DeleteLocar(@PathVariable(value = "id") Long id){
        Optional<Locar> locar = locarRepository.findById(id);
        if (locar.isPresent()){
            locarRepository.delete(locar.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Locar não encontrado"
        );
    }
}
