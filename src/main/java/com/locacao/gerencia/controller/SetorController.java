package com.locacao.gerencia.controller;


import com.locacao.gerencia.entities.Setor;
import com.locacao.gerencia.repositories.SetorRepository;
import com.locacao.gerencia.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class SetorController {
    @Autowired
    private SetorService setorService;

    @GetMapping("/setor")
    public List<Setor> GetSetor(){
        return setorService.GetSetor();
    }

    @GetMapping("/setor/{id}")
    public ResponseEntity<Setor> GetById(@PathVariable(value = "id") Long id)
    {
        Setor setor = setorService.GetById(id);
        if(setor == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Setor não encontrado."
            );
        }
        return ResponseEntity.ok(setor);
    }

    @PostMapping("/setor")
    public Setor PostSetor(@Validated @RequestBody Setor setor){
        return setorService.PostSetor(setor);
    }

    @PostMapping("/setor/{id}")
    public ResponseEntity<Setor> PutSetor(@PathVariable(value = "id") Long id, @Validated @RequestBody Setor newSetor)
    {
        Setor setor = setorService.PutSetor(id, newSetor);
        if(setor == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Setor não encontrado."
            );
        }
            return ResponseEntity.ok(setor);
    }

    @DeleteMapping("/setor/{id}")
    public ResponseEntity<Setor> DeleteSetor(@PathVariable(value = "id") Long id){
        Setor setor = setorService.DeleteSetor(id);
        if (setor == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Setor não encontrado."
            );
        }
        return ResponseEntity.ok(setor);
    }

}
